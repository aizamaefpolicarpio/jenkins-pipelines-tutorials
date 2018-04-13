// Scoping variables

// Accessing Environment Variables
// Environment variables are global!
println(env.BUILD_NUMBER)
println(env.BUILD_URL)


// Global dynamic variable
def word = "hello world"
simpleFunc(word) // word

// A simple function
def simpleFunc(word) {
    println(word)
    println(env.JOB_NAME)
}


