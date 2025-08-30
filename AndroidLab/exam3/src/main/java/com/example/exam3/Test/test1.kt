
package com.example.exam3.Test


import com.example.exam3.test2.User
import com.example.exam3.test2.name

val data4: Int by lazy{
    println("in lazy.....")
    10
}

fun main(){
    println("Hello World")
    println("Say Hello()")

    println(data4 + 10)
    println(data4 + 10)

    val str1 = "Hello \nWorld"
    val str2 = """
        Hello
        World
    """.trimIndent()
    println("str1 : $str1")
    println("str2 : $str2")


    val data1 : Array<Int> = Array(3,{0})
    data1[0] = 10
    data1[1] = 20
    data1.set(2,30)

    println(
        """
            array size : ${data1.size}
            array data : ${data1[0]},${data1[1]},${data1.get(2)}
        """.trimIndent()
    )
}

