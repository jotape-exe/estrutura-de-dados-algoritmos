package estruturas_de_dados.fila.practice.resolution

import estruturas_de_dados.fila.Fila
import kotlin.random.Random

val fila = Fila<Paciente>()

val filaVerde = Fila<Paciente>()
val filaAmarela = Fila<Paciente>()
val filaVermelha = Fila<Paciente>()

fun main() {
    iniciarFilaPacientes()
    iniciarAtendimento()
}

private fun gerarPessoaAleatoria(): Paciente {
    return getPrioridadeRandom().let { prioridade -> Paciente("Paciente Aleatorio (${prioridade})", prioridade) }
}

private fun getPrioridadeRandom(): PrioridadeAtendimento {
    val prioridadeRandom = Random.nextInt(0, 3)

    val PrioridadeAtendimentoMap = mapOf(
            PrioridadeAtendimento.VERDE.ordinal to PrioridadeAtendimento.VERDE,
            PrioridadeAtendimento.AMARELO.ordinal to PrioridadeAtendimento.AMARELO,
            PrioridadeAtendimento.VERMELHO.ordinal to PrioridadeAtendimento.VERMELHO
    )

    return PrioridadeAtendimentoMap[prioridadeRandom]!!
}

private fun iniciarFilaPacientes() {
    for (i in 0..<6) {
        val prioridade = getPrioridadeRandom()
        fila.add(Paciente("Paciente $i", prioridade))
    }
}


private fun iniciarAtendimento() {
    println(fila)

    do {
        val paciente = fila.pool()

        if (paciente?.pulseira == PrioridadeAtendimento.VERDE) {
            filaVerde.add(paciente)
        } else if (paciente?.pulseira == PrioridadeAtendimento.AMARELO) {
            filaAmarela.add(paciente)
        } else {
            paciente?.let {
                filaVermelha.add(it)
            }
        }

        println("Atendendo...")
        Thread.sleep(4000)
        val novaPessoa = gerarPessoaAleatoria()
        println("Nova Pessoa $novaPessoa \n")
        fila.add(novaPessoa)
        Thread.sleep(1000)


        if (filaVermelha.naoEstaVazio()){
            filaVermelha.pool()?.let {
                println("Atendido: $it")
            }
        }

        if (filaVermelha.estaVazio()){
            filaAmarela.pool()?.let {
                println("Atendido: $it")
            }
        }

        if (filaVermelha.estaVazio() && filaAmarela.estaVazio()){
            filaVerde.pool()?.let {
                println("Atendido: $it")
            }
        }

    } while (filaVerde.naoEstaVazio() || filaVermelha.naoEstaVazio() || fila.naoEstaVazio())
}

fun atender() = "asd"
data class Paciente(val nome: String, val pulseira: PrioridadeAtendimento)

enum class PrioridadeAtendimento(value: Int) {
    VERDE(value = 2),
    AMARELO(value = 1),
    VERMELHO(value = 0)
}