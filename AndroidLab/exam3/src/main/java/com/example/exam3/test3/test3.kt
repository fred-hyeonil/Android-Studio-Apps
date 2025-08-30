package com.example.exam3.test3

//import com.example.exam3.test2.name

class User1(name:String){
    constructor(name:String, count:Int):this(name)
}
class User2(name:String, count:Int){
    constructor(name:String, count:Int, email:String):this(name,count)
}
class User3(name:String, count:Int, email:String){

}
fun main() {
    val obj1 = User1("chuchu")
    val obj2 = User2("chuchu",100)
    val obj3 = User3("chuchu",100,"adjslkfa@.com")

}