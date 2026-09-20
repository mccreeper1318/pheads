plugins {
    java
}

group = "io.github.mccreeper1318"
val baseVersion = "0.0.2"
val releaseVersion = providers.gradleProperty("releaseVersion").orNull
if (releaseVersion != null) {
    val supportedReleaseVersion =
        Regex("^" + Regex.escape(baseVersion) + "(?:-(?:alpha|beta|rc)\\.\\d+)?$")
    if (!supportedReleaseVersion.matches(releaseVersion)) {
        throw GradleException(
            "releaseVersion must be $baseVersion, $baseVersion-alpha.x, $baseVersion-beta.x, or $baseVersion-rc.x"
        )
    }
}
version = releaseVersion ?: baseVersion

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.123-stable")

    testImplementation(platform("org.junit:junit-bom:6.1.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.papermc.paper:paper-api:26.2.build.123-stable")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(25)
}

tasks.processResources {
    val properties = mapOf("version" to project.version)
    inputs.properties(properties)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(properties)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveBaseName.set("pheads")
}
