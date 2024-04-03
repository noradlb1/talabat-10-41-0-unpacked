package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class PassthroughSectionPayloadReader implements SectionPayloadReader {
    private Format format;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    public PassthroughSectionPayloadReader(String str) {
        this.format = new Format.Builder().setSampleMimeType(str).build();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.timestampAdjuster);
        Util.castNonNull(this.output);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        assertInitialized();
        long lastAdjustedTimestampUs = this.timestampAdjuster.getLastAdjustedTimestampUs();
        long timestampOffsetUs = this.timestampAdjuster.getTimestampOffsetUs();
        if (lastAdjustedTimestampUs != C.TIME_UNSET && timestampOffsetUs != C.TIME_UNSET) {
            Format format2 = this.format;
            if (timestampOffsetUs != format2.subsampleOffsetUs) {
                Format build = format2.buildUpon().setSubsampleOffsetUs(timestampOffsetUs).build();
                this.format = build;
                this.output.format(build);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, bytesLeft);
            this.output.sampleMetadata(lastAdjustedTimestampUs, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
        }
    }

    public void init(TimestampAdjuster timestampAdjuster2, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster2;
        trackIdGenerator.generateNewId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
        this.output = track;
        track.format(this.format);
    }
}
