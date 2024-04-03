package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzgoy implements zzaif {
    private static final zzgpj zza = zzgpj.zzb(zzgoy.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1;
    zzgpd zzg;
    private zzaig zzh;
    private ByteBuffer zzi;
    private ByteBuffer zzj = null;

    public zzgoy(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        String str;
        if (!this.zzd) {
            try {
                zzgpj zzgpj = zza;
                String str2 = this.zzb;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzgpj.zza(str);
                this.zzi = this.zzg.zzd(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzgpd zzgpd, ByteBuffer byteBuffer, long j11, zzaic zzaic) throws IOException {
        this.zze = zzgpd.zzb();
        byteBuffer.remaining();
        this.zzf = j11;
        this.zzg = zzgpd;
        zzgpd.zze(zzgpd.zzb() + j11);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    public final void zzc(zzaig zzaig) {
        this.zzh = zzaig;
    }

    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        String str;
        zzd();
        zzgpj zzgpj = zza;
        String str2 = this.zzb;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzgpj.zza(str);
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzj = byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
