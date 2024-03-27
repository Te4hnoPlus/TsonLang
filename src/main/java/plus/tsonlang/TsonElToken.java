package plus.tsonlang;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;


public class TsonElToken extends TsonElement {
    public static TsonElToken EMPTY           = new TsonElToken("Empty");
    public static TsonElToken START_MAP       = new TsonElToken("Start Map", CONSTANT);
    public static TsonElToken END_MAP         = new TsonElToken("End Map"  , START_MAP.key);

    public static TsonElToken START_CLASS     = new TsonElToken("Start Class", FUNCTION_DECLARATION);
    public static TsonElToken END_CLASS       = new TsonElToken("End Class",   START_CLASS.key);

    public static TsonElToken START_LIST      = new TsonElToken("Start List", CONSTANT);
    public static TsonElToken END_LIST        = new TsonElToken("End List"  , START_LIST.key);

    public static TsonElToken PRIMITIVE_START = new TsonElToken("Start Primitive", METADATA);
    public static TsonElToken PRIMITIVE_END   = new TsonElToken("End Primitive"  , PRIMITIVE_START.key);

    public static TsonElToken STRING_BOUND    = new TsonElToken("String Bound", col(DOC_COMMENT_MARKUP,"STRING_B"));
    public static TsonElToken STRING          = new TsonElToken("String", col(DefaultLanguageHighlighterColors.STRING,"STRING"));
    public static TsonElToken NUMBER          = new TsonElToken("Number", col(DefaultLanguageHighlighterColors.NUMBER,"NUMBER"));
    public static TsonElToken CLASS           = new TsonElToken("Class", FUNCTION_DECLARATION);
    public static TsonElToken BOOLEAN         = new TsonElToken("Boolean", DefaultLanguageHighlighterColors.COMMA);

    public static TsonElToken COMMA = new TsonElToken("Comma", DefaultLanguageHighlighterColors.COMMA);//
    public static TsonElToken KEY_SEPARATOR = new TsonElToken("Separator", DOC_COMMENT_TAG_VALUE);

    //HIGHLIGHTED_REFERENCE нижняя черта
    //DOC_COMMENT_TAG_VALUE темный рыжий
    //DOC_COMMENT_TAG зеленый, нижняя черта
    //BLOCK_COMMENT темно серый
    //INSTANCE_METHOD ярко желтый
    //METADATA темно желтый
    //CONSTANT фиолетовый

    private TextAttributesKey[] key = {HighlighterColors.TEXT};


    public TsonElToken(@NotNull String debugName) {
        super(debugName);
    }


    private static TextAttributesKey col(String key){
        return TextAttributesKey.createTextAttributesKey("TSON."+key.toUpperCase());
    }


    private static TextAttributesKey col(TextAttributesKey parent, String key){
        return TextAttributesKey.createTextAttributesKey("TSON."+key.toUpperCase(), parent);
    }


    public TsonElToken(@NotNull String debugName, TextAttributesKey... c) {
        super(debugName);
        if(c != null) this.key = c;
    }


    public TextAttributesKey[] get(){
        return key;
    }
}


