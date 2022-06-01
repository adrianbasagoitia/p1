# README
This document will list all the features required for the correct implementation of the practice 1 of the subject Distributed Systems.

Beyond this point the document the document will be in spanish for simplicity.

El enunciado de la práctica expone que la intencion de la universidad es implementar un programa de movimiento sostenible dentro de los campus mediante la implementacion de un sistema de alquiler de bicicletas llamado BiciURJC, dentro de este programa se requiere una software de caracter distribuido para manejar toda la plataforma.

El pliego del proyecto detalla dos componentes software dentro, de los cuales solo el primero, la aplicación de gestion, es de nuestra actual competencia.

## Funcionalidades requeridas
La aplicacion de gestion debera implementar diferentes funcionalidades, que se gestionaran en los siguientes "modulos estancos":

- **Módulo de gestión de los usuarios**
- **Módulo de gestión de las estaciones**
- **Módulo de gestion de bicicletas**

La aplicación deberá ser distribuida y accesible mediante pagina web. El pliego indica que la implementación del código se ha de programar en el lenguaje Java, ademas al requerirse almacenamiento de datos se necesitará de una base de datos y al tratarse de web la correspondiente implementacion con código HTML/CSS.

---

### Modulo de gestion de los usuarios
La aplicación permitirá gestionar los usuarios del sistema. Un usuario es cualquier persona que pueda interactuar con el sistema, esto engloba tanto a personal de mantenimiento, gestion y/o usuarios finales.

**Notas para la implementación**
Este módulo dispondrá de una clase en java que se llamará User.java, los atributos y funcionalidades requeridos estarán dentro de esta clase, esta clase será la base y creara automaticamente una tabla en la base de datos donde almacenara todos los usuarios del sistema y desde domde se podra realizar consultas SQL para obtener información.
Pantallas:
- Lista general de usuarios.
- Lista detallada de un usuario.
- Creacion de un usuario.
- Modificación de un usuario.


#### Atributos
Un **usuario** estara definido por los siguientes atributos:
- **Identificador**: Atributo **único** que permita definir univocamente a un usuario. Será la **clave principal** en la tabla de la base de datos.
    + Tipo: **Entero**
    + Elección: Automatica

- **Contraseña**: Contraseña de acceso al sistema.
    + Tipo: Alfanumerico => **String**
    + Longitud: 8 <= x >= 16
    + Restricciones: Al menos una letra del alfabeto inglés y un numero entero
    + Elección: Usuario

- **Nombre completo**: Nombre del usuario, La implementacion de este campo puede resultar complicada debido a la disparidad de tipos de nombrado que existen alrededor del mundo, dado que la aplicación esta pensada para España, la convencion que se seguira será de nombre y dos apellidos, dado que personas extranjeras con otros tipos de nombre pueden venir a estudiar a la URJC (Erasmus) se permite que los campos apellidos puedan ser vacios, pero los caractteres del nombre deben ser del alfabeto latino.        
Nota: El mundo anglosajon utiliza solo un apellido, los paises arabes pueden utilizar numerosos nombres y solo un apellido, etc...

    + Tipo: **Array de String**
    + Tamaño: Fijo, 3
    + Null: Posible
    + Elección: Usuario

- **Foto**: Fotografia del usuario. Si se decide implementar esta funcionalidad este campo se expandira con la información correspondiente.

- **Fecha de alta**: Corresponderá con la fecha en la que el usuario se registra en la aplicación.
    + Tipo: **LocalDate**
    + Formato: aaaa/MM/dd => año, mes, día
    + Elección: Automatica, se aplicará la fecha del servidor

- **Estado**: Estado del usuario en el sistema. Solo podra tener dos posibles valores: Activo o Inactivo.
    + Tipo: **Boolean** => True: Activo; False: Inactivo.
    + Elección: Automatica, se inicializará en Activo por defecto

#### Funcionalidades
- **Lista de usuarios**: El sistema permitira recopilar y mostrar **todos** los usuarios del sistema. Esta funcionalidad tendrá que llamar a la base de datos y "pintar" en la pantalla correspondiente la información. La lista podrá ser total o paginada, se espera a posterior implementación para la decisión final.

- **Nuevo usuario**: El sistema creará un nuevo objeto usuario y será almacenado en la base de datos. El identificador unico, la fecha de alta y es estado se asignaran automaticamente, el resto deberán ser rellenados en un formulario en la pantalla, posteriormente manejados por el código java y almacenados en ultima instancia en la base de datos. A esta funcionalidad se debe acceder desde la pantalla donde se listan todos los usuarios.

- **Editar usuario**: El sistema permitirá modificar total o parcialmente todos los datos que pueden ser introducidos por el usuario durante su creacion añadiendo en este caso el estado. A esta funcionalidad se debe poder acceder a través de la pantalla donde se lista detalladamente a un usuario.

    ##### Nota: Preguntar si en editar usuario se permite modificar estado.

- **Dar de baja a un usuario**: Permitirá cambiar el estado de un usuario a inactivo. Es un '*soft delete*', elimina un usuario del sistema, no eliminandolo del sistema y evitando crear inconsistencias en la base de datos. Se "accede" desde la pantalla de la lista de usuarios general y desde la pantalla de detalles del usuario. No se considerá necesario crear una pantalla especifica para esta funcionalidad, esta funcionalidad se implementará como un boton en las pantallas anteriormente mencionadas y al pulsarse el boton se llamará al metodo java que a su vez mandará un consulta SQL que modifique el estado del usuario en la base de datos.

---

### Modulo de gestión de estaciones.
Se considerá una estación, como el lugar donde se encuentrán ancladas/almacenadas las bicicletas disponibles para el uso.

#### Atributos
Una **estación** esta definida por los siguientes atributos:
- **Identificador**: Atributo **único** que permita definir univocamente a un estación. Será la **clave principal** en la tabla de la base de datos.
    + Tipo: **Entero**
    + Elección: Automatica

- **Numero de serie**: Atributo **único** que será un identificador secundario. Será una clave secundaria en la tabla de la base de datos.
    + Tipo: **Entero**
    + Elección: Automática

- **Coordenadas**: Latitud y longitud donde se encuentra la estación. Serán en coordenadas decimales para su uso en la implementacion final.
    + Tipo: **Coordenada => Autodefinido**
    + Elección: Usuario

- **Capacidad**: Número de bicicletas que una estacion puede almacenar.
    + Tipo: **Entero**
    + Valores: 5 ó 10. Valores fijos, se introducirá mediante una lista desplegable en el formulario correspondiente de la pantalla.
    + Elección: Usuario

- **Estado**: Estado de la estación en el sistema. Solo podrá tener dos posibles valores: Activo o Inactivo.
    + Tipo: **Boolean** => True: Activo; False: Inactivo.
    + Elección: Automatica, se inicializará en Activo por defecto

- **Fecha de instalación**: Fecha en la que la estación fue instalada.
    + Tipo: **LocalDate**
    + Formato: aaaa/MM/dd => año, mes, día
    + Elección: Automatica, se aplicará la fecha del servidor


#### Funcionalidades

- **Lista de estaciones**: El sistema permitira recopilar y mostrar **todos** los estaciones del sistema. Esta funcionalidad tendrá que llamar a la base de datos y "pintar" en la pantalla correspondiente la información. La lista podrá ser total o paginada, se espera a posterior implementación para la decisión final.

- **Borrar Estacion**: El sistema dejará las bicicletas asignadas a la estación en el estado Sin-Base y la estacion en inactiva.

- **Editar coordenadas**: El sistema permitirá modificar las coordenadas de una estación.

- **Crear estación**: Se creará una nueva estación con los datos proporcionados excepto la fecha de alta, y el identificador unico de la estación que se asignaran automaticamente.

---

### Gestion del ciclo de vida de las bicicletas

#### Atributos
- **Número de serie**: Código alfanumerico **unico** de 16 caracteres. Será la clave primaria de la taba de la base de datos.
    + Tipo: Alfanúmerico => **String**
    + Asignación: Automatica

- **Modelo**: Atributo que referencie el modelo de la bicicleta, Ej: Shimano A4. Se entiende que dentro del modelo tambien entra la marca de la bicicleta, dado que diferentes empresas pueden tener un modelo que se llame igual.
    + Tipo: **String**
    + Elección: Usuario

- **Fecha de alta en el sistema**: Fecha en la que la bicicleta se **registro** en el sistema.
    + Tipo: **LocalDate**
    + Elección: Automatica, la fecha del servidor.

- **Estado en el que se encuentra**: Campo en el que se representará cual es el estado de la bicicleta: Sin-Base, En-Base, Reservada, Baja. Son cuatro estados, por lo tanto no puede ser booleano, se puede modelar como un entero con valores 0 a 3, ó como un String. Se espera a posterior implementación para decidir.
    + Tipo: **Indeterminado**
    + Elección: Automatica, al **registrar** una bicicleta se asignara automaticamente al estado Sin-Base.

- **Log de los estados**: Campo en el que se almacenará cualquier transicion en el automata del ciclo de vida de la bicicleta. Almacenará no solo la transicion entre estados sino que almacenará al menos la fecha en la que se realizo el cambio de estado
    - Tipo: **ArrayList** de dos campos: **Estado - Fecha**
    - Elección: Automatica, al crear la bicicleta está vacio y se aañadira automaticamente un primer elemento: **Sin-Base - {Fecha-de-creacion}**

#### Funcionalidades
- **Listado de todas la bicicletas en el sistema**: El sistema permitira recopilar y mostrar **todas** las bicicletas del sistema. Esta funcionalidad tendrá que llamar a la base de datos y "pintar" en la pantalla correspondiente la información. La lista podrá ser total o paginada, se espera a posterior implementación para la decisión final.

- **Dar de alta bicicleta**: Da de alta una nueva bicicleta en el sistema y asigna automaticamente el identificador, la fecha y el estado.

- **Dar de baja bicicleta**: *Sot-Delete* de la bicicleta, cambiar estado a Baja y eliminar de la estacion si la bicicleta estuviese almacenada.


---
---
# Requisitos Enunciado
- **Maquetacion HTML, CSS y Bootstrap**
- Backend con **Spring-MVC => Mustache** y **Spring-Data => Base de datos H2** utilizando interfaz **jpaRepository** y el datasource = **spring.datasource.url=jdbc:h2:mem:bdSDPractica1**.
- Servidor con **Tomcat**
- NO SE PUEDEN USAR PLANTILLAS DE BOOTSTRAP
- APLICACION EJECTADA EN EL PUERTO 8080 => localhost:8080/