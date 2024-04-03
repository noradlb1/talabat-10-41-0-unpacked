package b9;

import com.google.common.collect.ImmutableSortedMap;
import java.util.Comparator;
import java.util.Map;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f44497b;

    public /* synthetic */ c(Comparator comparator) {
        this.f44497b = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ImmutableSortedMap.lambda$fromEntries$0(this.f44497b, (Map.Entry) obj, (Map.Entry) obj2);
    }
}
