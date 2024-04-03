package com.google.android.exoplayer2.decoder;

public class CryptoException extends Exception {
    public final int errorCode;

    public CryptoException(int i11, String str) {
        super(str);
        this.errorCode = i11;
    }
}
