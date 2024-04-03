package com.huawei.location.lite.common.chain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Data {
    public static final Data EMPTY = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f50108a;

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        @NonNull
        public Data build() {
            return new Data((Map<String, ?>) this.mValues);
        }

        @NonNull
        public Builder put(@NonNull String str, @Nullable Object obj) {
            if (obj == null) {
                this.mValues.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Integer.class || cls == String.class || (obj instanceof Serializable) || (obj instanceof Parcelable)) {
                    this.mValues.put(str, obj);
                } else {
                    throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Data data) {
            putAll(data.f50108a);
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i11) {
            this.mValues.put(str, Integer.valueOf(i11));
            return this;
        }

        @NonNull
        public Builder putParcelable(@NonNull String str, @Nullable Parcelable parcelable) {
            this.mValues.put(str, parcelable);
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @Nullable String str2) {
            this.mValues.put(str, str2);
            return this;
        }
    }

    public Data() {
    }

    public Data(@NonNull Data data) {
        this.f50108a = new HashMap(data.f50108a);
    }

    public Data(@NonNull Map<String, ?> map) {
        this.f50108a = new HashMap(map);
    }

    public int getInt(@NonNull String str, int i11) {
        Object obj = this.f50108a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i11;
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.f50108a);
    }

    @Nullable
    public Parcelable getParcelable(@NonNull String str) {
        Object obj = this.f50108a.get(str);
        return obj instanceof Parcelable ? (Parcelable) obj : new Parcelable() {
            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
            }
        };
    }

    @Nullable
    public String getString(@NonNull String str) {
        Object obj = this.f50108a.get(str);
        return obj instanceof String ? (String) obj : "";
    }

    public int size() {
        return this.f50108a.size();
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f50108a.isEmpty()) {
            for (String next : this.f50108a.keySet()) {
                sb2.append(next);
                sb2.append(" : ");
                Object obj = this.f50108a.get(next);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append("}");
        return sb2.toString();
    }
}
