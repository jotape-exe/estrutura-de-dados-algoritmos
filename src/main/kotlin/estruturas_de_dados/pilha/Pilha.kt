package estruturas_de_dados.pilha

import estruturas_de_dados.base.CommonListStruct

class Pilha<T>(capacidade: Int) : CommonListStruct<T>(capacidade, "Pilha") {
    constructor() : this(10)

    fun empilhar(elemento: T) {
        super.add(elemento)
    }

    fun desempilhar(): T? {
        if (super.estaVazio()) {
            return null
        } else {
            val elemento = super.elementos[--super.tamanho]
            super.elementos[super.tamanho] = null
            return elemento
        }
    }



fun topo(): T? {
    if (super.estaVazio()) {
        return null
    }
    return super.get(tamanho - 1)
}


}