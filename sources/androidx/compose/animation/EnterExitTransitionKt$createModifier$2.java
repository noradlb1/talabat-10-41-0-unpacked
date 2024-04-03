package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt$createModifier$2 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Float> f1239g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$2(State<Float> state) {
        super(1);
        this.f1239g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(EnterExitTransitionKt.m55createModifier$lambda8(this.f1239g));
    }
}
