package androidx.compose.material;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4933g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4934h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Stroke f4935i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$1(float f11, long j11, Stroke stroke) {
        super(1);
        this.f4933g = f11;
        this.f4934h = j11;
        this.f4935i = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        ProgressIndicatorKt.m1348drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, this.f4933g * 360.0f, this.f4934h, this.f4935i);
    }
}
