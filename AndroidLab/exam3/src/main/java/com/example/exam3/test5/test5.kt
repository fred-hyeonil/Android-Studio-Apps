package com.example.exam3.test5

fun main(){
    fun f1(no1:Int, no2:Int): Int{
        return no1*no2
    }
    // 일반 함수
    f1(10,20)
    // 매개변수 2개
    val f2 = {no1:Int, no2:Int -> no1*no2}
    f2(10,20)
    val f3 = {no1:Int, no2:Int -> no1*no2}(10,20)
    // 매개변수 1개
    val f4 = {no:Int -> println(no)}
    val f5 : (Int)-> Unit = {println(it)}
    val f6 = {no1 : Int, no2 : Int ->
        //return no1* no2 이거는 문법 적 오류임
    println("hello")
    no1*no2
    }
}