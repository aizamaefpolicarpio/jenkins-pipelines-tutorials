node("CooperVisionSlave") {
    stage("checkout") {
        git(
            url: "https://github.com/bzon/spring-petclinic.git",
            branch: "master"
        )
    }
    
    stage("build") {
        mavenVerify()
    }
    
    stage("deploy") {
        println("deploying to env")
    }
}

def mavenVerify() {
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

    // Build Time
    try {
        sh "mvn clean verify"
        dependencyCheckPublisher(
            canComputeNew: false,
            defaultEncoding: '',
            healthy: '',
            pattern: '**/*dependency-check-report.xml',
            unHealthy: ''
        )
    } catch(e) {
        //
        // put the error into a Environemnt variable
        // for later use
        //
        env.GOT_ERROR = e
    } finally {
        //
        // Ensure test results are published
        // even if the build fails
        //
        junit(
            allowEmptyResults: true,
            testResults: '**/**TEST-*.xml'
        )
        //
        // Use the Env Variable created from catch(e)
        //
        if (env.GOT_ERROR) {
            error(env.GOT_ERROR)
        }
    }
}