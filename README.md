
# Crud servidores y estadisticas 


<h1 align="center">
  <p align="center">Cliente restapi</p>
  <img src="https://raw.githubusercontent.com/andresigacgmail/generar-uso-storage/main/src/main/resources/static/img/generar%20uso.gif" alt="encriptador texto">
</h1>

> **Backend para la gestión de servidores y estadisticas.**


>
## Requisitos:
	- El web service debe:
- Administracion de servidores(CRUD).
- Administracion de estadisticas(CRUD).
- Persister los datos en PostgreSql
- Acceder a la api por medio del protocolo http.


```Por ejemplo:
"http://10.23.13.5:8080/stat" => "{"discos":[{"path":"C:\\","disco_total":126.0,"disco_disponible":87.0,"disco_uso":38.0},{"path":"D:\\","disco_total":31.0,"disco_disponible":28.0,"disco_uso":3.0},{"path":"F:\\","disco_total":399.0,"disco_disponible":191.0,"disco_uso":208.0}],"memoria_total":3.08,"memoria_uso":3.08,"memoria_disponible":1.12}"
```

