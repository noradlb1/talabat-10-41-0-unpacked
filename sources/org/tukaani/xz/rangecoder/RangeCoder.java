package org.tukaani.xz.rangecoder;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.util.Arrays;

public abstract class RangeCoder {
    public static final void initProbs(short[] sArr) {
        Arrays.fill(sArr, SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL);
    }
}
