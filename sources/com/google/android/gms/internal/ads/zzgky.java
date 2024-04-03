package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzgky extends InputStream {
    private Iterator<ByteBuffer> zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    public zzgky(Iterable<ByteBuffer> iterable) {
        this.zza = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.zzc++;
        }
        this.zzd = -1;
        if (!zzb()) {
            this.zzb = zzgkv.zze;
            this.zzd = 0;
            this.zze = 0;
            this.zzi = 0;
        }
    }

    private final void zza(int i11) {
        int i12 = this.zze + i11;
        this.zze = i12;
        if (i12 == this.zzb.limit()) {
            zzb();
        }
    }

    private final boolean zzb() {
        this.zzd++;
        if (!this.zza.hasNext()) {
            return false;
        }
        ByteBuffer next = this.zza.next();
        this.zzb = next;
        this.zze = next.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzgnp.zze(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    public final int read() throws IOException {
        byte zza2;
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            zza2 = this.zzg[this.zze + this.zzh];
            zza(1);
        } else {
            zza2 = zzgnp.zza(((long) this.zze) + this.zzi);
            zza(1);
        }
        return zza2 & 255;
    }

    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int limit = this.zzb.limit();
        int i13 = this.zze;
        int i14 = limit - i13;
        if (i12 > i14) {
            i12 = i14;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i13 + this.zzh, bArr, i11, i12);
            zza(i12);
        } else {
            int position = this.zzb.position();
            ByteBuffer byteBuffer = (ByteBuffer) this.zzb.position(this.zze);
            this.zzb.get(bArr, i11, i12);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.zzb.position(position);
            zza(i12);
        }
        return i12;
    }
}
