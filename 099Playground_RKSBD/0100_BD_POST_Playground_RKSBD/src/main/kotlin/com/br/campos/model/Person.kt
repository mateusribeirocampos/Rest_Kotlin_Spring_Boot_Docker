package com.br.campos.model

// Definindo uma data class chamada Person, que é usada para representar informações sobre uma pessoa.
data class Person (
    var id: Long = 0,                 // Propriedade para armazenar o ID da pessoa (padrão inicializado como 0).
    var firstName: String = "",       // Propriedade para armazenar o primeiro nome da pessoa (padrão inicializado como uma string vazia).
    var lastName: String = "",        // Propriedade para armazenar o sobrenome da pessoa (padrão inicializado como uma string vazia).
    var age: Int = 0,                  // Propriedade para armazenar a idade da pessoa (padrão inicializado como 0).
    var birthday: String = "",         // Propriedade para armazenar a data de nascimento da pessoa (padrão inicializado como uma string vazia).
    var address: String = "",          // Propriedade para armazenar o endereço da pessoa (padrão inicializado como uma string vazia).
    var gender: String = ""            // Propriedade para armazenar o gênero da pessoa (padrão inicializado como uma string vazia).
)
