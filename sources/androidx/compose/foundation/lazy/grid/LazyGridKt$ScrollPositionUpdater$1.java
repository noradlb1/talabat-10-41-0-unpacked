package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt$ScrollPositionUpdater$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyGridItemProvider f2920g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2921h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2922i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridKt$ScrollPositionUpdater$1(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, int i11) {
        super(2);
        this.f2920g = lazyGridItemProvider;
        this.f2921h = lazyGridState;
        this.f2922i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyGridKt.ScrollPositionUpdater(this.f2920g, this.f2921h, composer, this.f2922i | 1);
    }
}
