package com.br.campos.unittests.mapper.mocks

import com.br.campos.data.vo.v1.PersonVO
import com.br.campos.model.Person

class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }
    fun mockVO(): PersonVO {
        return mockVO(0)
    }
    fun mockEntityList(): ArrayList<Person> {
        val persons = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }
    fun mockVOList(): ArrayList<PersonVO> {
        val persons = ArrayList<PersonVO>()
        for (i in 0..13) {
            persons.add(mockVO(i))
        }
        return persons
    }
    fun mockEntity(number: Int): Person {
        val person = Person()
        person.id = number.toLong()
        person.firstName = "First Name $number"
        person.lastName = "Last Name $number"
        person.age = number
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.address = "Address Test$number"
        person.state = "State Test$number"
        return person
    }
    fun mockVO(number: Int): PersonVO {
        val person = PersonVO()
        person.id = number.toLong()
        person.firstName = "Person Name $number"
        person.lastName = "Person Last Name $number"
        person.age = number
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.address = "Address Test$number"
        person.state = "State Test$number"
        return person
    }
}