CREATE TABLE worker (
    ID serial PRIMARY KEY,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),
    BIRTHDAY DATE CHECK (EXTRACT(YEAR FROM BIRTHDAY) > 1900),
    LEVEL VARCHAR(10) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    SALARY INTEGER CHECK (SALARY >= 100 AND SALARY <= 100000)
);

create table client (
	ID serial primary key,
	NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);

create table project(
	ID serial primary key,
	CLIENT_ID INT,
	START_DATE DATE,
	FINISH_DATE DATE,
	foreign key (CLIENT_ID) references client(ID)
);

create table project_worker(
	PROJECT_ID INT,
	WORKER_ID INT,
	primary key (PROJECT_ID, WORKER_ID),
	foreign key (PROJECT_ID) references project(ID),
	foreign key (WORKER_ID) references worker(ID)
);