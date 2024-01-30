package br.com.campos.model

import jakarta.persistence.*

@Entity // anotação do JPA
@Table(name = "person_table") // anotação do JPA
data class Person (

    @Id // anotação do JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // anotação do JPA
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80) // anotação do JPA
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80) // anotação do JPA
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(nullable = false, length = 6)
    var gender: String = ""
)