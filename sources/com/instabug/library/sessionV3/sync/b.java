package com.instabug.library.sessionV3.sync;

import com.instabug.library.core.plugin.c;
import com.instabug.library.sessionV3.providers.FeatureSessionLazyDataProvider;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import ld.g;
import org.jetbrains.annotations.NotNull;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f51829a = new b();

    private b() {
    }

    private final List a() {
        List d11 = c.d();
        Intrinsics.checkNotNullExpressionValue(d11, "getFeaturesSessionLazyDataProvider()");
        return d11;
    }

    @NotNull
    public Map a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessionIds");
        List<FeatureSessionLazyDataProvider> a11 = a();
        ArrayList<Future> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(a11, 10));
        for (FeatureSessionLazyDataProvider gVar : a11) {
            arrayList.add(PoolProvider.submitIOTask(new g(gVar, list)));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Future future : arrayList) {
            arrayList2.add((Map) future.get());
        }
        Sequence flatMapIterable = SequencesKt___SequencesKt.flatMapIterable(CollectionsKt___CollectionsKt.asSequence(arrayList2), a.f51823a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : flatMapIterable) {
            String str = (String) ((Map.Entry) next).getKey();
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(str, obj);
            }
            ((List) obj).add(next);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            boolean z11 = true;
            for (Map.Entry value : (Iterable) entry.getValue()) {
                z11 &= ((Boolean) value.getValue()).booleanValue();
            }
            linkedHashMap2.put(key, Boolean.valueOf(z11));
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap2);
        List minus = CollectionsKt___CollectionsKt.minus(list, (List) mutableMap.keySet());
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(minus, 10)), 16));
        for (Object next2 : minus) {
            String str2 = (String) next2;
            linkedHashMap3.put(next2, Boolean.TRUE);
        }
        mutableMap.putAll(linkedHashMap3);
        return mutableMap;
    }

    /* access modifiers changed from: private */
    public static final Map a(FeatureSessionLazyDataProvider featureSessionLazyDataProvider, List list) {
        Intrinsics.checkNotNullParameter(list, "$sessionIds");
        return featureSessionLazyDataProvider.isDataReady(list);
    }
}
