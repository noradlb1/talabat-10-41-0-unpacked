package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "R", "P", "it", "Lkotlin/Pair;", "invoke", "(Lkotlin/Pair;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentWithReceiverOf$movableContent$2 extends Lambda implements Function3<Pair<? extends R, ? extends P>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function4<R, P, Composer, Integer, Unit> f9138g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentWithReceiverOf$movableContent$2(Function4<? super R, ? super P, ? super Composer, ? super Integer, Unit> function4) {
        super(3);
        this.f9138g = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull Pair<? extends R, ? extends P> pair, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(pair, "it");
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) pair) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(812082854, i11, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:197)");
            }
            this.f9138g.invoke(pair.getFirst(), pair.getSecond(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
