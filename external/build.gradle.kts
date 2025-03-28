dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.2.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.github.openfeign:feign-jackson:12.5")

    testImplementation(kotlin("test"))
}
