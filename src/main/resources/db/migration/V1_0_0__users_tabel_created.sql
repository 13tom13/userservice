create table if not exists userservice.users
(
    id        bigint       NOT NULL AUTO_INCREMENT,
    username  varchar(255) not null,
    password  varchar(255) not null,
    fullname  varchar(255) not null,
    admin     bool default 0,
    nonLocked bool default 1,
    PRIMARY KEY (id)
);