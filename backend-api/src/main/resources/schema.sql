create table IF NOT EXISTS book (
  id int primary key auto_increment,
  title varchar(255),
  description varchar(255),
  author varchar(255)
);

insert into book (title, description, author) values ('the shinning', 'best sellers', 'Stephen King');