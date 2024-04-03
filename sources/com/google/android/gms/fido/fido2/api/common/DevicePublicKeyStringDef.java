package com.google.android.gms.fido.fido2.api.common;

import androidx.annotation.NonNull;

public @interface DevicePublicKeyStringDef {
    @NonNull
    public static final String DIRECT = "direct";
    @NonNull
    public static final String INDIRECT = "indirect";
    @NonNull
    public static final String NONE = "none";
}
