package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.database.core.ValidationPath;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;

public final class zzwn {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.SAMPLE_RATE, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, RendererCapabilities.MODE_SUPPORT_MASK, 448, 512, 640, ValidationPath.MAX_PATH_LENGTH_BYTES, 896, 1024, 1152, PlatformPlugin.DEFAULT_SYSTEM_UI, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, KfsConstant.KFS_RSA_KEY_LEN_3072, 3840, 4096, 6144, 7680};

    public static zzab zza(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable zzs zzs) {
        zzfc zzfc;
        int i11 = 0;
        int i12 = -1;
        if (bArr[0] == Byte.MAX_VALUE) {
            zzfc = new zzfc(bArr, bArr.length);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b11 = copyOf[0];
            if (b11 == -2 || b11 == -1) {
                for (int i13 = 0; i13 < copyOf.length - 1; i13 += 2) {
                    byte b12 = copyOf[i13];
                    int i14 = i13 + 1;
                    copyOf[i13] = copyOf[i14];
                    copyOf[i14] = b12;
                }
            }
            int length = copyOf.length;
            zzfc = new zzfc(copyOf, length);
            if (copyOf[0] == 31) {
                zzfc zzfc2 = new zzfc(copyOf, length);
                while (zzfc2.zza() >= 16) {
                    zzfc2.zzj(2);
                    zzfc.zze(zzfc2.zzc(14), 14);
                }
            }
            zzfc.zzg(copyOf, copyOf.length);
        }
        zzfc.zzj(60);
        int i15 = zzb[zzfc.zzc(6)];
        int i16 = zzc[zzfc.zzc(4)];
        int zzc2 = zzfc.zzc(5);
        if (zzc2 < 29) {
            i12 = (zzd[zzc2] * 1000) / 2;
        }
        zzfc.zzj(10);
        if (zzfc.zzc(2) > 0) {
            i11 = 1;
        }
        zzz zzz = new zzz();
        zzz.zzH(str);
        zzz.zzS(MimeTypes.AUDIO_DTS);
        zzz.zzv(i12);
        zzz.zzw(i15 + i11);
        zzz.zzT(i16);
        zzz.zzB((zzs) null);
        zzz.zzK(str2);
        return zzz.zzY();
    }
}
