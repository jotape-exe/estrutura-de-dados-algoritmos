package estruturas_de_dados.vetor

import estruturas_de_dados.base.CommonListStruct
import kotlin.IllegalArgumentException


class Vetor<T>(capacidade: Int){

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

        validarPosicao(posicao)

        addSize()

        for (i in tamanho - 1 downTo posicao) {
            elementos[i + 1] = elementos[i]
        }

        elementos[posicao] = valor

        tamanho++
    }

    fun remove(posicao: Int) {
        validarPosicao(posicao)

        for (i in posicao..<tamanho) {
            elementos[i] = elementos[i + 1]
        }

        tamanho--
    }

    fun remove(elemento: T?) {
        remove(get((elemento)))
    }

    fun clear() {
        for (i in 0..<elementos.size){
            elementos[i] = null
        }
    }

    private fun addSize() {
        if (tamanho == elementos.size) {

            var novosElementos = arrayListOf<T?>()

            for (i in 0..elementos.size * 2) {
                novosElementos.add(elemento)
            }

            for (i in 0..<elementos.size) {
                novosElementos[i] = elementos[i]
            }

            elementos = novosElementos

        }
    }

    fun clone(): Vetor<T?> {
        var newArray = Vetor<T?>(tamanho)

        for (element in elementos) {
            newArray.add(element)
        }

        return newArray
    }

    fun length(): Int {
        return tamanho
    }

    operator fun get(posicao: Int): T? {
        validarPosicao(posicao)

        return elementos[posicao]
    }

    operator fun get(elemento: T?): Int {
        var posicao: Int = -1
        for (i in 0..<tamanho) {
            if (elementos[i] == elemento) {
                posicao = i
            }
        }
        if (posicao == 0) {
            throw IndexOutOfBoundsException("Elemento ${elemento} não existe no vetor")
        }
        return posicao
    }

    fun contains(elemento: T?): Boolean{
        return get(elemento) != -1
    }

    fun lastIndexOf(elemento: T?): Int{
        var posicao: Int = -1
        for (i in 0..tamanho) {
            if (elementos[i] == elemento) {
                posicao = i
            }
        }
        if (posicao == 0) {
            throw IndexOutOfBoundsException("Elemento ${elemento} não existe no vetor")
        }
        return posicao
    }

    private fun validarPosicao(posicao: Int) {
        if (posicao !in 0..<tamanho) {
            throw IllegalArgumentException("Indice $posicao fora do vetor de tamanho ${tamanho}")
        }
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vetor<*>

        return elementos == other.elementos
    }

    override fun hashCode(): Int {
        return elementos.hashCode()
    }



}