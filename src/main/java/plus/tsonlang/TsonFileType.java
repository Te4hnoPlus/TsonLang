package plus.tsonlang;


import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;


public class TsonFileType extends LanguageFileType {
    public static final TsonFileType INSTANCE = new TsonFileType();
    public static final Icon ICON = IconLoader.getIcon("ico_x12.png", TsonFileType.class);

    protected TsonFileType() {
        super(TsonLang.INSTANCE);
    }


    @Override
    public @NonNls @NotNull String getName() {
        return Strings.TSON_FILE;
    }


    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return Strings.TSON_DESCRIPTION;
    }


    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return Strings.TSON;
    }


    @Override
    public @Nullable Icon getIcon() {
        return ICON;
    }
}