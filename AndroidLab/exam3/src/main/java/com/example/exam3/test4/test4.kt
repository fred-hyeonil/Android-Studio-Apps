package com.example.exam3.test4


open class A{
    var d1 = 10
    //protected
    var d2 = 20
    //private
    var d3 = 30
}

class B : A(){
    fun some(){
        d1++
        d2++
        d3++
    }
}

fun main(){
    var obj=A()
    obj.d1++
    obj.d2++
    obj.d3++

}
/*

class AA(val name:String, val email:String , val age : Int){
}
data class BB(val name:String, val email:String , val age : Int){
}
fun main(){
    val a1 = AA("kim","a1@.com", 10)
    val a2 = AA("kim","a1@.com", 10)
    val b1 = BB("kim","a1@.com", 10)
    val b2 = BB("kim","a1@.com", 10)
    println(a1.equals(a2))
    println(b1.equals(b2))
    println(a1.toString())
    println(b1.toString())

}*/