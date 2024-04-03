package androidx.compose.material;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4954g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4955h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4956i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$1$1(long j11, float f11, long j12) {
        super(1);
        this.f4954g = j11;
        this.f4955h = f11;
        this.f4956i = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float r72 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
        ProgressIndicatorKt.m1351drawLinearIndicatorBackgroundbw27NRU(drawScope, this.f4954g, r72);
        ProgressIndicatorKt.m1350drawLinearIndicator42QJj7c(drawScope, 0.0f, this.f4955h, this.f4956i, r72);
    }
}
