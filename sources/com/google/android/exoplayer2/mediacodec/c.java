package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f34960b;

    public /* synthetic */ c(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.f34960b = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.lambda$sortByScore$3(this.f34960b, obj, obj2);
    }
}
