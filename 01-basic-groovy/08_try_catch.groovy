try {
    error("this is an error")
} catch(e) {
    // do something about the error
    println(e)
    // currentBuild.result is jenkins variable which is null by default
    currentBuild.result = "FAILED"
} finally {
    // do something here
    println("this will always run")
    // but fail it instead
    if (currentBuild.result == "FAILED") {
        error("You got an error again")
    }
}