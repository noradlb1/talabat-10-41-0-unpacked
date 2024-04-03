package com.talabat.talabatcore.cache.impl;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcore.application.BaseApplication;
import com.talabat.talabatcore.cache.Cache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0012H\u0016J+\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J#\u0010\u001e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/talabatcore/cache/impl/DiskCache;", "Lcom/talabat/talabatcore/cache/Cache;", "name", "", "pref", "Landroid/content/SharedPreferences;", "(Ljava/lang/String;Landroid/content/SharedPreferences;)V", "clear", "", "key", "getBoolean", "", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getObject", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getString", "putBoolean", "value", "putFloat", "putInt", "putLong", "putObject", "obj", "(Ljava/lang/String;Ljava/lang/Object;)V", "putString", "Companion", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiskCache implements Cache {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TALABAT_PREFERENCE = "talabat_pref";
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f12015name;
    @NotNull
    private final SharedPreferences pref;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcore/cache/impl/DiskCache$Companion;", "", "()V", "TALABAT_PREFERENCE", "", "initSharedPreferences", "Landroid/content/SharedPreferences;", "name", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SharedPreferences initSharedPreferences(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            SharedPreferences sharedPreferences = BaseApplication.Companion.getInstance().getSharedPreferences(str, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "BaseApplication.instance…me, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    public DiskCache() {
        this((String) null, (SharedPreferences) null, 3, (DefaultConstructorMarker) null);
    }

    public DiskCache(@NotNull String str, @NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sharedPreferences, "pref");
        this.f12015name = str;
        this.pref = sharedPreferences;
    }

    public void clear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.remove(str);
        edit.apply();
    }

    public boolean getBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.pref.getBoolean(str, z11);
        } catch (Exception unused) {
            return z11;
        }
    }

    public float getFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.pref.getFloat(str, f11);
        } catch (Exception unused) {
            return f11;
        }
    }

    public int getInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.pref.getInt(str, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    public long getLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.pref.getLong(str, j11);
        } catch (Exception unused) {
            return j11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ JsonSyntaxException -> 0x0029 }] */
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
            android.content.SharedPreferences r1 = r2.pref     // Catch:{ JsonSyntaxException -> 0x0029 }
            java.lang.String r3 = r1.getString(r3, r0)     // Catch:{ JsonSyntaxException -> 0x0029 }
            if (r3 == 0) goto L_0x001c
            int r1 = r3.length()     // Catch:{ JsonSyntaxException -> 0x0029 }
            if (r1 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x001d
        L_0x001c:
            r1 = 1
        L_0x001d:
            if (r1 != 0) goto L_0x0029
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0029 }
            r1.<init>()     // Catch:{ JsonSyntaxException -> 0x0029 }
            java.lang.Object r3 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r3, r4)     // Catch:{ JsonSyntaxException -> 0x0029 }
            return r3
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcore.cache.impl.DiskCache.getObject(java.lang.String, java.lang.Class):java.lang.Object");
    }

    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.pref.getString(str, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void putBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putBoolean(str, z11);
        edit.apply();
    }

    public void putFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putFloat(str, f11);
        edit.apply();
    }

    public void putInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putInt(str, i11);
        edit.apply();
    }

    public void putLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putLong(str, j11);
        edit.apply();
    }

    public <T> void putObject(@NotNull String str, T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString(str, GsonInstrumentation.toJson(new Gson(), (Object) t11));
        edit.apply();
    }

    public void putString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DiskCache(java.lang.String r1, android.content.SharedPreferences r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.lang.String r1 = "talabat_pref"
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0010
            com.talabat.talabatcore.cache.impl.DiskCache$Companion r2 = Companion
            android.content.SharedPreferences r2 = r2.initSharedPreferences(r1)
        L_0x0010:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcore.cache.impl.DiskCache.<init>(java.lang.String, android.content.SharedPreferences, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public void clear() {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.clear();
        edit.apply();
    }
}
