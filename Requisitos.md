**Componentes Software**
- Aplicación de gestion: Empleados que realizaran la gestion de las estaciones y las bicicletas y usuarios de ambito general.
    2 tipos de usuarios con permisos diferentes.

- Aplicacion de explotación enfocada al usuario final: NO SE PIDE EN ESTA PRÁCTICA.


**Funcionalidades**
Se necesitan 3 módulos:
- Modulo de gestion de los usuarios de la plataforma.
- Modulo de gestion de las estaciones de bicicletas.
- Modulo de gestion de bicicletas y su ciclo de vida.

TODOS LOS MODULOS HAN DE SER ACCESIBLES DESDE UN MENÚ LATERAL O SUPERIOR. PREFERIBLEMENTE LATERAL AL IGUAL QUE EN EL AULA VIRTUAL.

---

**MODULO DE USUARIO**
Toda persona que se pueda relacionar con el sistema, ya sea empleado o usuario final.

**Atributos:**
- Identificador: Campo único, no se puede repetir => *¿int, string, alfanumerico?*
- Contraseña => *¿int, string, alfanumerico?*
- Nombre completo => *¿Nombre y dos apellidos; solo un apellido; un campo??, varios?, array, arrayList?*
- Foto => *Opcional*
- Fecha de alta en el sistema => *LocalDate*
- Estado => *Boolean*

**Metodos/Funcionalidades**
- Listar una lista de todos los usuarios del sistema. ESTA LISTA ES LA PANTALLA PRINCIPAL DEL MODULO. La lista tendrá el identificador, el nombre de usuario, nombre completo y estado. Pinchando sobre un usuario se pueden obtener sus detalles.

- Dar de alta un nuevo usuario en el sistema. A esta funcionalidad se accedera a partir de un boton en la lista de usuarios. Los campos se rellenaran a excepcion de fecha de alta y estado.

- Editar/modificar un usuario. Se permitira modificar todos los campos a excepcion de identificador y fecha de alta. A esta funcionalidad se accede a partir de un boton en la vision detallada del usuario en la lista de usuarios.

- Dar de baja un usuario en el sistema. Se cambiara el atributo estado a inactivo. Se accede a traves de la consulta de detalles de un usuario y desde la tabla principal con el listado de usuarios.


**Pantallas**
- Lista de usuarios
    - Detalles del usuario: ¿?¿? Se puede poner dentro de la lista o aparte ¿?¿?
- Crear nuevo usuario.
- Modificar usuario.
- Dar de baja usuario: ¿?¿? Confimarción por mensaje emergente ¿?¿?


---


**Estaciones de bicicleta**
Lugar donde se encuentran ancladas las bicicletas para que estas puedan ser alquiladas y devueltas por los usuarios finales.

**Atributos**
- Identificador unico del sistema *¿int,string,alfanumerico?*
- Numero de serie => Otro identificador unico a la estacion pero no a la base de datos. *Alfanumerico de 8 cifras*.
- Coordenadas => Autodefinido en decimal.
- Capacidad de bicicletas. x=5 || x=10 => *integer* Las estaciones son de 5 O de 10. Numero fijo, nada de rango.
- Estado => *Boolean*
- Fecha de instalación => *Local Date*

**Metodos/Funcionalidades**
- Listado de todas las estaciones disponibles. ES LA PANTALLA PRINCIPAL. Se puede buscar por identificador o número de serie.
- Pantalla de detalle de estación. Se mostrara al pinchar en una estación en la lista de estaciones, mostrara sus detalles y todos sus campos.
    OPCIONALMENTE UN MAPA CON LA UBICACIÓN DENTRO DEL CAMPUS => GOOGLE MAPS¿?¿?
    Detalles de cada bicicleta almacenada

- Desde el listado de estaciones se podrá: Borrar estacion, todas las bicicletas se cambiaran a sin base y la estacion estara inactiva
    + Enlace a una NUEVA pantalla para modificar las coordenadas de la estación.

- Dar de alta una nueva estación en el sistema. Fecha de alta y identificador se gestiona automaticamente.


**Pantallas**
- Lista de todas las estaciones.
    + Detalles de una estacion ¿?¿?
- Nueva estacion


---


**Bicicletas**
Se gestionara el ciclo de vida de cada bicicleta

**Atributos**
- Numero de serie: Código alfanumerico de 16 caracteres => *String*
- Modelo => *String*
- Fecha de alta en el sistema => *LocalDate*
- Estado => *int de 4 posibilidades? 0 - Sin Base; 1 - En base; 2 - Reservada; 3 - Baja*

**Funcionalidades**
- Lista de todas la bicicletas disponibles: ES LA PANTALLA PRINCIPAL. Se puede buscar por numero de serie o estado
    + Detalles de cada bicicleta. Historico de transiciones entre las bases.
    + Si no tiene base asignar a una base y cambiar estado. Comprobar la estacion y si tiene plazas disponibles.
    + Dar de baja una bicicleta

- Dar de alta una nueva bicicleta: Insertar todos los parametros a excepcion de identificador, estado y fecha de insercion. Se accede a traves del listado de bicicletas.

**Pantallas**
- Lista de bicicletas
    + Detalles de la estacion¿?¿? En lista o aparte????
    + Dar de baja¿?¿? En lista o aparte????
- Dar de alta


---

# Cosas que no hay que hacer

- No será necesario realizar el login ni gestión de Autenticación en la aplicación.
- No será necesario realizar una gestión de roles ni Autorización en la aplicación.
- No será necesario realizar más funcionalidades que las marcadas en el enunciado.
- No será necesario realizar validación de errores dinámicamente en cliente. La validación de errores se podrá realizar en servidor y:
    + Redirigir a una página genérica indicando que ha habido un error e indicando el detalle del error producido. Opcionalmente, en dicha página de error genérica, un enlace para que el usuario pueda volver a repetir la operación. 
    + (opcionalmente) Redirigir a la misma página con el formulario que produjo el error con un área donde incluir el detalle del error producido.








Mastering lambdas. Java programming


Servlet.
Peticion a lista bicicletas
Peticion a lista estaciones.

Application properties
logging.level.org.springframework.web=TRACE 
Traza cuando spring levanta la parte web.
