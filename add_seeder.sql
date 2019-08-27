USE adlister_db;

INSERT INTO users(username, email, password)
VALUE ('luigi', 'luigi@brother.com', 'password');

INSERT INTO ads (user_id, title, description)
VALUE (1, 'Shoes', 'Nike Fly Knit');