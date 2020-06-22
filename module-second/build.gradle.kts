extra["arctics"] = true
tasks.named("hello") {
    doLast {
        println(" * current Location in module-second")
    }
}

tasks.register("distanceToIceberg") {
    doLast {
        println("5 nautical miles")
    }
}
