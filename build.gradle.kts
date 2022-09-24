buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.2.1")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

val clean by tasks.creating(Delete::class) {
  delete(rootProject.buildDir)
}
