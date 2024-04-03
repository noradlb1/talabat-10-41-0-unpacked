package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.exoplayer2.util.MimeTypes;

final class zzatm implements zzatk {
    private zzatm() {
    }

    public /* synthetic */ zzatm(zzatl zzatl) {
    }

    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo zzb(int i11) {
        return MediaCodecList.getCodecInfoAt(i11);
    }

    public final boolean zzc(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return MimeTypes.VIDEO_H264.equals(str);
    }

    public final boolean zzd() {
        return false;
    }
}
