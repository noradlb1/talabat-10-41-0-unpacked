package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt$createModifier$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Float> f1236g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f1237h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<TransformOrigin> f1238i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$1(State<Float> state, State<Float> state2, State<TransformOrigin> state3) {
        super(1);
        this.f1236g = state;
        this.f1237h = state2;
        this.f1238i = state3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(EnterExitTransitionKt.m55createModifier$lambda8(this.f1236g));
        graphicsLayerScope.setScaleX(EnterExitTransitionKt.m50createModifier$lambda11(this.f1237h));
        graphicsLayerScope.setScaleY(EnterExitTransitionKt.m50createModifier$lambda11(this.f1237h));
        graphicsLayerScope.m3064setTransformOrigin__ExYCQ(EnterExitTransitionKt.m51createModifier$lambda13(this.f1238i));
    }
}
