package androidx.compose.material;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$Scrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4495g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Float> f4496h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$Scrim$1$1(long j11, Function0<Float> function0) {
        super(1);
        this.f4495g = j11;
        this.f4496h = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        b.K(drawScope, this.f4495g, 0, 0, this.f4496h.invoke().floatValue(), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
    }
}
