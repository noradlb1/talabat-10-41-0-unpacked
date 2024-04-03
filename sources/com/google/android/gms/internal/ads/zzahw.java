package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzahw extends ByteArrayOutputStream {
    private final zzahj zza;

    public zzahw(zzahj zzahj, int i11) {
        this.zza = zzahj;
        this.buf = zzahj.zzb(Math.max(i11, 256));
    }

    private final void zza(int i11) {
        int i12 = this.count;
        if (i12 + i11 > this.buf.length) {
            int i13 = i12 + i11;
            byte[] zzb = this.zza.zzb(i13 + i13);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zza.zza(this.buf);
            this.buf = zzb;
        }
    }

    public final void close() throws IOException {
        this.zza.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(this.buf);
    }

    public final synchronized void write(int i11) {
        zza(1);
        super.write(i11);
    }

    public final synchronized void write(byte[] bArr, int i11, int i12) {
        zza(i12);
        super.write(bArr, i11, i12);
    }
}
