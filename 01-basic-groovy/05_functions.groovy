node("docker") {
    def iGotAString = thisWillReturnAstring()
    println(iGotAString)

    // This will not work
    // def thisWillReturnAstring() {
    //     return "Hello"
    // }
}

// Declare functions outside the node {}
def thisWillReturnAstring() {
    return "Hello"
}