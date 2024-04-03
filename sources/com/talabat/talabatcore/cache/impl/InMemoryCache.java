package com.talabat.talabatcore.cache.impl;

import com.google.gson.Gson;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcore.cache.Cache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0012H\u0016J+\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J#\u0010\u001e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00142\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/talabatcore/cache/impl/InMemoryCache;", "Lcom/talabat/talabatcore/cache/Cache;", "map", "", "", "", "(Ljava/util/Map;)V", "clear", "", "key", "getBoolean", "", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getObject", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getString", "putBoolean", "value", "putFloat", "putInt", "putLong", "putObject", "obj", "(Ljava/lang/String;Ljava/lang/Object;)V", "putString", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InMemoryCache implements Cache {
    @NotNull
    private final Map<String, Object> map;

    public InMemoryCache() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public InMemoryCache(@NotNull Map<String, Object> map2) {
        Intrinsics.checkNotNullParameter(map2, Param.MAP);
        this.map = map2;
    }

    public void clear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.map.remove(str);
    }

    public boolean getBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.map.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z11;
    }

    public float getFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.map.get(str);
        if (obj instanceof Float) {
            return ((Number) obj).floatValue();
        }
        return f11;
    }

    public int getInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.map.get(str);
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        return i11;
    }

    public long getLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.map.get(str);
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        return j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ JsonSyntaxException -> 0x0031 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getObject(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.Class<T> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            java.util.Map<java.lang.String, java.lang.Object> r1 = r2.map     // Catch:{ JsonSyntaxException -> 0x0031 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ JsonSyntaxException -> 0x0031 }
            boolean r1 = r3 instanceof java.lang.String     // Catch:{ JsonSyntaxException -> 0x0031 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JsonSyntaxException -> 0x0031 }
            goto L_0x0019
        L_0x0018:
            r3 = r0
        L_0x0019:
            if (r3 == 0) goto L_0x0024
            int r1 = r3.length()     // Catch:{ JsonSyntaxException -> 0x0031 }
            if (r1 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r1 = 0
            goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            if (r1 != 0) goto L_0x0031
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0031 }
            r1.<init>()     // Catch:{ JsonSyntaxException -> 0x0031 }
            java.lang.Object r3 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r3, r4)     // Catch:{ JsonSyntaxException -> 0x0031 }
            return r3
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcore.cache.impl.InMemoryCache.getObject(java.lang.String, java.lang.Class):java.lang.Object");
    }

    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void putBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.map.put(str, Boolean.valueOf(z11));
    }

    public void putFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.map.put(str, Float.valueOf(f11));
    }

    public void putInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.map.put(str, Integer.valueOf(i11));
    }

    public void putLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.map.put(str, Long.valueOf(j11));
    }

    public <T> void putObject(@NotNull String str, T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        String json = GsonInstrumentation.toJson(new Gson(), (Object) t11);
        Map<String, Object> map2 = this.map;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        map2.put(str, json);
    }

    public void putString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.map.put(str, str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InMemoryCache(Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new LinkedHashMap() : map2);
    }

    public void clear() {
        this.map.clear();
    }
}
