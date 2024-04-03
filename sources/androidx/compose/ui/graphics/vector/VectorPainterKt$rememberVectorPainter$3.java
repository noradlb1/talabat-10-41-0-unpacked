package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainterKt$rememberVectorPainter$3 extends Lambda implements Function4<Float, Float, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageVector f9746g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainterKt$rememberVectorPainter$3(ImageVector imageVector) {
        super(4);
        this.f9746g = imageVector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @Composable
    public final void invoke(float f11, float f12, @Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1873274766, i11, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous> (VectorPainter.kt:166)");
            }
            VectorPainterKt.RenderVectorGroup(this.f9746g.getRoot(), (Map<String, ? extends VectorConfig>) null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
