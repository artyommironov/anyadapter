plugins {
  id("com.android.library")
  id("maven-publish")
  kotlin("android")
}

android {
  compileSdk = 30

  buildFeatures {
    buildConfig = false
  }

  defaultConfig {
    minSdk = 14
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
  implementation("androidx.recyclerview:recyclerview:1.2.0")
  implementation("androidx.annotation:annotation:1.2.0")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.10")
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
