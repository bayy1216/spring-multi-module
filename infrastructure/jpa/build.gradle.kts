plugins {
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_17


dependencies {
    implementation(project(":core:common"))


    // Spring
    compileOnly("org.springframework:spring-context")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // DB
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
}
