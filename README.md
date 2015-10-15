#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-marketplace)
  - [Entidad Empresa](#entidad-empresa)
  - [Entidad IVA](#entidad-iva)
  - [Entidad Orden](#entidad-orden)
  - [Entidad Paquete](#entidad-paquete)
  - [Entidad Permiso](#entidad-permiso)
  - [Entidad PrecioUnitario](#entidad-preciounitario)
  - [Entidad Producto](#entidad-producto)
  - [Entidad Rol](#entidad-rol)
  - [Entidad Servicio](#entidad-servicio)
  - [Entidad Usuario](#entidad-usuario)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /marketplace.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación marketplace
###Entidad Empresa
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Empresa, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Empresa
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    nit: '' /*Tipo Long que representa id de String*/,
    actividadEconomica: '' /*Tipo Long que representa id de Integer*/,
    direccion: '' /*Tipo Long que representa id de String*/,
    ciudad: '' /*Tipo Long que representa id de String*/,
    telefono: '' /*Tipo Long que representa id de String*/,
    fax: '' /*Tipo Long que representa id de String*/,
    paginaWeb: '' /*Tipo Long que representa id de String*/,
    nombresRepresentateLegal: '' /*Tipo Long que representa id de String*/,
    apellidosRepresentanteLegal: '' /*Tipo Long que representa id de String*/,
    tipoEmpresa: '' /*Tipo Long que representa id de String*/,
    vigiladaSuperfinanciera: '' /*Tipo Long que representa id de Boolean*/,
    vigiliadaSupersolidaria: '' /*Tipo Long que representa id de Boolean*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/empresas|Obtener todos los objetos JSON de Empresa (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Empresa y el total de registros en la base de datos en el header X-Total-Count
**GET**|/empresas/:id|Obtener los atributos de una instancia de Empresa en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Empresa
**POST**|/empresas|Crear una nueva instancia de la entidad Empresa (CREATE)||Objeto JSON de Empresa a crear|Objeto JSON de Empresa creado
**PUT**|/empresas/:id|Actualiza una instancia de la entidad Empresa (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Empresa|Objeto JSON de Empresa actualizado
**DELETE**|/empresas/:id|Borra instancia de Empresa en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Empresa
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Empresa son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|empresas/:id/ordenes|Obtener Objetos JSON de ordenes(Orden) dependientes de Empresa|**@PathParam id**: `id` de instancia de Empresa||Colección de objetos JSON de ordenes(Orden)
**POST**|empresas/:id/ordenes|Creación de instancias de ordenes(Orden) dependientes de Empresa|**@PathParam id**: `id` de instancia de Empresa|Colección de objetos JSON de ordenes(Orden) a crear|Colección de objetos JSON de ordenes(Orden) creados con sus respectivos ID
**PUT**|empresas/:id/ordenes|Actualización de instancias de ordenes(Orden) dependientes de Empresa|**@PathParam id**: `id` de instancia de Empresa|Colección de objetos JSON de ordenes(Orden) a actualizar|Colección de objetos JSON de ordenes(Orden) actualizados
**DELETE**|empresas/:id/ordenes|Eliminación de instancias de ordenes(Orden) dependientes de Empresa|**@PathParam id**: `id` de instancia de Empresa|Colección de atributo `id` de ordenes(Orden) a eliminar|

[Volver arriba](#tabla-de-contenidos)

###Entidad IVA
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad IVA, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto IVA
```javascript
{
    porcentajeIVA: '' /*Tipo Double*/,
    fechaInicioVigencia: '' /*Tipo Long que representa id de Date*/,
    fechaFinVigencia: '' /*Tipo Long que representa id de Date*/,
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/iVAs|Obtener todos los objetos JSON de IVA (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON IVA y el total de registros en la base de datos en el header X-Total-Count
**GET**|/iVAs/:id|Obtener los atributos de una instancia de IVA en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de IVA
**POST**|/iVAs|Crear una nueva instancia de la entidad IVA (CREATE)||Objeto JSON de IVA a crear|Objeto JSON de IVA creado
**PUT**|/iVAs/:id|Actualiza una instancia de la entidad IVA (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de IVA|Objeto JSON de IVA actualizado
**DELETE**|/iVAs/:id|Borra instancia de IVA en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Orden
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Orden, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Orden
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    manejoCreditoConsumo: '' /*Tipo Long que representa id de Boolean*/,
    manejoCreditoComercial: '' /*Tipo Long que representa id de Boolean*/,
    manejoCreditoLibranza: '' /*Tipo Long que representa id de Boolean*/,
    manejoCreditoHipotecario: '' /*Tipo Long que representa id de Boolean*/,
    manejoMicrocredito: '' /*Tipo Long que representa id de Boolean*/,
    fechaRegistroOrden: '' /*Tipo Long que representa id de Date*/,
    fechaInicioFacturacion: '' /*Tipo Long que representa id de Date*/,
    estadoOrden: '' /*Tipo Long que representa id de Integer*/,
    idCoreCartera: '' /*Tipo Long que representa id de String*/,
    usuarioCoreCartera: '' /*Tipo Long que representa id de String*/,
    urlCoreCartera: '' /*Tipo Long que representa id de String*/,
    numeroUsuariosInicial: '' /*Tipo Long que representa id de Integer*/,
    numeroCreditosInicial: '' /*Tipo Long que representa id de Integer*/,
    valorCarteraInicial: '' /*Tipo Long que representa id de Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/ordens|Obtener todos los objetos JSON de Orden (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Orden y el total de registros en la base de datos en el header X-Total-Count
**GET**|/ordens/:id|Obtener los atributos de una instancia de Orden en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Orden
**POST**|/ordens|Crear una nueva instancia de la entidad Orden (CREATE)||Objeto JSON de Orden a crear|Objeto JSON de Orden creado
**PUT**|/ordens/:id|Actualiza una instancia de la entidad Orden (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Orden|Objeto JSON de Orden actualizado
**DELETE**|/ordens/:id|Borra instancia de Orden en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Paquete
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Paquete, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Paquete
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    descripcion: '' /*Tipo Long que representa id de String*/,
    activo: '' /*Tipo Long que representa id de Boolean*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/paquetes|Obtener todos los objetos JSON de Paquete (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Paquete y el total de registros en la base de datos en el header X-Total-Count
**GET**|/paquetes/:id|Obtener los atributos de una instancia de Paquete en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Paquete
**POST**|/paquetes|Crear una nueva instancia de la entidad Paquete (CREATE)||Objeto JSON de Paquete a crear|Objeto JSON de Paquete creado
**PUT**|/paquetes/:id|Actualiza una instancia de la entidad Paquete (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Paquete|Objeto JSON de Paquete actualizado
**DELETE**|/paquetes/:id|Borra instancia de Paquete en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Paquete
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Paquete son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|paquetes/:id/ordenes|Obtener instancias de ordenes(Orden) asociados con Paquete|**@PathParam id**: `id` de instancia de Paquete||Colección de `id` de ordenes(Orden) asociados con Paquete
**PUT**|paquetes/:id/ordenes|Actualización de referencias a ordenes(Orden) desde Paquete|**@PathParam id**: `id` de instancia de Paquete|Colección de `id` de ordenes(Orden) a asociar|Colección de objetos JSON de ordenes(Orden) asociados
**GET**|paquetes/:id/servicios|Obtener instancias de servicios(Servicio) asociados con Paquete|**@PathParam id**: `id` de instancia de Paquete||Colección de `id` de servicios(Servicio) asociados con Paquete
**PUT**|paquetes/:id/servicios|Actualización de referencias a servicios(Servicio) desde Paquete|**@PathParam id**: `id` de instancia de Paquete|Colección de `id` de servicios(Servicio) a asociar|Colección de objetos JSON de servicios(Servicio) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Permiso
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Permiso, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Permiso
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    url: '' /*Tipo Long que representa id de String*/,
    metodoRest: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/permisos|Obtener todos los objetos JSON de Permiso (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Permiso y el total de registros en la base de datos en el header X-Total-Count
**GET**|/permisos/:id|Obtener los atributos de una instancia de Permiso en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Permiso
**POST**|/permisos|Crear una nueva instancia de la entidad Permiso (CREATE)||Objeto JSON de Permiso a crear|Objeto JSON de Permiso creado
**PUT**|/permisos/:id|Actualiza una instancia de la entidad Permiso (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Permiso|Objeto JSON de Permiso actualizado
**DELETE**|/permisos/:id|Borra instancia de Permiso en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Permiso
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Permiso son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|permisos/:id/roles|Obtener instancias de roles(Rol) asociados con Permiso|**@PathParam id**: `id` de instancia de Permiso||Colección de `id` de roles(Rol) asociados con Permiso
**PUT**|permisos/:id/roles|Actualización de referencias a roles(Rol) desde Permiso|**@PathParam id**: `id` de instancia de Permiso|Colección de `id` de roles(Rol) a asociar|Colección de objetos JSON de roles(Rol) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad PrecioUnitario
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad PrecioUnitario, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto PrecioUnitario
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    precioUnidad: '' /*Tipo Double*/,
    rangoInicial: '' /*Tipo Long que representa id de Integer*/,
    rangoFinal: '' /*Tipo Long que representa id de Integer*/,
    fechaInicioValidez: '' /*Tipo Long que representa id de Date*/,
    fechaFinValidez: '' /*Tipo Long que representa id de Date*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/precioUnitarios|Obtener todos los objetos JSON de PrecioUnitario (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON PrecioUnitario y el total de registros en la base de datos en el header X-Total-Count
**GET**|/precioUnitarios/:id|Obtener los atributos de una instancia de PrecioUnitario en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de PrecioUnitario
**POST**|/precioUnitarios|Crear una nueva instancia de la entidad PrecioUnitario (CREATE)||Objeto JSON de PrecioUnitario a crear|Objeto JSON de PrecioUnitario creado
**PUT**|/precioUnitarios/:id|Actualiza una instancia de la entidad PrecioUnitario (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de PrecioUnitario|Objeto JSON de PrecioUnitario actualizado
**DELETE**|/precioUnitarios/:id|Borra instancia de PrecioUnitario en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Producto
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Producto, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Producto
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    descripcion: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/productos|Obtener todos los objetos JSON de Producto (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Producto y el total de registros en la base de datos en el header X-Total-Count
**GET**|/productos/:id|Obtener los atributos de una instancia de Producto en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Producto
**POST**|/productos|Crear una nueva instancia de la entidad Producto (CREATE)||Objeto JSON de Producto a crear|Objeto JSON de Producto creado
**PUT**|/productos/:id|Actualiza una instancia de la entidad Producto (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Producto|Objeto JSON de Producto actualizado
**DELETE**|/productos/:id|Borra instancia de Producto en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Producto
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Producto son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|productos/:id/servicios|Obtener instancias de servicios(Servicio) asociados con Producto|**@PathParam id**: `id` de instancia de Producto||Colección de `id` de servicios(Servicio) asociados con Producto
**PUT**|productos/:id/servicios|Actualización de referencias a servicios(Servicio) desde Producto|**@PathParam id**: `id` de instancia de Producto|Colección de `id` de servicios(Servicio) a asociar|Colección de objetos JSON de servicios(Servicio) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Rol
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Rol, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Rol
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/rols|Obtener todos los objetos JSON de Rol (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Rol y el total de registros en la base de datos en el header X-Total-Count
**GET**|/rols/:id|Obtener los atributos de una instancia de Rol en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Rol
**POST**|/rols|Crear una nueva instancia de la entidad Rol (CREATE)||Objeto JSON de Rol a crear|Objeto JSON de Rol creado
**PUT**|/rols/:id|Actualiza una instancia de la entidad Rol (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Rol|Objeto JSON de Rol actualizado
**DELETE**|/rols/:id|Borra instancia de Rol en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Rol
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Rol son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|rols/:id/permisos|Obtener instancias de permisos(Permiso) asociados con Rol|**@PathParam id**: `id` de instancia de Rol||Colección de `id` de permisos(Permiso) asociados con Rol
**PUT**|rols/:id/permisos|Actualización de referencias a permisos(Permiso) desde Rol|**@PathParam id**: `id` de instancia de Rol|Colección de `id` de permisos(Permiso) a asociar|Colección de objetos JSON de permisos(Permiso) asociados
**GET**|rols/:id/usuarios|Obtener instancias de usuarios(Usuario) asociados con Rol|**@PathParam id**: `id` de instancia de Rol||Colección de `id` de usuarios(Usuario) asociados con Rol
**PUT**|rols/:id/usuarios|Actualización de referencias a usuarios(Usuario) desde Rol|**@PathParam id**: `id` de instancia de Rol|Colección de `id` de usuarios(Usuario) a asociar|Colección de objetos JSON de usuarios(Usuario) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Servicio
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Servicio, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Servicio
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/servicios|Obtener todos los objetos JSON de Servicio (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Servicio y el total de registros en la base de datos en el header X-Total-Count
**GET**|/servicios/:id|Obtener los atributos de una instancia de Servicio en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Servicio
**POST**|/servicios|Crear una nueva instancia de la entidad Servicio (CREATE)||Objeto JSON de Servicio a crear|Objeto JSON de Servicio creado
**PUT**|/servicios/:id|Actualiza una instancia de la entidad Servicio (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Servicio|Objeto JSON de Servicio actualizado
**DELETE**|/servicios/:id|Borra instancia de Servicio en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Servicio
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Servicio son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|servicios/:id/precios|Obtener Objetos JSON de precios(PrecioUnitario) dependientes de Servicio|**@PathParam id**: `id` de instancia de Servicio||Colección de objetos JSON de precios(PrecioUnitario)
**POST**|servicios/:id/precios|Creación de instancias de precios(PrecioUnitario) dependientes de Servicio|**@PathParam id**: `id` de instancia de Servicio|Colección de objetos JSON de precios(PrecioUnitario) a crear|Colección de objetos JSON de precios(PrecioUnitario) creados con sus respectivos ID
**PUT**|servicios/:id/precios|Actualización de instancias de precios(PrecioUnitario) dependientes de Servicio|**@PathParam id**: `id` de instancia de Servicio|Colección de objetos JSON de precios(PrecioUnitario) a actualizar|Colección de objetos JSON de precios(PrecioUnitario) actualizados
**DELETE**|servicios/:id/precios|Eliminación de instancias de precios(PrecioUnitario) dependientes de Servicio|**@PathParam id**: `id` de instancia de Servicio|Colección de atributo `id` de precios(PrecioUnitario) a eliminar|

######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|servicios/:id/paquetes|Obtener instancias de paquetes(Paquete) asociados con Servicio|**@PathParam id**: `id` de instancia de Servicio||Colección de `id` de paquetes(Paquete) asociados con Servicio
**PUT**|servicios/:id/paquetes|Actualización de referencias a paquetes(Paquete) desde Servicio|**@PathParam id**: `id` de instancia de Servicio|Colección de `id` de paquetes(Paquete) a asociar|Colección de objetos JSON de paquetes(Paquete) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Usuario
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Usuario, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Usuario
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    correoElectronico: '' /*Tipo Long que representa id de String*/,
    contrasenia: '' /*Tipo Long que representa id de String*/,
    cargo: '' /*Tipo Long que representa id de String*/,
    nombresContacto: '' /*Tipo Long que representa id de String*/,
    apellidosContacto: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/usuarios|Obtener todos los objetos JSON de Usuario (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Usuario y el total de registros en la base de datos en el header X-Total-Count
**GET**|/usuarios/:id|Obtener los atributos de una instancia de Usuario en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Usuario
**POST**|/usuarios|Crear una nueva instancia de la entidad Usuario (CREATE)||Objeto JSON de Usuario a crear|Objeto JSON de Usuario creado
**PUT**|/usuarios/:id|Actualiza una instancia de la entidad Usuario (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Usuario|Objeto JSON de Usuario actualizado
**DELETE**|/usuarios/:id|Borra instancia de Usuario en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Usuario
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Usuario son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|usuarios/:id/empresas|Obtener Objetos JSON de empresas(Empresa) dependientes de Usuario|**@PathParam id**: `id` de instancia de Usuario||Colección de objetos JSON de empresas(Empresa)
**POST**|usuarios/:id/empresas|Creación de instancias de empresas(Empresa) dependientes de Usuario|**@PathParam id**: `id` de instancia de Usuario|Colección de objetos JSON de empresas(Empresa) a crear|Colección de objetos JSON de empresas(Empresa) creados con sus respectivos ID
**PUT**|usuarios/:id/empresas|Actualización de instancias de empresas(Empresa) dependientes de Usuario|**@PathParam id**: `id` de instancia de Usuario|Colección de objetos JSON de empresas(Empresa) a actualizar|Colección de objetos JSON de empresas(Empresa) actualizados
**DELETE**|usuarios/:id/empresas|Eliminación de instancias de empresas(Empresa) dependientes de Usuario|**@PathParam id**: `id` de instancia de Usuario|Colección de atributo `id` de empresas(Empresa) a eliminar|

######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|usuarios/:id/roles|Obtener instancias de roles(Rol) asociados con Usuario|**@PathParam id**: `id` de instancia de Usuario||Colección de `id` de roles(Rol) asociados con Usuario
**PUT**|usuarios/:id/roles|Actualización de referencias a roles(Rol) desde Usuario|**@PathParam id**: `id` de instancia de Usuario|Colección de `id` de roles(Rol) a asociar|Colección de objetos JSON de roles(Rol) asociados
[Volver arriba](#tabla-de-contenidos)

