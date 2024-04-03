package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt$SwitchImpl$3$1 extends Lambda implements Function1<Density, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Float> f5706g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$3$1(State<Float> state) {
        super(1);
        this.f5706g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5587boximpl(m1406invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1406invokeBjo55l4(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(this.f5706g.getValue().floatValue()), 0);
    }
}
