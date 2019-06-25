# Menjadi-Android-Developer-Expert
Menjadi Android Developer Expert

I ``` https://www.dicoding.com/users/297307 ``` have learning on ```Dicoding.com```

![SS](https://1.bp.blogspot.com/-I4Wxq6zkSU0/XQ4HV3Z--xI/AAAAAAAAAYY/OKVDr4hsVUod6S0OCdpOv94joz6ID6tPwCLcBGAs/s1600/Screenshot_2019-06-22-18-42-44-810_id.scode.scholarshipexpertscodeidev.png)

## Build Gradle ( Project: ScholarshipExpertScodeIDEV )
```

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.3.21'
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.3.2'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {url "https://jitpack.io"}
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}


```

## Build Gradle ( Module: App)
```

apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    lintOptions {
        checkReleaseBuilds false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        abortOnError false
    }
    signingConfigs {
        config {
            keyAlias '**********'
            keyPassword '********'
            storeFile file('/***********')
            storePassword '************'
        }
    }
    compileSdkVersion 28
    defaultConfig {
        applicationId "id.scode.scholarshipexpertscodeidev"
        minSdkVersion 23
        targetSdkVersion 28
        versionCode 5
        versionName '5.0'
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        signingConfig signingConfigs.config
        multiDexEnabled true
        vectorDrawables.useSupportLibrary = true
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.config
        }
    }
    productFlavors {
    }
    buildToolsVersion '28.0.3'
    compileOptions {
        sourceCompatibility = '1.8'
        targetCompatibility = '1.8'
    }
}

dependencies {
    /**
     * D E F A U L T ----- D E P E N D E N C I E S ----- I NEED
     */
//    implementation fileTree(include: ['*.jar'], dir: 'libs')
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support:customtabs:28.0.0'
    implementation 'com.android.support:exifinterface:28.0.0'
    implementation 'com.android.support:animated-vector-drawable:28.0.0'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:cardview-v7:28.0.0'
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    implementation 'com.android.support:support-v4:28.0.0'
    /**
     * __________________________________
     */
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation('com.android.support.test.espresso:espresso-core:3.0.2', {
        exclude group: 'com.android.support:27.1.1', module: 'support-annotations'
    })
    /**
     * migrate to androidX
     * D E F A U L T ----- D E P E N D E N C I E S ----- I NEED
     */
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.core:core-ktx:1.2.0-alpha02'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.google.android.material:material:1.1.0-alpha07'
    implementation 'androidx.cardview:cardview:1.0.0'

    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation('androidx.test.espresso:espresso-core:3.1.0', {
        exclude group: 'com.android.support:27.1.1', module: 'support-annotations'
    })


    /**
     * Image
     */
    implementation 'de.hdodenhof:circleimageview:2.2.0'
    implementation 'com.github.bumptech.glide:glide:4.8.0'

    /**
     * ShowScreen
     */
    implementation 'me.toptas.fancyshowcase:fancyshowcaseview:1.1.4'
}



```
