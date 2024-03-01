create table if not exists userservice.user
(
    id        bigint      NOT NULL AUTO_INCREMENT,
    username  varchar(50) not null,
    password  varchar(50) not null,
    fullname  varchar(50) not null,
    admin     boolean     not null,
    nonLocked boolean     default true not null,
    PRIMARY KEY (id)
);