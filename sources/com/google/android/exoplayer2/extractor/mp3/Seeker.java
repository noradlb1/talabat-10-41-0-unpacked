package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;

interface Seeker extends SeekMap {

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(C.TIME_UNSET);
        }

        public long getDataEndPosition() {
            return -1;
        }

        public long getTimeUs(long j11) {
            return 0;
        }
    }

    long getDataEndPosition();

    long getTimeUs(long j11);
}
