plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency)
}

group = "com.reringuy"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.spring.boot.web)
    implementation(libs.kafka)
    implementation(libs.spring.kafka)
    compileOnly(libs.lombok)
    developmentOnly(libs.spring.docker)
    annotationProcessor(libs.lombok)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.kafka.test)
    testRuntimeOnly(libs.junit)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder = "paketobuildpacks/builder-jammy-base:latest"
}
