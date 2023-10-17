-- 1) I want to see a list of customer names and the order number for any orders that have made an order that has an order_date greater than the maximum payment date - 
-- will require a sub query to get the max(payment_date) from the payments table which can be used in the where clause to find orders with an order_date after the max(payment_date)
select c.customer_name, o.customer_id, o.order_date
	from customers c
	join orders o ON c.id = o.customer_id
	where o.order_date > (
		select MAX(payment_date)
		from payments p
		where p.customer_id = c.id
	);
    
select c.customer_name,o.id 
from customers c,orders o 
where c.id=o.customer_id 
 and o.order_date> (select max(p.payment_date) from payments p where p.customer_id=o.customer_id)
 order by customer_name;
 
 -- same queery as a subtable
 select c.customer_name ,o.id 
 from customers c, orders o, 
	(select p.customer_id, max(p.payment_date) as max_payment from payments p group by p.customer_id) as subtable
 where c.id=o.customer_id 
 and o.customer_id = subtable.customer_id
 and o.order_date> subtable.max_payment
 order by customer_name;
 

-- 2) I want to see all the employees that are working in an office where the state is not null;
select e.id, e.firstname, e.lastname, e.office_id, o.state
	from employees e 
	join offices o on e.office_id = o.id
	where o.state is not null;

select e.firstname, e.lastname 
from classic_models.employees e, classic_models.offices o
where e.office_id = o.id
and state is not null;

-- 3) I want to all of the products that are not ground vehicles.   Hint -  where not in a select statement from product line
select * from products where productline_id in ( select id from productlines where product_line in ('Planes', 'Ships') );


-- 3a) I want to see a unique list of the order status
select distinct status from orders;


-- 4) use an IN statement with a sub query - I want to see the list of products that have been ordered but not yet shipped. - the orders table has a status column that contins the order status 
select * from orders where status in ('In Process', 'On Hold');


-- 5) The product name, and quantity ordered for all orders that are on hold or in process
select p.product_name, od.quantity_ordered
from  products p , orders o , orderdetails od
where  p.id = od.product_id 
and o.id=od.order_id 
and o.status in ('In Process', 'On Hold');

select od.product_id 
from orderdetails od ,orders o 
where od.order_id=o.id 
and (o.status='On Hold' or o.status = 'In Process') 
order by od.product_id;

select p.product_name, od.quantity_ordered
    from orders o, products p, orderdetails od
    where status = 'On Hold' or status = 'In Process';


-- 6) I want to see a list of all employess that do not have a customer!!!!  use a where not in ( select employee_id from customer where .... )
select * from employees e where e.id not in ( select distinct c.sales_rep_employee_id from customers c where sales_rep_employee_id is not null);
select * from customers where sales_rep_employee_id = '1002';
select * from employees;

select c.sales_rep_employee_id from customers c where sales_rep_employee_id is not null;

select empl.* 
from employees empl  
where empl.id not in (select distinct c2.sales_rep_employee_id  from customers c2 where c2.sales_rep_employee_id=empl.id);

-- solved using a left join
SELECT *
FROM employees e
LEFT JOIN (select distinct c2.sales_rep_employee_id  from customers c2 ) sales_rep_employee 
  ON e.id= sales_rep_employee.sales_rep_employee_id
WHERE  sales_rep_employee.sales_rep_employee_id IS NULL;


-- 6a) I want to see the employee name and each of their customer names.   IF the employee does not have any customers then show null for the customer name ... this is a left join
--    order this by the employee first name asc    you will see the employee name repeated many times for each customer they have .. but if the employee has no customers it should print NULL in
--    the second column.
select e.id,e.firstname,e.lastname,c.customer_name
 from employees e 
 LEFT JOIN customers c ON c.sales_rep_employee_id = e.id
 order by e.id;
 
 select e.id,e.firstname,e.lastname,c.customer_name
 from employees e, customers c 
 where c.sales_rep_employee_id = e.id
 order by e.id;