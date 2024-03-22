-- Вставка данных в таблицу users
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Admin', 'Adminovich', 'admin@mail.ru', '$2a$12$e0zj3Zfmd3Cd1rN5Znm4YefODyVNMmNdfjjQ/166Ux7LBkIEHDjAS');

-- Вставка данных в таблицу users_roles
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
