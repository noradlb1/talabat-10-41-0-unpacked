package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    private static final int MATCH_BYTE_RANGE = 100000;
    private static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 4;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private static final int STATE_SKIP = 3;
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    /* access modifiers changed from: private */
    public final long payloadEndPosition;
    /* access modifiers changed from: private */
    public final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    /* access modifiers changed from: private */
    public final StreamReader streamReader;
    private long targetGranule;
    /* access modifiers changed from: private */
    public long totalGranules;

    public final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        public SeekMap.SeekPoints getSeekPoints(long j11) {
            return new SeekMap.SeekPoints(new SeekPoint(j11, Util.constrainValue((DefaultOggSeeker.this.payloadStartPosition + ((DefaultOggSeeker.this.streamReader.convertTimeToGranule(j11) * (DefaultOggSeeker.this.payloadEndPosition - DefaultOggSeeker.this.payloadStartPosition)) / DefaultOggSeeker.this.totalGranules)) - 30000, DefaultOggSeeker.this.payloadStartPosition, DefaultOggSeeker.this.payloadEndPosition - 1)));
        }

        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(StreamReader streamReader2, long j11, long j12, long j13, long j14, boolean z11) {
        boolean z12;
        if (j11 < 0 || j12 <= j11) {
            z12 = false;
        } else {
            z12 = true;
        }
        Assertions.checkArgument(z12);
        this.streamReader = streamReader2;
        this.payloadStartPosition = j11;
        this.payloadEndPosition = j12;
        if (j13 == j12 - j11 || z11) {
            this.totalGranules = j14;
            this.state = 4;
        } else {
            this.state = 0;
        }
        this.pageHeader = new OggPageHeader();
    }

    private long getNextSeekPosition(ExtractorInput extractorInput) throws IOException {
        long j11;
        ExtractorInput extractorInput2 = extractorInput;
        if (this.start == this.end) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!this.pageHeader.skipToNextPage(extractorInput2, this.end)) {
            long j12 = this.start;
            if (j12 != position) {
                return j12;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput2, false);
        extractorInput.resetPeekPosition();
        long j13 = this.targetGranule;
        OggPageHeader oggPageHeader = this.pageHeader;
        long j14 = oggPageHeader.granulePosition;
        long j15 = j13 - j14;
        int i11 = oggPageHeader.headerSize + oggPageHeader.bodySize;
        if (0 <= j15 && j15 < 72000) {
            return -1;
        }
        int i12 = (j15 > 0 ? 1 : (j15 == 0 ? 0 : -1));
        if (i12 < 0) {
            this.end = position;
            this.endGranule = j14;
        } else {
            this.start = extractorInput.getPosition() + ((long) i11);
            this.startGranule = this.pageHeader.granulePosition;
        }
        long j16 = this.end;
        long j17 = this.start;
        if (j16 - j17 < 100000) {
            this.end = j17;
            return j17;
        }
        long j18 = (long) i11;
        if (i12 <= 0) {
            j11 = 2;
        } else {
            j11 = 1;
        }
        long position2 = extractorInput.getPosition() - (j18 * j11);
        long j19 = this.end;
        long j21 = this.start;
        return Util.constrainValue(position2 + ((j15 * (j19 - j21)) / (this.endGranule - this.startGranule)), j21, j19 - 1);
    }

    private void skipToPageOfTargetGranule(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.pageHeader.skipToNextPage(extractorInput);
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition > this.targetGranule) {
                extractorInput.resetPeekPosition();
                return;
            }
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
            this.start = extractorInput.getPosition();
            this.startGranule = this.pageHeader.granulePosition;
        }
    }

    public long read(ExtractorInput extractorInput) throws IOException {
        int i11 = this.state;
        if (i11 == 0) {
            long position = extractorInput.getPosition();
            this.positionBeforeSeekToEnd = position;
            this.state = 1;
            long j11 = this.payloadEndPosition - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long nextSeekPosition = getNextSeekPosition(extractorInput);
                if (nextSeekPosition != -1) {
                    return nextSeekPosition;
                }
                this.state = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            skipToPageOfTargetGranule(extractorInput);
            this.state = 4;
            return -(this.startGranule + 2);
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 4;
        return this.positionBeforeSeekToEnd;
    }

    @VisibleForTesting
    public long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException {
        this.pageHeader.reset();
        if (this.pageHeader.skipToNextPage(extractorInput)) {
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
            long j11 = this.pageHeader.granulePosition;
            while (true) {
                OggPageHeader oggPageHeader2 = this.pageHeader;
                if ((oggPageHeader2.type & 4) == 4 || !oggPageHeader2.skipToNextPage(extractorInput) || extractorInput.getPosition() >= this.payloadEndPosition || !this.pageHeader.populate(extractorInput, true)) {
                    break;
                }
                OggPageHeader oggPageHeader3 = this.pageHeader;
                if (!ExtractorUtil.skipFullyQuietly(extractorInput, oggPageHeader3.headerSize + oggPageHeader3.bodySize)) {
                    break;
                }
                j11 = this.pageHeader.granulePosition;
            }
            return j11;
        }
        throw new EOFException();
    }

    public void startSeek(long j11) {
        this.targetGranule = Util.constrainValue(j11, 0, this.totalGranules - 1);
        this.state = 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0;
        this.endGranule = this.totalGranules;
    }

    @Nullable
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }
}
