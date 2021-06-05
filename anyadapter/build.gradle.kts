plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
}

android {
  compileSdkVersion(29)

  buildFeatures {
    buildConfig = false
  }

  defaultConfig {
    minSdkVersion(14)
  }
}

dependencies {
  implementation(libs.kotlinStdlib)
  implementation(libs.androidxRecyclerView)
  implementation(libs.androidxAnnotation)
  testImplementation(libs.kotlinTestJunit)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        from(components.findByName("release"))
      }
    }
  }
}
