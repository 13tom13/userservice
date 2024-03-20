insert into users (first_name, last_name, email, password)
VALUE ('Admin', 'Adminovich','admin@mail.ru',
       '$2a$12$e0zj3Zfmd3Cd1rN5Znm4YefODyVNMmNdfjjQ/166Ux7LBkIEHDjAS');

insert into users_roles (role_id, user_id)
    VALUES (1,1);
