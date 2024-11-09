INSERT INTO roles (name)
    VALUES('USER') , ('ADMIN');

INSERT INTO users (username, email, password)
    VALUE('Shenol10', 'shenol@gmail.com', 'asdasd');

INSERT INTO users_roles (user_id, role_id)
    VALUES (1, 1), (1, 2);