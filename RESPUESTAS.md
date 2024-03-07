# PARTE I. - JUGANDO A SER UN CLIENTE HTTP
Abre la aplicación Postman, lo usaremos para hacer una solicitud a un servidor HTTP, al abrirlo indentifica qué controles de Postman corresponde a los elementos de entrada y salida de un servicio HTTP:


- Elementos de entrada:
    - Métodos:  
      ![img_1.png](img_1.png)

    - URL:
      ![img_2.png](img_2.png)

    - Headers:
      ![img_3.png](img_3.png)

    - Body:
      ![img_4.png](img_4.png)

    - Cookies:
      ![img_5.png](img_5.png)

- Elementos de salida:
    - Body: ![img_6.png](img_6.png)

    - Headers: ![img_7.png](img_7.png)

    - Cookies: ![img_8.png](img_8.png)

Ahora has otro request GET al recurso https://dummyjson.com/todos, nuevamente verifica el body en varias opciones.

- Pretty:  
  ![img_12.png](img_12.png)
- Raw:  
  ![img_13.png](img_13.png)
- Preview:  
  ![img_14.png](img_14.png)

Responde las siguientes preguntas:
- ¿Qué pasa si no envío el método correcto?  
  Si no envío el método correcto, me puede sale un mensaje indicando que no podemos hacer determinado método (diferente a GET), ya que no tenemos la autorización para usar esos métodos.
  ![img_15.png](img_15.png)
  ![img_16.png](img_16.png)
- ¿Qué pasa si al body response HTML lo fuerzo a leerse como JSON?  
  Si bien es posible que a simple vista se puede leer el contenido HTML como si fuera JSON en Postman, esto no significa que se esté interpretando correctamente. Postman intenta analizar el contenido según el tipo de contenido especificado en la cabecera Content-Type, aunque siga diciendo que es HTML.

  Postman muestra el contenido HTML como si fuera JSON, esto podría deberse a que el contenido HTML tiene alguna estructura que se asemeja a JSON, pero esto no garantiza que se pueda leer o manipular correctamente como un objeto JSON.
  ![img_17.png](img_17.png)
- ¿Por qué el preview de HTML no se ve igual a cuando accedo a la URL en un navegador web?  
  El preview de HTML en Postman puede no verse igual que en un navegador web por varias razones:

    1. Estilos CSS no aplicados: El preview en Postman puede no aplicar los estilos CSS correctamente, lo que puede hacer que la apariencia sea diferente.

    2. Interpretación de JavaScript: Postman no interpreta ni ejecuta JavaScript en el HTML, por lo que cualquier contenido generado dinámicamente por JavaScript no se mostrará en el preview.

    3. Compatibilidad con HTML y CSS: Postman puede no ser tan compatible con ciertas características de HTML y CSS como lo es un navegador web, lo que puede llevar a diferencias en la visualización.

    4. Problemas de codificación: Si el HTML utiliza una codificación específica que no se maneja correctamente en Postman, podría afectar la visualización.

  Postman  
  ![img_18.png](img_18.png)
  Navegador Web
  ![img_19.png](img_19.png)
- ¿Qué pasa si le envías un body a una solicitud GET?  
  Si no pongo nada en la URL pero si en el Body, no me deja mandar la solicitud.  
  Si pongo el Body en el campo de la URL, no se puede mandar porque claramente no es una URL.  
  Si pongo una URL que no corresponde al Body, aborta.  
  Si pongo la URL que es con su Body correspondiente, se hace una consulta normal.

Como parte del laboratorio en casa has los dos request anteriores pero ahora usando la herramienta Telnet, ya que esta no funciona adecuadamente en los equipos del laboratorio.

# PARTE II. - CLIENT SIDE RENDERING CON REACT

Verificando en terminal sería `$ npm init`

![img_20.png](img_20.png)

- Abre la aplicación https://codesandbox.io/s/react-js-simple-calculator-pefmr, loguéate con GitHub y juega cambiando los parámetros como colores y duplicando las líneas del archivo App.js con tags como `<ResultComponent ...>` en la función render.  
  ![img_21.png](img_21.png)  
  ![img_22.png](img_22.png)   
  ![img_23.png](img_23.png)

- ¿Qué hace cada uno de los archivos en la aplicación?
  .
  ├── package.json
  ├── public
  │   └── index.html
  └── src
  ├── App.js
  ├── components
  │   ├── KeyPadComponent.js
  │   └── ResultComponent.js
  ├── index.js
  └── styles.css

    - package.json: Archivo de configuración de npm que contiene información sobre el proyecto y sus dependencias, scripts de ejecución, etc.
    - public: Directorio que contiene archivos estáticos que se servirán tal cual al navegador, como index.html.
        - index.html: Página principal de la aplicación web.
    - src: Directorio que contiene el código fuente de la aplicación.
        - App.js: Componente principal de la aplicación que se utiliza para estructurar y renderizar otros componentes. Es donde está la "lógica" de la calculadora.
        - components: Directorio que contiene componentes reutilizables de la aplicación.
            - KeyPadComponent.js: Componente que representa un teclado o panel de botones.
            - ResultComponent.js: Componente que muestra el resultado de la operación o el cálculo.
        - index.js: Archivo de entrada principal que se utiliza para renderizar la aplicación en el DOM.
        - styles.css: Archivo de hoja de estilos que contiene estilos CSS para la aplicación.

- Después de haber visto los cambios, vuelve a abrir la URL original https://codesandbox.io/s/react-js-simple-calculator-pefmr y sigue los siguientes pasos:
1) Descargar código en un Zip  
   ![img_24.png](img_24.png)
2) Descomprimir el Zip en la carpeta de proyectos de software, (en ciertos PC solo funciona 7-Zip)  
![img_25.png](img_25.png)
3) Abrir una terminal de Git Bash en la carpeta descomprimida  
![img_26.png](img_26.png)
4) Instalar las dependencias con `npm install`  
![img_27.png](img_27.png)
5) Iniciar la aplicación con `npm star`, en algunos computadores con versiones antiguas de nodejs hay que agregar `NODE_OPTIONS=--openssl-legacy-provider npm run start`  
![img_28.png](img_28.png)
6) Si te sale el Firewall dale click en cancelar
7) Abrir la ruta http://localhost:3000/ en un navegador web como Firefox o Google Chrome  
![img_29.png](img_29.png)

Ahora, haz el request GET http://localhost:3000/ usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?  
![img_30.png](img_30.png)
El Body es igual al index.html, lo que significa que es un recurso web estático.
