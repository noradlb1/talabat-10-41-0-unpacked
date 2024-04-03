package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {
    private int currentSegmentIndex = -1;
    private final ParsableByteArray packetArray = new ParsableByteArray(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private final OggPageHeader pageHeader = new OggPageHeader();
    private boolean populated;
    private int segmentCount;

    private int calculatePacketSize(int i11) {
        int i12;
        int i13 = 0;
        this.segmentCount = 0;
        do {
            int i14 = this.segmentCount;
            int i15 = i11 + i14;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i15 >= oggPageHeader.pageSegmentCount) {
                break;
            }
            int[] iArr = oggPageHeader.laces;
            this.segmentCount = i14 + 1;
            i12 = iArr[i14 + i11];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public boolean populate(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        boolean z12;
        int i11;
        if (extractorInput != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (this.populated) {
            this.populated = false;
            this.packetArray.reset(0);
        }
        while (!this.populated) {
            if (this.currentSegmentIndex < 0) {
                if (!this.pageHeader.skipToNextPage(extractorInput) || !this.pageHeader.populate(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.pageHeader;
                int i12 = oggPageHeader.headerSize;
                if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                    i12 += calculatePacketSize(0);
                    i11 = this.segmentCount + 0;
                } else {
                    i11 = 0;
                }
                if (!ExtractorUtil.skipFullyQuietly(extractorInput, i12)) {
                    return false;
                }
                this.currentSegmentIndex = i11;
            }
            int calculatePacketSize = calculatePacketSize(this.currentSegmentIndex);
            int i13 = this.currentSegmentIndex + this.segmentCount;
            if (calculatePacketSize > 0) {
                ParsableByteArray parsableByteArray = this.packetArray;
                parsableByteArray.ensureCapacity(parsableByteArray.limit() + calculatePacketSize);
                if (!ExtractorUtil.readFullyQuietly(extractorInput, this.packetArray.getData(), this.packetArray.limit(), calculatePacketSize)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.packetArray;
                parsableByteArray2.setLimit(parsableByteArray2.limit() + calculatePacketSize);
                if (this.pageHeader.laces[i13 - 1] != 255) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.populated = z12;
            }
            if (i13 == this.pageHeader.pageSegmentCount) {
                i13 = -1;
            }
            this.currentSegmentIndex = i13;
        }
        return true;
    }

    public void reset() {
        this.pageHeader.reset();
        this.packetArray.reset(0);
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public void trimPayload() {
        if (this.packetArray.getData().length != 65025) {
            ParsableByteArray parsableByteArray = this.packetArray;
            parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.packetArray.limit())), this.packetArray.limit());
        }
    }
}
