# 🚗 Sistema de Gestión de Garage

## 📌 Descripción

Este proyecto consiste en un sistema de gestión de un garage desarrollado en Java, que permite registrar el ingreso y egreso de vehículos, controlar la capacidad disponible y generar reportes.

El sistema fue diseñado utilizando Programación Orientada a Objetos (POO), aplicando conceptos como herencia, polimorfismo, manejo de excepciones y separación por capas.

---

## 🛠️ Tecnologías utilizadas

- Java JDK 17
- IntelliJ IDEA

---

## 🏗️ Arquitectura

El sistema sigue una estructura por capas:

* **model**: Contiene las clases del dominio (`Vehiculo`, `Auto`, `Moto`, `Camion`, `Garage`)
* **service**: Contiene la lógica de negocio (`GarageService`)
* **exceptions**: Excepciones personalizadas para manejo de errores
* **interfaces**: Interfaces (`Calculable`, `Mostrable`)
* **ui**: Interfaz de usuario por consola (`Main`)

Diagramas UML:
https://lucid.app/lucidchart/1745976b-a80a-49aa-84b9-36520023b469/edit?invitationId=inv_9e1d39e8-c7e4-4e8a-b073-dc3b404273de&page=0_0#

---

## 🚀 Funcionalidades

* Registrar ingreso de vehículos
* Registrar salida de vehículos
* Listar vehículos estacionados
* Consultar estado del garage
* Generar reportes (cantidad por tipo, recaudación, espacios)

---

## 🚗 Tipos de Vehículos

| Tipo   | Espacio | Costo por hora |
| ------ | ------- | -------------- |
| Moto   | 1       | 700            |
| Auto   | 2       | 1000           |
| Camion | 4       | 1500           |

---

## ⚙️ Reglas del sistema

* No se permiten patentes duplicadas
* Las horas deben ser mayores a 0
* No se puede superar la capacidad del garage
* No se puede retirar un vehículo inexistente

---

## ⚠️ Manejo de Excepciones

El sistema utiliza excepciones personalizadas:

* `GarageLlenoException`
* `PatenteDuplicadaException`
* `VehiculoNoEncontradoException`
* `HorasInvalidasException`

---

## 🧠 Conceptos aplicados

* Programación Orientada a Objetos
* Herencia y polimorfismo
* Encapsulamiento
* Manejo de excepciones
* Separación de responsabilidades
* Arquitectura por capas

---

## 📌 Autor

Cabral Esteban
Parcial 1 de Programación Avanzada.
