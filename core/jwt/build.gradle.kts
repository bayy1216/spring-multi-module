
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(project(":core:common"))
    compileOnly("org.springframework:spring-context")

    // Jwt
    implementation("io.jsonwebtoken:jjwt-api:0.12.3")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.3")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.3")
}