package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzxd {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    @Nullable
    public final zzxc zzk;
    @Nullable
    private final zzdd zzl;

    private zzxd(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, @Nullable zzxc zzxc, @Nullable zzdd zzdd) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
        this.zzf = zzi(i15);
        this.zzg = i16;
        this.zzh = i17;
        this.zzi = zzh(i17);
        this.zzj = j11;
        this.zzk = zzxc;
        this.zzl = zzdd;
    }

    public zzxd(byte[] bArr, int i11) {
        zzfc zzfc = new zzfc(bArr, bArr.length);
        zzfc.zzh(i11 * 8);
        this.zza = zzfc.zzc(16);
        this.zzb = zzfc.zzc(16);
        this.zzc = zzfc.zzc(24);
        this.zzd = zzfc.zzc(24);
        int zzc2 = zzfc.zzc(20);
        this.zze = zzc2;
        this.zzf = zzi(zzc2);
        this.zzg = zzfc.zzc(3) + 1;
        int zzc3 = zzfc.zzc(5) + 1;
        this.zzh = zzc3;
        this.zzi = zzh(zzc3);
        this.zzj = zzfn.zzv(zzfc.zzc(4), zzfc.zzc(32));
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i11) {
        if (i11 == 8) {
            return 1;
        }
        if (i11 == 12) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 != 20) {
            return i11 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i11) {
        switch (i11) {
            case 8000:
                return 4;
            case AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.SAMPLE_RATE:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND:
                return 3;
            default:
                return -1;
        }
    }

    @Nullable
    private static zzdd zzj(List<String> list, List<zzyz> list2) {
        String str;
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str2 = list.get(i11);
            String[] zzad = zzfn.zzad(str2, "=");
            if (zzad.length != 2) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str = "Failed to parse Vorbis comment: ".concat(valueOf);
                } else {
                    str = new String("Failed to parse Vorbis comment: ");
                }
                Log.w("FlacStreamMetadata", str);
            } else {
                arrayList.add(new zzzb(zzad[0], zzad[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdd((List<? extends zzdc>) arrayList);
    }

    public final long zza() {
        long j11 = this.zzj;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j11) {
        return zzfn.zzo((j11 * ((long) this.zze)) / 1000000, 0, this.zzj - 1);
    }

    public final zzab zzc(byte[] bArr, @Nullable zzdd zzdd) {
        bArr[4] = Byte.MIN_VALUE;
        int i11 = this.zzd;
        if (i11 <= 0) {
            i11 = -1;
        }
        zzdd zzd2 = zzd(zzdd);
        zzz zzz = new zzz();
        zzz.zzS(MimeTypes.AUDIO_FLAC);
        zzz.zzL(i11);
        zzz.zzw(this.zzg);
        zzz.zzT(this.zze);
        zzz.zzI(Collections.singletonList(bArr));
        zzz.zzM(zzd2);
        return zzz.zzY();
    }

    @Nullable
    public final zzdd zzd(@Nullable zzdd zzdd) {
        zzdd zzdd2 = this.zzl;
        return zzdd2 == null ? zzdd : zzdd2.zzd(zzdd);
    }

    public final zzxd zze(List<zzyz> list) {
        return new zzxd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzj(Collections.emptyList(), list)));
    }

    public final zzxd zzf(@Nullable zzxc zzxc) {
        return new zzxd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzxc, this.zzl);
    }

    public final zzxd zzg(List<String> list) {
        return new zzxd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzj(list, Collections.emptyList())));
    }
}
