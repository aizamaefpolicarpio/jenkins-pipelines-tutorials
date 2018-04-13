node("docker") {
    stage("checkout") {
        println("I'm checking out the repo")
    }
    
    stage("build") {
        println("Building maven")
    }
    
    stage("deploy") {
        println("deploying to env")
    }
}