# LibCountriesKit
### Android Flag Kit Clone which provides the beautiful flags and the country names for Android developers


Flag Kit repo: https://github.com/madebybowtie/FlagKit 

# Features:

## Provides List of Country Codes:
     LibCK.availableCountryCodesArray() Or availableCountryCodesSet() Or LibCK.availableCountryCodesList()

## Provide List Of Countries:
    LibCK.getCountriesList(Context context)
## Get The Country By Country Code:
    LibCK.getCountryByCode(Context context, String countryCode)
## Get Country Name by Country Code:
    LibCK.getCountryNameByCode(Context context, String countryCode)
## Get Flag As Drawable By Country Code:
 #### No theme applied :
    LibCK.getFlagDrawable(Context context, String countryCode)
#### Or Applying The Context Theme:
    LibCK.getCompatFlagDrawable(Context context, String countryCode)
    
# Usage:

## Requirements
- AndroidX (this library uses AndroidX)
- Minimum SDK: 21 (Android 5.0 Lollipop)

## Installation

### Step 1: Add JitPack repository

**For projects using settings.gradle (recommended for newer projects):**

In your `settings.gradle` file:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

**For projects using build.gradle (legacy):**

In your root `build.gradle` file:
```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the dependency

In your `app/build.gradle` file:
```gradle
dependencies {
    implementation 'com.github.FazalHussain:LibCountriesKit:1.0'
}
```

**Note:** Replace `1.0` with the latest release tag or use `-SNAPSHOT` for the latest commit from the main branch.


