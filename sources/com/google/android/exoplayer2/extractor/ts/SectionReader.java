package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader implements TsPayloadReader {
    private static final int DEFAULT_SECTION_BUFFER_LENGTH = 32;
    private static final int MAX_SECTION_LENGTH = 4098;
    private static final int SECTION_HEADER_LENGTH = 3;
    private int bytesRead;
    private final SectionPayloadReader reader;
    private final ParsableByteArray sectionData = new ParsableByteArray(32);
    private boolean sectionSyntaxIndicator;
    private int totalSectionLength;
    private boolean waitingForPayloadStart;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.reader = sectionPayloadReader;
    }

    public void consume(ParsableByteArray parsableByteArray, int i11) {
        boolean z11;
        int i12;
        boolean z12;
        if ((i11 & 1) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i12 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
        } else {
            i12 = -1;
        }
        if (this.waitingForPayloadStart) {
            if (z11) {
                this.waitingForPayloadStart = false;
                parsableByteArray.setPosition(i12);
                this.bytesRead = 0;
            } else {
                return;
            }
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i13 = this.bytesRead;
            if (i13 < 3) {
                if (i13 == 0) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.setPosition(parsableByteArray.getPosition() - 1);
                    if (readUnsignedByte == 255) {
                        this.waitingForPayloadStart = true;
                        return;
                    }
                }
                int min = Math.min(parsableByteArray.bytesLeft(), 3 - this.bytesRead);
                parsableByteArray.readBytes(this.sectionData.getData(), this.bytesRead, min);
                int i14 = this.bytesRead + min;
                this.bytesRead = i14;
                if (i14 == 3) {
                    this.sectionData.setPosition(0);
                    this.sectionData.setLimit(3);
                    this.sectionData.skipBytes(1);
                    int readUnsignedByte2 = this.sectionData.readUnsignedByte();
                    int readUnsignedByte3 = this.sectionData.readUnsignedByte();
                    if ((readUnsignedByte2 & 128) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    this.sectionSyntaxIndicator = z12;
                    this.totalSectionLength = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    int capacity = this.sectionData.capacity();
                    int i15 = this.totalSectionLength;
                    if (capacity < i15) {
                        this.sectionData.ensureCapacity(Math.min(4098, Math.max(i15, this.sectionData.capacity() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(parsableByteArray.bytesLeft(), this.totalSectionLength - this.bytesRead);
                parsableByteArray.readBytes(this.sectionData.getData(), this.bytesRead, min2);
                int i16 = this.bytesRead + min2;
                this.bytesRead = i16;
                int i17 = this.totalSectionLength;
                if (i16 != i17) {
                    continue;
                } else {
                    if (!this.sectionSyntaxIndicator) {
                        this.sectionData.setLimit(i17);
                    } else if (Util.crc32(this.sectionData.getData(), 0, this.totalSectionLength, -1) != 0) {
                        this.waitingForPayloadStart = true;
                        return;
                    } else {
                        this.sectionData.setLimit(this.totalSectionLength - 4);
                    }
                    this.sectionData.setPosition(0);
                    this.reader.consume(this.sectionData);
                    this.bytesRead = 0;
                }
            }
        }
    }

    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.reader.init(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.waitingForPayloadStart = true;
    }

    public void seek() {
        this.waitingForPayloadStart = true;
    }
}
