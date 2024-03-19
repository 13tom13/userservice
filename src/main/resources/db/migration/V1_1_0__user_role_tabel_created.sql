create table if not exists  roles
(
    id   bigint auto_increment primary key,
    name varchar(255) not null unique
);

create table if not exists  users_roles
(
    role_id bigint not null,
    user_id bigint not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);