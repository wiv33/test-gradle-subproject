plugins {
    java
    `maven-publish`
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.palantir.docker") version "0.22.1"
}

extra["springCloudVersion"] = "Hoxton.SR5"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${extra["springCloudVersion"]}")
    }
}

allprojects {
    group = "org.psawesome"
    version = "1.0.0-SNAPSHOT"

    java.sourceCompatibility = JavaVersion.VERSION_13

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

subprojects {
    repositories {

    }
}
