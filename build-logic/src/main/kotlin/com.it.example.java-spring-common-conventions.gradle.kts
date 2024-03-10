plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("com.it.example.java-common-library-conventions")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    implementation(enforcedPlatform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

