package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@KeepForSdk
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                if (!fastJsonResponse.isFieldSet(next) || !Objects.equal(getFieldValue(next), fastJsonResponse.getFieldValue(next))) {
                    return false;
                }
            } else if (fastJsonResponse.isFieldSet(next)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    @VisibleForTesting
    public Object getValueObject(@NonNull String str) {
        return null;
    }

    @KeepForSdk
    public int hashCode() {
        int i11 = 0;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                i11 = (i11 * 31) + Preconditions.checkNotNull(getFieldValue(next)).hashCode();
            }
        }
        return i11;
    }

    @VisibleForTesting
    public boolean isPrimitiveFieldSet(@NonNull String str) {
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
