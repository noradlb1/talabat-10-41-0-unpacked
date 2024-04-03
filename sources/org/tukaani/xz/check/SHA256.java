package org.tukaani.xz.check;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 extends Check {
    private final MessageDigest sha256 = MessageDigest.getInstance(Constants.SHA256);

    public SHA256() throws NoSuchAlgorithmException {
        this.f63419a = 32;
        this.f63420b = Constants.SHA256;
    }

    public byte[] finish() {
        byte[] digest = this.sha256.digest();
        this.sha256.reset();
        return digest;
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.sha256.update(bArr, i11, i12);
    }
}
