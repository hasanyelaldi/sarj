INSERT INTO t_user (id,first_name,last_name) VALUES (1, 'Ziya', 'Ferit');
INSERT INTO t_user (id,first_name,last_name) VALUES (2, 'Beşir', 'Dal');
INSERT INTO t_user (id,first_name,last_name) VALUES (3, 'Eda', 'Rize');
INSERT INTO t_user (id,first_name,last_name) VALUES (4, 'Hadi', 'Duru');
INSERT INTO t_user (id,first_name,last_name) VALUES (5, 'Pınar', 'Mus');
INSERT INTO t_user (id,first_name,last_name) VALUES (6, 'Çiğdem', 'Su');
INSERT INTO t_user (id,first_name,last_name) VALUES (7, 'Aslı', 'Zor');
INSERT INTO t_user (id,first_name,last_name) VALUES (8, 'Murat', 'Eski');
INSERT INTO t_user (id,first_name,last_name) VALUES (9, 'Davut', 'Saz');
INSERT INTO t_user (id,first_name,last_name) VALUES (10, 'Kadir', 'Mutlu');

INSERT INTO t_brand (id,name) VALUES (1, 'Audi');
INSERT INTO t_brand (id,name) VALUES (2, 'Mercedes');

INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (1, 'A3', '2010', 1, 1);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (2, 'C180', '2008', 1, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (3, 'A4', '2001', 1, 1);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (4, 'E200', '2009', 2, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (5, 'C180', '2010', 2, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (6, 'E180', '2010', 3, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (7, 'A5', '2008', 5, 1);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (8, 'C180', '2008', 5, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (9, 'A6', '2007', 5, 1);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (10, 'C200', '2009', 6, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (11, 'A1', '2000', 7, 1);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (12, 'C200D', '2000', 8, 2);
INSERT INTO t_car (id,name,year,user_id,brand_id) VALUES (13, 'A3', '2002', 9, 1);
