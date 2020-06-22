plugins {
    ->
    this.java
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allprojects {
    apply(plugin = "java")
    group = "org.psawesome.sample"
    version = "1.0.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "war")
    repositories {
//        mavenCentral()
    }
    dependencies {
        "providedCompile"("javax.servlet:servlet-api:2.5")
    }
}

dependencies {
//    implementation("junit:junit:4.13")
//    testImplementation("junit:junit:4.13")
}

