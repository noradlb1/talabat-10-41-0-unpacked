package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(28)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceHelperMethodsApi28;", "", "()V", "create", "Landroid/graphics/Typeface;", "typeface", "finalFontWeight", "", "finalFontStyle", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypefaceHelperMethodsApi28 {
    @NotNull
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    private TypefaceHelperMethodsApi28() {
    }

    @RequiresApi(28)
    @NotNull
    @DoNotInline
    public final Typeface create(@NotNull Typeface typeface, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        Typeface a11 = Typeface.create(typeface, i11, z11);
        Intrinsics.checkNotNullExpressionValue(a11, "create(typeface, finalFontWeight, finalFontStyle)");
        return a11;
    }
}
