-- *************************************************************
-- This script creates the games database (games_db)
-- from Julien Metrot
-- *************************************************************

-- ********************************************
-- CREATE THE AP DATABASE
-- *******************************************

-- create the database
drop database if exists games_db;
create database games_db;

-- select the database
use games_db;

-- create the tables
drop table if exists game;
create table game
(
game_ID			int			auto_increment	primary key,
game_name		varchar(50)	not null,
release_date	date		not null,
release_price	decimal(5,2)		not null			 
)
comment 'The game table'
;

drop table if exists developer;
create table developer
(
developer_ID	int			auto_increment	primary key,
developer_name	varchar(50)	not null,
date_founded	date		not null 	default '2022-01-01'
)
comment 'The developer table'
;

drop table if exists genre;
create table genre
(
genre_ID		int			auto_increment	primary key,
genre_name		varchar(50)	not null
)
comment 'The genre table'
;

drop table if exists person;
create table person
(
person_ID		int			auto_increment	primary key,
first_name		varchar(50)	not null,
last_name		varchar(50)	not null,
email			varchar(50)	null
)
comment 'The person table'
;

drop table if exists platform;
create table platform
(
platform_ID		int			auto_increment	primary key,
platform_name	varchar(50)	not null,
manufacturer	varchar(50)	null
)
comment 'The platform table'
;

drop table if exists game_developer;
create table game_developer
(
game_ID			int			not null,
developer_ID	int			not null,

constraint game_developer_fk_game
foreign key (game_ID)
references game (game_ID)
on delete cascade,
constraint game_developer_fk_developer
foreign key (developer_ID)
references developer (developer_ID)
)
comment 'The game_developer relationship table'
;

drop table if exists purchases;
create table purchases
(
game_ID			int			not null,
person_ID		int			not null,
purchase_date	date		not null,
purchase_price	decimal(5,2) not null,

constraint purchases_fk_game
foreign key (game_ID)
references game (game_ID)
on delete cascade,
constraint purchases_fk_person
foreign key (person_ID)
references person (person_ID)
)
comment 'The purchases relationship table'
;

drop table if exists game_genre;
create table game_genre
(
game_ID			int			not null,
genre_ID		int			not null,

constraint game_genre_fk_game
foreign key (game_ID)
references game (game_ID)
on delete cascade,
constraint game_genre_fk_genre
foreign key (genre_ID)
references genre (genre_ID)
)
comment 'The game_genre relationship table'
;

drop table if exists game_platform;
create table game_platform
(
game_ID			int			not null,
platform_ID		int			not null,

constraint game_platform_fk_game
foreign key (game_ID)
references game (game_ID)
on delete cascade,
constraint game_platform_fk_platform
foreign key (platform_ID)
references platform (platform_ID)
)
comment 'The game_platform relationship table'
;

-- insert rows into the tables
insert into game values
(default, 'Grand Theft Auto V', '2018-09-17', '59.99'),
(default, 'Call Of Duty: Modern Warfare', '2019-10-25', '59.99'),
(default, 'Pokémon Legends: Arceus', '2022-01-28', '59.99'),
(default, 'Pokémon Scarlet and Violet', '2022-11-18', '59.99'),
(default, 'God of War Ragnarök', '2022-11-09', '69.99'),
(default, 'Call Of Duty: Mordern Warfare II', '2022-10-27', '69.99'),
(default, 'Call of Duty: Black Ops Cold War', '2020-11-13', '59.99'),
(default, 'Minecraft', '2011-11-18', '20.00'),
(default, 'Minecraft Dungeons', '2020-05-26', '19.99'),
(default, 'The Legend of Zelda: Breath of the Wild', '2017-03-03', '59.99');

insert into developer values
(default, 'Mojang', '2009-05-12'),
(default, 'Infinity Ward', '2002-04-28'),
(default, 'Treyarch', '1996-08-01'),
(default, 'Nintendo Entertainment Planning & Development', '1889-09-07'),
(default, 'Game Freak', '1989-04-23'),
(default, 'Rockstar Games', '1998-12-30'),
(default, 'Santa Monica Studio', '1999-11-03');

insert into genre values
(default, 'Open World'),
(default, 'First Person Shooter'),
(default, 'Dungeon Crawler'),
(default, 'Story Game');

insert into person values
(default, 'Julien', 'Metrot', 'jul.metrot@gmail.com'),
(default, 'Lauren', 'McCollum', 'lauren.mvia@gmail.com'),
(default, 'Payton', 'Houser', 'payton.houser@gmail.com');

insert into platform values
(default, 'Playstation 4', 'Sony'),
(default, 'Playstation 5', 'Sony'),
(default, 'Xbox One', 'Microsoft'),
(default, 'Xbox Series X', 'Microsoft'),
(default, 'Nintendo Switch', 'Nintendo');

insert into game_developer values
(1,6),
(2,2),
(3,5),
(4,5),
(5,7),
(6,2),
(7,3),
(8,1),
(9,1),
(10,4);

insert into purchases values
(1,1,'2014-12-20','39.99'),
(1,3,'2015-08-23','29.99'),
(2,1,'2019-12-03','59.99'),
(3,1,'2022-05-16','59.99'),
(4,1,'2022-11-11','59.99'),
(4,2,'2022-11-13','59.99'),
(4,3,'2022-11-12','59.99'),
(5,2,'2022-11-28','69.99'),
(6,1,'2022-10-27','69.99'),
(6,3,'2022-10-29','69.99'),
(7,1,'2021-12-27','29.99'),
(7,3,'2022-05-12','39.99'),
(8,1,'2013-07-08','9.99'),
(8,2,'2017-06-19','14.99'),
(8,3,'2012-02-29','20.00'),
(9,1,'2020-06-02','19.99'),
(9,2,'2021-04-26','9.99'),
(9,3,'2022-04-12','14.99'),
(10,1,'2017-03-03','59.99'),
(10,3,'2019-05-26','45.00');

insert into game_genre values
(1,1), (1,4),
(2,2),
(3,1), (3,4),
(4,1), (4,4),
(5,1), (5,4),
(6,2),
(7,2),
(8,1),
(9,3),
(10,1), (10,4);

insert into game_platform values
(1,1), (1,2), (1,3), (1,4),
(2,1), (2,2), (2,3), (2,4),
(3,5),
(4,5),
(5,2),
(6,1), (6,2), (6,3), (6,4),
(7,1), (7,2), (7,3), (7,4),
(8,1), (8,2), (8,3), (8,4), (8,5),
(9,1), (9,2), (9,3), (9,4), (9,5),
(10,5);


/* Stored Procedures */
/* Insert a new row into the developer table */
delimiter $$

drop procedure if exists sp_insert_developer$$
create procedure sp_insert_developer
(
developer_ID_param int,
developer_name_param varchar(50)
)
COMMENT 'Insert Stored Procedure'
begin
/*
		Copyright statement
		Author: Julien Metrot
		File:	sp_insert_developer
		DESCRIPTION:
			Insert a new row into the developer table
		
		Modification History
		Date modified - Who did it - what was modified
		2022-12-01	Julien Metrot	Initial Creation
		
	*/

declare sql_error tinyint default false;

	declare continue handler for sqlexception
		set sql_error = true;
	
insert into developer(developer_ID, 
						developer_name)
values
(
developer_ID_param,
developer_name_param
)
;

if sql_error = false then
		commit;
	else
		rollback;
	end if;

end $$
delimiter ;


/* Reads the savings by substrating the purchase price from the release price */
delimiter $$

drop procedure if exists sp_read_savings$$
create procedure sp_read_savings()
COMMENT 'Read Stored Procedure'
begin
/*
		Copyright statement
		Author: Julien Metrot
		File:	sp_read_savings
		DESCRIPTION:
			Reads the savings by substrating the purchase price from the release price
		
		Modification History
		Date modified - Who did it - what was modified
		2022-12-01	Julien Metrot	Initial Creation
		
	*/

declare sql_error tinyint default false;

	declare continue handler for sqlexception
		set sql_error = true;
        
start transaction;

select game.game_ID,
		game.game_name,
        game.release_price,
        person.person_ID,
        person.first_name,
        person.last_name,
        purchases.purchase_price,
        game.release_price - purchases.purchase_price as 'savings'
from game
inner join purchases
on game.game_ID = purchases.game_ID
inner join person
on person.person_ID = purchases.person_ID
where game.release_price - purchases.purchase_price > 0
order by game.game_name
;

if sql_error = false then
		commit;
	else
		rollback;
	end if;

end $$
delimiter ;

/* Updates the developer name using parameters */
delimiter $$

drop procedure if exists sp_update_developer_name$$
create procedure sp_update_developer_name
(
developer_ID_param int,
developer_name_param varchar(50)
)
COMMENT 'Update Stored Procedure'
begin
/*
		Copyright statement
		Author: Julien Metrot
		File:	sp_update_developer_name
		DESCRIPTION:
			Updates the developer name using parameters.
		
		Modification History
		Date modified - Who did it - what was modified
		2022-12-01	Julien Metrot	Initial Creation
		
	*/
    
declare sql_error tinyint default false;

	declare continue handler for sqlexception
		set sql_error = true;

start transaction;

update developer
set developer_name = developer_name_param
where developer_ID = developer_ID_param
;

if sql_error = false then
		commit;
	else
		rollback;
	end if;

end $$
delimiter ;

/* Delete a row in the game table */
delimiter $$

drop procedure if exists sp_delete_game$$
create procedure sp_delete_game
(
game_ID_param int
)
COMMENT 'Delete Stored Procedure'
begin
/*
		Copyright statement
		Author: Julien Metrot
		File:	sp_delete_game
		DESCRIPTION:
			Deletes a row in the game table.
		
		Modification History
		Date modified - Who did it - what was modified
		2022-12-01	Julien Metrot	Initial Creation
		
	*/
    
declare sql_error tinyint default false;

	declare continue handler for sqlexception
		set sql_error = true;

start transaction;
	
delete from game
where game_ID_param = game_ID 
;

if sql_error = false then
		commit;
	else
		rollback;
	end if;

end $$
delimiter ;


/* Triggers */

/* Triggers to lowercase when an update is made in the developer table */
drop trigger if exists tr_update_developer;
create trigger tr_update_developer
before update on developer
for each row
set new.developer_name = lower(new.developer_name)
;

/* Triggers to uppercase when an insert is made in the developer table */
drop trigger if exists tr_insert_developer;
create trigger tr_insert_developer
before insert on developer
for each row
set new.developer_name = upper(new.developer_name)
;



/* Views */

/* Which developers made what games */
drop view if exists vw_developer_game;
create view vw_developer_game as
select developer.developer_ID, 
        developer.developer_name,
		game.game_ID,
		game.game_name,
        game.release_date,
        concat("$", game.release_price) as 'release_price'
from game
inner join game_developer
on game.game_ID = game_developer.game_ID
inner join developer
on developer.developer_ID = game_developer.developer_ID
order by game.game_name
;

/* Which person owns what games */
drop view if exists vw_person_game;
create view vw_person_game as
select person.person_ID,
        person.first_name,
        person.last_name,
		game.game_ID,
		game.game_name,
        purchases.purchase_date,
        concat("$", purchases.purchase_price) as 'purchase_price'
from person
inner join purchases
on person.person_ID = purchases.person_ID
inner join game
on game.game_ID = purchases.game_ID
order by game.game_name
;


-- drop user if it already exists
DROP USER IF EXISTS games_db_admin@localhost;

-- create user
CREATE USER games_db_admin@localhost
IDENTIFIED BY 'admin';

-- grant privileges to that user
GRANT SELECT, INSERT, DELETE, UPDATE
ON games_db.*
TO games_db_admin@localhost;