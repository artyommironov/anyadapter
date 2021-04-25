plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
}

setupDependencyUpdates()

android {
  compileSdkVersion(Sdk.compile)

  buildFeatures {
    buildConfig = false
  }

  defaultConfig {
    minSdkVersion(14)
  }
}

dependencies {
  implementation(Libs.kotlinStdLib)
  implementation(Libs.androidxRecyclerView)
  implementation(Libs.androidxAnnotation)
  testImplementation(Libs.kotlinTestJunit)
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
