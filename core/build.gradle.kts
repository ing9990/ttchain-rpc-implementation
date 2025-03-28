tasks.getByName("bootJar") {
    enabled = true
}

dependencies {
    api(project(":external"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}