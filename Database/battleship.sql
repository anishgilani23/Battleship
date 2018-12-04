DROP TABLE ship;
DROP TABLE board;
DROP TABLE Users;

CREATE TABLE Users
(
	name VARCHAR(50) NOT NULL,
	pass VARCHAR(50) NOT NULL
);

CREATE TABLE board
	(name	varchar(25) NOT NULL,
	isturn boolean);

CREATE TABLE ship
	(name varchar(25) NOT NULL,
	issunk boolean,
	boardname varchar(25) NOT NULL);

ALTER TABLE board
 add constraint board_name_pk primary key(name);

ALTER TABLE ship
 add constraint ship_name_boardname_pk primary key(name, boardname);

ALTER TABLE ship
 add constraint ship_boardname_fk foreign key(boardname)
 references board(name);