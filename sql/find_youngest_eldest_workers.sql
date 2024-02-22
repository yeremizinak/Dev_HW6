(select case
	when birthday = (select max(birthday) from worker) then 'YOUNGEST'
end as "type","name", birthday
from worker
 where birthday = (select max(birthday) from worker))
union all
(select case
	when birthday = (select min(birthday) from worker) then 'ELDEST'
end as "type","name", birthday
from worker
where birthday = (select min(birthday) from worker));