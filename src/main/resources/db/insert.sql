INSERT INTO users (id, email, password) values (100, 'gipati5703@qianhost.com', 'password'),
                                               (101, 'dayokr@gmail.com', 'passworddd');


insert into media (id, title, description, url, user_id, created_at)
values (105, 'my image', 'my first media here now', 'https://www.cloudinary.com/xyz', 100, '2023-01-11 21:32'),
       (106, 'my image', 'my first media here now', 'https://www.cloudinary.com/xyz', 100, '2023-01-11 21:32');

insert into comments (id, comment, media_id, user_id, created_at)
values (100, 'I hate your picture', 105, 100, '2023-02-11 00:44');