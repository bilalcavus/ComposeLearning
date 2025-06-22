plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.composeintro"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.composeintro"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
//    implementation(libs.androidx.navigation.compose.jvmstubs)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    val nav_version = "2.9.0"
    implementation("androidx.navigation:navigation-compose:$nav_version") // For navigation in Compose
    implementation ("com.google.code.gson:gson:2.13.1") // For JSON parsing

    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version") // For Retrofit
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version") // For Gson converter
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofit_version") // For RxJava adapter

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4") // For coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4") // For Android coroutines support
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // For ViewModel support
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // For lifecycle support
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // For LiveData support


}