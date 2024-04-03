package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawerScrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4442g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4443h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawerScrim$1$1(long j11, State<Float> state) {
        super(1);
        this.f4442g = j11;
        this.f4443h = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        b.K(drawScope, this.f4442g, 0, 0, DrawerKt.m1227BottomDrawerScrim_3J_VO9M$lambda0(this.f4443h), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
    }
}
