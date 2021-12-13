# cardsource

Design Notes:
The API is defined using OpenAPI and then generated with Swagger Codegen. The API definition may be found defined
in src/main/resource/api.yml. Swagger Codegen is invoked on each build through a Maven plugin.

Generation of each card type is delegated to a dedicated class (per card type) implementing the CardTypeFactory
interface. Instances of CardTypeFactory are "registered" as Spring service providers in the CardFactoryProvider
class. This allows additional card types to be added either within this project or as linked modules.  