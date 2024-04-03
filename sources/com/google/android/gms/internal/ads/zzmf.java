package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

final class zzmf extends zzme {
    @Nullable
    private int[] zzd;
    @Nullable
    private int[] zze;

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i11 : iArr) {
                zzj.putShort(byteBuffer.getShort(i11 + i11 + position));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }

    public final zzlf zzi(zzlf zzlf) throws zzlg {
        boolean z11;
        boolean z12;
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzlf.zza;
        }
        if (zzlf.zzd == 2) {
            if (zzlf.zzc != iArr.length) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i11 = 0;
            while (true) {
                int length = iArr.length;
                if (i11 < length) {
                    int i12 = iArr[i11];
                    if (i12 < zzlf.zzc) {
                        if (i12 != i11) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        z11 |= z12;
                        i11++;
                    } else {
                        throw new zzlg(zzlf);
                    }
                } else if (z11) {
                    return new zzlf(zzlf.zzb, length, 2);
                } else {
                    return zzlf.zza;
                }
            }
        } else {
            throw new zzlg(zzlf);
        }
    }

    public final void zzk() {
        this.zze = this.zzd;
    }

    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(@Nullable int[] iArr) {
        this.zzd = iArr;
    }
}
