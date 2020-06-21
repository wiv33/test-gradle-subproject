extra["arctics"] = true
tasks.named("hello") {
    doLast {
        println(" * current Location in module-second")
    }
}