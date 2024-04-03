package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzarb extends zzaqw {
    public final zzaqz zza = new zzaqz();
    public ByteBuffer zzb;
    public long zzc;

    public zzarb(int i11) {
    }

    private final ByteBuffer zzj(int i11) {
        int i12;
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            i12 = 0;
        } else {
            i12 = byteBuffer.capacity();
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("Buffer too small (");
        sb2.append(i12);
        sb2.append(" < ");
        sb2.append(i11);
        sb2.append(")");
        throw new IllegalStateException(sb2.toString());
    }

    public final void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void zzh(int i11) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = zzj(i11);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzb.position();
        int i12 = i11 + position;
        if (capacity < i12) {
            ByteBuffer zzj = zzj(i12);
            if (position > 0) {
                this.zzb.position(0);
                this.zzb.limit(position);
                zzj.put(this.zzb);
            }
            this.zzb = zzj;
        }
    }

    public final boolean zzi() {
        return zzd(1073741824);
    }
}
