package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBarItem$2$1 extends Lambda implements Function1<IntSize, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f7373g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItem$2$1(MutableState<Integer> mutableState) {
        super(1);
        this.f7373g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1758invokeozmzZPI(((IntSize) obj).m5642unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1758invokeozmzZPI(long j11) {
        NavigationBarKt.m1750NavigationBarItem$lambda4(this.f7373g, IntSize.m5638getWidthimpl(j11));
    }
}
