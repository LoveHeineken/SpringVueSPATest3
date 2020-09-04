DROP TABLE IF EXISTS SpringVueSpaTest3;

CREATE TABLE SpringVueSpaTest3 (
  id int(3) NOT NULL,
  name varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
);

INSERT INTO user(id, name) VALUES(1, 'test1');
INSERT INTO user(id, name) VALUES(2, 'test2');
INSERT INTO user(id, name) VALUES(3, 'test3');
