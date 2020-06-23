plugins {
    java
//    `maven-publish`
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.palantir.docker") version "0.22.1"
}

//group = "org.psawesome"
//version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_13

extra["springCloudVersion"] = "Hoxton.SR5"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

/*
springBoot {
//    mainClassName = "com.psawesome.ExampleApplication"
    buildInfo {
        properties {
            artifact = "example-app"
            version = "1.0.0-SNAPSHOT"
            group = "org.psawesome"
            name = "Exam Application"
        }
    }
}
*/

/*
tasks.getByName<Jar>("jar") {
    enabled = true
}
*/
/*
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    mainClassName = "org.psawesome.ExampleApplication"
}
*/

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${extra["springCloudVersion"]}")
    }
}
val myTask = Action<Task> {
    doLast {
        println("myTask : ${this.project.name}")
    }
}
allprojects {
    apply(plugin = "java")

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

subprojects {

    when (name) {
        "personService" -> {
            run { myTask }
            tasks.register<Copy>("bundle") {
                from("resources")
                into("target/bundle")
                include("$buildDir/front/dist/*.*")
            }
        }
        "module-api" -> {
            tasks.register("taskX") {
                evaluationDependsOn("shared")
            }
        }
    }
    repositories {

    }
}
