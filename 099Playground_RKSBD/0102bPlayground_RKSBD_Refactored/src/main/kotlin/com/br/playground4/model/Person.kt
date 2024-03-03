package com.br.playground4.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "table_person4")
data class Person (

    @Id
    var id: Long,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String,

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String,

    @Column(name = "age", nullable = false, length = 2)
    var age: Int,

    @Column(name = "address", nullable = false, length = 100)
    var address: String,

    @Column(name = "city", nullable = false, length = 80)
    var country: String,
)