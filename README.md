# cardsource
To run: use mvn spring-boot:run
then, using cURL, send requests such as: 
curl 127.0.0.1:8080/card/statusupdate?count=5
curl 127.0.0.1:8080/card/dailyquote
unrecognized card types will return a 400 result
new card types may be added by implementing the CardFactory interface and registering the factory as a Spring provider (i.e. including a META-INF/spring.factories file with the factory names listed)
