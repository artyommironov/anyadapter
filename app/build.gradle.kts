plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(Sdk.compile)

  defaultConfig {
    applicationId = "com.artyommironov.anyadaptersample"
    minSdkVersion(14)
    targetSdkVersion(Sdk.target)
    versionCode = 1
    versionName = "1.0"
  }
}

dependencies {
  implementation(project(":anyadapter"))
  implementation(Libs.kotlinStdLib)
  implementation(Libs.androidxRecyclerView)
  implementation(Libs.androidxKtx)
}
