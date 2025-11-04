# 🧩 Práctica – Barreras, Cadenas y Estados en Jetpack Compose

## 📘 Objetivo
Aplicar **ConstraintLayout** (barreras y cadenas) y la **gestión de estado** en Jetpack Compose para resolver situaciones habituales de interfaz, como:
- Alineaciones dependientes del contenido  
- Distribución equilibrada de elementos  
- Persistencia de datos ante recomposición o cambios de configuración  

---

## 🧱 Ejercicio 1 – Ficha de producto con texto variable

### 🎯 Objetivo
Diseñar una tarjeta de producto con:
- Imagen  
- Título (de longitud variable)  
- Precio  
- Botón **“Comprar”** alineado correctamente mediante una **barrera** (`end barrier`)

### 🧠 Explicación
Se utiliza `ConstraintLayout` para controlar la alineación de los elementos dentro de una tarjeta (`Card`).  
El **botón** se coloca a la derecha, y se crea una **barrera entre el título y el precio** para evitar que el botón se solape, incluso si el texto del título es largo.

Esto demuestra cómo crear una **barrera dinámica** que se ajusta al contenido más ancho, manteniendo la distribución limpia y adaptable.

```kotlin
val textBarrier = createEndBarrier(titleRef, priceRef)
```

# ⚙️ Ejercicio 2 — Acciones principales en una barra

## 🎯 Objetivo
Crear una barra con tres acciones de texto (**Explorar**, **Favoritos** y **Perfil**) dispuestas horizontalmente mediante `ConstraintLayout`, aplicando una **cadena** (`createHorizontalChain`) con diferentes estilos de distribución:  
`Spread`, `SpreadInside` y `Packed`.

---

## 🧠 Explicación
En este ejercicio se usa `ConstraintLayout` para colocar tres textos en una **cadena horizontal**.  
Una cadena en Compose permite controlar cómo se distribuyen varios elementos dentro de un mismo eje (horizontal o vertical) sin necesidad de usar `Row` o `Column`.  

Para ello se crean tres referencias (`explore`, `favorites`, `profile`) y luego se agrupan con:
```kotlin
createHorizontalChain(explore, favorites, profile, chainStyle = chainStyle)
```

# 🎨 Ejercicio 3 — Cambiando colores con estado

## 🎯 Objetivo
Crear una pantalla con un **botón** y un **cuadro de color** (`Box`) que cambie de color cada vez que se pulse el botón.  
Además, el color debe **mantenerse ante recomposición** y cambiar aleatoriamente entre varios valores (por ejemplo: rojo, verde, azul o amarillo).

---

## 🧠 Explicación
En este ejercicio se trabaja con el **estado mutable** en Jetpack Compose.  
Se utiliza la función `remember` junto con `mutableStateOf` para guardar el **color actual** del cuadro:

```kotlin
var colorCuadro by remember { mutableStateOf(Color.Red) }
```

# 🔢 Ejercicio 4 — Contador doble

## 🎯 Objetivo
Crear una vista con **dos botones**, uno que **sume (+)** y otro que **reste (−)** un valor mostrado en el centro de la pantalla.  
El valor debe mantenerse entre recomposiciones y no puede **bajar de 0** (el botón de restar deja de funcionar si llega a cero).

---

## 🧠 Explicación
En este ejercicio se practica el manejo del **estado mutable con lógica condicional**.  
Se usa la función `remember` junto con `mutableIntStateOf` para almacenar el valor actual del contador:

```kotlin
var resultado by remember { mutableIntStateOf(0) }
```

# 👁️ Ejercicio 5 — Interruptor de visibilidad

## 🎯 Objetivo
Crear una pantalla con un **texto** y un **botón** que permita **mostrar u ocultar** dicho texto.  
El botón debe cambiar su etiqueta dinámicamente entre **“Mostrar texto”** y **“Ocultar texto”**, dependiendo del estado actual.

---

## 🧠 Explicación
Este ejercicio trabaja con un **estado booleano** en Jetpack Compose para controlar la visibilidad de un elemento en pantalla.  
Se usa `remember` y `mutableStateOf` para recordar si el texto está visible o no:

```kotlin
var estado by remember { mutableStateOf(true) }
```

