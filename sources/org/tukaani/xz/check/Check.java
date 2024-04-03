package org.tukaani.xz.check;

import java.security.NoSuchAlgorithmException;
import org.tukaani.xz.UnsupportedOptionsException;

public abstract class Check {

    /* renamed from: a  reason: collision with root package name */
    public int f63419a;

    /* renamed from: b  reason: collision with root package name */
    public String f63420b;

    public static Check getInstance(int i11) throws UnsupportedOptionsException {
        if (i11 == 0) {
            return new None();
        }
        if (i11 == 1) {
            return new CRC32();
        }
        if (i11 == 4) {
            return new CRC64();
        }
        if (i11 == 10) {
            try {
                return new SHA256();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        throw new UnsupportedOptionsException("Unsupported Check ID " + i11);
    }

    public abstract byte[] finish();

    public String getName() {
        return this.f63420b;
    }

    public int getSize() {
        return this.f63419a;
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public abstract void update(byte[] bArr, int i11, int i12);
}
