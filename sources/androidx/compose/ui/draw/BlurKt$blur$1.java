package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BlurKt$blur$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f9560g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f9561h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9562i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f9563j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f9564k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlurKt$blur$1(float f11, float f12, int i11, Shape shape, boolean z11) {
        super(1);
        this.f9560g = f11;
        this.f9561h = f12;
        this.f9562i = i11;
        this.f9563j = shape;
        this.f9564k = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        float r02 = graphicsLayerScope.m5447toPx0680j_4(this.f9560g);
        float r12 = graphicsLayerScope.m5447toPx0680j_4(this.f9561h);
        graphicsLayerScope.setRenderEffect((r02 <= 0.0f || r12 <= 0.0f) ? null : RenderEffectKt.m3194BlurEffect3YTHUZs(r02, r12, this.f9562i));
        Shape shape = this.f9563j;
        if (shape == null) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        graphicsLayerScope.setShape(shape);
        graphicsLayerScope.setClip(this.f9564k);
    }
}
