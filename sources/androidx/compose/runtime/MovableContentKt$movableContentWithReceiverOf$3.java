package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u0002H\u0004H\u000b¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "R", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentWithReceiverOf$3 extends Lambda implements Function5<R, P1, P2, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MovableContent<Pair<Pair<R, P1>, P2>> f9135g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentWithReceiverOf$3(MovableContent<Pair<Pair<R, P1>, P2>> movableContent) {
        super(5);
        this.f9135g = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(R r11, P1 p12, P2 p22, @Nullable Composer composer, int i11) {
        int i12;
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) r11) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            i12 |= composer.changed((Object) p12) ? 32 : 16;
        }
        if ((i11 & 896) == 0) {
            i12 |= composer.changed((Object) p22) ? 256 : 128;
        }
        if ((i12 & 5851) != 1170 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(583402949, i11, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:227)");
            }
            composer.insertMovableContent(this.f9135g, TuplesKt.to(TuplesKt.to(r11, p12), p22));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
