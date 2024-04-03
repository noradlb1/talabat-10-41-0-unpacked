package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1 extends Lambda implements Function1<IntSize, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f4184g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(MutableState<Float> mutableState) {
        super(1);
        this.f4184g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1127invokeozmzZPI(((IntSize) obj).m5642unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1127invokeozmzZPI(long j11) {
        BottomSheetScaffoldKt.m1123BottomSheetScaffold_bGncdBI$lambda5(this.f4184g, Float.valueOf((float) IntSize.m5637getHeightimpl(j11)));
    }
}
