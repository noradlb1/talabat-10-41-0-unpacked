package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridState$scrollableState$1 extends Lambda implements Function1<Float, Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2967g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridState$scrollableState$1(LazyGridState lazyGridState) {
        super(1);
        this.f2967g = lazyGridState;
    }

    @NotNull
    public final Float invoke(float f11) {
        return Float.valueOf(-this.f2967g.onScroll$foundation_release(-f11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
