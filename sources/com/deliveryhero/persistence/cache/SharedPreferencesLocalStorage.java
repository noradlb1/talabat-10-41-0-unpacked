package com.deliveryhero.persistence.cache;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.deliveryhero.persistence.DelicatePersistenceApi;
import java.io.File;
import java.security.KeyStore;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0017J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020!H\u0016J1\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u0002H#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0002¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010)2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010*\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u001fH\u0016J\u0018\u0010/\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020!H\u0016J\u0018\u00100\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0016J\u001e\u00101\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u00063"}, d2 = {"Lcom/deliveryhero/persistence/cache/SharedPreferencesLocalStorage;", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "context", "Landroid/content/Context;", "preferenceName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "hasRetried", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "clearAll", "", "createSharedPreference", "name", "unEncrypted", "deleteCorruptPreference", "encryptedPreferenceName", "getAll", "", "", "getBoolean", "key", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getOrRemove", "T", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getString", "getStringSet", "", "initializeEncryptedSharedPreferences", "putBoolean", "value", "putFloat", "putInt", "putLong", "putString", "putStringSet", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage implements LocalStorage {
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    private boolean hasRetried;
    /* access modifiers changed from: private */
    @NotNull
    public final String preferenceName;
    @NotNull
    private final Lazy sharedPreferences$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SharedPreferencesLocalStorage(@NotNull Context context2) {
        this(context2, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    @JvmOverloads
    public SharedPreferencesLocalStorage(@NotNull Context context2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "preferenceName");
        this.context = context2;
        this.preferenceName = str;
        this.sharedPreferences$delegate = LazyKt__LazyJVMKt.lazy(new SharedPreferencesLocalStorage$sharedPreferences$2(this));
    }

    /* access modifiers changed from: private */
    public final SharedPreferences createSharedPreference(Context context2, String str, SharedPreferences sharedPreferences) {
        SharedPreferences sharedPreferences2;
        try {
            return initializeEncryptedSharedPreferences(context2, str);
        } catch (Exception e11) {
            Timber.e(e11, "Failed to create encrypted shared preference", new Object[0]);
            if (!this.hasRetried) {
                deleteCorruptPreference("encrypted_" + str);
                this.hasRetried = true;
                sharedPreferences2 = createSharedPreference(context2, str, sharedPreferences);
            } else {
                sharedPreferences2 = context2.getSharedPreferences(str, 0);
            }
            Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "{\n        Timber.e(e, \"F…_PRIVATE)\n        }\n    }");
            return sharedPreferences2;
        }
    }

    private final void deleteCorruptPreference(String str) {
        try {
            File file = new File(this.context.getFilesDir().getParent() + "/shared_prefs/" + str + ".xml");
            if (file.exists()) {
                Timber.e("Corrupt Shared prefs file deleted: " + file.delete() + "; path: " + file.getAbsolutePath(), new Object[0]);
            } else {
                Timber.e("Corrupt Shared prefs file non-existent; path: " + file.getAbsolutePath(), new Object[0]);
            }
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            instance.deleteEntry(MasterKey.DEFAULT_MASTER_KEY_ALIAS);
        } catch (Exception e11) {
            Timber.e(e11, "Could not delete corrupt master key", new Object[0]);
        }
    }

    private final <T> T getOrRemove(String str, T t11, Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (SecurityException e11) {
            Timber.e(e11, "Corrupt data found", new Object[0]);
            remove(str);
            return t11;
        }
    }

    /* access modifiers changed from: private */
    public final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences$delegate.getValue();
    }

    private final SharedPreferences initializeEncryptedSharedPreferences(Context context2, String str) {
        MasterKey build = new MasterKey.Builder(context2).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(context)\n       …GCM)\n            .build()");
        SharedPreferences create = EncryptedSharedPreferences.create(context2, "encrypted_" + str, build, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            cont…heme.AES256_GCM\n        )");
        return create;
    }

    @DelicatePersistenceApi
    public synchronized void clearAll() {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.clear();
        edit.apply();
    }

    @NotNull
    public synchronized Map<String, Object> getAll() {
        Map<String, ?> all;
        all = getSharedPreferences().getAll();
        Intrinsics.checkNotNullExpressionValue(all, "sharedPreferences.all");
        return all;
    }

    public boolean getBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return ((Boolean) getOrRemove(str, Boolean.FALSE, new SharedPreferencesLocalStorage$getBoolean$1(this, str))).booleanValue();
    }

    public synchronized float getFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return ((Number) getOrRemove(str, Float.valueOf(f11), new SharedPreferencesLocalStorage$getFloat$1(this, str, f11))).floatValue();
    }

    public synchronized int getInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return ((Number) getOrRemove(str, Integer.valueOf(i11), new SharedPreferencesLocalStorage$getInt$1(this, str, i11))).intValue();
    }

    public synchronized long getLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return ((Number) getOrRemove(str, Long.valueOf(j11), new SharedPreferencesLocalStorage$getLong$1(this, str, j11))).longValue();
    }

    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (String) getOrRemove(str, (Object) null, new SharedPreferencesLocalStorage$getString$1(this, str));
    }

    @Nullable
    public synchronized Set<String> getStringSet(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Set) getOrRemove(str, (Object) null, new SharedPreferencesLocalStorage$getStringSet$1(this, str));
    }

    public synchronized void putBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putBoolean(str, z11);
        edit.apply();
    }

    public synchronized void putFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putFloat(str, f11);
        edit.apply();
    }

    public synchronized void putInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putInt(str, i11);
        edit.apply();
    }

    public synchronized void putLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putLong(str, j11);
        edit.apply();
    }

    public synchronized void putString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putString(str, str2);
        edit.apply();
    }

    public synchronized void putStringSet(@NotNull String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(set, "value");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putStringSet(str, set);
        edit.apply();
    }

    public synchronized void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.remove(str);
        edit.apply();
    }

    public synchronized boolean getBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return ((Boolean) getOrRemove(str, Boolean.valueOf(z11), new SharedPreferencesLocalStorage$getBoolean$2(this, str, z11))).booleanValue();
    }

    @Nullable
    public synchronized String getString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (String) getOrRemove(str, str2, new SharedPreferencesLocalStorage$getString$2(this, str, str2));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SharedPreferencesLocalStorage(android.content.Context r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0019
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.getPackageName()
            r2.append(r3)
            java.lang.String r3 = "_preferences"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x0019:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.persistence.cache.SharedPreferencesLocalStorage.<init>(android.content.Context, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
