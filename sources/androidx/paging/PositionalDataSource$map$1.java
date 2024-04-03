package androidx.paging;

import androidx.arch.core.util.Function;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00042\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u0002H\u0005 \u0003*\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "V", "kotlin.jvm.PlatformType", "", "T", "list", "apply"}, k = 3, mv = {1, 4, 2})
public final class PositionalDataSource$map$1<I, O> implements Function<List<? extends T>, List<? extends V>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f37053a;

    public PositionalDataSource$map$1(Function function) {
        this.f37053a = function;
    }

    public final List<V> apply(List<? extends T> list) {
        Intrinsics.checkNotNullExpressionValue(list, DefaultCardView.CARD_LIST);
        Iterable<Object> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object apply : iterable) {
            arrayList.add(this.f37053a.apply(apply));
        }
        return arrayList;
    }
}
