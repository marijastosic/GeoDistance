create table if not exists postcodelatlng (
	id int auto_increment primary key,
	postcode varchar(50) not null,
	latitude varchar(50) not null,
	longitude varchar(50) not null
);