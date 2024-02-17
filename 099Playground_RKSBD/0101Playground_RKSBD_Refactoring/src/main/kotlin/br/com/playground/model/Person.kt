package br.com.playground.model

import jakarta.persistence.*

@Entity
@Table(name = "person_table_test")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(nullable = false, length = 2)
    var age: Int = 0,

    @Column(nullable = false, length = 6)
    var gender: String = "",

    @Column(nullable = false, length = 100)
    var address: String,

    @Column(name = "phone_number", nullable = false, length = 15)
    var phoneNumber: String = "",

    @Column(nullable = false, length = 100)
    var email: String = "",

    @Column(nullable = false, length = 80)
    var city: String = "",

    @Column(nullable = false, length = 100)
    var state: String = "",

    @Column(nullable = false, length = 30)
    var country: String = "",

    @Column(name = "zip_code", nullable = false, length = 10)
    var zipCode: String = ""

) {
    constructor() : this(0, "", "", 0, "", "", "", "", "", "", "", "")
}