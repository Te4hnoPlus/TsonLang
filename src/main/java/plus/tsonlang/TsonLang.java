package plus.tsonlang;

import com.intellij.lang.Language;


public final class TsonLang extends Language {
    public static final TsonLang INSTANCE = new TsonLang();

    private TsonLang() {
        super("Tson");
    }
}