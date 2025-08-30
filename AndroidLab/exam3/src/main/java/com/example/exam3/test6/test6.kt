package com.example.exam3.test6

// 고차 함수 예제
fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if (arg(-10)) {
        "valid"
    } else {
        "invalid"
    }

    return { "hofFun result : $result" }
}

fun main() {
    val result = hofFun { no -> no > 0 }
    println(result())
}
