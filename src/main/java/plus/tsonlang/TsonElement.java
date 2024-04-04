package plus.tsonlang;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;


public class TsonElement extends IElementType {
    public TsonElement(@NotNull String debugName) {
        super(debugName, TsonLang.INSTANCE);
    }


    @Override
    public String toString() {
        return "Tson." + super.toString();
    }
}