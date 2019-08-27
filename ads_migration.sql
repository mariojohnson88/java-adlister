USE adlister_db;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL DEFAULT 'NONE',
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(100),
  description text,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

