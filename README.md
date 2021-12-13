# cardsource

Design Notes:
The API is defined using OpenAPI and then generated with Swagger Codegen. The API definition may be found defined
in src/main/resource/api.yml. Swagger Codegen is invoked on each build through a Maven plugin.

Generation of each card type is delegated to a dedicated class (per card type) implementing the CardTypeFactory
interface. Instances of CardTypeFactory are "registered" as Spring service providers in the CardFactoryProvider
class. This allows additional card types to be added either within this project or as linked modules.


To run: use mvn spring-boot:run
then, using cURL, send requests such as:
curl 127.0.0.1:8080/card/statusupdate?count=5
curl 127.0.0.1:8080/card/dailyquote
unrecognized card types will return a 400 result
new card types may be added by implementing the CardFactory interface and registering the factory as a Spring provider (i.e. including a META-INF/spring.factories file with the factory names listed)
