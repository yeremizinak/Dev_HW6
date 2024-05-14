select id as "name", sum(salary * duration) as price
FROM (
    select p.id,w.salary,extract(year from age(p.FINISH_DATE, p.START_DATE)) * 12 + extract(month from age(p.FINISH_DATE, p.START_DATE)) as duration
    from project p
    join project_worker pw on p.id = pw.project_id 
    join worker w on pw.worker_id = w.id
) subquery
group by id
order by price desc;