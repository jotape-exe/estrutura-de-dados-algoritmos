package estruturas_de_dados.base;

open class CommonListStruct<T>(capacidade: Int, tipoLista: String) {
    private var elemento: T? = null
    protected open var tamanho: Int = 0
    protected open var elementos: ArrayList<T?> = arrayListOf()
    private val tipo = tipoLista

    init {
        for (i in 0..<capacidade) {
            elementos.add(elemento)
        }
    }

    protected open fun add(valor: T) {
        addSize()
        if (tamanho < elementos.size) {
            elementos[tamanho] = valor
            tamanho++
        } else {
            throw IndexOutOfBoundsException("Vetor no tamanho máximo")
        }

    }

    protected open fun add(posicao: Int, valor: T) {

        validarPosicao(posicao)

        addSize()

        for (i in tamanho - 1 downTo posicao) {
            elementos[i + 1] = elementos[i]
        }

        elementos[posicao] = valor

        tamanho++
    }

    private fun validarPosicao(posicao: Int) {
        if (posicao !in 0..<tamanho) {
            throw IllegalArgumentException("Indice $posicao fora do vetor de tamanho ${tamanho}")
        }
    }

    private fun addSize() {
        if (tamanho == elementos.size) {

            val novosElementos = arrayListOf<T?>()

            for (i in 0..elementos.size * 2) {
                novosElementos.add(elemento)
            }

            for (i in 0..<elementos.size) {
                novosElementos[i] = elementos[i]
            }

            elementos = novosElementos

        }
    }

    override fun toString(): String {
        var string = ""

        elementos.forEach {
            if (it != null) {
                string += "{valor=${it}},"
            }
        }

        string = "$tipo[${string}]"

        return string

    }

    open operator fun get(posicao: Int): T? {
        validarPosicao(posicao)

        return elementos[posicao]
    }

    open fun contains(elemento: T?): Boolean {
        return get(elemento) != -1
    }

    open operator fun get(elemento: T?): Int {
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

    open fun clone(): CommonListStruct<T?> {
        val newArray = CommonListStruct<T?>(tamanho, tipo)

        for (element in elementos) {
            newArray.add(element)
        }

        return newArray
    }

    open fun length(): Int {
        return tamanho
    }

    open fun clear() {
        for (i in 0..<elementos.size) {
            elementos[i] = null
        }
    }

    fun estaVazio() = tamanho == 0

    fun naoEstaVazio() = !estaVazio()

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

}
