
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(project(":core:common"))
    compileOnly("org.springframework.boot:spring-boot-starter-web")

    //swagger
    compileOnly ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
}