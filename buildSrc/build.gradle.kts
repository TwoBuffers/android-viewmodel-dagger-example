import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenLocal()
    jcenter()
}

plugins {
    `kotlin-dsl`
}

sourceSets["main"].java.srcDir("src/kotlin/main")
