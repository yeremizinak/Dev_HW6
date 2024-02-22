select client."name" as "Name", count(project.id) as Project_Count from client
left join project on client.ID = project.CLIENT_ID group by client.ID, client."name"
having COUNT(project.ID) = (
        select MAX(Project_Count) from
            (select CLIENT_ID, COUNT(ID) as Project_Count from project group by CLIENT_ID)
    );