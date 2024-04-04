package com.br.playground4.model

import jakarta.persistence.*

@Entity
@Table(name = "table_person4")
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

    @Column(name = "address", nullable = false, length = 100)
    var address: String = "",

    @Column(name = "country", nullable = false, length = 80)
    var country: String = "",
)
{
    constructor() : this(0, "", "", 0, "", "") // Construtor padrão sem argumentos
}