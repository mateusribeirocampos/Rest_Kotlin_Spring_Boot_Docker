package com.br.campos.unittests.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import com.br.campos.data.vo.v1.PersonVO
import com.br.campos.mapper.DozerMapper
import com.br.campos.model.Person
import com.br.campos.unittests.mapper.mocks.MockPerson

class DozerMapperTest {

    var inputObject: MockPerson? = null

    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: PersonVO = DozerMapper.parseObject(inputObject!!.mockEntity(), PersonVO::class.java)
        assertEquals(0, output.id)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("age Test0", output.age)
        assertEquals("Male", output.gender)
        assertEquals("Address Test0", output.address)
        assertEquals("State Test0", output.state)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: ArrayList<PersonVO> =
            DozerMapper.parseListObject(inputObject!!.mockEntityList(), PersonVO::class.java)

        val outputZero: PersonVO = outputList[0]

        assertEquals(0, outputZero.id)
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("age Test0", outputZero.age)
        assertEquals("Male", outputZero.gender)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("State Test0", outputZero.state)

        val outputSeven: PersonVO = outputList[7]
        assertEquals(7.toLong(), outputSeven.id)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("age Test0", outputSeven.age)
        assertEquals("Male", outputSeven.gender)
        assertEquals("Address Test0", outputSeven.address)
        assertEquals("State Test0", outputSeven.state)

        val outputTwelve: PersonVO = outputList[12]
        assertEquals(12.toLong(), outputTwelve.id)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("age Test0", outputTwelve.age)
        assertEquals("Male", outputTwelve.gender)
        assertEquals("Address Test0", outputTwelve.address)
        assertEquals("State Test0", outputTwelve.state)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = DozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)

        assertEquals(0, output.id)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("age Test0", output.age)
        assertEquals("Male", output.gender)
        assertEquals("Address Test0", output.address)
        assertEquals("State Test0", output.state)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: ArrayList<Person> = DozerMapper.parseListObject(inputObject!!.mockVOList(), Person::class.java)

        val outputZero: Person = outputList[0]
        assertEquals(0, outputZero.id)
        assertEquals("Person Name 0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("age Test0", outputZero.age)
        assertEquals("Male", outputZero.gender)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("State Test0", outputZero.state)

        val outputSeven: Person = outputList[7]
        assertEquals(7, outputSeven.id)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("age Test0", outputSeven.age)
        assertEquals("Male", outputSeven.gender)
        assertEquals("Address Test0", outputSeven.address)
        assertEquals("State Test0", outputSeven.state)

        val outputTwelve: Person = outputList[12]
        assertEquals(12, outputTwelve.id)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("age Test0", outputTwelve.age)
        assertEquals("Male", outputTwelve.gender)
        assertEquals("Address Test0", outputTwelve.address)
        assertEquals("State Test0", outputTwelve.state)
    }
}