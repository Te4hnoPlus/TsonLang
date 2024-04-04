package plus.tsonlang;


import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;


public final class TsonFileType extends LanguageFileType {
    public static final TsonFileType INSTANCE = new TsonFileType();
    public static final Icon ICON = IconLoader.getIcon("ico_x12.png", TsonFileType.class);

    private TsonFileType() {
        super(TsonLang.INSTANCE);
    }


    @Override
    public @NotNull String getName() {
        return Strings.TSON_FILE;
    }


    @Override
    public @NotNull String getDescription() {
        return Strings.TSON_DESCRIPTION;
    }


    @Override
    public @NotNull String getDefaultExtension() {
        return Strings.TSON;
    }


    @Override
    public @Nullable Icon getIcon() {
        return ICON;
    }
}