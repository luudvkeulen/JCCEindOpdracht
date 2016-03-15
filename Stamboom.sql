create database Stamboom;

create table Persoon
(
	id int primary key,
	naam varchar(100),
);

create table Gezin
(
	id int primary key,
	persoon_id int references persoon(id),
	ouder1 varchar(100),
	ouder2 varchar(100),
);

create table Familie
(
	id int primary key,
	gezin_id int references gezin(id)
	naam varchar(100)
);