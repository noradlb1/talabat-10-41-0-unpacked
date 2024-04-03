package com.talabat.talabatcore.cache;

import com.talabat.talabatcore.cache.CurrentNanoTimeProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\tH\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J+\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J#\u0010 \u001a\u00020\t\"\u0004\b\u0000\u0010\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u0002H\u0016H\u0016¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\f\u0010%\u001a\u00020\u000b*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/talabatcore/cache/ExpiringCacheDecorator;", "Lcom/talabat/talabatcore/cache/Cache;", "cache", "flushIntervalMillis", "", "currentNanoTimeProvider", "Lcom/talabat/talabatcore/cache/CurrentNanoTimeProvider;", "(Lcom/talabat/talabatcore/cache/Cache;JLcom/talabat/talabatcore/cache/CurrentNanoTimeProvider;)V", "clear", "", "key", "", "flush", "getBoolean", "", "defaultValue", "getFloat", "", "getInt", "", "getLong", "getObject", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getString", "putBoolean", "value", "putFloat", "putInt", "putLong", "putObject", "obj", "(Ljava/lang/String;Ljava/lang/Object;)V", "putString", "trackTime", "toTimeStampKey", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCacheDecorator implements Cache {
    @NotNull
    private final Cache cache;
    @NotNull
    private final CurrentNanoTimeProvider currentNanoTimeProvider;
    private final long flushIntervalMillis;

    public ExpiringCacheDecorator(@NotNull Cache cache2, long j11, @NotNull CurrentNanoTimeProvider currentNanoTimeProvider2) {
        Intrinsics.checkNotNullParameter(cache2, "cache");
        Intrinsics.checkNotNullParameter(currentNanoTimeProvider2, "currentNanoTimeProvider");
        this.cache = cache2;
        this.flushIntervalMillis = j11;
        this.currentNanoTimeProvider = currentNanoTimeProvider2;
    }

    private final void flush(String str) {
        boolean z11;
        if (this.currentNanoTimeProvider.currentNanoTime() - this.cache.getLong(toTimeStampKey(str), 0) >= TimeUnit.MILLISECONDS.toNanos(this.flushIntervalMillis)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.cache.clear(str);
        }
    }

    private final String toTimeStampKey(String str) {
        return str + "_added_nano_time";
    }

    private final void trackTime(String str) {
        this.cache.putLong(toTimeStampKey(str), this.currentNanoTimeProvider.currentNanoTime());
    }

    public void clear() {
        this.cache.clear();
    }

    public void clear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.clear(str);
    }

    public boolean getBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        flush(str);
        return this.cache.getBoolean(str, z11);
    }

    public float getFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        flush(str);
        return this.cache.getFloat(str, f11);
    }

    public int getInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        flush(str);
        return this.cache.getInt(str, i11);
    }

    public long getLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        flush(str);
        return this.cache.getLong(str, j11);
    }

    @Nullable
    public <T> T getObject(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        flush(str);
        return this.cache.getObject(str, cls);
    }

    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        flush(str);
        return this.cache.getString(str);
    }

    public void putBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.putBoolean(str, z11);
        trackTime(str);
    }

    public void putFloat(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.putFloat(str, f11);
        trackTime(str);
    }

    public void putInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.putInt(str, i11);
        trackTime(str);
    }

    public void putLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.putLong(str, j11);
        trackTime(str);
    }

    public <T> void putObject(@NotNull String str, T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.cache.putObject(str, t11);
        trackTime(str);
    }

    public void putString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.cache.putString(str, str2);
        trackTime(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpiringCacheDecorator(Cache cache2, long j11, CurrentNanoTimeProvider currentNanoTimeProvider2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cache2, j11, (i11 & 4) != 0 ? new CurrentNanoTimeProvider() {
            public long currentNanoTime() {
                return CurrentNanoTimeProvider.DefaultImpls.currentNanoTime(this);
            }
        } : currentNanoTimeProvider2);
    }
}
