package com.huawei.hms.hatool;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f49024a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f49025b = 0;

    public h(int i11) {
        this.f49024a = new byte[i11];
    }

    public void a(byte[] bArr, int i11) {
        if (i11 > 0) {
            byte[] bArr2 = this.f49024a;
            int length = bArr2.length;
            int i12 = this.f49025b;
            if (length - i12 >= i11) {
                System.arraycopy(bArr, 0, bArr2, i12, i11);
            } else {
                byte[] bArr3 = new byte[((bArr2.length + i11) << 1)];
                System.arraycopy(bArr2, 0, bArr3, 0, i12);
                System.arraycopy(bArr, 0, bArr3, this.f49025b, i11);
                this.f49024a = bArr3;
            }
            this.f49025b += i11;
        }
    }

    public byte[] a() {
        int i11 = this.f49025b;
        if (i11 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i11];
        System.arraycopy(this.f49024a, 0, bArr, 0, i11);
        return bArr;
    }

    public int b() {
        return this.f49025b;
    }
}
