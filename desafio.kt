enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }

    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }

    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }

}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    //cursos individuais
    val moduloJava = ConteudoEducacional("curso java", 120)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 60)
    val moduloSQL = ConteudoEducacional("curso sql", 30)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    listConteudos.add(moduloSQL)
    
    //formação completa com todos os cursos
    val formacaoAndroid = Formacao("Formação Android Developer", listConteudos, Nivel.INTERMEDIARIO)
    
    //Criar lista de usuarios
    val fernanda = Usuario("Fernanda", "fernanda@gmail.com")
    val wilian = Usuario("Wilian", "wilian@hotmail.com")
    val camila = Usuario("Camila", "camila@uol.com.br")
    
    //matriculando usuarios na formação
    formacaoAndroid.matricular(fernanda)
    formacaoAndroid.matricular(wilian)
    formacaoAndroid.matricular(camila)
    
    println("======================================")
    println("Dados da formação")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Grade formação")
    println(formacaoAndroid.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoAndroid.imprimirListaInscritos())
}
