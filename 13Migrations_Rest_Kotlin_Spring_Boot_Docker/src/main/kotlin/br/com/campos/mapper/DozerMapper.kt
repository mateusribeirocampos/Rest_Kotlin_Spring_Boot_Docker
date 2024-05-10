package br.com.campos.mapper

import org.modelmapper.ModelMapper

// Esta classe é responsável por fornecer métodos para mapeamento de objetos usando o ModelMapper.
// O ModelMapper é uma biblioteca utilizada para mapear objetos Java de forma simples e flexível.
object DozerMapper {

    // Instância do ModelMapper que será usada para realizar os mapeamentos.
    private val mapper: ModelMapper = ModelMapper()

    // Este método recebe um objeto de origem e a classe de destino e retorna o objeto mapeado para a classe de destino.
    fun <O, D> parseObject(origin: O, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    // Este método recebe uma lista de objetos de origem e a classe de destino e retorna uma lista de objetos mapeados para a classe de destino.
    fun <O, D> parseListObject(origin: List<O>, destination: Class<D>?): ArrayList<D> {
        // Lista que armazenará os objetos mapeados para a classe de destino.
        val destinationObjects: ArrayList<D> = ArrayList()
        
        // Itera sobre a lista de objetos de origem.
        for(o in origin) {
            // Mapeia cada objeto de origem para a classe de destino e adiciona à lista de objetos mapeados.
            destinationObjects.add(mapper.map(o, destination))
        }
        return destinationObjects // Retorna a lista de objetos mapeados para a classe de destino.
    }
}