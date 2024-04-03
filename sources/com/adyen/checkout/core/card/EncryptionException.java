package com.adyen.checkout.core.card;

import android.support.annotation.NonNull;

public class EncryptionException extends Exception {
    public EncryptionException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }
}
