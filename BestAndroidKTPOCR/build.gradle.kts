plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id("maven-publish")
}

android {
    namespace = "com.tirtavium.bestandroidktpocr"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

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
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation ("com.google.android.gms:play-services-mlkit-text-recognition:18.0.2")
    implementation("androidx.test:monitor:1.7.2")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}