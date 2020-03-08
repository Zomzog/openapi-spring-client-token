CREATE TABLE tbl_user (
  id bigint(20) NOT NULL,
  username varchar(25) NOT NULL,
  password varchar(75) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tbl_user (id, username, password) VALUES (1, 'user1', '$2a$10$hhAGTSHgnbR5o7PnsGaJTeYHwzawlPhMqAvykv/RAqzqx205GIncW');
INSERT INTO tbl_user (id, username, password) VALUES (2, 'user2', '$2a$10$hhAGTSHgnbR5o7PnsGaJTeYHwzawlPhMqAvykv/RAqzqx205GIncW');
