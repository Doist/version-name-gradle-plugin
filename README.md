# Version Name Gradle Plugin

This plugin adds a kotlin extension function that provides a version name based on the latest git tag.

## How to use it 👣

Apply the plugin in `build.gradle.kts`:  
```
plugins {
    id("com.doist.gradle.version-name")
}
```

Then, you can use:
```
versionName = project.versionName()
```

It adds also `project.versionCode()` extension method that's useful in Android projects. This can be used like:

```
android {
    defaultConfig {
        versionCode = project.versionCode()
        versionName = project.versionName()
        ...
    }
}
```

Version name is calculated based on the latest git tag. To be specific it uses following command to get it: 
```
git describe --tags --abbrev=0 --match $prefix*
```

It requires git.

Version code is a version name without a prefix, `v` by default.

## Configuration ⚙️

```
versionName {
    namePrefix.set("v")
}
``` 

## Contributing 🤝

Feel free to open an issue or submit a pull request for any bugs/improvements.

## Acknowledgements 🙏
This plugin is based on [kotlin-gradle-plugin-template 🐘](https://github.com/cortinico/kotlin-gradle-plugin-template)
