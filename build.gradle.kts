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
// register 에 hello 등록 후 하위 모듈을 찾을 수 있다.
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
/*
    # allprojects 주석 후 확인 결과
    register 등록은 꼭 allprojects가 아니어도 관계없음.
    tasks.register("hello")
*/
    println("# start sub-Project")
    tasks.named("hello", fun Task.() {
        doLast {
            println(" - I depend on water")
        }
    })
})

// 서브 프로젝트 끝나고 특정 프로젝트에게 적용
// 서브 프로젝트와 연관성은 없고, 순서에 영향음
project(":module-api").tasks.named("hello") {
    println("# start Project")
    doLast {
        println(" - module-api doLast")
    }
}



dependencies {
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}