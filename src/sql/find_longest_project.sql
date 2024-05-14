select id as "name",
EXTRACT(year FROM AGE(FINISH_DATE, START_DATE)) * 12 + EXTRACT(month FROM AGE(FINISH_DATE, START_DATE)) as month_count 
from project
order by month_count desc
limit 1;