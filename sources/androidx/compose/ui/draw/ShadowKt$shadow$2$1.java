package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ShadowKt$shadow$2$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f9582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f9583h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f9584i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f9585j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f9586k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowKt$shadow$2$1(float f11, Shape shape, boolean z11, long j11, long j12) {
        super(1);
        this.f9582g = f11;
        this.f9583h = shape;
        this.f9584i = z11;
        this.f9585j = j11;
        this.f9586k = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.m5447toPx0680j_4(this.f9582g));
        graphicsLayerScope.setShape(this.f9583h);
        graphicsLayerScope.setClip(this.f9584i);
        graphicsLayerScope.m3062setAmbientShadowColor8_81llA(this.f9585j);
        graphicsLayerScope.m3063setSpotShadowColor8_81llA(this.f9586k);
    }
}
