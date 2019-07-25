# PruebaTecnicaIBM

## Pre requisitos
_Tener instalado Node.js, npm y angular CLI segun documentacion oficial: https://angular.io/_
_Realizar un update project de maven para tener actualizadas todas las dependencias del POM._
_Si devuelve un error el pom.xml Actualizar el m2e connector de maven_

## Consideraciones BackEnd
_Se utilizo el gestor de base de datos embebido Apache Derby_
_Se crearon los CRUDs en Backend para Asesores, Clientes, Tarjetas y Consumos. Quedando las operaciones como sigue:_
_Clientes:_
```
GET http://localhost:8080/ibm/customer
GET http://localhost:8080/ibm/customer/{id}
GET http://localhost:8080/ibm/customer/{id}/cards
POST http://localhost:8080/ibm/customer
PUT http://localhost:8080/ibm/customer
DELETE http://localhost:8080/ibm/customer/{id}
```
_Tarjetas_
```
GET http://localhost:8080/ibm/card
GET http://localhost:8080/ibm/card/{id}
GET http://localhost:8080/ibm/card/{id}/historys
POST http://localhost:8080/ibm/card
PUT http://localhost:8080/ibm/card
DELETE http://localhost:8080/ibm/card/{id}
```
_Historia de consumo_
```
GET http://localhost:8080/ibm/history
GET http://localhost:8080/ibm/history/{id}
POST http://localhost:8080/ibm/history
PUT http://localhost:8080/ibm/history
DELETE http://localhost:8080/ibm/history/{id}
```
_Asesores_
```
GET http://localhost:8080/ibm/adviser
GET http://localhost:8080/ibm/adviser/{id}
POST http://localhost:8080/ibm/adviser
PUT http://localhost:8080/ibm/adviser
DELETE http://localhost:8080/ibm/adviser/{id}
```

## Consideraciones FrontEnd
_Se hicieron vistas para:_
_- Crud Clientes_
_- Ver registros de clientes, tarjetas y consumos._
_- Crud Asesores._
_Se utilizaron las librerias:_
#### Rxjs
#### Forms
#### NgBootstrap
#### FontAwesome

## Consideraciones Deploy
_Con una cuenta en IBM Cloud se creo un recurso de CloudFoundry Java Liberty con el que es posible realizar deploys de aplicaciones Java Web. Se procedio a obtener el build Angular y el war de spring boot. Y se crea el archivo manifiest.yml que permite hacer el despliegue:
```
applications:
   - name: BackEndIBM
     random-route: true
     path: target/BackEndIBM-0.0.1-SNAPSHOT.war
     memory: 256M
     instances: 1
```
