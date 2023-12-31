import estruturas_de_dados.vetor.Vetor

fun main() {
    val vetor = Vetor<String>(6)

    vetor.add("Elemento 1")
    vetor.add("Elemento 2")
    vetor.add("Elemento 3")
    vetor.add("Elemento 4")
    vetor.add("Elemento 5")
    vetor.add("Elemento 5")
    vetor.add("Elemento 6")
    vetor.add("Elemento 7")
    vetor.add("Elemento 5")
    vetor.add("Elemento 5")

    println(vetor[2])

    vetor.add(0, "Novo Elemento 1")

    println(vetor["Elemento 2"])

    println(vetor.toString())

    vetor.add(0, "Elemento 0")
    vetor.add(2, "Elemento 22")

    println(vetor.length())

    //vetor.remove(0)
    //vetor.remove(1)
    //vetor.remove(2)
    //vetor.remove("Elemento 7")

    val vetor2: Vetor<String?> = vetor.clone()

    vetor2.add("Elemento vetor 2")

    println(vetor.equals(vetor2))

    /*for (i in 0..vetor2.length()-1) {
        println("index $i, elemento -> ${vetor2[i]}")
    }*/

    println("Contem Elmento 3 ? ${vetor.contains("Elemento 3")}")

    //vetor.clear()

    println("Ultimo indice de (Elmento 5): ${vetor2.lastIndexOf("Elemento 5")}")

    println("Vetor 1 -> ${vetor.toString()}")
    println("Vetor 2 -> ${vetor2.toString()}")
}