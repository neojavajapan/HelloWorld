CREATE TABLE IF NOT EXISTS Blogs(id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(50), content VARCHAR(100), create_time TIMESTAMP , update_time TIMESTAMP, user_id int);
CREATE TABLE IF NOT EXISTS Users(user_id INT PRIMARY KEY, login_password VARCHAR(50), user_name VARCHAR(30));