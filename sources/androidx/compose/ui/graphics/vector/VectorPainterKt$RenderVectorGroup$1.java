package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainterKt$RenderVectorGroup$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VectorNode f9740g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, VectorConfig> f9741h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainterKt$RenderVectorGroup$1(VectorNode vectorNode, Map<String, ? extends VectorConfig> map) {
        super(2);
        this.f9740g = vectorNode;
        this.f9741h = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450046638, i11, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:412)");
            }
            VectorPainterKt.RenderVectorGroup((VectorGroup) this.f9740g, this.f9741h, composer, 64, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
