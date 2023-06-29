plugins {
    java
    id("org.springframework.boot") version "2.7.9"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.miniproject"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    // https://mvnrepository.com/artifact/io.springfox/springfox-swagger2
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.github.flashvayne:chatgpt-spring-boot-starter:1.0.0")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation("com.googlecode.json-simple:json-simple:1.1.1")



}

tasks.withType<Test> {
    useJUnitPlatform()
}
