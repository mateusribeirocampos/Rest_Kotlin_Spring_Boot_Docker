package com.br.playground5.model

import jakarta.persistence.*


@Entity
@Table(name = "tb_person5")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_Name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_Name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(name = "age", nullable = false, length = 2)
    var age: Int = 0,

    @Column(name = "address", nullable = false, length = 100)
    var address: String = "",

    @Column(name = "city", nullable = false, length = 80)
    var city: String = "",

    @Column(name = "country", nullable = false, length = 80)
    var country: String = ""

)