package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Color;", "it", "", "invoke-ijrfgN4"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$ColorSaver$2 extends Lambda implements Function1<Object, Color> {
    public static final SaversKt$ColorSaver$2 INSTANCE = new SaversKt$ColorSaver$2();

    public SaversKt$ColorSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke-ijrfgN4  reason: not valid java name */
    public final Color invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return Color.m2909boximpl(Color.m2915constructorimpl(((ULong) obj).m6552unboximpl()));
    }
}
