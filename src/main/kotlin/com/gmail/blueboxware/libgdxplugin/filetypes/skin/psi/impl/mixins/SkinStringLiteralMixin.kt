package com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.impl.mixins

import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.SkinPropertyName
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.SkinPsiUtil
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.SkinResource
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.SkinStringLiteral
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi.impl.SkinLiteralImpl
import com.gmail.blueboxware.libgdxplugin.filetypes.skin.references.SkinResourceAliasReference
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiReference

/*
 * Copyright 2016 Blue Box Ware
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
abstract class SkinStringLiteralMixin(node: ASTNode) : SkinStringLiteral, SkinLiteralImpl(node) {

  override fun getValue(): String = StringUtil.unescapeStringCharacters(SkinPsiUtil.stripQuotes(text))

  override fun asPropertyName(): SkinPropertyName? = this.parent as? SkinPropertyName

  override fun getReference(): PsiReference? {
    if (context is SkinResource) {
      return SkinResourceAliasReference(this)
    }

    return null
  }
}