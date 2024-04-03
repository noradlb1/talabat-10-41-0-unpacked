package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class LazyDslKt$itemsIndexed$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> f2723g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<T> f2724h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$itemsIndexed$4(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
        super(4);
        this.f2723g = function5;
        this.f2724h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull LazyItemScope lazyItemScope, int i11, @Nullable Composer composer, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        if ((i12 & 14) == 0) {
            i13 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            i13 |= composer.changed(i11) ? 32 : 16;
        }
        if ((i13 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091073711, i13, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
            }
            this.f2723g.invoke(lazyItemScope, Integer.valueOf(i11), this.f2724h.get(i11), composer, Integer.valueOf((i13 & 14) | (i13 & 112)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
