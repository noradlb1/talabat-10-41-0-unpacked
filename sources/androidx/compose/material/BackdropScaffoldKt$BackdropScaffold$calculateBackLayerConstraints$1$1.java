package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends Lambda implements Function1<Constraints, Constraints> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4014g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f11) {
        super(1);
        this.f4014g = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Constraints.m5410boximpl(m1100invokeZezNO4M(((Constraints) obj).m5428unboximpl()));
    }

    /* renamed from: invoke-ZezNO4M  reason: not valid java name */
    public final long m1100invokeZezNO4M(long j11) {
        return ConstraintsKt.m5439offsetNN6EwU$default(Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 10, (Object) null), 0, -MathKt__MathJVMKt.roundToInt(this.f4014g), 1, (Object) null);
    }
}
