package com.google.firebase.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONObject;

public abstract class MultiFactorInfo extends AbstractSafeParcelable {
    @NonNull
    public static final String FACTOR_ID_KEY = "factorIdKey";

    @Nullable
    public abstract String getDisplayName();

    public abstract long getEnrollmentTimestamp();

    @NonNull
    public abstract String getFactorId();

    @NonNull
    public abstract String getUid();

    @Nullable
    public abstract JSONObject toJson();
}
