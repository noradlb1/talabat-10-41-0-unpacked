package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutPrefetchState f3030g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemContentFactory f3031h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubcomposeLayoutState f3032i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3033j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, int i11) {
        super(2);
        this.f3030g = lazyLayoutPrefetchState;
        this.f3031h = lazyLayoutItemContentFactory;
        this.f3032i = subcomposeLayoutState;
        this.f3033j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.f3030g, this.f3031h, this.f3032i, composer, this.f3033j | 1);
    }
}
