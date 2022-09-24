plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  val sdkVersion = 30
  compileSdkVersion(sdkVersion)

  defaultConfig {
    applicationId = "com.artyommironov.anyadaptersample"
    minSdkVersion(14)
    targetSdkVersion(sdkVersion)
    versionCode = 1
    versionName = "1.0"
  }
}

dependencies {
  implementation(project(":anyadapter"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
  implementation("androidx.recyclerview:recyclerview:1.2.0")
  implementation("androidx.core:core-ktx:1.3.2")
}
