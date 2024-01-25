package com.br.campos.model

data class Person (
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = 0,
    var address: String = "",
    var gender: String = ""
)