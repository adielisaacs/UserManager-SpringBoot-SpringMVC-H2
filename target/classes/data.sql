DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  username VARCHAR(250) NOT NULL PRIMARY KEY,
  phone VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL,
  enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

INSERT INTO users (username, phone, password,enabled) VALUES
  ('aisaacs', '0798811601', 'P@ssword1',true),
  ('Paul', '021911', 'P@ssword2',true),
  ('test', '021101111', 'password',true);
  
insert into authorities(username,authority) values ('aisaacs','ROLE_ADMIN');
insert into authorities(username,authority)values('aisaacs','ROLE_USER');
