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
"address": "北海道",
"insurancecard": "国保",
"medicalhistory": "ストレートネック"
}'

![04FCC644-63E1-4CB3-B516-27AAE5B6A487.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2F0%2F04FCC644-63E1-4CB3-B516-27AAE5B6A487.jpeg)


## PATCH リクエスト

curl --location --request PATCH 'http://localhost:8080/patientcharts/1' \
--header 'Content-Type: application/json' \
--data '{
"address": "千葉",
"insurancecard": "共済",
"medicalhistory": "腰痛"
}'


![CAD74102-2630-40BE-BCB8-925BAE2E3DAF.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2FC%2FCAD74102-2630-40BE-BCB8-925BAE2E3DAF.jpeg)


## DELETE リクエスト

curl --location --request DELETE 'http://localhost:8080/patientcharts/1' \
--header 'Content-Type: application/json' \
--data '{
"medicalhistory": "腰痛"
}'


![6ADE0698-1752-411C-B8B7-17DFD85D024A.jpeg](..%2F..%2FPictures%2F%E5%86%99%E7%9C%9F%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA.photoslibrary%2Foriginals%2F6%2F6ADE0698-1752-411C-B8B7-17DFD85D024A.jpeg)




