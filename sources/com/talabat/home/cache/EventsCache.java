package com.talabat.home.cache;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0006R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/home/cache/EventsCache;", "", "()V", "cache", "", "", "", "exists", "", "cacheKey", "remove", "", "resetWhen", "set", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventsCache {
    @NotNull
    public static final EventsCache INSTANCE = new EventsCache();
    @NotNull
    private static final Map<String, List<String>> cache = new LinkedHashMap();

    private EventsCache() {
    }

    public final boolean exists(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        return cache.containsKey(str);
    }

    public final void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resetWhen");
        Map<String, List<String>> map = cache;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (((List) next.getValue()).contains(str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry key : linkedHashMap.entrySet()) {
            cache.remove((String) key.getKey());
        }
    }

    @Nullable
    public final List<String> set(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        Intrinsics.checkNotNullParameter(list, "resetWhen");
        return cache.put(str, list);
    }
}
