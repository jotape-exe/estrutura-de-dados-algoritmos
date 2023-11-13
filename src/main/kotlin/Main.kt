import estruturas_de_dados.vetor.Vetor

fun main() {
    val vetor = Vetor<String>(6)

    vetor.add("Elemento 1")
    vetor.add("Elemento 2")
    vetor.add("Elemento 3")
    vetor.add("Elemento 4")
    vetor.add("Elemento 5")
    vetor.add("Elemento 6")
    vetor.add("Elemento 7")

    println(vetor[2])

    vetor.add(0, "Novo Elemento 1")



    println(vetor["Elemento 2"])

    println(vetor.toString())

    vetor.add(0, "Elemento 0")
    vetor.add(2, "Elemento 22")


    println(vetor.toString())
}