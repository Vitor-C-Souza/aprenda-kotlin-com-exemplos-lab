// [Template no Kotlin Playground](https://pl.kotl.in/Z54hX4BQ1)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL, INEXISTENTE }

data class Usuario(val nome: String? = null){
    fun getUsuario(){															//Retorna um usuario
        println(nome)
    }
}

data class ConteudoEducacional(var nome: String? = null, val duracao: Int = 60){
    fun getConteudoEducacional(){												//Retorna os dados de um Conteudo educacional
        println("$nome durara $duracao Horas")
    }
}

data class Formacao(var nome: String? = null, var conteudos: List<ConteudoEducacional>) {    
    constructor(nome: String?) : this(nome, emptyList())
    
    init{      
        //Condições caso a criação da formação esteja faltando algum dado e realizando alterações
        if(nome == null){
            conteudos = listOf()
        } else if (conteudos.isEmpty()){
            nome = null
        }   
        
        conteudos = conteudos.filter {it.nome != null}  		
    }
    
    var inscritos = mutableMapOf<Usuario, Pair<Nivel, List<ConteudoEducacional>>>()
    fun matricular(usuario: Usuario? = null) {										//Matricula um usuario novo na formação
    	// TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")                   
        nome?.let{
            usuario?.let{            
                var nivel: Nivel = when(nome){
                    "Fundamental" -> Nivel.BASICO
                    "Médio" -> Nivel.INTERMEDIARIO
                    "Faculdade" -> Nivel.DIFICIL
                    else -> Nivel.INEXISTENTE
                }            
                inscritos[usuario] = nivel to conteudos
                         
            }  
        }                          
	}
    
    fun getMatriculados(){     												//Retorna todos que estão matriculados
        inscritos.forEach{
        	inscrito -> print("[${inscrito.key.nome} matricula: $nome] ")
        }
        
        println("")
    }
    
    
    fun desmatricular(usuario: Usuario? = null) {      						//Retira um usuario da formação
        nome?.let{
            usuario?.let{                 
               inscritos = inscritos.filter { it.key != usuario}.toMutableMap()                
            }
        }
    }
    
    fun getFormacao(){														//Retorna a formação e seu conteúdo
        val conteudosNome = conteudos.map{it.nome}
        println("$nome conteudo: $conteudosNome")
    }

}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
   
    //Criando os conteudos educacionais
    val portugues = ConteudoEducacional("Portugues", 90)					// com parametro > dado pre determinado
    val matematica = ConteudoEducacional("Matematica", 90)
    val historia = ConteudoEducacional("Historia", 30)						// com parametro < dado pre determinado
    val sociologia = ConteudoEducacional("Sociologia")						// sem enviar o parametro duração
    val filosofia = ConteudoEducacional("Filosofia", 60)					// enviando o parametro padrão
    val ti = ConteudoEducacional("TI", 120)
    val semAula = ConteudoEducacional()										// sem enviar o nome do ConteudoEducacional
    

    portugues.getConteudoEducacional()
    historia.getConteudoEducacional()
    sociologia.getConteudoEducacional()
    filosofia.getConteudoEducacional()
    semAula.getConteudoEducacional()											
    
    
    // Criando as formações
    val fundamental = Formacao(												// Enviando todos os dados corretamente
        nome = "Fundamental", 
        conteudos = listOf(portugues, matematica, historia)
    )
    val medio = Formacao(
        nome = "Médio", 
        conteudos = listOf(portugues, matematica, historia, sociologia, filosofia)
    )
    val faculdade = Formacao(
        nome = "Faculdade", 
        conteudos = listOf(portugues, matematica, historia, sociologia, filosofia, ti)
    )
    val semNome = Formacao(													// Enviando sem o nome da formação
        conteudos = listOf(portugues, matematica, historia)
    )
    val semConteudo = Formacao(												// Enviando sem o conteudo da formacão
    	nome = "Fundamental"
    )
    
    val comConteudoInvalido = Formacao(										// Enviado com conteudo invalido
        nome = "Faculdade", 
        conteudos = listOf(portugues, matematica, historia, sociologia, filosofia, ti, semAula)
    )
    
	fundamental.getFormacao()
    semNome.getFormacao()
    semConteudo.getFormacao()
    comConteudoInvalido.getFormacao()
    
    //Criando os usuarios
    val carlos = Usuario("Carlos")											// Criando o usuario corretamente
    val arthur = Usuario("Arthur")
    val vitor = Usuario("Vítor")
    val semUsuario = Usuario()												// Criando o usuario sem enviar o nome
    
	
    carlos.getUsuario()
    semUsuario.getUsuario()
    
    //Criando as matriculas
    fundamental.matricular(carlos)											//Criando a matricula corretamente
    medio.matricular(arthur)
    faculdade.matricular(vitor)
    faculdade.matricular(carlos)											//Matriculando um segundo aluno na formação
    
    semNome.matricular(carlos)												//Criando a matricula em uma formação invalida    
    fundamental.matricular()												//Criando a matricula sem enviar o nome
    
    faculdade.getMatriculados()												//Retornando valor dos alunos matriculados na formação    
    
    faculdade.desmatricular(carlos)											//Implementado a função desmatricular da formação    
    faculdade.getMatriculados()												//Retornando a lista de matriculados após usado a função de desmatricular
    
}

