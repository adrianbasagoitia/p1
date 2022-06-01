### Modelo MVC *Model view Controller*      

#### **Modelo (*Model*)**
Modelo de datos. La clase java con el objeto java de toda la vida.


#### **Vista (*View*)**
Plantilla que general el html final. 

+ Recibe los datos del modelo.
+ Es un fichero .html *parcialmente vacio* referencia a cosas que solo se tienen en tiempo de ejecución y que vienen de la base de datos / navegador. 
+ **SE USARA MUSTACHE**
+ En las plantillas los elementos del modelo se marcaran con {{<elemento>}} para luego ser sustituidos por los valores finales.

#### **Controlador (*Controller*)**
Atiende las peticiones que vienen del navegador, lo que pide el usuario. 

+ **Es una clase Java**
+ Manda la peticion al modelo.
+ Manipula los datos de la BBDD
+ Utiliza servicios externos
+ Obtiene los datos que se visualizaran en la página web
+ Decide que plantilla generará el HTML final.

- La clase se denota con *@Controller*
- El metodo que ejecute la peticion HTML desde el navegador debe ser anotada con *@GetMapping ó **@PostMapping***
    + Tras la anotacion de arriba, se debe indicar la URL donde se "*pintara*" la página web. Ejem: @GetMapping("/greeting")
    + Debe tener el modelo como atributo de entrada.
    + Se debe añadir la información que sea visualizada como atributos del modelo en el bloque de código. 
    + El metodo deve devolver el nombre de la plantilla que vaya a "*pintar*" la página web.


---


### Generar HTML con Mustache
#### Generación condicional
##### Condiciones booleanas
En la Plantilla **Vista** se puede expresar cierto código HTML que permita detectar condiciones booleanas, si algo es cierto "*pintará*" cierca cosa y si es falso otra.
+ Se puede utilizar para listas vacias. ¿Condicion verdadera vacia, falsa con contenido?
+ Se puede utilizar para detectar objetos nulos ¿Condicion verdadera nulo, falsa con contenido?

Ejemplo:        
**Condicion verdadera**     
```HTML
{{#hello}}
<p>Hello,</p>
{{/hello}}

```

**Condicion Falsa**
```HTML
{{^hello}}
<p>Goodbye,</p>
{{/hello}}
```

##### Listas
Se pueden pintar listas sin saber el número de elementos simplemente anotando el HTML con el atributo que devuelve el modelo.

Ejem:
```HTML
<html>
<body>
    <p>Colors in list:</p>
    <ul>
    {{#colors}}
        <li>{{.}}</li> <!-- Se repetira esta linea por 
        cada elemento de la tabla -->
    {{/colors}}
    </ul>

    <p>Colors in table:</p>
    <table>
    {{#colors}}
        <tr>
            <td>{{-index}}</td> <!-- Se pueden especificar variables
            especiales como el índice de la iteración -->
            <td>{{.}}</td>
        </tr>
        {{/colors}}
        </table>
</body>
</html>
```
En general las lineas entre {{#<elemento>}} y {{/<elemento>}} se repiten en cada iteración al "*pintar*" una lista.        
Durante cada iteración se puede acceder a los atributos del objeto de la clase java poniendo el nombre del atributo entre llaves Ejem: {{nombre}}

#### Cabecera y pie común a todas las plantillas
Las plantillas pueden a su vez acceder al contenido de otras plantillas.
Para acceder al contenido de otras plantillas se debe especificar de la siguiente manera:
{{><nombre_plantila>}}

De esta manera se puede utilizar en todas las plantillas un header y un footer comun a todo el sitio web de forma sencilla dado que estos elementos no cambian de una plantilla a otra. Hay que destacar que aunque sean plantillas diferentes no se debe abrir/cerrar el tag <html>.
Es decir, el el header no se cerrará el tag y en el footer no se abrirá. Esto es debido a que Mustache copia el contenido del fichero y lo pega el la plantilla que lo solicita.

Los atributos del modelo (El objeto java) accesibles desde cualquier controlador se definen en un *@ControllerAdvice*  con metodos *@ModelAttribute* denotan

### Formularios y enlaces
Hay dos formas de enviar información desde el navegador hacie el servidor:
 - **Mediante un formulario HTML**: EL usuario introducirá de forma manual la información.
 - **Insertar la informacion en la URL**: La información estará disponible cuando el usuario pulse el enlace.

En el servidor la información puede ser recibida:
 - Como **pares clave-valor**
 - Se accede a la información como **parámetros** en los metodos del controlador


#### Formularios en HTML
Se delimita con el tag <form>, puede contener otros elementos HTML, "deberia" tener un action conteniendo la url del controlador que se ejecutará al enviar los datos al pulsar el boton de enviar. Ejem: <form action="<url_controlador>"></form>

**Los formularios SIEMPRE tienen que tener al menos un boton**

- Boton con texto: <input type="submit" value="Send"/> 
- Boton Gráfico: <input type="image" src="image.png"/>
- Campo de texto (Ejemplo el campo para introducir el nombre): <input type="text" name="param_name"/>
- Area de texto (Area de varias lineas, por ejemplo para hacer sugerencias): <textarea name='paramName' rows=5 cols=40> Text already written in the text area </textarea>
- Casilla de verificación: <input type='checkbox' name='paramName' value="OptionValue">Text right to the checkbox Example: Accept Cookies

#### Acceso a los datos desde el controlador
Los valores que reciba el controlador **deben** ser marcados con *@RequestParam*, el nombre del parametro y el del campo en el HTML deberian ser el mismo para evitar problemas.

Los parametros opcionales se deben marcar igual, salvo que debe añadirse el valor required = false y en el código java deben marcarse con un Optional. Ejem: @RequestParam Optional<String> surname1

Para enviar los datos desde el navegador al servidor hay dos maneras:
- Con el metodo **GET** del protocolo HTTP
- Con el metodo **POST** del protocolo HTTP

La manera preferida de hacerlo es con POST, las URLs son mas limpias y es mas seguro.

Anotacion a nivel de método en las clases controladoras Java:
- @GetMapping
- @RequestMapping => Tambien se puede usar a nivel de clase.
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

#### Insertar la informacion en la URL
Esto es desaconsejado.

### Inyeccion de dependencias

Las aplicaciones se suelen dividir en módulos de alto nivel o Componentes. Algunos componentes ofrecen servicios a otros. 



