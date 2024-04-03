package androidx.datastore.migrations;

import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006J(\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00062\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesView;", "", "prefs", "Landroid/content/SharedPreferences;", "keySet", "", "", "(Landroid/content/SharedPreferences;Ljava/util/Set;)V", "checkKey", "key", "contains", "", "getAll", "", "getBoolean", "defValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "defValues", "datastore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SharedPreferencesView {
    @Nullable
    private final Set<String> keySet;
    @NotNull
    private final SharedPreferences prefs;

    public SharedPreferencesView(@NotNull SharedPreferences sharedPreferences, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Can't access key outside migration: ", str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.contains(checkKey(str));
    }

    @NotNull
    public final Map<String, Object> getAll() {
        boolean z11;
        Map<String, ?> all = this.prefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Set<String> set = this.keySet;
            if (set == null) {
                z11 = true;
            } else {
                z11 = set.contains(str);
            }
            if (z11) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = CollectionsKt___CollectionsKt.toSet((Iterable) value);
            }
            linkedHashMap2.put(key, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.getBoolean(checkKey(str), z11);
    }

    public final float getFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.getFloat(checkKey(str), f11);
    }

    public final int getInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.getInt(checkKey(str), i11);
    }

    public final long getLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.getLong(checkKey(str), j11);
    }

    @Nullable
    public final String getString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.prefs.getString(checkKey(str), str2);
    }

    @Nullable
    public final Set<String> getStringSet(@NotNull String str, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "key");
        Set<String> stringSet = this.prefs.getStringSet(checkKey(str), set);
        if (stringSet == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.toMutableSet(stringSet);
    }
}
