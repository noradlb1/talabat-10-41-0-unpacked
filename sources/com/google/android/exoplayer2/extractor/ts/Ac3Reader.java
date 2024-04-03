package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Ac3Reader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 128;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    @Nullable
    private final String language;
    private boolean lastByteWas0B;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public Ac3Reader() {
        this((String) null);
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i11) {
        int min = Math.min(parsableByteArray.bytesLeft(), i11 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i12 = this.bytesRead + min;
        this.bytesRead = i12;
        if (i12 == i11) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
        Format format2 = this.format;
        if (format2 == null || parseAc3SyncframeInfo.channelCount != format2.channelCount || parseAc3SyncframeInfo.sampleRate != format2.sampleRate || !Util.areEqual(parseAc3SyncframeInfo.mimeType, format2.sampleMimeType)) {
            Format.Builder peakBitrate = new Format.Builder().setId(this.formatId).setSampleMimeType(parseAc3SyncframeInfo.mimeType).setChannelCount(parseAc3SyncframeInfo.channelCount).setSampleRate(parseAc3SyncframeInfo.sampleRate).setLanguage(this.language).setPeakBitrate(parseAc3SyncframeInfo.bitrate);
            if (MimeTypes.AUDIO_AC3.equals(parseAc3SyncframeInfo.mimeType)) {
                peakBitrate.setAverageBitrate(parseAc3SyncframeInfo.bitrate);
            }
            Format build = peakBitrate.build();
            this.format = build;
            this.output.format(build);
        }
        this.sampleSize = parseAc3SyncframeInfo.frameSize;
        this.sampleDurationUs = (((long) parseAc3SyncframeInfo.sampleCount) * 1000000) / ((long) this.format.sampleRate);
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z11 = false;
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (!this.lastByteWas0B) {
                if (parsableByteArray.readUnsignedByte() == 11) {
                    z11 = true;
                }
                this.lastByteWas0B = z11;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.lastByteWas0B = false;
                    return true;
                }
                if (readUnsignedByte == 11) {
                    z11 = true;
                }
                this.lastByteWas0B = z11;
            }
        }
    }

    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.output);
        while (parsableByteArray.bytesLeft() > 0) {
            int i11 = this.state;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, min);
                        int i12 = this.bytesRead + min;
                        this.bytesRead = i12;
                        int i13 = this.sampleSize;
                        if (i12 == i13) {
                            long j11 = this.timeUs;
                            if (j11 != C.TIME_UNSET) {
                                this.output.sampleMetadata(j11, 1, i13, 0, (TrackOutput.CryptoData) null);
                                this.timeUs += this.sampleDurationUs;
                            }
                            this.state = 0;
                        }
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.getData(), 128)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 128);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
                this.headerScratchBytes.getData()[0] = 11;
                this.headerScratchBytes.getData()[1] = 119;
                this.bytesRead = 2;
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
        this.bytesRead = 0;
        this.lastByteWas0B = false;
        this.timeUs = C.TIME_UNSET;
    }

    public Ac3Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.headerScratchBits = parsableBitArray;
        this.headerScratchBytes = new ParsableByteArray(parsableBitArray.data);
        this.state = 0;
        this.timeUs = C.TIME_UNSET;
        this.language = str;
    }
}
