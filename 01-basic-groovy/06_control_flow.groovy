println(((1 + 1) == 2)) // true
println (1 == 5) // false

// If else conditions
def isTrue = false

if (isTrue) {
    println("is True")
} else if (isTrue == false) {
    println("is False")
} else {
    println("What else could it be?")
} // is False

// Switch case
def month = 1
switch(month) {
    case 1:
        println "January"
        break;
    case 2:
        println "February"
        break;
    default:
        println "Not a month"
} // "January"