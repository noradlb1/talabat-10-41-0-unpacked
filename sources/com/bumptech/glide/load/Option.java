package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = new CacheKeyUpdater<Object>() {
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] bArr, @NonNull T t11, @NonNull MessageDigest messageDigest);
    }

    private Option(@NonNull String str, @Nullable T t11, @NonNull CacheKeyUpdater<T> cacheKeyUpdater2) {
        this.key = Preconditions.checkNotEmpty(str);
        this.defaultValue = t11;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater2);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater2) {
        return new Option<>(str, (Object) null, cacheKeyUpdater2);
    }

    @NonNull
    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return EMPTY_UPDATER;
    }

    @NonNull
    private byte[] getKeyBytes() {
        if (this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(Key.CHARSET);
        }
        return this.keyBytes;
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str) {
        return new Option<>(str, (Object) null, emptyUpdater());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.key.equals(((Option) obj).key);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.key + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public void update(@NonNull T t11, @NonNull MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(getKeyBytes(), t11, messageDigest);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @Nullable T t11, @NonNull CacheKeyUpdater<T> cacheKeyUpdater2) {
        return new Option<>(str, t11, cacheKeyUpdater2);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str, @NonNull T t11) {
        return new Option<>(str, t11, emptyUpdater());
    }
}
