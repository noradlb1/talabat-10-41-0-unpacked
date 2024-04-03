package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 extends Lambda implements Function1<Integer, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f2826g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<LazyGridItemInfo> f2827h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(boolean z11, List<? extends LazyGridItemInfo> list) {
        super(1);
        this.f2826g = z11;
        this.f2827h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Integer invoke(int i11) {
        return Integer.valueOf(this.f2826g ? this.f2827h.get(i11).getRow() : this.f2827h.get(i11).getColumn());
    }
}
