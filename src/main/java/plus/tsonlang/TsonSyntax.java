package plus.tsonlang;

import com.intellij.json.JsonLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class TsonSyntax extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey(",", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);



    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private final JsonLexer lexer = new JsonLexer();

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return lexer;
    }


    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
//        if (tokenType.equals(SimpleTypes.SEPARATOR)) {
//            return SEPARATOR_KEYS;
//        }
//        if (tokenType.equals(SimpleTypes.KEY)) {
//            return KEY_KEYS;
//        }
//        if (tokenType.equals(SimpleTypes.VALUE)) {
//            return VALUE_KEYS;
//        }
//        if (tokenType.equals(SimpleTypes.COMMENT)) {
//            return COMMENT_KEYS;
//        }
//        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
//            return BAD_CHAR_KEYS;
//        }
        return EMPTY_KEYS;
    }
}
