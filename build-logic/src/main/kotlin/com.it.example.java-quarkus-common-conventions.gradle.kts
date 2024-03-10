/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("com.it.example.java-common-library-conventions")
    id("org.kordamp.gradle.jandex")
    id("io.quarkus")
}

tasks.named<JavaCompile>("compileJava"){
    dependsOn("compileQuarkusGeneratedSourcesJava")
}

tasks.named<JavaCompile>("compileTestJava"){
    dependsOn("compileQuarkusTestGeneratedSourcesJava")
}

tasks.named("quarkusDependenciesBuild") {
    dependsOn("jandex")
}

tasks.named<Checkstyle>("checkstyleMain"){
    dependsOn("jandex")
}

tasks.named<Javadoc>("javadoc") {
    dependsOn("jandex")
}


tasks.withType<GenerateModuleMetadata> {
    // The value 'enforced-platform' is provided in the validation
    // error message you got
    suppressedValidationErrors.add("enforced-platform")
}

dependencies{
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:3.1.2.Final"))
    implementation(enforcedPlatform("org.testcontainers:testcontainers-bom:1.18.3"))
}
