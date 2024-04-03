package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class w {

    /* renamed from: a  reason: collision with root package name */
    private final Map f28398a;

    w(Map map) {
        this.f28398a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int i11 = x.f28402d;
                hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            Collections.sort(arrayList2, x.f28400b);
            hashMap.put((B) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put((Object) null, arrayList);
        }
        Collections.sort(arrayList, x.f28400b);
    }

    /* access modifiers changed from: package-private */
    public final String a(long j11, B b11) {
        Map map = (Map) this.f28398a.get(b11);
        if (map != null) {
            return (String) map.get(Long.valueOf(j11));
        }
        return null;
    }
}
