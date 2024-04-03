package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainter$composeVector$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> f9737g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VectorPainter f9738h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainter$composeVector$1(Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, VectorPainter vectorPainter) {
        super(2);
        this.f9737g = function4;
        this.f9738h = vectorPainter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1916507005, i11, -1, "androidx.compose.ui.graphics.vector.VectorPainter.composeVector.<anonymous> (VectorPainter.kt:211)");
            }
            this.f9737g.invoke(Float.valueOf(this.f9738h.vector.getViewportWidth()), Float.valueOf(this.f9738h.vector.getViewportHeight()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
