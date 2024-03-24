package estruturas_de_dados.vetor

import estruturas_de_dados.base.CommonListStruct
import kotlin.IllegalArgumentException


class Vetor<T>(capacidade: Int): CommonListStruct<T>(capacidade, "Vetor"){

    constructor() : this(10)

    fun add(element: T){
        super.CLadd(element)
    }

    fun add(position: Int,element: T){
        super.CLadd(position, element)
    }

    fun clone (): Vetor<T?>{
        val list =  super.CLclone()
        return  super.toVetor(list)
    }
}