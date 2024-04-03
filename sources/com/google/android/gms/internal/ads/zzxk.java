package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzxk {
    /* access modifiers changed from: private */
    public static final String[] zza = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    /* access modifiers changed from: private */
    public static final int[] zzb = {44100, OpusUtil.SAMPLE_RATE, 32000};
    /* access modifiers changed from: private */
    public static final int[] zzc = {32000, 64000, 96000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */
    public static final int[] zzd = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};
    /* access modifiers changed from: private */
    public static final int[] zze = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};
    /* access modifiers changed from: private */
    public static final int[] zzf = {32000, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};
    /* access modifiers changed from: private */
    public static final int[] zzg = {8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 24000, 32000, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000};

    public static int zzb(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (!zzm(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return -1;
        }
        int i18 = zzb[i15];
        if (i12 == 2) {
            i18 /= 2;
        } else if (i12 == 0) {
            i18 /= 4;
        }
        int i19 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            if (i12 == 3) {
                i17 = zzc[i14 - 1];
            } else {
                i17 = zzd[i14 - 1];
            }
            return (((i17 * 12) / i18) + i19) * 4;
        }
        if (i12 != 3) {
            i16 = zzg[i14 - 1];
        } else if (i13 == 2) {
            i16 = zze[i14 - 1];
        } else {
            i16 = zzf[i14 - 1];
        }
        int i21 = Opcodes.D2F;
        if (i12 == 3) {
            return ((i16 * Opcodes.D2F) / i18) + i19;
        }
        if (i13 == 1) {
            i21 = 72;
        }
        return ((i21 * i16) / i18) + i19;
    }

    public static int zzc(int i11) {
        int i12;
        int i13;
        if (!zzm(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0) {
            return -1;
        }
        int i14 = (i11 >>> 12) & 15;
        int i15 = (i11 >>> 10) & 3;
        if (i14 == 0 || i14 == 15 || i15 == 3) {
            return -1;
        }
        return zzl(i12, i13);
    }

    /* access modifiers changed from: private */
    public static int zzl(int i11, int i12) {
        if (i12 == 1) {
            return i11 == 3 ? 1152 : 576;
        }
        if (i12 != 2) {
            return RendererCapabilities.MODE_SUPPORT_MASK;
        }
        return 1152;
    }

    /* access modifiers changed from: private */
    public static boolean zzm(int i11) {
        return (i11 & -2097152) == -2097152;
    }
}
