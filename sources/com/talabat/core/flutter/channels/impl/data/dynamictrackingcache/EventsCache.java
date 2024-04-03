package com.talabat.core.flutter.channels.impl.data.dynamictrackingcache;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J$\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0006R,\u0010\u0003\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/dynamictrackingcache/EventsCache;", "", "()V", "groups", "", "", "", "exists", "", "groupKey", "cacheKey", "remove", "", "resetWhen", "set", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventsCache {
    @NotNull
    public static final EventsCache INSTANCE = new EventsCache();
    @NotNull
    private static final Map<String, Map<String, List<String>>> groups = new LinkedHashMap();

    private EventsCache() {
    }

    public final boolean exists(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "cacheKey");
        Map map = groups.get(str);
        if (map == null || !map.containsKey(str2)) {
            return false;
        }
        return true;
    }

    public final void remove(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "resetWhen");
        Map map = groups.get(str);
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((List) entry.getValue()).contains(str2)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry key : linkedHashMap.entrySet()) {
                String str3 = (String) key.getKey();
                Map map2 = groups.get(str);
                if (map2 != null) {
                    List list = (List) map2.remove(str3);
                }
            }
        }
    }

    public final void set(@NotNull String str, @NotNull String str2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "groupKey");
        Intrinsics.checkNotNullParameter(str2, "cacheKey");
        Intrinsics.checkNotNullParameter(list, "resetWhen");
        Map<String, Map<String, List<String>>> map = groups;
        Map map2 = map.get(str);
        if (map2 == null) {
            map2 = new LinkedHashMap();
        }
        map2.put(str2, list);
        map.put(str, map2);
    }
}
