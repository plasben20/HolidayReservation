# Spring Cloud Session - Source Code

# Guía de uso
Para iniciar la aplicación es necesario como mínimo iniciar los contenedores de las bases de datos.
Estan configurados en el docker-compose.yml
Además están doquerizados los demás microservicios, pero no he conseguido arrancar los micros con
el config server, eureka y gateway.
Se puede lanzar los contenedores de bases de datos y los de eureka, config y gateway sin los usados para
la aplicación.
Se compone de los tres micros comentados y además de cinco micros más:
	- vuelos (micro que contiene la gestion de vuelos, tabla vuelos) -- ataca a una base de datos PostgreSQL de vuelos
			hacia la tabla vuelos 
	- hoteles (micro que contiene la gestión de hoteles, tabla hoteles) -- ataca a una base de datos Mysql de hoteles
			hacia la tabla hoteles
	- vuelosofer (micro que contiene la gestion de reservas hacia vuelos) -- ataca hacia la base de datos vuelos,
			a la tabla vuelos_oferta
	- hotelesofer (micro que contiene la gestión de reservas hacia hoteles) -- ataca hacia la base de datos hoteles,
			a la tabla hoteles_oferta
	- reservas (micro que gestiona una reserva de las reservas que hay de vuelos y de hoteles) -- ataca a una base
			de datos Mysql de reservas, hacia la tabla reservas. Tiene relación indirecta con vuelos_oferta 
			y hoteles_oferta.
# Diagrama de componentes


	


# Documentación
- Fichero de la colección de Postman ```(EurekaVuelosHoteles.postman_collection.json)```
- Eureka: http://localhost:8761/
- RabbitMq: http://localhost:15672/#/
	usr / pwd: guest / guest
- Zipkin: http://localhost:9411/zipkin/
- Config server: http://localhost:8888/<service_name>/default

# Autor del enunciado
Tomás Benedi Santos
