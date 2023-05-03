
# Ejercicio01

Ejercicio de desarrollo de api rest 
creacion de usuario y generacion de token jwt

Nota: los diagramas se encuentran en la carpeta src/main/resources

 Creación de proyectos Java con Gradle

##### Esta guía lo guiará a través del uso de Gradle para construir un proyecto Java simple.

### Lo que necesitarás
+ Un editor de texto favorito o IDE
+ JDK 8 o posterior
+ Instalar Gradle

### Instalar Gradle
+ **En Unix**
```
$ sudo add-apt-repository ppa:cwchien/gradle
$ sudo apt-get update
$ sudo apt-get install gradle
```


+ **En Mac OS X**
    + `brew install gradle`

    + [Install Homebrew](http://brew.sh/).


+ **En Windows**

 + [Descargar del sitio de Gradle](https://docs.gradle.org/current/userguide/installation.html).

  + Descomprima la descarga de Gradle en la carpeta en la que desea instalar Gradle, p. “C:\Archivos de programa”. El subdirectorio gradle-x.x se creará a partir del archivo, donde x.x es la versión.

  + Agregue la ubicación de su carpeta "bin" de Gradle a su ruta. Abra las propiedades del sistema (WinKey + Pausa), seleccione la pestaña "Avanzado" y el botón "Variables de entorno", luego agregue "C:\Archivos de programa\gradle-x.x\bin" (o donde haya descomprimido Gradle) hasta el final de su variable "Ruta" en Propiedades del sistema. Asegúrese de omitir las comillas alrededor de la ruta, incluso si contiene espacios. También asegúrese de separar las entradas de PATH anteriores con un punto y coma ";".

  + En el mismo cuadro de diálogo, asegúrese de que JAVA_HOME exista en sus variables de usuario o en las variables del sistema y que esté configurado en la ubicación de su JDK, p. C:\Program Files\Java\jdk1.8.0_202 y que %JAVA_HOME%\bin está en su variable de entorno Path.

  + Abra un nuevo símbolo del sistema (escriba cmd en el menú Inicio) y ejecute gradle –version para verificar que esté instalado correctamente.
  
### Para probar la instalación de Gradle, ejecute Gradle desde la línea de comandos: `gradle`
+ Si todo va bien, verá un mensaje de bienvenida:
```
:help

Welcome to Gradle 2.8.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL

Total time: 6.317 secs
```

+

### Configurar el proyecto
 

### Build el codigo

Ahora debemos realizar lo siguiente(si existe gradle.build saltar al siguiente paso):

+ `cd Ejercicio01`. Esta es la carpeta de nuestro proyecto

+ Ahora ejecutar el comando `gradle build`.

    Para ver los resultados del esfuerzo de compilación, eche un vistazo a la carpeta de compilación. Allí encontrará varios directorios, incluidas estas tres carpetas:

    + classes. Los archivos .class compilados del proyecto.
    + libs. Bibliotecas de proyectos (generalmente archivos JAR y/o WAR).



+ Ya casi terminamos, simplemente ejecute este comando `gradle bootRun`.
  Ahora puedes ver la salida.

```
  Started Ejercicio01

  Application in 5.556 seconds (JVM running for 6.341)
<==========---> 80% EXECUTING [17m 37s]
> :bootRun
```






