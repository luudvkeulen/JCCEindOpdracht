/*
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
----------------------------------DROP TABLES----------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
*/

drop table Persoon;
drop table Gezin;
drop table Familie;

/*
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
----------------------------------CREATE TABLES--------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
*/

create table Persoon
(
	id int primary key auto_increment,
	naam varchar(100)
);

create table Gezin
(
	id int primary key auto_increment,
	ouder1 int references persoon(id),
	ouder2 int references persoon(id)
);

create table Familie
(
	id int primary key auto_increment,
	gezin_id int references gezin(id),
	naam varchar(100)
);

/*
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
----------------------------------INSERT DATA----------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
*/

insert into Persoon(naam)
values("Henrie"); /*--ID 1*/
insert into Persoon(naam)
values("Bianca"); /*--ID 2*/
insert into Persoon(naam)
values("Petertje"); /*--ID 3*/
insert into Persoon(naam)
values("Dieny"); /*--ID 4*/
insert into Persoon(naam)
values("Hans"); /*--ID 5*/
insert into Persoon(naam)
values("Petra"); /*--ID 6*/
insert into Persoon(naam)
values("Mohammed"); /*--ID 7*/
insert into Persoon(naam)
values("Wesley"); /*--ID 8*/
insert into Persoon(naam)
values("Marian"); /*--ID 9*/
insert into Persoon(naam)
values("Beppie"); /*--ID 10*/

-- Gezinnen aanmaken
insert into Gezin(ouder1, ouder2)
values(1, 2);
insert into Gezin(ouder1, ouder2)
values(3, 4);
insert into Gezin(ouder1, ouder2)
values(5, 6);
insert into Gezin(ouder1, ouder2)
values(7, null);
insert into Gezin(ouder1, ouder2)
values(8, 9);
insert into Gezin(ouder1, ouder2)
values(10, null);


-- Gezinnen aan families koppelen
Insert into Familie(gezin_id, naam)
values(1, "den Hoeve");
Insert into Familie(gezin_id, naam)
values(2, "den Akker");
Insert into Familie(gezin_id, naam)
values(3, "van Veger");
Insert into Familie(gezin_id, naam)
values(4, "den Hoeve");
Insert into Familie(gezin_id, naam)
values(5, "de Rond");
Insert into Familie(gezin_id, naam)
values(6, "de Vlieger");

/*
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
----------------------------------SELECT QUERIES-------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
*/

-- Haal de familie 'den Hoeve' op. Laat hierbij de namen van de ouders en het gezinsnummer zien
select f.id as familieNummer, g.id as gezinsNummer, p1.naam as ouder1, p2.naam as ouder2
from persoon p1, persoon p2, gezin g, familie f
where p1.id = g.ouder1
and p2.id = g.ouder2
and f.naam = 'den Hoeve';

-- Haal alle gezinnen op. Laat hierbij de namen van de ouders zien
select g.id as gezinsNummer, p1.naam as ouder1, p2.naam as ouder2
from persoon p1, persoon p2, gezin g, familie f
where p1.id = g.ouder1
and p2.id = g.ouder2