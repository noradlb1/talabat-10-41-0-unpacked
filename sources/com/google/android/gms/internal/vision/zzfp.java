package com.google.android.gms.internal.vision;

final class zzfp {
    private final byte[] buffer;
    private final zzga zzsd;

    private zzfp(int i11) {
        byte[] bArr = new byte[i11];
        this.buffer = bArr;
        this.zzsd = zzga.zze(bArr);
    }

    public final zzfh zzev() {
        this.zzsd.zzfh();
        return new zzfr(this.buffer);
    }

    public final zzga zzew() {
        return this.zzsd;
    }

    public /* synthetic */ zzfp(int i11, zzfk zzfk) {
        this(i11);
    }
}
