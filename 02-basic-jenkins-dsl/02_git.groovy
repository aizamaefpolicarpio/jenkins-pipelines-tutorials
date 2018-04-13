node("docker") {
    stage("checkout") {
        deleteDir()
        git(
            url: 'https://github.com/bzon/spring-petclinic.git',
            branch: 'master'
        )
    }
    
    stage("build") {
        println("Building maven")
    }
    
    stage("deploy") {
        println("deploying to env")
    }
}