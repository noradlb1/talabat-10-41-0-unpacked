package com.instabug.library.internal.sharedpreferences;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import cd.k;
import cd.l;
import cd.m;
import cd.n;
import cd.o;
import cd.p;
import cd.q;
import cd.r;
import cd.s;
import cd.t;
import cd.u;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.encryption.EncryptionManager;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@VisibleForTesting
public final class c implements SharedPreferences {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final b f51012b = new b((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f51013a;

    public c(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.f51013a = sharedPreferences;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r2 = com.instabug.library.encryption.EncryptionManager.decrypt(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(com.instabug.library.internal.sharedpreferences.c r1, java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            android.content.SharedPreferences r1 = r1.f51013a
            java.lang.String r1 = r1.getString(r2, r3)
            com.instabug.library.e0 r2 = com.instabug.library.e0.c()
            com.instabug.library.Feature$State r2 = r2.b()
            com.instabug.library.Feature$State r3 = com.instabug.library.Feature.State.ENABLED
            if (r2 != r3) goto L_0x001f
            java.lang.String r2 = com.instabug.library.encryption.EncryptionManager.decrypt((java.lang.String) r1)
            if (r2 == 0) goto L_0x001f
            return r2
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.sharedpreferences.c.a(com.instabug.library.internal.sharedpreferences.c, java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static final Map b(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return cVar.f51013a.getAll();
    }

    public boolean contains(@Nullable String str) {
        Boolean bool = (Boolean) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new l(this, str));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @NotNull
    public SharedPreferences.Editor edit() {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new s(this));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor edit = this.f51013a.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "sharedPreferences.edit()");
        return new a(edit);
    }

    @Nullable
    public Map getAll() {
        return (Map) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new k(this));
    }

    public boolean getBoolean(@Nullable String str, boolean z11) {
        Boolean bool = (Boolean) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new n(this, str, z11));
        if (bool == null) {
            return z11;
        }
        return bool.booleanValue();
    }

    public float getFloat(@Nullable String str, float f11) {
        Float f12 = (Float) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new r(this, str, f11));
        if (f12 == null) {
            return f11;
        }
        return f12.floatValue();
    }

    public int getInt(@Nullable String str, int i11) {
        Integer num = (Integer) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new t(this, str, i11));
        if (num == null) {
            return i11;
        }
        return num.intValue();
    }

    public long getLong(@Nullable String str, long j11) {
        Long l11 = (Long) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new m(this, str, j11));
        if (l11 == null) {
            return j11;
        }
        return l11.longValue();
    }

    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        return (String) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new u(this, str, str2));
    }

    @Nullable
    public Set getStringSet(@Nullable String str, @Nullable Set set) {
        return (Set) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new o(this, str, set));
    }

    public void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        CoreServiceLocator.getSharedPreferencesExecutor().execute(new q(this, onSharedPreferenceChangeListener));
    }

    public void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        CoreServiceLocator.getSharedPreferencesExecutor().execute(new p(this, onSharedPreferenceChangeListener));
    }

    /* access modifiers changed from: private */
    public static final void b(c cVar, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        cVar.f51013a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* access modifiers changed from: private */
    public static final Set a(c cVar, String str, Set set) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        Set<String> stringSet = cVar.f51013a.getStringSet(str, set);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (e0.c().b() != Feature.State.ENABLED) {
            return stringSet;
        }
        if (stringSet != null) {
            for (String str2 : stringSet) {
                String decrypt = EncryptionManager.decrypt(str2);
                if (decrypt != null) {
                    linkedHashSet.add(decrypt);
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "it");
                    linkedHashSet.add(str2);
                }
            }
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: private */
    public static final Integer a(c cVar, String str, int i11) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return Integer.valueOf(cVar.f51013a.getInt(str, i11));
    }

    /* access modifiers changed from: private */
    public static final Long a(c cVar, String str, long j11) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return Long.valueOf(cVar.f51013a.getLong(str, j11));
    }

    /* access modifiers changed from: private */
    public static final Float a(c cVar, String str, float f11) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return Float.valueOf(cVar.f51013a.getFloat(str, f11));
    }

    /* access modifiers changed from: private */
    public static final Boolean a(c cVar, String str, boolean z11) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return Boolean.valueOf(cVar.f51013a.getBoolean(str, z11));
    }

    /* access modifiers changed from: private */
    public static final Boolean a(c cVar, String str) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        return Boolean.valueOf(cVar.f51013a.contains(str));
    }

    /* access modifiers changed from: private */
    public static final a a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        SharedPreferences.Editor edit = cVar.f51013a.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "sharedPreferences.edit()");
        return new a(edit);
    }

    /* access modifiers changed from: private */
    public static final void a(c cVar, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        cVar.f51013a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
