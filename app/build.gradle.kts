plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(29)

  defaultConfig {
    applicationId = "com.artyommironov.anyadaptersample"
    minSdkVersion(14)
    targetSdkVersion(29)
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
