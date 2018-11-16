DROP TABLE coordinate;
DROP TABLE ship;
DROP TABLE board;

CREATE TABLE board
	(name	varchar(25) NOT NULL,
	isturn boolean);

CREATE TABLE ship
	(name varchar(25) NOT NULL,
	issunk boolean,
	boardname varchar(25) NOT NULL);


CREATE TABLE coordinate
	(xcoord numeric(1) NOT NULL,
	ycoord numeric(1) NOT NULL,
	boardname varchar(25) NOT NULL,
	shipname varchar(25),
	selected boolean,
	hit boolean);

ALTER TABLE board
 add constraint board_name_pk primary key(name);

ALTER TABLE ship
 add constraint ship_name_boardname_pk primary key(name, boardname);

ALTER TABLE coordinate
 add constraint coordinate_xcord_ycord_boardname_pk primary key(xcoord,ycoord,boardname);


ALTER TABLE ship
 add constraint ship_boardname_fk foreign key(boardname)
 references board(name);

ALTER TABLE coordinate
 add constraint coordinate_boardname_fk foreign key(boardname)
 references board(name);

ALTER TABLE coordinate
 add constraint coordinate_shipname_fk foreign key(shipname)
 references ship(name);