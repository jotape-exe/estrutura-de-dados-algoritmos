package estruturas_de_dados.pilha

import estruturas_de_dados.base.CommonListStruct

class Pilha<T>(capacidade: Int) : CommonListStruct<T>(capacidade, "Pilha") {
    constructor() : this(10)

    fun empilhar(elemento: T) {
        super.add(elemento)
    }

    fun desempilhar(): T?{
        return if (super.estaVazio()) null else elementos[--tamanho]
    }

    fun topo(): T? {
        if (super.estaVazio()) {
            return null
        }
        return super.get(tamanho - 1)
    }


}