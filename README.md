# LibCountriesKit

[![JitPack](https://jitpack.io/v/FazalHussain/LibCountriesKit.svg)](https://jitpack.io/#FazalHussain/LibCountriesKit)

A lightweight Android library that provides beautiful country flags and country names for Android developers. Easily integrate country flag icons and country information into your Android applications.

> **Note:** This library is based on the [FlagKit](https://github.com/madebybowtie/FlagKit) design and provides an Android-native implementation.

## Features

- 🌍 **200+ Country Flags**: High-quality flag icons for all major countries
- 📱 **AndroidX Compatible**: Built with modern AndroidX libraries
- 🎨 **Flexible API**: Multiple methods to retrieve country codes, names, and flags
- 💡 **Easy Integration**: Simple API with minimal setup required
- 🚀 **Lightweight**: Small library size with no heavy dependencies
- 🔄 **Multiple Formats**: Get country codes as Array, List, or Set

## Requirements

- **Minimum SDK**: 21 (Android 5.0 Lollipop)
- **Target SDK**: 34
- **AndroidX**: Required (this library uses AndroidX)
- **Java**: 17 or higher

## Installation

### Step 1: Add JitPack Repository

#### For Modern Projects (Gradle 7.0+)

Add the JitPack repository to your `settings.gradle` file:

```gradle
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

#### For Legacy Projects

Add the JitPack repository to your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency

Add the library to your `app/build.gradle` (or module's `build.gradle`):

```gradle
dependencies {
    implementation 'com.github.FazalHussain:LibCountriesKit:1.0.2'
}
```

## Usage

### Basic Example

```java
import co.gistech.libs.countrieskit.LibCK;
import co.gistech.libs.countrieskit.Country;
import android.graphics.drawable.Drawable;

// Get country flag as Drawable
Drawable flagDrawable = LibCK.getFlagDrawable(context, "us");

// Get country name by code
String countryName = LibCK.getCountryNameByCode(context, "us");
// Returns: "United States"

// Get complete country object
Country country = LibCK.getCountryByCode(context, "us");
```

### Get Country Codes

```java
// As Array
String[] codes = LibCK.availableCountryCodesArray();

// As List
List<String> codesList = LibCK.availableCountryCodesList();

// As Set
Set<String> codesSet = LibCK.availableCountryCodesSet();
```

### Get All Countries

```java
List<Country> allCountries = LibCK.getCountriesList(context);

for (Country country : allCountries) {
    String code = country.getCountryCode();
    String name = country.getCountryName();
    int flagResId = country.getFlagResId();
}
```

### Get Flag Drawables

```java
// Without theme applied (recommended for most cases)
Drawable flag = LibCK.getFlagDrawable(context, "us");

// With context theme applied
Drawable themedFlag = LibCK.getCompatFlagDrawable(context, "us");
```

### Complete Example: Display Country Flag in ImageView

```java
import android.widget.ImageView;
import co.gistech.libs.countrieskit.LibCK;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView flagImageView = findViewById(R.id.flagImageView);
        
        // Get flag drawable for United States
        Drawable usFlag = LibCK.getFlagDrawable(this, "us");
        flagImageView.setImageDrawable(usFlag);
        
        // Get country name
        String countryName = LibCK.getCountryNameByCode(this, "us");
        // Display countryName in a TextView
    }
}
```

## API Reference

### Static Methods

#### `availableCountryCodesArray()`
Returns all available country codes as a `String[]`.

```java
String[] codes = LibCK.availableCountryCodesArray();
```

#### `availableCountryCodesList()`
Returns all available country codes as a `List<String>`.

```java
List<String> codes = LibCK.availableCountryCodesList();
```

#### `availableCountryCodesSet()`
Returns all available country codes as a `Set<String>`.

```java
Set<String> codes = LibCK.availableCountryCodesSet();
```

#### `getFlagDrawable(Context context, String countryCode)`
Returns a `Drawable` for the specified country flag without applying the context theme.

**Parameters:**
- `context`: Android Context (cannot be null)
- `countryCode`: ISO 3166-1 alpha-2 country code (e.g., "us", "gb", "fr")

**Returns:** `Drawable` or `null` if country code is invalid

#### `getCompatFlagDrawable(Context context, String countryCode)`
Returns a `Drawable` for the specified country flag with the context theme applied.

**Parameters:**
- `context`: Android Context (cannot be null)
- `countryCode`: ISO 3166-1 alpha-2 country code

**Returns:** `Drawable` or `null` if country code is invalid

#### `getCountryByCode(Context context, String countryCode)`
Returns a `Country` object containing country code, name, and flag resource ID.

**Parameters:**
- `context`: Android Context (cannot be null)
- `countryCode`: ISO 3166-1 alpha-2 country code

**Returns:** `Country` object or `null` if country code is invalid

#### `getCountryNameByCode(Context context, String countryCode)`
Returns the country name for the specified country code.

**Parameters:**
- `context`: Android Context (cannot be null)
- `countryCode`: ISO 3166-1 alpha-2 country code

**Returns:** Country name as `String` or `null` if country code is invalid

#### `getCountriesList(Context context)`
Returns a list of all available countries.

**Parameters:**
- `context`: Android Context (cannot be null)

**Returns:** `List<Country>` containing all countries

### Country Class

The `Country` class provides the following methods:

```java
public class Country {
    public String getCountryCode()      // Returns ISO country code (e.g., "us")
    public String getCountryName()      // Returns country name (e.g., "United States")
    public int getFlagResId()          // Returns flag drawable resource ID
    public String getFlagUrl()          // Returns flag URL (if available)
    
    // Setters
    public void setCountryCode(String code)
    public void setCountryName(String name)
    public void setFlagResId(int resId)
    public void setFlagUrl(String url)
}
```

## Supported Countries

The library supports 200+ countries including all ISO 3166-1 alpha-2 standard country codes. Some examples:

- `us` - United States
- `gb` - United Kingdom
- `fr` - France
- `de` - Germany
- `jp` - Japan
- `cn` - China
- `in` - India
- And many more...

## Error Handling

The library throws `IllegalArgumentException` if a `null` context is passed to any method. Invalid country codes return `null` instead of throwing exceptions.

```java
try {
    Drawable flag = LibCK.getFlagDrawable(context, "invalid");
    if (flag == null) {
        // Handle invalid country code
    }
} catch (IllegalArgumentException e) {
    // Handle null context
}
```

## Migration from Support Library

If you're migrating from an older version that used Android Support Library, update your imports:

**Old:**
```java
import android.support.v4.content.ContextCompat;
```

**New:**
```java
import androidx.core.content.ContextCompat;
```

## Build Status

Check the build status on [JitPack](https://jitpack.io/#FazalHussain/LibCountriesKit).

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

## Credits

- Flag designs based on [FlagKit](https://github.com/madebybowtie/FlagKit)
- Original Android implementation by Ahmad R Musa

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Issues

If you encounter any issues or have feature requests, please open an issue on [GitHub](https://github.com/FazalHussain/LibCountriesKit/issues).

## Changelog

### Version 1.0.2
- Initial release
- Modernized to Gradle 8.7 and Android Gradle Plugin 8.3.2
- Migrated to AndroidX
- Updated minimum SDK to 21
- Added JitPack publishing support

---

**Made with ❤️ for Android developers**
