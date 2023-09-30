## MySQlのDBをPostmanからGET


curl --location 'http://localhost:8080/patientcharts'



![0CE68C40-596B-47A9-A512-890C8C534F4C.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2F0%2F0CE68C40-596B-47A9-A512-890C8C534F4C.jpeg)


## MySQLの追加select後のPostmanからGET


curl --location 'http://localhost:8080/patientcharts'



![8A0C1CC3-3529-42E9-AE5B-0C39803C7A3C.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2F8%2F8A0C1CC3-3529-42E9-AE5B-0C39803C7A3C.jpeg)


## POST リクエスト  201バージョン

curl --location 'http://localhost:8080/patientcharts' \
--header 'Content-Type: application/json' \
--data '{
"address": "福岡",
"insurancecard": "共済",
"medicalhistory": "ストレートネック"
}'

![9AB246FC-5AEC-482D-A71D-CBDF121BEDD8_1_105_c.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Fresources%2Fderivatives%2F9%2F9AB246FC-5AEC-482D-A71D-CBDF121BEDD8_1_105_c.jpeg)


## PATCH リクエスト

curl --location --request PATCH 'http://localhost:8080/patientcharts/1' \
--header 'Content-Type: application/json' \
--data '{
"address": "北海道",
"insurancecard": "国保",
"medicalhistory": "腰痛"
}'


![CD252F80-7C32-4B9D-B705-B60C712CB7DB_1_105_c.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Fresources%2Fderivatives%2FC%2FCD252F80-7C32-4B9D-B705-B60C712CB7DB_1_105_c.jpeg)


## DELETE リクエスト

curl --location --request DELETE 'http://localhost:8080/patientcharts/1' \
--header 'Content-Type: application/json' \
--data '{
"medicalhistory": "心臓病"
}'


![1C7C665E-F70B-48C7-9BA7-F750426FDC7F.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2F1%2F1C7C665E-F70B-48C7-9BA7-F750426FDC7F.jpeg)




