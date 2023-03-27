
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
"http://localhost:8081/servidor" => "[
    {
        "t_id": 1,
        "direccion_ip_privada": "10.23.13.11",
        "direccion_ip_publica": "20.122.69.231",
        "puerto": "8080",
        "usuario": "redgeodesica",
        "contrasenia": "fake123",
        "nombre": "SCCTPRD02",
        "alias": "2 x Servidores de clúster",
        "uso": null,
        "dominio": null,
        "tipo_protocolo": 5
    }]"
```

