create table account (
  email text primary key,
  role text,
  password text
);

insert into account
values ('email@domain.com', 'admin', '$2a$10$Uc.SZ0hvGJQlYdsAp7be1.lFjmOnc7aAr4L0YY3/VN3oK.F8zJHRG');
