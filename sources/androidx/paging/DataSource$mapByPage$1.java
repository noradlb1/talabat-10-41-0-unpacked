package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0004\"\b\b\u0002\u0010\u0006*\u00020\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u0002H\u0006 \u0003*\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "ToValue", "kotlin.jvm.PlatformType", "", "Key", "Value", "it", "apply"}, k = 3, mv = {1, 4, 2})
public final class DataSource$mapByPage$1<I, O> implements Function<List<? extends Value>, List<? extends ToValue>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36551a;

    public DataSource$mapByPage$1(Function1 function1) {
        this.f36551a = function1;
    }

    public final List<ToValue> apply(List<? extends Value> list) {
        Function1 function1 = this.f36551a;
        Intrinsics.checkNotNullExpressionValue(list, "it");
        return (List) function1.invoke(list);
    }
}
