package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MenuKt$DropdownMenuContent$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f7321g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7322h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7323i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuContent$1$1(MutableState<TransformOrigin> mutableState, State<Float> state, State<Float> state2) {
        super(1);
        this.f7321g = mutableState;
        this.f7322h = state;
        this.f7323i = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleX(MenuKt.m1739DropdownMenuContent$lambda1(this.f7322h));
        graphicsLayerScope.setScaleY(MenuKt.m1739DropdownMenuContent$lambda1(this.f7322h));
        graphicsLayerScope.setAlpha(MenuKt.m1740DropdownMenuContent$lambda3(this.f7323i));
        graphicsLayerScope.m3064setTransformOrigin__ExYCQ(this.f7321g.getValue().m3291unboximpl());
    }
}
