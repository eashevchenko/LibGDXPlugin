package com.gmail.blueboxware.libgdxplugin.inspections.gradle

import com.gmail.blueboxware.libgdxplugin.components.VersionManager
import com.gmail.blueboxware.libgdxplugin.message
import com.gmail.blueboxware.libgdxplugin.versions.Libraries
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.lang.properties.psi.Property
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import org.jetbrains.kotlin.config.MavenComparableVersion

/*
 * Copyright 2017 Blue Box Ware
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class GradlePropertiesOutdatedVersionsInspection : LibGDXGradleBaseInspection() {

  override fun getStaticDescription() = message("outdated.version.inspection.static.description", Libraries.Companion.listOfCheckedLibraries())

  override fun getID() = "LibGDXOutdatedVersionGradleProperties"

  override fun getDisplayName() = message("outdated.version.inspection.display.name.gradle.properties")

  override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor = object : PsiElementVisitor() {

    override fun visitElement(element: PsiElement?) {

      if (element is Property && element.containingFile.name == "gradle.properties") {

        element.name?.let { extKey ->
          Libraries.fromExtKey(extKey)?.let { lib ->
            element.project.getComponent(VersionManager::class.java)?.getLatestVersion(lib)?.let { latestVersion ->
              element.value?.let { value ->
                if (MavenComparableVersion(value) < latestVersion) {
                  holder.registerProblem(
                          element,
                          message("outdated.version.inspection.msg", lib.library.name, latestVersion)
                  )
                }
              }
            }
          }
        }

      }

    }
  }
}