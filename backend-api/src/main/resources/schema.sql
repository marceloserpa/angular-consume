create table IF NOT EXISTS book (
  id int primary key auto_increment,
  title varchar(255),
  description varchar(255),
  author varchar(255)
);

create table IF NOT EXISTS users (
  id int primary key auto_increment,
  username varchar(255),
  password varchar(255)
);

--insert into users (username, password) values ('admin', '21232f297a57a5a743894a0e4a801fc3')
insert into users (username, password) values ('admin', 'admin')