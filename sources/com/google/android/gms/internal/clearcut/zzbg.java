package com.google.android.gms.internal.clearcut;

final class zzbg {
    private final byte[] buffer;
    private final zzbn zzfo;

    private zzbg(int i11) {
        byte[] bArr = new byte[i11];
        this.buffer = bArr;
        this.zzfo = zzbn.zzc(bArr);
    }

    public /* synthetic */ zzbg(int i11, zzbc zzbc) {
        this(i11);
    }

    public final zzbb zzad() {
        if (this.zzfo.zzag() == 0) {
            return new zzbi(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn zzae() {
        return this.zzfo;
    }
}
