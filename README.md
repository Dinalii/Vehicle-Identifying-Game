# Vehicle-Identifying Game

This is a Native Android Mobile Application which was developed as a Vehicle Identifying Game.</br>

Vehicle Identifying Game has following features :</br>
:small_orange_diamond:Select correct Car Make from a Dropdown Menu</br>
:small_orange_diamond:Guess Car Maker's brand by entering letters</br>
:small_orange_diamond:Select correct Car Make out of 3 car images</br>
:small_orange_diamond:Enter 3 different Car Make brands and guess</br>
:small_orange_diamond:10s of Timer to get things spice a little bit</br>

All the populated images are picked randomly from the image array and remove them once the current acivity over. So player won't get the same car make in future.

## File Structure

```
.
├── app
│   ├── build
│   ├── build.gradle
│   ├── libs
│   └── src
│       ├── androidTest
│       ├── main
│       │   ├── AndroidManifest.xml
│       │   ├── java
│       │   │   └── com.example.mad_cw
│       │   │       └── Adapter
├── MainActivity.java
│       │   │               └── utils
│       │   │           └── nimendra
│       │   │               ├── AdvancedActivity.java
│       │   │               ├── CarHintActivity.java
│       │   │               ├── CarImageActivity.java
│       │   │               ├── CarMakeActivity.java
│       │   │               ├── MainActivity.java
│       │   │               └── utils
│       │   │                   ├── ImageLoader.java
│       │   │                   ├── PopulateData.java
│       │   │                   ├── Styles.java
│       │   │                   └── ValidateImages.java
│       │   └── res
│       │       ├── drawable
│       │       └── values
│       │           ├── colors.xml
│       │           ├── dimen.xml
│       │           ├── strings.xml
│       │           └── styles.xml
│       └── test
├── build.gradle
├── gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── local.properties
└── settings.gradle

```
