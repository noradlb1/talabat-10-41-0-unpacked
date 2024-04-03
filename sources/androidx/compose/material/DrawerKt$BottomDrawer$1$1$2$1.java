package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawer$1$1$2$1 extends Lambda implements Function1<Density, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomDrawerState f4419g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$1$1$2$1(BottomDrawerState bottomDrawerState) {
        super(1);
        this.f4419g = bottomDrawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5587boximpl(m1236invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1236invokeBjo55l4(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffsetKt.IntOffset(0, MathKt__MathJVMKt.roundToInt(this.f4419g.getOffset().getValue().floatValue()));
    }
}
