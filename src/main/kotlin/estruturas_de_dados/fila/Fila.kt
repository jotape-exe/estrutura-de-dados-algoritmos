package estruturas_de_dados.fila

import estruturas_de_dados.base.CommonListStruct
import javax.swing.text.Position

const val FIRST = 0
open class Fila<T>(capacidade: Int) : CommonListStruct<T>(capacidade, "Fila") {
    constructor() : this(10)

    open fun add(element: T){
        super.CLadd(element)
    }

    protected fun add(position: Int, element: T){
        super.CLadd(position, element)
    }

    fun remove(){
        super.remove(FIRST)
    }

    fun peek(): T?{
        if (super.estaVazio()){
            return null
        }

        return elementos[FIRST]
    }

    fun pool(): T?{

        if (super.estaVazio()) {
            return null
        } else {
            val element = elementos[FIRST]
            super.remove(FIRST)
            return  element
        }
    }
}