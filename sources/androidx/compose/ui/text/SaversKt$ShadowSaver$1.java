package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/graphics/Shadow;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$ShadowSaver$1 extends Lambda implements Function2<SaverScope, Shadow, Object> {
    public static final SaversKt$ShadowSaver$1 INSTANCE = new SaversKt$ShadowSaver$1();

    public SaversKt$ShadowSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(shadow, "it");
        return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Color.m2909boximpl(shadow.m3230getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope), SaversKt.save(Offset.m2665boximpl(shadow.m3231getOffsetF1C5BW0()), SaversKt.getSaver(Offset.Companion), saverScope), SaversKt.save(Float.valueOf(shadow.getBlurRadius())));
    }
}
