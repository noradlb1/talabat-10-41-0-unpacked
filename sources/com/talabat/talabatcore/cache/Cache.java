package com.talabat.talabatcore.cache;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH&J+\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H&¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fH&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000eH&J#\u0010\u001a\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcore/cache/Cache;", "", "clear", "", "key", "", "getBoolean", "", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getObject", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getString", "putBoolean", "value", "putFloat", "putInt", "putLong", "putObject", "obj", "(Ljava/lang/String;Ljava/lang/Object;)V", "putString", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Cache {
    void clear();

    void clear(@NotNull String str);

    boolean getBoolean(@NotNull String str, boolean z11);

    float getFloat(@NotNull String str, float f11);

    int getInt(@NotNull String str, int i11);

    long getLong(@NotNull String str, long j11);

    @Nullable
    <T> T getObject(@NotNull String str, @NotNull Class<T> cls);

    @Nullable
    String getString(@NotNull String str);

    void putBoolean(@NotNull String str, boolean z11);

    void putFloat(@NotNull String str, float f11);

    void putInt(@NotNull String str, int i11);

    void putLong(@NotNull String str, long j11);

    <T> void putObject(@NotNull String str, T t11);

    void putString(@NotNull String str, @NotNull String str2);
}
