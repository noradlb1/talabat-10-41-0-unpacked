package com.instabug.library.internal.sharedpreferences;

import android.content.SharedPreferences;
import cd.b;
import cd.c;
import cd.d;
import cd.e;
import cd.f;
import cd.g;
import cd.h;
import cd.i;
import cd.j;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.encryption.EncryptionManager;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a implements SharedPreferences.Editor {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences.Editor f51011a;

    public a(@NotNull SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.f51011a = editor;
    }

    /* access modifiers changed from: private */
    public static final a a(String str, a aVar, String str2) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        if (e0.c().b() == Feature.State.ENABLED) {
            String encrypt = EncryptionManager.encrypt(str);
            if (encrypt != null) {
                aVar.f51011a.putString(str2, encrypt);
            } else {
                aVar.f51011a.putString(str2, str);
            }
        } else {
            aVar.f51011a.putString(str2, str);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a b(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.clear();
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final Boolean c(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        return Boolean.valueOf(aVar.f51011a.commit());
    }

    public void apply() {
        CoreServiceLocator.getSharedPreferencesExecutor().execute(new c(this));
    }

    @NotNull
    public SharedPreferences.Editor clear() {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new b(this));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor clear = this.f51011a.clear();
        Intrinsics.checkNotNullExpressionValue(clear, "editor.clear()");
        return clear;
    }

    public boolean commit() {
        Boolean bool = (Boolean) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new cd.a(this));
        if (bool == null) {
            return this.f51011a.commit();
        }
        return bool.booleanValue();
    }

    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String str, boolean z11) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new j(this, str, z11));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor putBoolean = this.f51011a.putBoolean(str, z11);
        Intrinsics.checkNotNullExpressionValue(putBoolean, "editor.putBoolean(key, value)");
        return putBoolean;
    }

    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String str, float f11) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new f(this, str, f11));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor putFloat = this.f51011a.putFloat(str, f11);
        Intrinsics.checkNotNullExpressionValue(putFloat, "editor.putFloat(key, value)");
        return putFloat;
    }

    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String str, int i11) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new i(this, str, i11));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor putInt = this.f51011a.putInt(str, i11);
        Intrinsics.checkNotNullExpressionValue(putInt, "editor.putInt(key, value)");
        return putInt;
    }

    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String str, long j11) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new h(this, str, j11));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor putLong = this.f51011a.putLong(str, j11);
        Intrinsics.checkNotNullExpressionValue(putLong, "editor.putLong(key, value)");
        return putLong;
    }

    @NotNull
    public SharedPreferences.Editor putString(@Nullable String str, @Nullable String str2) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new e(str2, this, str));
        if (aVar == null) {
            return this;
        }
        return aVar;
    }

    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String str, @Nullable Set set) {
        SharedPreferences.Editor editor;
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new g(set, this, str));
        if (aVar != null) {
            return aVar;
        }
        if (e0.c().b() == Feature.State.ENABLED) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    String encrypt = EncryptionManager.encrypt(str2);
                    if (encrypt != null) {
                        linkedHashSet.add(encrypt);
                    } else {
                        linkedHashSet.add(str2);
                    }
                }
            }
            editor = this.f51011a.putStringSet(str, linkedHashSet);
        } else {
            editor = this.f51011a.putStringSet(str, set);
        }
        SharedPreferences.Editor editor2 = editor;
        Intrinsics.checkNotNullExpressionValue(editor2, "if (InstabugFeaturesMana…ey, values)\n            }");
        return editor2;
    }

    @NotNull
    public SharedPreferences.Editor remove(@Nullable String str) {
        a aVar = (a) CoreServiceLocator.getSharedPreferencesExecutor().executeAndGet(new d(this, str));
        if (aVar != null) {
            return aVar;
        }
        SharedPreferences.Editor remove = this.f51011a.remove(str);
        Intrinsics.checkNotNullExpressionValue(remove, "editor.remove(key)");
        return remove;
    }

    /* access modifiers changed from: private */
    public static final a a(Set set, a aVar, String str) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        if (e0.c().b() == Feature.State.ENABLED) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    String encrypt = EncryptionManager.encrypt(str2);
                    if (encrypt != null) {
                        linkedHashSet.add(encrypt);
                    } else {
                        linkedHashSet.add(str2);
                    }
                }
            }
            aVar.f51011a.putStringSet(str, linkedHashSet);
        } else {
            aVar.f51011a.putStringSet(str, set);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a a(a aVar, String str, int i11) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.putInt(str, i11);
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a a(a aVar, String str, long j11) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.putLong(str, j11);
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a a(a aVar, String str, float f11) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.putFloat(str, f11);
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a a(a aVar, String str, boolean z11) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.putBoolean(str, z11);
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final a a(a aVar, String str) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.remove(str);
        return aVar;
    }

    /* access modifiers changed from: private */
    public static final void a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        aVar.f51011a.commit();
    }
}
