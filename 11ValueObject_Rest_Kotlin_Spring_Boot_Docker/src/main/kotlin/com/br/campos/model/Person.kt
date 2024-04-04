package com.br.campos.model

import jakarta.persistence.*

@Entity
@Table(name = "person11")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(name = "age", nullable = false, length = 2)
    var age: Int = 0,

    @Column(name = "gender", nullable = false, length = 6)
    var gender: String = "",

    @Column(name = "address", nullable = false, length = 100)
    var address: String = "",

    @Column(name = "state", nullable = false, length = 50)
    var state: String = ""


)