package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    public static class Builder {
        /* access modifiers changed from: private */
        public Map<String, String> keysAndValues = new HashMap();

        @NonNull
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z11) {
            this.keysAndValues.put(str, Boolean.toString(z11));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d11) {
            this.keysAndValues.put(str, Double.toString(d11));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f11) {
            this.keysAndValues.put(str, Float.toString(f11));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i11) {
            this.keysAndValues.put(str, Integer.toString(i11));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j11) {
            this.keysAndValues.put(str, Long.toString(j11));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @NonNull String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    public CustomKeysAndValues(@NonNull Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
