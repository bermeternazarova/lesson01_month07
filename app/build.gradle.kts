
plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.lesson01_month07"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.lesson01_month07"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles (
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }

    viewBinding{
        android.buildFeatures.viewBinding=true
    }
}


dependencies {
    implementation(project(":dataModule"))
    implementation(project(":domainModule"))
    implementation(UI.core)
    implementation(UI.appcompat)
    implementation(UI.material)
    implementation(UI.constraintLayout)
    testImplementation(UI.junit)
    androidTestImplementation(UI.extjunit)
    androidTestImplementation(UI.espresso_core)
    implementation(UI.fragment)

    implementation(Room.runtime)
    kapt(Room.compiler)
    implementation(Room.room)

    implementation(Coroutines.android)

    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)

    implementation(Lifecycle.viewmodel)
    implementation(Lifecycle.runtime)

    implementation(NavigationFragment.navigationfragment)
    implementation(NavigationFragment.navigationui)

    implementation(platform(Bom.bom))

    implementation(ViewBindingPropertyDelegate.noReflection)

    implementation(UI.swipeRefreshLayout)


}