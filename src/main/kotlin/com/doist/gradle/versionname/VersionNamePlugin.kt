package com.doist.gradle.versionname

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.the
import java.io.ByteArrayOutputStream

@Suppress("unused")
class VersionNamePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create<VersionNameExtension>("versionName", target)
    }
}

open class VersionNameExtension(project: Project) {
    val increaseBy: Property<Int> = project.objects.property<Int>().convention(1)
    val namePrefix: Property<String> = project.objects.property<String>().convention("v")
}

fun Project.versionCode(): Int {
    val prefix = the<VersionNameExtension>().namePrefix.get()
    return versionName().removePrefix(prefix).toInt()
}

fun Project.versionName(): String {
    val prefix = the<VersionNameExtension>().namePrefix.get()
    return exec(listOf("git", "describe", "--tags", "--abbrev=0", "--match", "$prefix*")).trim()
}

@Suppress("unused")
fun Project.nextVersionName(): String {
    val increaseBy = the<VersionNameExtension>().increaseBy.get()
    val prefix = the<VersionNameExtension>().namePrefix.get()

    val currentVersionCode = versionCode()
    val nextVersionCode = currentVersionCode + increaseBy

    return prefix + nextVersionCode
}

private fun Project.exec(args: List<String>): String {
    val output = ByteArrayOutputStream()
    project.exec {
        commandLine = args
        standardOutput = output
    }
    return output.toString()
}
