package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class zzaps {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] zzd = {2, 1, 2, 3, 3, 4, 4, 5};

    public static int zza(ByteBuffer byteBuffer) {
        int i11 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i11 = zzb[(byteBuffer.get(byteBuffer.position() + 4) & TarConstants.LF_NORMAL) >> 4];
        }
        return i11 * 256;
    }

    public static zzapg zzb(zzawu zzawu, String str, String str2, zzarf zzarf) {
        int i11 = zzc[(zzawu.zzg() & 192) >> 6];
        int zzg = zzawu.zzg();
        int i12 = zzd[(zzg & 56) >> 3];
        if ((zzg & 4) != 0) {
            i12++;
        }
        return zzapg.zzg(str, MimeTypes.AUDIO_AC3, (String) null, -1, -1, i12, i11, (List<byte[]>) null, zzarf, 0, str2);
    }

    public static zzapg zzc(zzawu zzawu, String str, String str2, zzarf zzarf) {
        zzawu zzawu2 = zzawu;
        zzawu.zzw(2);
        int i11 = zzc[(zzawu.zzg() & 192) >> 6];
        int zzg = zzawu.zzg();
        int i12 = zzd[(zzg & 14) >> 1];
        if ((zzg & 1) != 0) {
            i12++;
        }
        return zzapg.zzg(str, MimeTypes.AUDIO_E_AC3, (String) null, -1, -1, i12, i11, (List<byte[]>) null, zzarf, 0, str2);
    }
}
