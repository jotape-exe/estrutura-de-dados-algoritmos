import estruturas_de_dados.vetor.Vetor

fun main() {
    val vetor = Vetor<String>(20)

    vetor.add("Elemento 1")
    vetor.add("Elemento 2")
    vetor.add("Elemento 3")
    vetor.add("Elemento 4")
    vetor.add("Elemento 5")
    vetor.add("Elemento 6")
    vetor.add("Elemento 7")

    println(vetor[2])

    vetor.add(0, "Novo Elemento 1")

    println(vetor.exist(13))

    println(vetor.get("Elemento 2"))

    println(vetor.toString())
}