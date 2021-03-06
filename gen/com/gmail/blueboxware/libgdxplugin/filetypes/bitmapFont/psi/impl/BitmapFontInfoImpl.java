// This is a generated file. Not intended for manual editing.
package com.gmail.blueboxware.libgdxplugin.filetypes.bitmapFont.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gmail.blueboxware.libgdxplugin.filetypes.bitmapFont.BitmapFontElementTypes.*;
import com.gmail.blueboxware.libgdxplugin.filetypes.bitmapFont.psi.impl.mixins.BitmapFontInfoMixin;
import com.gmail.blueboxware.libgdxplugin.filetypes.bitmapFont.psi.*;

public class BitmapFontInfoImpl extends BitmapFontInfoMixin implements BitmapFontInfo {

  public BitmapFontInfoImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BitmapFontElementVisitor visitor) {
    visitor.visitInfo(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BitmapFontElementVisitor) accept((BitmapFontElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BitmapFontProperty> getPropertyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BitmapFontProperty.class);
  }

}
