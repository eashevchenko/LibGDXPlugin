package com.gmail.blueboxware.libgdxplugin.skin

import com.gmail.blueboxware.libgdxplugin.LibGDXCodeInsightFixtureTestCase
import com.intellij.codeInsight.generation.actions.CommentByBlockCommentAction
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction

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
class TestEditorFeatures : LibGDXCodeInsightFixtureTestCase() {

  fun testFolding() {
    myFixture.testFolding(testDataPath + "folding.skin")
  }

  fun testComments() {
    myFixture.configureByFile("comments.skin")
    val commentByLineAction = CommentByLineCommentAction()
    commentByLineAction.actionPerformedImpl(project, myFixture.editor)
    myFixture.checkResultByFile("lineComment.txt")
    myFixture.editor.caretModel.moveCaretRelatively(0, -1, false, false, false)
    commentByLineAction.actionPerformedImpl(project, myFixture.editor)
    myFixture.checkResultByFile("noComment.txt")
    myFixture.editor.caretModel.moveCaretRelatively(0, -1, false, false, false)
    myFixture.editor.caretModel.moveToOffset(myFixture.editor.caretModel.visualLineStart)
    myFixture.editor.caretModel.moveCaretRelatively(myFixture.editor.caretModel.visualLineEnd - 1, 0, true, false, false)
    val blockCommentAction = CommentByBlockCommentAction()
    blockCommentAction.actionPerformedImpl(project, myFixture.editor)
    myFixture.checkResultByFile("blockComment.txt")
    blockCommentAction.actionPerformedImpl(project, myFixture.editor)
    myFixture.checkResultByFile("noComment.txt")
  }

  override fun getBasePath() = "/filetypes/skin/editor/"
}