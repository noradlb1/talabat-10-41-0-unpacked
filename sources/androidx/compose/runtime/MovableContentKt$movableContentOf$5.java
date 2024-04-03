package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\u000b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "P4", "p1", "p2", "p3", "p4", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentOf$5 extends Lambda implements Function6<P1, P2, P3, P4, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> f9128g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$5(MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> movableContent) {
        super(6);
        this.f9128g = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        invoke(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(P1 p12, P2 p22, P3 p32, P4 p42, @Nullable Composer composer, int i11) {
        int i12;
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) p12) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            i12 |= composer.changed((Object) p22) ? 32 : 16;
        }
        if ((i11 & 896) == 0) {
            i12 |= composer.changed((Object) p32) ? 256 : 128;
        }
        if ((i11 & 7168) == 0) {
            i12 |= composer.changed((Object) p42) ? 2048 : 1024;
        }
        if ((i12 & 46811) != 9362 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741877681, i11, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
            }
            composer.insertMovableContent(this.f9128g, TuplesKt.to(TuplesKt.to(p12, p22), TuplesKt.to(p32, p42)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
