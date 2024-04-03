package com.google.android.gms.internal.gtm;

final class zzqa {
    private final byte[] buffer;
    private final zzqj zzawd;

    private zzqa(int i11) {
        byte[] bArr = new byte[i11];
        this.buffer = bArr;
        this.zzawd = zzqj.zzg(bArr);
    }

    public final zzps zzng() {
        if (this.zzawd.zzoi() == 0) {
            return new zzqc(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzqj zznh() {
        return this.zzawd;
    }

    public /* synthetic */ zzqa(int i11, zzpt zzpt) {
        this(i11);
    }
}
