package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

final class zzael extends zzwg {
    public zzael(zzfk zzfk, long j11, long j12) {
        super(new zzwb(), new zzaek(zzfk, (zzaej) null), j11, 0, j11 + 1, 0, j12, 188, 1000);
    }

    public static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i11 + 1] & 255) << Ascii.DLE) | ((bArr[i11 + 2] & 255) << 8);
    }
}
