package org.tukaani.xz.check;

public class None extends Check {
    public None() {
        this.f63419a = 0;
        this.f63420b = "None";
    }

    public byte[] finish() {
        return new byte[0];
    }

    public void update(byte[] bArr, int i11, int i12) {
    }
}
