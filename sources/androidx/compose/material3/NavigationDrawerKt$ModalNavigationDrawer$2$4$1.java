package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$ModalNavigationDrawer$2$4$1 extends Lambda implements Function1<Density, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DrawerState f7492g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$ModalNavigationDrawer$2$4$1(DrawerState drawerState) {
        super(1);
        this.f7492g = drawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5587boximpl(m1772invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1772invokeBjo55l4(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(this.f7492g.getOffset().getValue().floatValue()), 0);
    }
}
