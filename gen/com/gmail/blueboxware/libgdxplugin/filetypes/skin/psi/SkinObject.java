// This is a generated file. Not intended for manual editing.
package com.gmail.blueboxware.libgdxplugin.filetypes.skin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import java.awt.Color;

public interface SkinObject extends SkinValue {

  @NotNull
  List<SkinProperty> getPropertyList();

  @Nullable
  Color asColor(boolean force);

  @Nullable
  SkinResource asResource();

  @NotNull
  List<String> getPropertyNames();

  @Nullable
  SkinObject setColor(Color color);

  void addProperty(SkinProperty property);

  @Nullable
  SkinProperty getProperty(String name);

}
