buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath(Plugins.kotlin)
    classpath(Plugins.android)
    classpath(Plugins.gradleVersions)
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
