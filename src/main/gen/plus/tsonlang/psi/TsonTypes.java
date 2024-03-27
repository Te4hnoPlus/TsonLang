// This is a generated file. Not intended for manual editing.
package plus.tsonlang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import plus.tsonlang.TsonElement;
import plus.tsonlang.TsonElToken;
import plus.tsonlang.psi.impl.*;

public interface TsonTypes {

  IElementType PROPERTY = new TsonElement("PROPERTY");

  IElementType COMMENT = new TsonElToken("COMMENT");
  IElementType CRLF = new TsonElToken("CRLF");
  IElementType KEY = new TsonElToken("KEY");
  IElementType SEPARATOR = new TsonElToken("SEPARATOR");
  IElementType VALUE = new TsonElToken("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new TsonPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
