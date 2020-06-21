/*
tasks.register("hello2", fun Task.() {
    doLast(fun Task.() {
        println("sub build.gradle this ${this.project.name}")
    })
})
*/
extra["arctics"] = true
tasks.named("hello", fun Task.() {
    doLast {
        println(" * current location in module-api")
    }
})
