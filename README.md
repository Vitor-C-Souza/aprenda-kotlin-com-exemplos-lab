# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


```kotlin
TODO("Crie uma solução em Koltin abstraindo esse domínio. O arquivo [desafio.kt] te ajudará 😉")
```
## Resolução do desafio

**Foi Desenvolvido enum class Nivel, data class Usuario, data class ConteudoEducacional e data class Formacao.**

**Cada uma dessas classes tirando a classe Nivel tem uma função get que retorna o dado salvo no construtor naquela instancia, mas a classe formação tem 2 função get uma para retornar sua formação com conteudos daquela instancia criada e outra para quem estão matriculado na formação retornando numa lista mais a formação escolhida.**

**Dentro de cada uma das classes foi implementado tambem o tratamento de exceções de eventuais problemas como a instancia com parametros faltando e o dado ficar =null.**

**Após realizar a instacia da data class formação tera função matricular e ou desmatricular, resumidamente a função matricular adiciona um usuario novo na variavel inscrito do tipo Map e outra remove um usuario dessa mesma variavel e ambas recebendo como parametro o usuario apenas.**