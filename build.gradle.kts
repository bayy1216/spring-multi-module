import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring") apply false

    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")  apply false

}


java{
    sourceCompatibility = JavaVersion.VERSION_17
}



val projectGroup: String by project
val applicationVersion: String by project

allprojects {
    group = projectGroup
    version = applicationVersion



    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")




    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

    }

    /**
     * bootJar은 Spring Boot 프로젝트에서 실행 가능한 JAR 파일을 빌드하기 위한 태스크입니다.
     * 이 태스크는 프로젝트의 모든 의존성을 포함한 JAR 파일을 생성합니다.
     * 이 JAR 파일을 실행하면 Spring Boot 애플리케이션이 시작됩니다.
     */
    tasks.getByName("bootJar") {
        enabled = false
    }

    /**
     * jar은 일반적인 JAR 파일을 빌드하기 위한 태스크입니다.
     * 이 태스크는 프로젝트의 소스 코드만을 포함한 JAR 파일을 생성합니다.
     * 이 JAR 파일은 실행 가능한 JAR 파일이 아닙니다.
     */
    tasks.getByName("jar") {
        enabled = true
    }


    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
