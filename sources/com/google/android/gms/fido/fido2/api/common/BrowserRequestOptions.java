package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import androidx.annotation.NonNull;

public abstract class BrowserRequestOptions extends RequestOptions {
    @NonNull
    public abstract byte[] getClientDataHash();

    @NonNull
    public abstract Uri getOrigin();
}
