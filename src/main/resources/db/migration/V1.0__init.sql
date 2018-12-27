create table if not exists postcodelatlng (
	id int auto_increment primary key,
	postcode varchar(8) not null,
	latitude decimal(18,15) not null,
	longitude decimal(18,15) not null
);
