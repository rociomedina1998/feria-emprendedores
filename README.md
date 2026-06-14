# Feria de Emprendedores

Sistema de gestión para una feria de emprendedores. Permite registrar emprendedores con sus productos, procesar ventas con descuentos automáticos, y generar reportes por categoría.

## Requisitos

- Java 17+
- Maven 3.8+

## Cómo ejecutar el programa

```bash
mvn exec:java
```

O desde un IDE, ejecutar directamente la clase `Main.java`.

## Cómo correr los tests

```bash
mvn test
```

El reporte de cobertura generado por JaCoCo queda disponible en `target/site/jacoco/index.html`.

## Estructura del proyecto

```
src/
├── main/java/com/feria/
│   ├── Main.java
│   ├── modelos/        # Entidades del dominio (Emprendedor, Producto, Venta, estrategias de descuento)
│   ├── servicios/      # Lógica de negocio (GestorFeria, Reportes)
│   └── utils/          # Validación (IValidadorEmprendedor, Validadores)
└── test/java/com/feria/
    ├── modelos/        # Tests unitarios de Producto
    └── servicios/      # Tests de integración con mocks de GestorFeria
```

## Decisiones técnicas

Se aplicaron dos principios SOLID centrales: **SRP** separando la lógica de reportes y validación en clases propias, y **DIP** haciendo que `GestorFeria` dependa de la interfaz `IValidadorEmprendedor` en lugar de su implementación concreta.

El **patrón Strategy** se implementó para el cálculo de descuentos en `Venta`: la interfaz `EstrategiaDescuento` permite intercambiar la lógica de descuento (`DescuentoEstandar`, `SinDescuento`) sin modificar la clase que la usa. Esto reemplaza una cadena de `if/else` embebida directamente en `Venta`.

Los tests usan **Mockito** para aislar `GestorFeria` de su validador, verificando el comportamiento sin depender de una implementación concreta. El pipeline de CI ejecuta la compilación y los tests automáticamente en cada push a `main`.
