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
  implementation(libs.kotlinStdlib)
  implementation(libs.androidxRecyclerView)
  implementation(libs.androidxCoreKtx)
}
