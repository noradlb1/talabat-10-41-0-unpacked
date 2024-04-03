package com.google.android.gms.internal.ads;

import android.media.ApplicationMediaCapabilities;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.MimeTypes;

@RequiresApi(31)
final class zztg {
    @DoNotInline
    public static void zza(Bundle bundle) {
        bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", new ApplicationMediaCapabilities.Builder().addSupportedVideoMimeType(MimeTypes.VIDEO_H265).addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
    }
}
