# amoviles-android-kotlin-g12
Curso de Aplicaciones Android con Kotlin G12(Básico - Intermedio- Avanzado) - Academia Móviles 


## Kotlin Fundamentals

Slide https://docs.google.com/presentation/d/1wnqOdBUW7fF_2XOL7C5GUdNGgkd6PtVW7q269FmeNMU/edit?usp=sharing

Lesson https://github.com/emedinaa/amoviles-android-kotlin-g12/archive/L2-Kotlin.zip

## Kotlin Language

- Hello World

```kotlin
fun main(args:Array<String>){
    println("Hello Kotlin !")
}
```

output
```
Hello Kotlin !
```

- Functions

```kotlin
fun showMessage(message: String): Unit {                               // 1
    println(message)
}
```

```kotlin
fun showMessage2(message: String){                                    // 2
    println(message)
}
```

```kotlin
fun showMessage(message:String, param:String="Parameter"){            // 3
    println("message : $message param : $param")
}
```

```kotlin
fun area(base:Int, height:Int):Int{                                   // 4
    return base*height
}
```

```kotlin
fun perimeter(base:Int, height:Int)=2*base+ 2*height                  // 5
```

```kotlin
fun main(args:Array<String>){
    showMessage("Hello Kotlin") //1
    showMessage2("Hello Kotlin") //2
    showMessage("Hello Kotlin","Leave Java")//3
    println(area(10,20)) //4
    println(perimeter(10,20)) //5

}
```

output
```
Hello Kotlin
Hello Kotlin
message : Hello Kotlin param : Leave Java
200
60
```

- Functions / vararg parameters

```kotlin
fun printWithArgs(vararg languages:String){
    for(item in languages){
        println(item)
    }
}
```

```kotlin
   printWithArgs("Java", "Kotlin", "Scala", "Groovy",
            "Clojure")
   printWithArgs("Java", "Kotlin", "C++", param = "Android")
```

output
```
Java
Kotlin
Scala
Groovy
Clojure
Android : Java
Android : Kotlin
Android : C++
```

- Variables

```kotlin
fun main(args:Array<String>){
    var language:String= "Java"

    println(language)

    language="Kotlin"

    println(language)

    val age:Int = 18

    println("Age : $age")

    val message="Kotlin for Android Developers"

    println("Message : $message")

    //message="Java for Android Developers"
}
```

output
```
Java
Kotlin
Age : 18
Message : Kotlin for Android Developers
```
- Null Safety

```kotlin
fun main(args:Array<String>){
    println("Null Safety!")

    var byeNull: String = "No puede ser null"
    //byeNull= null

    var nullable: String?="Puede ser null"
    nullable= null

    var neverNull= "No puede ser null"
    //neverNull= null

    println("byeNull : $byeNull")
    println("nullable : $nullable")
    println("neverNull : $neverNull")
}
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
```

- Working with nulls

```kotlin
fun main(args:Array<String>){
    println("Null Safety!")

    var byeNull: String = "No puede ser null"
    //byeNull= null

    var nullable: String?="Puede ser null"
    nullable= null

    var neverNull= "No puede ser null"
    //neverNull= null

    println("byeNull : $byeNull")
    println("nullable : $nullable")
    println("neverNull : $neverNull")

    //working with null

    //nullable="Esta variable no es null"

    if(nullable!=null){
        println("Not null (if) : $nullable")
    }

    println("Not null length (?) : ${ nullable?.length }")

    nullable?.let {
        println("Not null length (let) :${nullable?.length}")
    }?: run {
        println("Not null length (run) : 0")
    }
}
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null length (?) : null
Not null length (run) : 0
```

```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null (if) : Esta variable no es null
Not null length (?) : 24
Not null length (let) :24

```

- Classes

```kotlin

class Language()

class JVMLanguage(val id:Int, val name:String)

class JavaLanguage(val id:Int , var nullable:Boolean)

fun main(args:Array<String>) {
    println("Classes!")

    val language= Language()
    println("language $language")

    val jvmLanguage= JVMLanguage(0,"Kotlin")

    println("jvmLanguage $jvmLanguage")
    println("jvmLanguage ${jvmLanguage.id}  & ${jvmLanguage.name}")

    //jvmLanguage.id=1
    //jvmLanguage.name="Java"

    val javaLanguage= JavaLanguage(1,false)
    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")
    javaLanguage.nullable=true

    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")

}
```

output
```
Classes!
language Language@5e2de80c
jvmLanguage JVMLanguage@1d44bcfa
jvmLanguage 0  & Kotlin
javaLanguage 1  & false
javaLanguage 1  & true
```

- Inheritance

```kotlin
open class ObsoleteLanguage(){
    open fun sayHello() {       // 2
        println("I'm bored...")
    }
}

open class AwesomeLanguage(val message:String){
    open fun showMessage(){
        println(message)
    }
}


class JavaOLanguage:ObsoleteLanguage(){
    override fun sayHello() {
        println("I'm an obsolete language")
    }
}

class KotlinAwesomeLanguage(message:String):AwesomeLanguage(message)

fun main(args:Array<String>) {
    val obsoleteLanguage: ObsoleteLanguage = JavaOLanguage()
    obsoleteLanguage.sayHello()

    val awesomeLanguage:AwesomeLanguage= KotlinAwesomeLanguage("Kotlin is a cool language!")
    awesomeLanguage.showMessage()
}
```

output
```
I'm an obsolete language
Kotlin is a cool language!
```
---

- Control Flow

**Conditional expression**

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b         // 1
println(max(99, -42))
```
output
```
99
```

**When** 

```kotlin
class MyClass

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")                          // 1
        "Hello" -> println("Greeting")               // 2
        is Long -> println("Long")                   // 3
        !is String -> println("Not a string")        // 4
        else -> println("Unknown")                   // 5
    }
}

fun main(args:Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}
```

output
```
Greeting
One
Long
Not a string
Unknown
```
- Loops (for, while, do-while)

**For**

```kotlin
fun main(args:Array<String>) {

    //for
    val jvmLanguages = listOf("Kotlin", "Java", "Groovy")
    for (language in jvmLanguages) {                               // 1
        println("Jvm language : $language")
    }
}
```

output
```
Jvm language : Kotlin
Jvm language : Java
Jvm language : Groovy
```
**while**

```kolin
  //while
    var count=0
    while (count<5){
        println("count : $count")
        count++
    }
```

```
count : 0
count : 1
count : 2
count : 3
count : 4
```

**do-while**

```kotlin
    //do - while
    var i = 1
    do{
        println("item : $i")
        i++
    }while (i<5)
```

```
item : 1
item : 2
item : 3
item : 4
```
---
## Ejercicios

- Hello World

```kotlin
fun main(args:Array<String>){
    println("Hello Kotlin !")
}
```

output
```
Hello Kotlin !
```
Compilador online https://play.kotlinlang.org/

- Pide 2 números y muestra cual es el mayor, el menor, o si son iguales
- Calcular el mayor de 2 números
- Calcular el factorial de un número.
- Dado 10 números , calcular el mayor y menor
- Dado 10 números , calcular los múltiplos de 3
- Mostrar la tabla de multiplicar del 1 al 10
- Realizar un programa que nos pida un número n, y nos diga cuantos números hay entre 1 y n que son
primos. 
- Calcular el mayor de tres números enteros
- Pide un número y muestra si es positivo o negativo y si es par o impar
- Obtener el valor máximo y mínimo de un array de valores.

```kotlin
 //Pide 2 números y muestra cual es el mayor, el menor, o si son iguales
 
fun main(args:Array<String>){
    println("Hello Kotlin !")
    val num1= 5
    val num2= 3
    comparar(num1,num2)
}
fun comparar(v1:Int, v2:Int){
    var message:String=""
    if(v1>v2){
        message= "v1 $v1 > v2 $v2" //
    }else if(v1<v2){
       message= "v1 $v1 < v2 $v2"  
    }else{
        message= "v1 $v1 = v2 $v2"  
    }
    println(message)
}

```

```kotlin
//Calcular el factorial de un número.
fun main(args:Array<String>){
    println("Hello Kotlin !")
    //factorial 5 5x4x3x2x1 5*(5-1)*(5-2)*(5-3)*(5-4)
   	val num=5
    var factorial= 5
    for(i in 1..(num-1)){// for(val i=1, i<5,i++){
        //factorial = num*(num-i) 
        factorial = factorial*(num-i) 
        println( "$num x ($num - $i) = $num x ${num-i} factorial $factorial")
    }
    println( "factorial $factorial")
        //1 5*(5-1)
        //2 5*(5-2)
        //3 5*(5-3)
        //4 5* ()5-4)
}

```

```kotlin
//Obtener el valor máximo y mínimo de un array de valores.
fun main(args:Array<String>){
    //Obtener el valor máximo y mínimo de un array de valores //[3,5,2,1,7,8] max , min
    println( "Hello kotlin")
    val arr= intArrayOf(3,5,2,1,7,8)
    calcular(arr)
}

fun calcular(arr:IntArray){
    var max=arr[0]
    var min=arr[0]
    // min > it min= it
    arr.forEach{//i->
        println("it $it - min :$min - max : $max")
        if(min>it){ min=it }
        if(max<it){ max= it}
        println("nuevo min :$min / nuevo max : $max")
    }
    println(" min : $min - max : $max") //[3,5,2,1,7,8]
}

```
  
# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
- Develop Android Apps with Kotlin https://developer.android.com/kotlin/
- Getting started with Android and Kotlin https://kotlinlang.org/docs/tutorials/kotlin-android.html
- Android Developers https://developer.android.com/?hl=es-419
- Google codelabs https://codelabs.developers.google.com/
- Android Studio https://developer.android.com/studio/install
- Genymotion https://www.genymotion.com/account/create/
