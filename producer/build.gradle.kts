tasks.register("action") {
    doLast {
        println("Producer Message: ")
        rootProject.extra["producerMessage"] = "Watch the order of execution."
    }
}