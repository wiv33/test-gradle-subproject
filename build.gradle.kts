plugins {
    java
}

group = "org.psawesome"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
}

subprojects {

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}