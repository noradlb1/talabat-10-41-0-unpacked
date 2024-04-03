package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        public abstract Builder setExtras(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract Builder setPriority(Priority priority);
    }

    public static Builder builder() {
        return new AutoValue_TransportContext.Builder().setPriority(Priority.DEFAULT);
    }

    public abstract String getBackendName();

    @Nullable
    public abstract byte[] getExtras();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Priority getPriority();

    public boolean shouldUploadClientHealthMetrics() {
        return getExtras() != null;
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = getBackendName();
        objArr[1] = getPriority();
        if (getExtras() == null) {
            str = "";
        } else {
            str = Base64.encodeToString(getExtras(), 2);
        }
        objArr[2] = str;
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TransportContext withPriority(Priority priority) {
        return builder().setBackendName(getBackendName()).setPriority(priority).setExtras(getExtras()).build();
    }
}
