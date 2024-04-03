package com.google.android.gms.internal.places;

final class zzae {
    private final byte[] buffer;
    private final zzaj zzem;

    private zzae(int i11) {
        byte[] bArr = new byte[i11];
        this.buffer = bArr;
        this.zzem = zzaj.zzc(bArr);
    }

    public final zzw zzah() {
        if (this.zzem.zzak() == 0) {
            return new zzag(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzaj zzai() {
        return this.zzem;
    }

    public /* synthetic */ zzae(int i11, zzv zzv) {
        this(i11);
    }
}
