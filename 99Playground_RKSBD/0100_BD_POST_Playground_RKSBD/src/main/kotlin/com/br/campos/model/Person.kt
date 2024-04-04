package com.br.campos.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,                 // Propriedade para armazenar o ID da pessoa (padrão inicializado como 0).


    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",       // Propriedade para armazenar o primeiro nome da pessoa (padrão inicializado como uma string vazia).


    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",        // Propriedade para armazenar o sobrenome da pessoa (padrão inicializado como uma string vazia).


    @Column(nullable = false, length = 2)
    var age: Int = 0,                  // Propriedade para armazenar a idade da pessoa (padrão inicializado como 0).


    @Column(nullable = false, length = 10)
    var birthday: String = "",         // Propriedade para armazenar a data de nascimento da pessoa (padrão inicializado como uma string vazia).


    @Column(nullable = false, length = 100)
    var address: String = "",          // Propriedade para armazenar o endereço da pessoa (padrão inicializado como uma string vazia).


    @Column(nullable = false, length = 6)
    var gender: String = ""            // Propriedade para armazenar o gênero da pessoa (padrão inicializado como uma string vazia).
)
