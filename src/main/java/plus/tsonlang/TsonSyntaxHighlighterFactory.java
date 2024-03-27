package plus.tsonlang;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class TsonSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    @NotNull
    @Override
    public SyntaxHighlighter getSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile) {
        return new TsonHighliner();
    }


    private static class TsonHighliner extends SyntaxHighlighterBase {
        @Override
        public @NotNull Lexer getHighlightingLexer() {
            return new TsonLexer.Adapter();
        }


        @Override
        public TextAttributesKey @NotNull [] getTokenHighlights(IElementType type) {
            if(type instanceof TsonElToken){
                return ((TsonElToken) type).get();
            }
            return TsonElToken.EMPTY.get();
        }
    }
}