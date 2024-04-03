package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "totalSize", "", "size", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "outPosition", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class RowKt$DefaultRowMeasurePolicy$1 extends Lambda implements Function5<Integer, int[], LayoutDirection, Density, int[], Unit> {
    public static final RowKt$DefaultRowMeasurePolicy$1 INSTANCE = new RowKt$DefaultRowMeasurePolicy$1();

    public RowKt$DefaultRowMeasurePolicy$1() {
        super(5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        Arrangement.INSTANCE.getStart().arrange(density, i11, iArr, layoutDirection, iArr2);
    }
}
