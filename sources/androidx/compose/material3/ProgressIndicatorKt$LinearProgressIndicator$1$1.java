package androidx.compose.material3;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f7804g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f7805h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7806i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$1$1(long j11, float f11, long j12) {
        super(1);
        this.f7804g = j11;
        this.f7805h = f11;
        this.f7806i = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float r72 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
        ProgressIndicatorKt.m1808drawLinearIndicatorTrackbw27NRU(drawScope, this.f7804g, r72);
        ProgressIndicatorKt.m1807drawLinearIndicator42QJj7c(drawScope, 0.0f, this.f7805h, this.f7806i, r72);
    }
}
