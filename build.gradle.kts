plugins {
    id("application")
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.github.sapher:youtubedl-java:ef1bdc8c2e3e7eac134bc4ea9fae37318e79771a")
    implementation("commons-io:commons-io:2.8.0")

}

application {
    mainClass.set("YouTubeDownloaderApp")
}

