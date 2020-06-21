plugins {
    java
}

group = "org.psawesome"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// .gradlew -q hello
// root 포함 모든 프로젝트의 이름을 출력
allprojects {
    tasks.register("hello", fun Task.() {
        doLast {
            println("I'm ${this.project.name}")
        }
    })
}

// root project를 제외한
//서브 프로젝트 전부에 적용.
subprojects(fun Project.() {
    tasks.named("hello", fun Task.() {
        doLast {
            println(" - I depend on water")
        }
    })
})

dependencies {
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}