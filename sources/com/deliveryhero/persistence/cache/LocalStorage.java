package com.deliveryhero.persistence.cache;

import com.deliveryhero.persistence.DelicatePersistenceApi;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\fH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H&J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/persistence/cache/LocalStorage;", "", "clearAll", "", "getAll", "", "", "getBoolean", "", "key", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "putBoolean", "value", "putFloat", "putInt", "putLong", "putString", "putStringSet", "remove", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LocalStorage {
    @DelicatePersistenceApi
    void clearAll();

    @NotNull
    Map<String, Object> getAll();

    boolean getBoolean(@NotNull String str);

    boolean getBoolean(@NotNull String str, boolean z11);

    float getFloat(@NotNull String str, float f11);

    int getInt(@NotNull String str, int i11);

    long getLong(@NotNull String str, long j11);

    @Nullable
    String getString(@NotNull String str);

    @Nullable
    String getString(@NotNull String str, @Nullable String str2);

    @Nullable
    Set<String> getStringSet(@NotNull String str);

    void putBoolean(@NotNull String str, boolean z11);

    void putFloat(@NotNull String str, float f11);

    void putInt(@NotNull String str, int i11);

    void putLong(@NotNull String str, long j11);

    void putString(@NotNull String str, @NotNull String str2);

    void putStringSet(@NotNull String str, @NotNull Set<String> set);

    void remove(@NotNull String str);
}
