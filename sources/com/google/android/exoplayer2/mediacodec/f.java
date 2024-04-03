package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

public final /* synthetic */ class f implements MediaCodecUtil.ScoreProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f34961a;

    public /* synthetic */ f(Format format) {
        this.f34961a = format;
    }

    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.f34961a, (MediaCodecInfo) obj);
    }
}
