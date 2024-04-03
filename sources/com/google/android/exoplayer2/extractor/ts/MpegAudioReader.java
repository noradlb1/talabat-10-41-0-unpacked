package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MpegAudioReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioUtil.Header header;
    private final ParsableByteArray headerScratch;
    @Nullable
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state;
    private long timeUs;

    public MpegAudioReader() {
        this((String) null);
    }

    private void findHeader(ParsableByteArray parsableByteArray) {
        boolean z11;
        boolean z12;
        byte[] data = parsableByteArray.getData();
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            byte b11 = data[position];
            if ((b11 & 255) == 255) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!this.lastByteWasFF || (b11 & 224) != 224) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.lastByteWasFF = z11;
            if (z12) {
                parsableByteArray.setPosition(position + 1);
                this.lastByteWasFF = false;
                this.headerScratch.getData()[1] = data[position];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
        }
        parsableByteArray.setPosition(limit);
    }

    @RequiresNonNull({"output"})
    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray, min);
        int i11 = this.frameBytesRead + min;
        this.frameBytesRead = i11;
        int i12 = this.frameSize;
        if (i11 >= i12) {
            long j11 = this.timeUs;
            if (j11 != C.TIME_UNSET) {
                this.output.sampleMetadata(j11, 1, i12, 0, (TrackOutput.CryptoData) null);
                this.timeUs += this.frameDurationUs;
            }
            this.frameBytesRead = 0;
            this.state = 0;
        }
    }

    @RequiresNonNull({"output"})
    private void readHeaderRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray.readBytes(this.headerScratch.getData(), this.frameBytesRead, min);
        int i11 = this.frameBytesRead + min;
        this.frameBytesRead = i11;
        if (i11 >= 4) {
            this.headerScratch.setPosition(0);
            if (!this.header.setForHeaderData(this.headerScratch.readInt())) {
                this.frameBytesRead = 0;
                this.state = 1;
                return;
            }
            MpegAudioUtil.Header header2 = this.header;
            this.frameSize = header2.frameSize;
            if (!this.hasOutputFormat) {
                this.frameDurationUs = (((long) header2.samplesPerFrame) * 1000000) / ((long) header2.sampleRate);
                this.output.format(new Format.Builder().setId(this.formatId).setSampleMimeType(this.header.mimeType).setMaxInputSize(4096).setChannelCount(this.header.channels).setSampleRate(this.header.sampleRate).setLanguage(this.language).build());
                this.hasOutputFormat = true;
            }
            this.headerScratch.setPosition(0);
            this.output.sampleData(this.headerScratch, 4);
            this.state = 2;
        }
    }

    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.output);
        while (parsableByteArray.bytesLeft() > 0) {
            int i11 = this.state;
            if (i11 == 0) {
                findHeader(parsableByteArray);
            } else if (i11 == 1) {
                readHeaderRemainder(parsableByteArray);
            } else if (i11 == 2) {
                readFrameRemainder(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.timeUs = j11;
        }
    }

    public void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
        this.timeUs = C.TIME_UNSET;
    }

    public MpegAudioReader(@Nullable String str) {
        this.state = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray;
        parsableByteArray.getData()[0] = -1;
        this.header = new MpegAudioUtil.Header();
        this.timeUs = C.TIME_UNSET;
        this.language = str;
    }
}
