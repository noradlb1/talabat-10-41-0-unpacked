package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;

public interface AudioProcessorChain {
    PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

    boolean applySkipSilenceEnabled(boolean z11);

    AudioProcessor[] getAudioProcessors();

    long getMediaDuration(long j11);

    long getSkippedOutputFrameCount();
}
