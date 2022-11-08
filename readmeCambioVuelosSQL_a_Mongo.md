# Kata 1 Cambiar micros de vuelos que usa PostgreSQL a Mango

# Pasos a seguir

Para hacer el cambio de modelo relacional a no relacional en los micro-servicios asociados a las reservas de vuelos,
tenemos que realizar una serie de pasos:

	Lo primero de todo, es disponer de una base de datos no relaccional (NoSQL), por ello 
	tenemos que decidirnos por una de las que existan. He buscado información de Mongo para hacer esto.

El archivo docker-compose.yml lo modifico cambiando la base de datos a Mongodb

![](../../Imágenes/Capturas de pantalla/Captura desde 2022-11-08 16-05-24.png)

Dependencias

Una vez tenemos la base de datos dockerizada, tenemos que añadir dependencias en los módulos asignados a hacer uso de ella.
También hay que modificar el fichero de configuración dentro de resources en caso de Intellij, application.yml o application.properties.

![](../../Imágenes/Capturas de pantalla/Captura desde 2022-11-08 16-07-48.png)

![](../../Imágenes/Capturas de pantalla/Captura desde 2022-11-08 16-09-01.png)



Entidades

Anotamos en las entidades de vuelos y vuelosoferta para reservas la anotación @Document con mucha atención de que usa la
dependencia Mongo que hemos añadido a POM.



Repositorios

El repositorio en vez de extender de JPA repository deberá extender de MongoRepository.

Prácticamente, sin tener que cambiar nada, puedes aprovechar todas las palabras clave 
de Spring Data, como FindBy, Between, IsGreaterThan, Like, Exists, etc.



Servicios

Se inyectan y se utilizan los repositorios en los servicios como se haría normalmente, no es necesario ninguna
modificación en estos.

Inicialización de datos

Nos creamos una clase para inicializar los datos del documento vuelos

![](../../Imágenes/Capturas de pantalla/Captura desde 2022-11-08 16-42-52.png)

# Problemas Encontrados
Para esta práctica, he seguido varios tutoriales y son cambios simples, pero tengo problemas para que
me cree la base de datos en mongo y añada los datos de inicialización de vuelos.
Al no montar la base de datos, hace saltar una exception 500 cuando va en busca de datos hacia el repositorio.
No he conseguido solucionar esto basta que es un cambio muy simple, debería de funcionar con estos cambios.
Faltaría una vez solucionado esto el cambio de configuración de la base de datos H2 para tests hacia flapdoodle que
es similar a h2 pero como base de datos no relacional.

# Autor del enunciado
Tomás Benedí Santos
