package com.br.playground3.model

import jakarta.persistence.*


@Entity
@Table(name = "TB_person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstname: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastname: String = "",

    @Column(name = "age", nullable = false, length = 2)
    var age: Int = 0,

    @Column(name = "email", nullable = false, length = 100)
    var email: String = "",

    @Column(name = "phone", nullable = false, length = 11)
    var phone: String = "",

    @Column(name = "address", nullable = false, length = 100)
    var address: String = "",

    @Column(name = "city", nullable = false, length = 100)
    var city: String = "",

    @Column(name = "state", nullable = false, length = 2)
    var state: String = "",

    @Column(name = "country", nullable = false, length = 50)
    var country: String = "",

    @Column(name = "postal_code", nullable = false, length = 9)
    var postalCode: String = ""
)