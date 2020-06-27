plugins {
    java
//    `maven-publish`
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.palantir.docker") version "0.22.1"
}
val myTask = Action<Task> {
    doLast {
        println("myTask : ${this.project.name}")
    }
}
allprojects {
    apply(plugin = "java")
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
//group = "org.psawesome"
//version = "1.0.0-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_13

    extra["springCloudVersion"] = "Hoxton.SR5"

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    repositories {
        mavenCentral()
        maven {
            url = uri("http://repo.mycompany.com/repo")
            metadataSources {
                mavenPom()
                artifact()
                ignoreGradleMetadataRedirection()
            }
        }
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${extra["springCloudVersion"]}")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// 하위 프로젝트 build
project(":shared") {
    myTask
    tasks.register("action") {
        doLast {
            println("Consuming message: ${rootProject.extra["producerMessage"]}")
        }
    }
}

project(":module-api") {
    apply(plugin = "org.springframework.boot")
    myTask
    tasks.register("api") {
        doLast {
            println("run api")
        }
    }
    dependencies {
        implementation(project(":shared"))

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }
}
