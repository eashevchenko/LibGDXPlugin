package com.gmail.blueboxware.libgdxplugin.filetypes.skin.inspections

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.LocalInspectionTool

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
open class SkinFileInspection : LocalInspectionTool() {

  override fun getGroupPath() = arrayOf("LibGDX", "Skin files")

  override fun getGroupDisplayName() = "LibGDX"

  override fun isEnabledByDefault() = true

  override fun getDefaultLevel(): HighlightDisplayLevel = HighlightDisplayLevel.ERROR

}