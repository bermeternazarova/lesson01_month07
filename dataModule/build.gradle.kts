
plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Kotlin.android)

}

android {
    namespace = "com.example.lesson01_month07"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
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
}

dependencies {
    implementation(project(":domainModule"))
    //modules
    //testing
    testImplementation(UI.junit)
    androidTestImplementation(UI.extjunit)
    //room
    implementation(Room.room)
    kapt(Room.compiler)
    implementation(Room.runtime)
    //coroutines
    implementation(Coroutines.android)
    //inject
    implementation(Javax.javax)


}