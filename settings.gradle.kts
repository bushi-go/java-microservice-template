/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.5/userguide/building_swift_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

pluginManagement {
    // Include 'plugins build' to define convention plugins.
    includeBuild("build-logic")
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "java-microservice-template"
rootProject.group = "com.it.example"

project(":application:rest:contract").group = rootProject.group+".rest"
project(":application:rest:executable").group = rootProject.group + ".rest"
project(":application:rest:contract").name = "contract"
project(":application:rest:executable").name = "rest"

project(":application:grpc:contract").group = rootProject.group +".grpc"
project(":application:grpc:executable").group = rootProject.group +".grpc"
project(":application:grpc:contract").name = "contract"
project(":application:grpc:executable").name = "grpc"


project(":application:consumer:contract").group = rootProject.group+".consumer"
project(":application:consumer:executable").group = rootProject.group+".consumer"
project(":application:consumer:contract").name = "contract"
project(":application:consumer:executable").name = "consumer"

project(":application:cli:executable").group = rootProject.group+".cli"
project(":application:cli:executable").name = "cli"

project(":domain:contract").group =rootProject.group+".domain"
project(":domain:core").group = rootProject.group+".domain"
project(":domain:contract").name = "contract"
project(":domain:core").name = "domain"

project(":infrastructure:clients").group = rootProject.group+"infrastructure"
project(":infrastructure:configuration").group = rootProject.group+"infrastructure"
project(":infrastructure:events").group = rootProject.group+"infrastructure"
project(":infrastructure:clients").name = "clients"
project(":infrastructure:configuration").name = "configuration"
project(":infrastructure:events").name = rootProject.events

include(
    // Appliction packages
    // Those packages contains the code of the various applications you can need
    "application:rest:contract",
    "application:rest:executable",
    "application:grpc:contract",
    "application:grpc:executable",
    "application:consumer:contract",
    "application:consumer:executable",
    "application:cli:executable",
    // Domain packages
    // Those packages contains the code of the core of your application, embedding the business logic
    "domain:contract",
    "domain:core",
    // Infrastructure packages
    // Those packages contains the code of the infrastructure of your application, like configuration, the database, async publishers, rest or grpc clients.
    "infrastructure:clients",
    "infrastructure:configuration",
    "infrastructure:events"
    "infrastructure:persistence"
)