plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
}

android {
  compileSdk = 33

  buildFeatures {
    buildConfig = false
  }

  defaultConfig {
    minSdk = 14
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
  implementation("androidx.recyclerview:recyclerview:1.2.1")
  implementation("androidx.annotation:annotation:1.5.0")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.7.20")
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
