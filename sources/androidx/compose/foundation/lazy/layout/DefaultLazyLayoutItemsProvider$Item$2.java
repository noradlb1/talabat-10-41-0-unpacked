package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class DefaultLazyLayoutItemsProvider$Item$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DefaultLazyLayoutItemsProvider<IntervalContent> f2979g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2980h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2981i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultLazyLayoutItemsProvider$Item$2(DefaultLazyLayoutItemsProvider<IntervalContent> defaultLazyLayoutItemsProvider, int i11, int i12) {
        super(2);
        this.f2979g = defaultLazyLayoutItemsProvider;
        this.f2980h = i11;
        this.f2981i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f2979g.Item(this.f2980h, composer, this.f2981i | 1);
    }
}
