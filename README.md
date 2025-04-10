# PORTAFOLIO-FINAL---INGENIER-A-DE-SOFTWARE
SISTEMA DE CONTROL DE ACCESO
# Sistema de Control de Acceso (SGA) - Versión Java

## Descripción General

Este proyecto consiste en la implementación de un **Sistema de Control de Acceso (SGA)** desarrollado en Java. Su propósito es gestionar el acceso seguro de usuarios a distintos tipos de recursos, mediante autenticación y asignación explícita de permisos. Se basa en los principios de programación orientada a objetos, emplea el patrón Singleton para la autenticación centralizada y el patrón Factory Method para la creación dinámica de recursos.

El sistema fue desarrollado como parte de la asignatura **Desarrollo de Software Orientado a Objetos**, abordando conceptos de diseño modular, encapsulamiento, herencia y control de acceso basado en roles.

## Características del Sistema

- Autenticación centralizada y segura con control de intentos fallidos.
- Bloqueo de usuario tras múltiples intentos inválidos.
- Creación de recursos mediante una fábrica (`RecursoFactory`).
- Control de acceso específico por recurso.
- Gestión de archivos, servicios y aplicaciones como recursos con comportamiento personalizado.
- Separación clara entre lógica de autenticación, usuarios y recursos.

## Clases Principales

| Clase            | Descripción                                                                 |
|------------------|-----------------------------------------------------------------------------|
| `Autenticacion`  | Singleton encargado de validar credenciales y administrar instancias.       |
| `Usuario`        | Representa un usuario con nombre, contraseña y control de intentos fallidos.|
| `Recurso`        | Clase abstracta para definir permisos de acceso comunes a distintos recursos.|
| `Archivo`        | Hereda de `Recurso`, simula una descarga de archivo.                        |
| `Servicio`       | Hereda de `Recurso`, permite iniciar o detener servicios.                   |
| `App`            | Hereda de `Recurso`, permite ejecutar o detener aplicaciones.               |
| `RecursoFactory` | Fábrica que instancia recursos según su tipo (`Archivo`, `Servicio`, `App`).|

## Requisitos

- Java 8 o superior.
- IDE recomendado: IntelliJ IDEA o Eclipse.

## Ejecución del Proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/sga-java.git
   cd sga-java
