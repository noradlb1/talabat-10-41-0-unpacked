package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SimpleGraphicsLayerModifier$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SimpleGraphicsLayerModifier f9633g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.f9633g = simpleGraphicsLayerModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
        graphicsLayerScope.setScaleX(this.f9633g.scaleX);
        graphicsLayerScope.setScaleY(this.f9633g.scaleY);
        graphicsLayerScope.setAlpha(this.f9633g.alpha);
        graphicsLayerScope.setTranslationX(this.f9633g.translationX);
        graphicsLayerScope.setTranslationY(this.f9633g.translationY);
        graphicsLayerScope.setShadowElevation(this.f9633g.shadowElevation);
        graphicsLayerScope.setRotationX(this.f9633g.rotationX);
        graphicsLayerScope.setRotationY(this.f9633g.rotationY);
        graphicsLayerScope.setRotationZ(this.f9633g.rotationZ);
        graphicsLayerScope.setCameraDistance(this.f9633g.cameraDistance);
        graphicsLayerScope.m3064setTransformOrigin__ExYCQ(this.f9633g.transformOrigin);
        graphicsLayerScope.setShape(this.f9633g.shape);
        graphicsLayerScope.setClip(this.f9633g.clip);
        graphicsLayerScope.setRenderEffect(this.f9633g.renderEffect);
        graphicsLayerScope.m3062setAmbientShadowColor8_81llA(this.f9633g.ambientShadowColor);
        graphicsLayerScope.m3063setSpotShadowColor8_81llA(this.f9633g.spotShadowColor);
    }
}
