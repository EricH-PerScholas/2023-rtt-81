select avg(amount) from payments;

select * from payments
where amount > (select avg(amount) from payments)
order by amount desc;


-- the following 2 statements are the same
select * 
from employees e 
where e.office_id IN ( 1,2,3);

select * 
from employees e
where e.office_id = 1 or e.office_id = 2 or e.office_id = 3;

-- the in statement can be used with a subquery
select id from offices where city like '%o%';
select * from employees where office_id IN (1,2,5,7);
select * from employees where office_id IN (select id from offices where city like '%o%');


-- show the top 10 most popular products
select * 
from products p, 
	( select p.id, sum(od.quantity_ordered) as total_ordered
	from products p, orderdetails od
	where od.product_id = p.id
	group by p.id
	order by total_ordered desc
	limit 10 ) popular
where p.id = popular.id;


-- she me any orders that have happened after the lasted payment for each customer
select * from payments;




select * from customers;
update customers set contact_lastname = 'Another last name' where id = 103;
commit;
rollback;


select * from employees;

-- I want to see all of the offices that have someone with the first name L
select * from employees where firstname like 'L%';
select * from offices where id in ( select office_id from employees where firstname like 'L%' );

-- 1) Think of mroe examples for IN
-- 2) Left join examples

-- know that you need to use is when checking for null
-- this will work
select * from offices where state is null;
-- this will not produce any results
select * from offices where state = null;


-- 
SELECT *
    FROM products p, orderdetails od
WHERE p.id = od.product_id and od.product_id is null;



select e.id, o.id
from employees e, offices o
where e.office_id = o.id;
