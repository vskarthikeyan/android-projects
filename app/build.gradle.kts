plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.artbooktesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.artbooktesting"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.example.artbooktesting.HiltTestRunner"
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
        viewBinding = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.dagger:hilt-android:2.52")
    implementation("androidx.test.espresso:espresso-contrib:3.6.1")
    kapt("com.google.dagger:hilt-compiler:2.52")
    // If using Kotlin, also add
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.2.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-ktx:1.9.1")

    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    //implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.test:core:1.6.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:2.8.4")
    testImplementation("androidx.room:room-testing:2.6.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("org.mockito:mockito-core:4.7.0")
    testImplementation("com.google.truth:truth:1.4.4")


    androidTestImplementation("androidx.test.ext:junit:1.2.1")
   // androidTestImplementation("androidx.test:core:1.6.1")
    androidTestImplementation("org.mockito:mockito-android:5.12.0")
    androidTestImplementation("org.mockito:mockito-core:5.12.0")
    androidTestImplementation("androidx.test:core-ktx:1.6.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.2.1")
    androidTestImplementation("androidx.test.ext:truth:1.6.0")
    androidTestImplementation("androidx.test:runner:1.6.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0-RC")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("com.google.truth:truth:1.4.4")
    androidTestUtil("androidx.test:orchestrator:1.5.0")
    debugImplementation("androidx.fragment:fragment-ktx:1.8.2")
    debugImplementation("androidx.fragment:fragment-testing:1.8.2")




    // Hilt testing dependencies
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.52")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.52")
    androidTestAnnotationProcessor("com.google.dagger:hilt-compiler:2.52")

    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.52")
    testAnnotationProcessor("com.google.dagger:hilt-compiler:2.52")


}