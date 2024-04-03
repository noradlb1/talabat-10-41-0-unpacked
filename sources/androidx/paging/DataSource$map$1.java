package androidx.paging;

import androidx.arch.core.util.Function;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ToValue", "", "Key", "Value", "list", "invoke"}, k = 3, mv = {1, 4, 2})
public final class DataSource$map$1 extends Lambda implements Function1<List<? extends Value>, List<? extends ToValue>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function f36549g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataSource$map$1(Function function) {
        super(1);
        this.f36549g = function;
    }

    @NotNull
    public final List<ToValue> invoke(@NotNull List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        Iterable<Object> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object apply : iterable) {
            arrayList.add(this.f36549g.apply(apply));
        }
        return arrayList;
    }
}
