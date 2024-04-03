package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> values = new CachedHashCodeArrayMap();

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        return this.values.containsKey(option) ? this.values.get(option) : option.getDefaultValue();
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.values.putAll(options.values);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t11) {
        this.values.put(option, t11);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + AbstractJsonLexerKt.END_OBJ;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i11 = 0; i11 < this.values.size(); i11++) {
            updateDiskCacheKey(this.values.keyAt(i11), this.values.valueAt(i11), messageDigest);
        }
    }

    private static <T> void updateDiskCacheKey(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }
}
