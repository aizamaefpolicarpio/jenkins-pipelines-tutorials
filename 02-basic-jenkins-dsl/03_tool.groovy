node("docker") {
    stage("checkout") {
        git(
            url: "https://github.com/bzon/spring-petclinic.git",
            branch: "master"
        )
    }
    
    stage("build") {
        
        def javaHome = tool(
            name: "ORACLEJDK8",
            type: "jdk"
        ) // returns java install home directory for ORACLEJDK8

        def mavenHome = tool(
            name: "ADOP Maven",
            type: "maven"
        ) // returns maven install home directory for ADOP Maven
        
        env.PATH = "${env.PATH}:${javaHome}/bin:${mavenHome}/bin"
        sh "java -version"
        sh "mvn --version"

    }
    
    stage("deploy") {
        println("deploying to env")
    }
}