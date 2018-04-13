node("docker") {
    sh "ls -lrt"
    // put shell command output to a variable
    def word = sh(
        script: "echo hello world",
        returnStdout: true
    )
    println(word)
}