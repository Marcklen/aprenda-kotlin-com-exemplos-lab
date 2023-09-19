package dio.kotlin

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL, AVANCADO }

class Usuario {
    var nome: String = "Marcklen Guimaraes"
    var email: String = "marcklen@email.com"
    var nivel: Nivel = Nivel.BASICO

    override fun toString(): String {
        return """
            Nome: $nome
            E-mail: $email
            Nível: $nivel
        """.trimIndent() + "\n"
    }

    fun evoluindo() {
        nivel = when (nivel) {
            Nivel.BASICO -> Nivel.INTERMEDIARIO
            Nivel.INTERMEDIARIO -> Nivel.DIFICIL
            Nivel.DIFICIL -> Nivel.AVANCADO
            Nivel.AVANCADO -> Nivel.AVANCADO
        }
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    init {
        println("Criando conteúdo educacional $nome")
    }

    init {
        println("Criando conteúdo educacional $nome" + "e tempo de duração $duracao")
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {

        for (inscrito in inscritos) {
            if (inscrito.equals("Marcklen Guimaraes")) {
                println("Usuário já matriculado")
            } else {
                inscritos.add(inscrito)
                println("Usuário matriculado com sucesso!!")
            }
        }
    }
}

fun main() {
    val usuario = Usuario()
    for (i in 1..4) {
        println(usuario)
        usuario.evoluindo()
    }
    if (usuario.nivel == Nivel.AVANCADO) {
        println("Parabéns, você é um programador avançado")
    } else {
        println("Você ainda não é um programador avançado")
    }
    val conteudo = ConteudoEducacional("Kotlin")
    println(conteudo)
    val formacao = Formacao("Kotlin", listOf(conteudo))
    println(formacao)
    formacao.matricular(usuario)
    println(formacao.inscritos)
}