# Spring Cloud Session - Source Code

# Guía de uso
1. ```git clone https://github.com/Curso-Microservicios-2022/spring-cloud-session.git```.
2. ```docker-compose up -d``` para iniciar Rabbit MQ y Zipkin.
3. Configurar la ruta spring.cloud.config.server.git.uri en el servidor de configuraciones con el repositorio de configuraciones.
4. Actualizar las rutas de Rabbit y Zipkin en el fichero application.yml del repositorio de configuraciones con la direccion IP del host.
5. Inicializar el repositorio de configuraciones como reposirotio git.
6. Desde el IDE, arrancar los servicios en el siguiente orden: servidor de configuraciones, eureka, gatewat, item-service, product-service.
7. Utilizar la colección de postman para realizar peticiones.

# Diagrama de componentes



# Documentación
- Fichero de la colección de Postman ```(Hiberus_Sesion_Sprint_Cloud.postman_collection.json)```
- Eureka: http://localhost:8761/
- RabbitMq: http://localhost:15672/#/
	usr / pwd: guest / guest
- Zipkin: http://localhost:9411/zipkin/
- Config server: http://localhost:8888/<service_name>/default

# Autor del enunciado
José Ángel Martínez Vera
