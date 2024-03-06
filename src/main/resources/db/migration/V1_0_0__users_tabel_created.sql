
create table users
(
    id       int auto_increment
        primary key,
    email    varchar(255) not null,
    name     varchar(255) not null,
    password varchar(255) not null
);

create table user_role
(
    id      int          not null primary key,
    role_id int          not null,
    user_id int          not null,
    name    varchar(255) not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references user_role (id)
);
