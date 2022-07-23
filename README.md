Welcome to the Proyecto-ARSW-i wiki!

# Tic-Taciting
## ✒️Autor ✒️
* **Juan Mateo Mejia**
## 👾	Link Heroku:👾	
## https://matiwsxd.herokuapp.com/
##👽Link del repositorio del front:👽
## https://github.com/MatiwsxD/ARSW-I-FrontEnd
## 🚀Resumen🚀

_Este juego es un proyecto de ARSW y esta basado en el clásico juego de 3 en línea o triqui, como lo conocemos. El objetivo de este proyecto era construir una API que permitiera jugar el juego de forma online y además de esto que permita a multiples usuarios jugar._

### 📋Descripción📋
El juego está desplegado en dos partes, la primera es el backend y este tiene todos los servicios de bases de datos y una API REST, este se encarga de enviar y recibir datos además de tener alojado el WebSocket. En la segunda parte tenemos desplegada una aplicacion Node.js que es la encargada de interactuar con el usuario.
La idea principal del juego es que los jugadores consigan hacer una lineal recta o una en diagonal con su símbolo correspondiente. Adicionalmente, el juego va a contar con un sistema de registro para que el usuario se pueda registrar y pueda guardar información sobre su perfil, ya sea la cantidad de partidas jugadas, partidas ganadas y partidas perdidas.


### 🤓Casos de uso 🤓
## Pagina de login
![image](https://user-images.githubusercontent.com/42101956/173468746-9a26b6d9-c93f-4c83-8ea7-16f9e2324ed0.png)

## Pagina principal
![casoUso](https://user-images.githubusercontent.com/42101956/180586666-256a18c4-dbfe-437e-9fa0-cddc7877a8dc.png)



## Durante el juego
![image](https://user-images.githubusercontent.com/42101956/173468988-8e75f372-9522-49b8-a7d1-312e9bee1d96.png)

## Finalizar el juego
![image](https://user-images.githubusercontent.com/42101956/173469129-390ef365-f4b0-4870-b8dd-2f8f982faa7a.png)

### ⌨️Historias de uso ⌨️

```
* Como Jugador QUIERO crear una cuenta PARA PODER jugar y guardar mi progreso en el juego.
* Criterios de aceptación: 
- Que no haya una cuenta registrada con el mismo correo.
- Que no se pueda acceder con una contraseña incorrecta
- Que no se pueda acceder si el usuario no está registrado

```
```
* Como Jugador QUIERO unirme una sala PARA PODER jugar con amigos.
* Criterios de aceptación: 
-La cantidad máxima de jugadores es 2
-El juego no puede haber iniciado
-El juego solo iniciara cuando hayan dos jugadores en la sala 

```
```
* Como Jugador QUIERO ver las estadísticas de mi cuenta PARA PODER ver el progreso.
* Criterios de aceptación: 
- Las estadísticas se van a generar automáticamente 
- Las estadísticas no se van poder modificar manualmente
- Las estadisticas tienen que ser acorde con la cantidad de juegos que el jugador haya jugado
```

```
* Como Jugador QUIERO los movimientos de mi rival en tiempo real PARA PODER tomar decisiones y conseguir la victoria.
* Criterios de aceptación: 
- Se debe poder ver donde el enemigo puso su ficha en tiempo real
- No voy a poder modificar las celdas que previamente ya fueron usadas
- El juego debe mostrar quien fue el ganador
```

```
* Como jugador QUIERO ver las estadísticas de mi enemigo PARA PODER saber que tan bueno es mi oponente.}
* Criterios de aceptación: 
-En el ranking se debe mostrar cuantas partidas ha jugado, cuantas ha ganado y perdido
-Los jugadores no podrán modificar estos datos de forma manual
-Los datos van a ser guardados de manera automatica una vez la partida concluya
```
```
* Como Jugador QUIERO volver a la pagina principal PARA PODER iniciar una nueva partida.
* Criterios de aceptación:
- La sala debe desocuparse una vez se declare un ganador
- Los jugadores no deben poder volver al tablero de juego una vez termine la partida
``` 

## Diagrama de clases
![Clases](https://user-images.githubusercontent.com/42101956/180586593-5a00a1bc-8cdf-4411-9003-57c5ece1ee9a.jpg)



Diagrama de componentes

## ![DiagramaComponentes](https://user-images.githubusercontent.com/42101956/180587895-cfc8afed-0710-43e7-ae16-2fae2541cdea.jpg)


