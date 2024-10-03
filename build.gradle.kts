plugins {
    id("fabric-loom") version "1.7-SNAPSHOT"
}

object Properties {
    const val MINECRAFT_VERSION = "24w40a"
    const val YARN_MAPPINGS_VERSION = "24w40a+build.8"
    const val FABRIC_LOADER_VERSION = "0.16.5"
    const val FABRIC_API_VERSION = "0.105.2+1.21.2"
}

base.archivesName = "redtech"
version = "1.0.0-alpha.1"
group = "me.hrrocha"

dependencies {
    minecraft("com.mojang:minecraft:${Properties.MINECRAFT_VERSION}")
    mappings("net.fabricmc:yarn:${Properties.YARN_MAPPINGS_VERSION}:v2")

    modImplementation("net.fabricmc:fabric-loader:${Properties.FABRIC_LOADER_VERSION}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${Properties.FABRIC_API_VERSION}")
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    compileJava {
        options.release = 21
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${base.archivesName}" }
        }
    }
}
