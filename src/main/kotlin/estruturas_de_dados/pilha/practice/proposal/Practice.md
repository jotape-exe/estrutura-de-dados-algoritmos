# Praticando a implementação de Pilhas(`Stack<*>`)


## 1. Inverta a ordem da seguinte pilha:
```kotlin
fun main(){
    val pilha = Pilha<String>(capacidade = 10)

    for (i in 0..27 step 3){
        pilha.empilhar("Elemento ${i}")
    }
}


//Implemente o código
//...


//Saída esperada:
//Pilha[{valor=Elemento 27},{valor=Elemento 24},{valor=Elemento 21},{valor=Elemento 18},{valor=Elemento 15},{valor=Elemento 12},{valor=Elemento 9},{valor=Elemento 6},{valor=Elemento 3},{valor=Elemento 0},]

```
## 2. Verificar se uma sequência de parênteses está balanceada
Escreva uma função que receba uma sequência de parênteses como uma string e determine se os parênteses estão balanceados.
````kotlin
fun main() {
    val options = listOf('(', ')')
    val pilha = Pilha<Char>(20)
    val tempPilha = Pilha<Char>(20)

    while (pilha.length() < 100) {
        pilha.empilhar(options.random())
    }
    
    //Implemente o código abaixo
    //...
    
    
    
    //Saída esperada(Não sera 100% preciso pois o valores são randomicos):
    //Sequancia: () () () () ()
}
````

## 3. Testador de palíndromos. Escreva um programa que use uma pilha para determinar se uma string é um palíndromo (ou seja, se ela é escrita de forma idêntica de trás para a frente e de frente para trás).
- Ex: __AABBAA__, __ASDDFFDDSA__, __OOPPIIPPOO__

````kotlin
fun main() {
    //Teste usando diferentes strings
    val palindromo = "AABBCCASSACCBBAA"
    val palindromo2 = "ANA"
    val naoPalindromo = "AADDSA"

    var ehPalindromo = StringBuilder()
    val pilha = Pilha<Char>()


    for (element in palindromo) {
        pilha.empilhar(element)
    }
    
    //Implemente o código abaixo
    //..
    
}
````