package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class j implements Consumer {
    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
    }
}
