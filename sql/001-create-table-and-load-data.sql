DROP TABLE IF EXISTS patientcharts;

CREATE TABLE patientcharts (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL UNIQUE,
 gender VARCHAR(255) NOT NULL,
 address VARCHAR(255) NOT NULL UNIQUE,
 insurancecard VARCHAR(255) NOT NULL,
 medicalhistory VARCHAR(255) NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO patientcharts (id,name,gender,address,insurancecard,medicalhistory)
VALUES (1, "島村", "男性", "沖縄", "協会", "心臓病");
INSERT INTO patientcharts (id,name,gender,address,insurancecard,medicalhistory)
VALUES (2, "鈴木", "男性", "福岡", "国保", "肺癌");
INSERT INTO patientcharts (id,name,gender,address,insurancecard,medicalhistory)
VALUES (3, "広瀬", "女性", "東京", "健保", "胃癌");
INSERT INTO patientcharts (id,name,gender,address,insurancecard,medicalhistory)
VALUES (4, "松本", "女性", "京都", "共済", "骨盤骨折");