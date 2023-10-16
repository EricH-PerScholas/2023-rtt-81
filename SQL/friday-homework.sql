-- #1 show me the name of the product line and the number of products in each product line
select * from productlines;

select pl.product_line, count(p.id)
from products p, productlines pl
where pl.id = p.productline_id
group by pl.id;

-- #2 For each customer show the customer name, the total number of payments
select c.id, c.customer_name, count(*) as number_payments 
from payments p, customers c 
where  c.id = p.customer_id 
group by p.customer_id 
order by number_payments desc;

-- #3 For each customer show the customer name and the total amount paid
select c.id, c.customer_name, sum(p.amount) as total_amount 
from payments p, customers c 
where  c.id = p.customer_id 
group by p.customer_id 
order by total_amount desc;

-- for each customer show the min payment amount, max payment amount, total payments, number of payments, and average payment
select c.id, c.customer_name, min(p.amount) as minimum_payment_amount, max(p.amount) as max_payment_amount, sum(p.amount) as total_payment, count(*) as payment_count,
avg(p.amount) as average_payment
from payments p, customers c 
where  c.id = p.customer_id 
group by p.customer_id 
order by minimum_payment_amount desc;

-- #4 for each emoployee show the employee name and the total number of customers that employee has
select e.id,  CONCAT(e.firstname ,' ',e.lastname) as name, count(*) as total_customers 
from employees e, customers c 
where e.id =c.sales_rep_employee_id 
group by e.id 
order by total_customers desc;

-- #5 for each office, I want to see office name and the total number quantity of products ordered
select o.city,count(*) as num_of_products,sum(od1.quantity_ordered)as total_quantity
from offices o,employees e,customers c,orders od,orderdetails od1
where o.id = e.office_id
and e.id=c.sales_rep_employee_id
and c.id=od.customer_id
and od.id =od1.order_id
group by o.id
order by 3 desc;

-- #6 for each office, I want to see the total profit for total quantity of all products ordered
select o.city,
	count(*) as Num_Of_Products,
	sum(od1.quantity_ordered) as Toal_Quantity,
	sum(((p.msrp - p.buy_price) * od1.quantity_ordered)) as 'Total_Profit'
from offices o,employees e,customers c,orders od,orderdetails od1,products p
where o.id = e.office_id
and e.id=c.sales_rep_employee_id
and c.id=od.customer_id
and od.id =od1.order_id
and od1.product_id=p.id
group by o.id
ORDER BY 3 desc;