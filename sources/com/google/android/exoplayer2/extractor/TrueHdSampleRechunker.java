package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class TrueHdSampleRechunker {
    private int chunkFlags;
    private int chunkOffset;
    private int chunkSampleCount;
    private int chunkSize;
    private long chunkTimeUs;
    private boolean foundSyncframe;
    private final byte[] syncframePrefix = new byte[10];

    public void outputPendingSampleMetadata(TrackOutput trackOutput, @Nullable TrackOutput.CryptoData cryptoData) {
        if (this.chunkSampleCount > 0) {
            trackOutput.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, cryptoData);
            this.chunkSampleCount = 0;
        }
    }

    public void reset() {
        this.foundSyncframe = false;
        this.chunkSampleCount = 0;
    }

    public void sampleMetadata(TrackOutput trackOutput, long j11, int i11, int i12, int i13, @Nullable TrackOutput.CryptoData cryptoData) {
        boolean z11;
        if (this.chunkOffset <= i12 + i13) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.foundSyncframe) {
            int i14 = this.chunkSampleCount;
            int i15 = i14 + 1;
            this.chunkSampleCount = i15;
            if (i14 == 0) {
                this.chunkTimeUs = j11;
                this.chunkFlags = i11;
                this.chunkSize = 0;
            }
            this.chunkSize += i12;
            this.chunkOffset = i13;
            if (i15 >= 16) {
                outputPendingSampleMetadata(trackOutput, cryptoData);
            }
        }
    }

    public void startSample(ExtractorInput extractorInput) throws IOException {
        if (!this.foundSyncframe) {
            extractorInput.peekFully(this.syncframePrefix, 0, 10);
            extractorInput.resetPeekPosition();
            if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != 0) {
                this.foundSyncframe = true;
            }
        }
    }
}
