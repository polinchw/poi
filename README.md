## Spring Boot project that uses Microsoft POI to generate Word documents.

###
Http Client->Spring-Boot-Contoller->Query the DB->Write File

###
Create a directory called outbox.
###
Run the app by running java -jar poi.jar
###
Point your browser to http://localhost:8080/writeHotelToFile?id=1 
###
It should write a file to the /outbox folder.
