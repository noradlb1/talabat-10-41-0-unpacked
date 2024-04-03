package androidx.compose.material3;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$InputChip$2$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f6890g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f6891h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$InputChip$2$1$1(float f11, Shape shape) {
        super(1);
        this.f6890g = f11;
        this.f6891h = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(this.f6890g);
        graphicsLayerScope.setShape(this.f6891h);
        graphicsLayerScope.setClip(true);
    }
}
