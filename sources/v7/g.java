package v7;

import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public final /* synthetic */ class g implements MediaCodecSelector {
    public final List getDecoderInfos(String str, boolean z11, boolean z12) {
        return MediaCodecUtil.getDecoderInfos(str, z11, z12);
    }
}
