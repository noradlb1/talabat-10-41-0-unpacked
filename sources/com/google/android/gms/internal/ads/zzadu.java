package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.Arrays;

final class zzadu {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzadu(int i11) {
    }

    public final void zza(byte[] bArr, int i11, int i12) {
        if (this.zze) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i14 = this.zza + i13;
            if (length < i14) {
                this.zzc = Arrays.copyOf(bArr2, i14 + i14);
            }
            System.arraycopy(bArr, i11, this.zzc, this.zza, i13);
            this.zza += i13;
        }
    }

    public final void zzb() {
        this.zze = false;
        this.zza = 0;
        this.zzf = 0;
    }

    public final boolean zzc(int i11, int i12) {
        int i13 = this.zzf;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 != 3) {
                        if (i11 == 179 || i11 == 181) {
                            this.zza -= i12;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i11 & PsExtractor.VIDEO_STREAM_MASK) != 32) {
                        Log.w("H263Reader", "Unexpected start code value");
                        zzb();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i11 > 31) {
                    Log.w("H263Reader", "Unexpected start code value");
                    zzb();
                } else {
                    this.zzf = 3;
                }
            } else if (i11 != 181) {
                Log.w("H263Reader", "Unexpected start code value");
                zzb();
            } else {
                this.zzf = 2;
            }
        } else if (i11 == 176) {
            this.zzf = 1;
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
