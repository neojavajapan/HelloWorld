INSERT INTO Blogs(title, content, create_time, update_time, user_id) values('タイトル1', '内容1', LOCALTIME(), LOCALTIME(), 1);
INSERT INTO Blogs(title, content, create_time, update_time, user_id) values('タイトル2', '内容2', LOCALTIME(), LOCALTIME(), 2);
INSERT INTO Users(user_id, login_password, user_name) values(1, '123', 'irie');