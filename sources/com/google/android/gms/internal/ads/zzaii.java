package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;

public final class zzaii extends zzgpa {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzgpk zzm = zzgpk.zza;
    private long zzn;

    public zzaii() {
        super("mvhd");
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzj;
    }

    public final long zze() {
        return this.zzi;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzgpf.zza(zzaie.zzf(byteBuffer));
            this.zzh = zzgpf.zza(zzaie.zzf(byteBuffer));
            this.zzi = zzaie.zze(byteBuffer);
            this.zzj = zzaie.zzf(byteBuffer);
        } else {
            this.zza = zzgpf.zza(zzaie.zze(byteBuffer));
            this.zzh = zzgpf.zza(zzaie.zze(byteBuffer));
            this.zzi = zzaie.zze(byteBuffer);
            this.zzj = zzaie.zze(byteBuffer);
        }
        this.zzk = zzaie.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & 255) | ((short) ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))))) / 256.0f;
        zzaie.zzd(byteBuffer);
        zzaie.zze(byteBuffer);
        zzaie.zze(byteBuffer);
        double zzb = zzaie.zzb(byteBuffer);
        double zzb2 = zzaie.zzb(byteBuffer);
        double zza2 = zzaie.zza(byteBuffer);
        this.zzm = new zzgpk(zzb, zzb2, zzaie.zzb(byteBuffer), zzaie.zzb(byteBuffer), zza2, zzaie.zza(byteBuffer), zzaie.zza(byteBuffer), zzaie.zzb(byteBuffer), zzaie.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzaie.zze(byteBuffer);
    }
}
