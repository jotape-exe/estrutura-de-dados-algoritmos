package estruturas_de_dados.fila.practice.resolution

import estruturas_de_dados.fila.Fila

fun main(){
    val filaDocumentos = Fila<Documento>()

    for (i in 0..7){
        filaDocumentos.add(Documento("Documento $i", i*20))
    }

    var count  = 0

    while (filaDocumentos.naoEstaVazio()){
        filaDocumentos.pool()?.let { imprimirDocumento(it) }
        count++
    }
}

fun imprimirDocumento(documento: Documento){
    var message = StringBuilder()
    var time = 500

    print("Imprimindo ")
    for(i in 0..2){
        message.append(".")
        print(message)
        Thread.sleep((time+documento.qtdFolhas).toLong())
    }
    println()
    println("=-=-=-=-==-=-=-=-=-=")
    println("Documento Impresso! -> $documento")
    println("=-=-=-=-==-=-=-=-=-=")
}

data class Documento(val nome: String, val qtdFolhas: Int)