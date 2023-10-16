select *
from customers 
where city like 'M%'
order by contact_firstname asc;

-- '' is empty string which is not equal to null

-- write a query that will return the list of countries in the customers table with no duplicates orderd in descending
-- delete all records from customer where the customer_name is 'Hibernate Customer' and the id is greater than 498
-- write a query to find all customers that have a first name that begins with E
-- delete all records from customer where the customer_name ends with a 4
-- write a query to find all cities from the customers table that contain a dash and remove the duplicates sorting in asecding order
select distinct city from customers where city like '%a%' order by city asc;


select firstname from employees order by firstname;


insert into customers ( customer_name, contact_lastname, contact_firstname, phone, address_line1, address_line2, city, state, postal_code, country )
			 values   ( 'Series Reminder', "Heilig",     'Eric',  '555-555-1212', 'Address Line 1', 'Address Line2', 'Denver', 'CO', 80203, 'USA' );
             

select * From customers;
select * from customers where contact_lastname = 'Heilig';

update customers set address_line2 = null, address_line1 = '123 Some Street' where id = 520;

delete from customers where id > 520;



-- ----------------------------------------------------------------

select * from offices;
select * from employees;

-- we want to show the first name, last name, office city, and office country for all employees that are in a particular city
select e.firstname, e.lastname, e.office_id, o.id, o.city, o.country 
from offices o, employees e
where o.city like 'Tokyo'
and o.id = e.office_id; 

select * from employees where office_id = 1;
select * From offices where city like '%o%';



-- we want to see the products in a partular order
select * from orders;
select * From orderdetails where order_id = '10103';
select * from products;

-- this query gets the list of products for the order 10100 and prints the order id, product id, product name, quantity ordered, buy price, msrp
-- and it caluclates the profit and total profit for each line item.
select o.id, p.id as product_id, p.product_name, od.quantity_ordered, p.buy_price, p.msrp, (p.msrp - p.buy_price) as profit, 
	((p.msrp - p.buy_price) * od.quantity_ordered) as total_profit
from orders o, orderdetails od, products p
where o.id = '10100'
and od.order_id = o.id
and od.product_id = p.id;

-- how many distinct products are in the order 10100
select o.id, count(*)
from orders o, orderdetails od
where o.id = od.order_id
group by o.id;

-- how many employees are in each office
select o.city, count(*)
from employees e, offices o
where e.office_id = o.id
group by o.id;


-- show me the total quantity ordered for each product across all customers
select p.id, p.product_name, sum(od.quantity_ordered) as total_quantity_ordered
from products p, orderdetails od
where p.id = od.product_id
group by p.id
order by total_quantity_ordered desc;

select * from orderdetails where product_id = 40;

-- what product appears in the most orders
select p.product_name, count(*) as order_count
from orderdetails od, products p
where p.id = od.product_id
group by product_id
order by order_count asc;

-- what product has the highest quanity ordered
select p.product_name, sum(quantity_ordered) as total_ordered, count(*) as order_count, avg(quantity_ordered) as avg_per_order
from orderdetails od, products p
where p.id = od.product_id
group by product_id
order by total_ordered desc;

-- show me the customer name and the total number of orders for that customer - useing count(*)
-- limit this query to show only customers that have more than 5 orders
select * from customers;
select * from orders;

select c.customer_name, count(*) as number_orders
from customers c, orders o
where c.id = o.customer_id
group by c.id
having number_orders > 3
order by number_orders desc;

-- show me the custoemr name and the total number products ordered  - using count(*)
select c.id, c.customer_name, count(distinct product_id) as distinct_products, count(product_id) as total_products
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id
order by count(*) desc;
    
-- see all of the product names that have been ordered by customer_id = 141
select p.product_name
from customers c, orders o, orderdetails od, products p
where c.id = o.customer_id
and o.id = od.order_id
and p.id = od.product_id
and c.id = 141
order by product_name asc;

-- show me the customer name, the product name, and the total quantaity orderd of each product - using sum()
select c.customer_name, p.product_name, sum(od.quantity_ordered) as total_quantity_ordered
from customers c, orders o, orderdetails od, products p
where c.id = o.customer_id
and o.id = od.order_id
and p.id = od.product_id
group by c.id, p.id
order by customer_name asc, total_quantity_ordered desc;

