INSERT INTO Blogs(title, content, create_time, update_time, user_id) values('タイトル', '内容', LOCALTIME(), LOCALTIME(), 1);
INSERT INTO Users(user_id, login_password, user_name) values(1, '123', 'irie');