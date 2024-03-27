// This is a generated file. Not intended for manual editing.
package plus.tsonlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static plus.tsonlang.psi.TsonTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import plus.tsonlang.psi.*;

public class TsonPropertyImpl extends ASTWrapperPsiElement implements TsonProperty {

  public TsonPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TsonVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TsonVisitor) accept((TsonVisitor)visitor);
    else super.accept(visitor);
  }

}
