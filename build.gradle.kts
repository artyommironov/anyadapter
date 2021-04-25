buildscript {
  repositories {
    google()
    jcenter()
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
    jcenter()
  }
}

val clean by tasks.creating(Delete::class) {
  delete(rootProject.buildDir)
}
