plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  namespace = "com.artyommironov.anyadaptersample"
  val sdkVersion = 33
  compileSdk = sdkVersion

  defaultConfig {
    applicationId = "com.artyommironov.anyadaptersample"
    minSdk = 14
    targetSdk = sdkVersion
    versionCode = 1
    versionName = "1.0"
  }
}

dependencies {
  implementation(project(":anyadapter"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
  implementation("androidx.recyclerview:recyclerview:1.2.1")
  implementation("androidx.core:core-ktx:1.9.0")
}
