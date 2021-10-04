package com.doist.gradle.versionname

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class VersionNamePluginTest {
    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.doist.gradle.version-name")

        assert(project.extensions.getByName("versionName") is VersionNameExtension)
    }
}
