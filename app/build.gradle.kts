import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)
    buildToolsVersion = "28.0.3"
    defaultConfig {
        applicationId = "com.mnowak.cirriculumvitae"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {

    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:2.2.2") {
        exclude(group = "com.android.support", module = "support-annotations")
    }

    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:design:28.0.0")
    implementation("com.android.support:support-v4:28.0.0")

    //Kotlin
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))

    //ButterKnife
    implementation("com.jakewharton:butterknife:8.8.1")
    annotationProcessor("com.jakewharton:butterknife-compiler:8.8.1")
    kapt("com.jakewharton:butterknife-compiler:8.8.1")

    //GSON
    implementation("com.google.code.gson:gson:2.8.2")

    //Bindable Circle Image View
    implementation("de.hdodenhof:circleimageview:2.1.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.6.1")
}
repositories {
    mavenCentral()
}