package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;

@Immutable
@Alpha
public final class SecretBytes {
    private final Bytes bytes;

    private SecretBytes(Bytes bytes2) {
        this.bytes = bytes2;
    }

    public static SecretBytes copyFrom(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return new SecretBytes(Bytes.copyFrom(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static SecretBytes randomBytes(int i11) {
        return new SecretBytes(Bytes.copyFrom(Random.randBytes(i11)));
    }

    public boolean equalsSecretBytes(SecretBytes secretBytes) {
        byte[] byteArray = this.bytes.toByteArray();
        byte[] byteArray2 = secretBytes.bytes.toByteArray();
        if (byteArray.length != byteArray2.length) {
            return false;
        }
        byte b11 = 0;
        for (int i11 = 0; i11 < byteArray.length; i11++) {
            b11 |= byteArray[i11] ^ byteArray2[i11];
        }
        if (b11 == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.bytes.size();
    }

    public byte[] toByteArray(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return this.bytes.toByteArray();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
