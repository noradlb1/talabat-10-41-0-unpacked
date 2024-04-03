package com.instabug.library.sessionV3.sync;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.instabug.library.model.v3Session.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class g implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final g f51833a = new g();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set f51834b = SetsKt__SetsKt.mutableSetOf("id");

    private g() {
    }

    private final Map b(List list) {
        List<String> c11 = c(list);
        ArrayList arrayList = new ArrayList();
        for (String a11 : c11) {
            Pair a12 = f51833a.a(list, a11);
            if (a12 != null) {
                arrayList.add(a12);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    private final List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((Map) it.next()).keySet());
        }
        return CollectionsKt___CollectionsKt.distinct(arrayList);
    }

    public void a(@NotNull Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, UserMetadata.KEYDATA_FILENAME);
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(f51834b, iterable);
    }

    @NotNull
    public h a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        g gVar = f51833a;
        Map b11 = gVar.b(list);
        List a11 = gVar.a(list, b11);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) ((Map) it.next()).get("id");
            if (str != null) {
                arrayList.add(str);
            }
        }
        return new h(b11, a11, arrayList);
    }

    private final Pair a(List list, String str) {
        List a11 = a(str, list);
        if (f51834b.contains(str) || !a(a11, list)) {
            return null;
        }
        Object first = CollectionsKt___CollectionsKt.first(a11);
        Intrinsics.checkNotNull(first);
        return TuplesKt.to(str, first);
    }

    private final boolean a(List list, List list2) {
        return CollectionsKt___CollectionsKt.distinct(list).size() == 1 && list.size() == list2.size();
    }

    private final List a(List list, Map map) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f51833a.a((Map) it.next(), map));
        }
        return arrayList;
    }

    private final Map a(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final List a(String str, List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).get(str));
        }
        return arrayList;
    }
}
