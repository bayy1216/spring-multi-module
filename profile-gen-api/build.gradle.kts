
plugins {

}

java.sourceCompatibility = JavaVersion.VERSION_17


/**
 * 스프링 부트 어플리케이션으로 사용하기 위해서
 * bootJar 태스크를 활성화합니다.
 */
tasks.getByName("bootJar") {
    enabled = true
}

/**
 * 스프링 부트 어플리케이션이므로
 * 일반적인 JAR 파일을 생성하지 않도록 설정합니다.
 */
tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:jwt"))
    implementation(project(":infrastructure:jpa"))
    implementation(project(":core:api"))
    implementation(project(":core:domain"))
    runtimeOnly(project(":core:infrastructure"))


    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")


    //swagger
    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
}

