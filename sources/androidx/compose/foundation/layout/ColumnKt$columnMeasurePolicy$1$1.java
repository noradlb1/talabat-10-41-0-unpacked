package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ColumnKt$columnMeasurePolicy$1$1 extends Lambda implements Function5<Integer, int[], LayoutDirection, Density, int[], Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2477g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColumnKt$columnMeasurePolicy$1$1(Arrangement.Vertical vertical) {
        super(5);
        this.f2477g = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        this.f2477g.arrange(density, i11, iArr, iArr2);
    }
}
