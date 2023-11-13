package estruturas_de_dados.vetor

import kotlin.IllegalArgumentException


class Vetor<T>(private val capacidade: Int) {

    private var elemento: T? = null
    private var tamanho: Int = 0
    private var elementos: ArrayList<T?> = arrayListOf()

    init {
        for (i in 0..<capacidade) {
            elementos.add(elemento)
        }
    }

    fun add(valor: T) {
        addSize()
        if (tamanho < elementos.size) {
            elementos[tamanho] = valor
            tamanho++
        } else {
            throw IndexOutOfBoundsException("Vetor no tamanho máximo")
        }

    }
    fun add(posicao: Int, valor: T) {

        if (posicao !in 0..<tamanho) {
            throw IllegalArgumentException("Indice $posicao fora do vetor de tamanho ${tamanho}")
        }

        addSize()

        for(i in tamanho-1 downTo posicao ){
            elementos[i+1] = elementos[i]
        }

        elementos[posicao] = valor

        tamanho++
    }

    private fun addSize(){
        if (tamanho == elementos.size){
            var novosElementos = arrayListOf<T?>()

            for (i in 0..elementos.size*2) {
                novosElementos.add(elemento)
            }

            for (i in 0..<elementos.size){
                novosElementos[i] = elementos[i]
            }

            elementos = novosElementos

        }
    }

    fun length(): Int {
        return tamanho
    }

    operator fun get(posicao: Int): T? {
        if (posicao !in 0..<tamanho) {
            throw IllegalArgumentException("Indice $posicao fora do vetor de tamanho ${tamanho}")
        }
        return elementos[posicao]
    }

    operator fun get(elemento: T?): Int{
        var valor: T? = null
        for (i in 0..tamanho){
            if (elementos[i] == elemento){
                return i
            }
        }
        return -1
    }


    override fun toString(): String {
        var string = ""

        elementos.forEach {
            if (it != null) {
                string += "{valor=${it}},"
            }
        }

        string = "Vetor[${string}]"

        return string

    }


}