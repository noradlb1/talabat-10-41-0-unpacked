package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007¨\u0006\t"}, d2 = {"FontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "typeface", "Landroidx/compose/ui/text/font/Typeface;", "fonts", "", "Landroidx/compose/ui/text/font/Font;", "([Landroidx/compose/ui/text/font/Font;)Landroidx/compose/ui/text/font/FontFamily;", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyKt {
    @NotNull
    @Stable
    public static final FontFamily FontFamily(@NotNull List<? extends Font> list) {
        Intrinsics.checkNotNullParameter(list, "fonts");
        return new FontListFontFamily(list);
    }

    @NotNull
    @Stable
    public static final FontFamily FontFamily(@NotNull Font... fontArr) {
        Intrinsics.checkNotNullParameter(fontArr, "fonts");
        return new FontListFontFamily(ArraysKt___ArraysJvmKt.asList((T[]) fontArr));
    }

    @NotNull
    @Stable
    public static final FontFamily FontFamily(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        return new LoadedFontFamily(typeface);
    }
}
