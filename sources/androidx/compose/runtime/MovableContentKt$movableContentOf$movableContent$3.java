package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0004\u0012\u0002H\u00040\u0006H\u000b¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "it", "Lkotlin/Pair;", "invoke", "(Lkotlin/Pair;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentOf$movableContent$3 extends Lambda implements Function3<Pair<? extends Pair<? extends P1, ? extends P2>, ? extends P3>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function5<P1, P2, P3, Composer, Integer, Unit> f9131g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentOf$movableContent$3(Function5<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function5) {
        super(3);
        this.f9131g = function5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull Pair<? extends Pair<? extends P1, ? extends P2>, ? extends P3> pair, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-284417101, i11, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:114)");
        }
        this.f9131g.invoke(((Pair) pair.getFirst()).getFirst(), ((Pair) pair.getFirst()).getSecond(), pair.getSecond(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
