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
public final class BackdropScaffoldKt$BackdropScaffold$1$1$1$1 extends Lambda implements Function1<Density, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BackdropScaffoldState f3965g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$1$1$1$1(BackdropScaffoldState backdropScaffoldState) {
        super(1);
        this.f3965g = backdropScaffoldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5587boximpl(m1099invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1099invokeBjo55l4(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffsetKt.IntOffset(0, MathKt__MathJVMKt.roundToInt(this.f3965g.getOffset().getValue().floatValue()));
    }
}
