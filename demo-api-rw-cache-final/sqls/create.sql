drop table if exists customer;
drop table if exists customer_seq;
create table customer 
(
	customer_id bigint not null AUTO_INCREMENT,
	first_name varchar(25) not null, 
	last_name varchar(25) not null, 
	age integer, 
	ssn integer not null,
	last_updated_by varchar(25),
	created datetime not null,  
	updated datetime not null, 
	primary key (customer_id),
	CONSTRAINT cust_uniquee UNIQUE (ssn)
) engine=InnoDB;

create table customer_seq (next_val bigint) engine=InnoDB;


ALTER TABLE customer ADD CONSTRAINT cust_uniquee UNIQUE (ssn);