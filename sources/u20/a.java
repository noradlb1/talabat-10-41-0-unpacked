package u20;

import java.util.Comparator;
import java.util.Map;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f28211b;

    public /* synthetic */ a(Map map) {
        this.f28211b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return ((Integer) this.f28211b.get(obj2)).compareTo((Integer) this.f28211b.get(obj));
    }
}
