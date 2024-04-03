package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentOf$3 extends Lambda implements Function4<P1, P2, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MovableContent<Pair<P1, P2>> f9126g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$3(MovableContent<Pair<P1, P2>> movableContent) {
        super(4);
        this.f9126g = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(P1 p12, P2 p22, @Nullable Composer composer, int i11) {
        int i12;
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) p12) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            i12 |= composer.changed((Object) p22) ? 32 : 16;
        }
        if ((i12 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1200019734, i11, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
            }
            composer.insertMovableContent(this.f9126g, TuplesKt.to(p12, p22));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
