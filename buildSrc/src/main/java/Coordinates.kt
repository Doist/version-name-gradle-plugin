object PluginCoordinates {
    const val ID = "com.doist.gradle.version-name"
    const val GROUP = "com.doist.gradle"
    const val VERSION = "0.0.1"
    const val IMPLEMENTATION_CLASS = "com.doist.gradle.versionname.VersionNamePlugin"
}

object PluginBundle {
    const val VCS = "https://github.com/Doist/version-name-gradle-plugin"
    const val WEBSITE = "https://github.com/Doist/version-name-gradle-plugin"
    const val DESCRIPTION = "Gradle plugin to use git tags as project version names."
    const val DISPLAY_NAME = "Version name plugin"
    val TAGS = listOf(
        "plugin",
        "gradle",
        "android",
        "versioning"
    )
}
