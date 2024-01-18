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

//サンプル

DROP TABLE IF EXISTS todo_list;

CREATE TABLE task (
 id int unsigned AUTO_INCREMENT,
 user_id int(4) ,
 name VARCHAR(255) NOT NULL,
 start_date DATE NOT NULL,
 scheduled_end_date DATE NOT NULL,
 actual_end_date DATE,
 PRIMARY KEY(id)
);

CREATE TABLE user (
 id int unsigned AUTO_INCREMENT,
 manager VARCHAR(255) NOT NULL,
);

INSERT INTO task (id, user_id, name, start_date, scheduled_end_date, actual_end_date)
VALUES (1, null, "構想", 2023/12/06, null, null);

INSERT INTO task (id, user_id, name, start_date, scheduled_end_date, actual_end_date)
VALUES (2, null, "API作成", 2023/12/07, null, null);

INSERT INTO task  (id, user_id, name, start_date, scheduled_end_date, actual_end_date)
VALUES (3, null, "テスト", 2023/12/08, null, null);

INSERT INTO task  (id, user_id, name, start_date, scheduled_end_date, actual_end_date) 
VALUES (4, null, "リリース" 2023/12/09, null, null);


INSERT INTO user (id,name)
VALUES (1, "しまむー");

INSERT INTO user (id,name)
VALUES (2, "柴田");

INSERT INTO user (id,name)
VALUES (3, "小山");

INSERT INTO user (id,name)
VALUES (4, "ジェイ");



