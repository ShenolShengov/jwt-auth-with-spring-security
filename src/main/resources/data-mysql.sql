INSERT INTO roles (name)
    VALUES('USER') , ('ADMIN');

INSERT INTO users (username, email, password)
    VALUE('Shenol10', 'shenol@gmail.com', '5f35d1da3af7857ff3310c96bb06445f5d0f25bb67698474669dbd3136157c9bd6daab57cfa3e162eed542d166776216');

INSERT INTO users_roles (user_id, role_id)
    VALUES (1, 1), (1, 2);