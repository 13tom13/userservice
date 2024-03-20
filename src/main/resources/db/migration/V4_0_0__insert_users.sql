insert into users (first_name, last_name, email, password)
VALUES ('Ivan', 'Ivanov','ivan@mail.ru',
       '$2a$12$XVKiPmYGmTdFfITSW8BhQuA2tBwjRN4QbsvL3TzJ7dVYMxf1BLvV.'),
       ('Fet', 'Pet','pet@mail.ru',
        '$2a$12$c3tK7LH3RbKZvnzefQLgiulxQynVkdBemEzCWlNKPuE3AnKmMgEMG'),
       ('Sir', 'Mir','mir@mail.ru',
        '$2a$12$0iPIo5NPkzhAp7Hd84quVOhuKMDO3kCE9A5aSrCXZrL8UVophqjVq'),
       ('Dmitrii', 'Petrov','dp@mail.ru',
        '$2a$12$pBbS345U3HiDj1I9SYmtgeNJN/9OIrzxKjV2Pns5MYMX3QeG2Xeji'),
       ('Kirill', 'Ivanov','kir@mail.ru',
        '$2a$12$8MPAQ26WCrI76YvT.got5uPoDseJPH2O9/JZriqF97QC.NTMcr8A.'),
       ('Kate', 'Bush','kate@mail.ru',
        '$2a$12$1aLOHwREyiE0hv6wO4R03usdmzEjjbInaV43avSfLuZLRfHzDdiU6'),
       ('Victor', 'Frank','vic@mail.ru',
        '$2a$12$VxehgUI1KCHwTJP.CsFMxuAb9u0QqAgt.ZYrkzV.GWGF8hqPWLo8O'),
       ('Rick', 'Sanchez','rik@mail.ru',
        '$2a$12$UerWX8CJeZe.H3h75ZHDKeKgIYXzsfitatPyIwGlDywNTv3.A7.uC');

insert into users_roles (role_id, user_id)
    VALUES (2,2),
           (2,3),
           (2,4),
           (2,5),
           (2,6),
           (2,7),
           (2,8),
           (2,9);
