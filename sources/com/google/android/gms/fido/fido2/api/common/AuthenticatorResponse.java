package com.google.android.gms.fido.fido2.api.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class AuthenticatorResponse extends AbstractSafeParcelable {
    @NonNull
    public abstract byte[] getClientDataJSON();

    @NonNull
    public abstract byte[] serializeToBytes();
}
