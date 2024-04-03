package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListKt$ScrollPositionUpdater$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyListItemProvider f2767g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2768h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2769i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListKt$ScrollPositionUpdater$1(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, int i11) {
        super(2);
        this.f2767g = lazyListItemProvider;
        this.f2768h = lazyListState;
        this.f2769i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyListKt.ScrollPositionUpdater(this.f2767g, this.f2768h, composer, this.f2769i | 1);
    }
}
