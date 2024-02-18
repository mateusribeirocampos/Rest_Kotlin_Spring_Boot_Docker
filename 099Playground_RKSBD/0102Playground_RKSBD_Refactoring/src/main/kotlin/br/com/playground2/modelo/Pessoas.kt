package br.com.playground2.modelo

import jakarta.persistence.*

@Entity
@Table(name = "pessoas")
data class Pessoas (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "nome", nullable = false, length = 100)
    var nome: String = "",

    @Column(name = "sobrenome", nullable = false, length = 100)
    var sobrenome: String = "",

    @Column(name = "sexo", nullable = false, length = 1)
    var sexo: String = "",

    @Column(name = "idade", nullable = false, length = 2)
    var idade: Int = 0,

    @Column(name = "email", nullable = false, length = 30)
    var email: String = "",

    @Column(name = "telefone", nullable = false, length = 15)
    var telefone: String = "",

    @Column(name = "endereco", nullable = false, length = 100)
    var endereco: String = "",

    @Column(name = "cidade", nullable = false, length = 10)
    var cidade: String = "",

    @Column(name = "estado", nullable = false, length = 2)
    var estado: String = "",

    @Column(name = "pais", nullable = false, length = 30)
    var pais: String = "",

    @Column(name = "cep", nullable = false, length = 8)
    var cep: String = ""
)