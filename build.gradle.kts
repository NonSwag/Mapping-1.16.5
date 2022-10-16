plugins {
    id("java")
}

group = "net.nonswag.tnl.mapping"
version = "1.16.5"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.destroystokyo.paper:papermc:1.16.5")
    implementation("net.nonswag.tnl:listener:5.1")
    implementation("org.projectlombok:lombok:1.18.24")
}