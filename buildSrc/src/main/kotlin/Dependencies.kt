object Dependencies {

}
object UI {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val extjunit = "androidx.test.ext:junit:${Versions.extjunit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
}
object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room = "androidx.room:room-ktx:${Versions.room}"
}
object Coroutines{
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coreCoroutines}"
const val android  ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}
object DaggerHilt{
    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}
object Lifecycle {
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}
object NavigationFragment{
    const val navigationfragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val  navigationui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}
object Bom{
    const val bom = "org.jetbrains.kotlin:kotlin-bom:${Versions.bom}"
}
object ViewBindingPropertyDelegate{
    const val noReflection ="com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.noReflection}"
}
object Javax{
    const val javax = "javax.inject:javax.inject:1"
}
object Java{
    const val javaLibrary ="java-library"
}

object Plugins {
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
        const val jvm ="org.jetbrains.kotlin.jvm"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }
}
object Versions {
    const val coreCoroutines = "1.6.4"
    const val AGP = "7.3.1"
    const val android = "1.8.0"
    const val hilt = "2.44"
    const val lifecycle = "2.6.1"
    const val core = "1.10.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val junit = "4.13.2"
    const val extjunit = "1.1.5"
    const val espresso_core = "3.5.1"
    const val fragment = "1.5.6"
    const val room = "2.5.1"
    const val coroutines ="1.6.4"
    const val navigation ="2.5.3"
    const val bom ="1.8.0"
    const val noReflection ="1.5.8"
    const val swipeRefreshLayout = "1.1.0"
}
