package com.karumi.dexter;

import com.karumi.dexter.listener.DexterError;

final class DexterException extends IllegalStateException {
    final DexterError error;

    public DexterException(String str, DexterError dexterError) {
        super(str);
        this.error = dexterError;
    }
}
