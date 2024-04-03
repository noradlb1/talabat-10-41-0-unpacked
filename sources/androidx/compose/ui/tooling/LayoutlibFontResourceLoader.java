package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/tooling/LayoutlibFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LayoutlibFontResourceLoader implements Font.ResourceLoader {
    @NotNull
    private final Context context;

    public LayoutlibFontResourceLoader(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public Typeface load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        if ((font instanceof ResourceFont) && Build.VERSION.SDK_INT >= 26) {
            return ResourceFontHelper.INSTANCE.load(this.context, (ResourceFont) font);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown font type: ", font.getClass().getName()));
    }
}
