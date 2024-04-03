package com.braze.support;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010$\n\u0000\u001a\u001a\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001¨\u0006\u0002"}, d2 = {"filterToStringKeyedMap", "", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapUtils {

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43956b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Removing non-string keys from map";
        }
    }

    public static final Map<?, ?> filterToStringKeyedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() instanceof String)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!linkedHashMap.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) map, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43956b, 6, (Object) null);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry next2 : map.entrySet()) {
            if (next2.getKey() instanceof String) {
                linkedHashMap2.put(next2.getKey(), next2.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Date) {
                value = DateTimeUtils.formatDate$default((Date) value, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null);
            } else if (value instanceof Map) {
                value = filterToStringKeyedMap((Map) value);
            }
            linkedHashMap3.put(key, value);
        }
        return linkedHashMap3;
    }
}
