create table users
(
    id       int auto_increment primary key,
    email    varchar(255) not null unique,
    name     varchar(255) not null,
    password varchar(255) not null
);

create table user_role
(
    name varchar(255) not null unique primary key
);

insert into user_role (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER')
