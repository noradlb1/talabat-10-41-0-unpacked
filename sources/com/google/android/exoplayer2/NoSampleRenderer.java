package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import g7.b1;
import g7.c1;
import java.io.IOException;

public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    @Nullable
    private SampleStream stream;
    private boolean streamIsFinal;

    public final void disable() {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j11, boolean z11, boolean z12, long j12, long j13) throws ExoPlaybackException {
        boolean z13;
        boolean z14 = z11;
        if (this.state == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        Assertions.checkState(z13);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z11);
        replaceStream(formatArr, sampleStream, j12, j13);
        long j14 = j11;
        onPositionReset(j11, z11);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Nullable
    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public MediaClock getMediaClock() {
        return null;
    }

    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    public final int getState() {
        return this.state;
    }

    @Nullable
    public final SampleStream getStream() {
        return this.stream;
    }

    public final int getTrackType() {
        return -2;
    }

    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
    }

    public final boolean hasReadStreamToEnd() {
        return true;
    }

    public final void init(int i11, PlayerId playerId) {
        this.index = i11;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public boolean isEnded() {
        return true;
    }

    public boolean isReady() {
        return true;
    }

    public final void maybeThrowStreamError() throws IOException {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z11) throws ExoPlaybackException {
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
    }

    public void onRendererOffsetChanged(long j11) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j11, long j12) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j12);
    }

    public final void reset() {
        boolean z11;
        if (this.state == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        onReset();
    }

    public final void resetPosition(long j11) throws ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j11, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public /* synthetic */ void setPlaybackSpeed(float f11, float f12) {
        b1.a(this, f11, f12);
    }

    public final void start() throws ExoPlaybackException {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.state = 2;
        onStarted();
    }

    public final void stop() {
        boolean z11;
        if (this.state == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.state = 1;
        onStopped();
    }

    public int supportsFormat(Format format) throws ExoPlaybackException {
        return c1.a(0);
    }

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
