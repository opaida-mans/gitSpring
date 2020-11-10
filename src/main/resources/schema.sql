DROP table IF EXISTS Employee;


CREATE TABLE Employee(
id int not null primary key auto_increment,
FIRST_NAME varchar(225) not null,
LAST_NAME varchar(255) not null,
address varchar(255) not null,
JOINING_DATE timestamp default(CURRENT_TIME)
)