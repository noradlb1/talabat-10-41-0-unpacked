package com.google.android.exoplayer2.extractor.mp3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j11, long j12) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j11;
        this.dataEndPosition = j12;
    }

    @Nullable
    public static VbriSeeker create(long j11, long j12, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i11;
        int i12;
        long j13 = j11;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i13 = header2.sampleRate;
        long j14 = (long) readInt;
        if (i13 >= 32000) {
            i11 = 1152;
        } else {
            i11 = 576;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j14, ((long) i11) * 1000000, (long) i13);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j15 = j12 + ((long) header2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i14 = 0;
        long j16 = j12;
        while (i14 < readUnsignedShort) {
            int i15 = readUnsignedShort2;
            jArr[i14] = (((long) i14) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j17 = j15;
            jArr2[i14] = Math.max(j16, j17);
            if (readUnsignedShort3 == 1) {
                i12 = parsableByteArray.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i12 = parsableByteArray.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i12 = parsableByteArray.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i12 = parsableByteArray.readUnsignedIntToInt();
            }
            long j18 = (long) i12;
            int i16 = i15;
            j16 += j18 * ((long) i16);
            i14++;
            jArr = jArr;
            readUnsignedShort2 = i16;
            j15 = j17;
        }
        long[] jArr3 = jArr;
        if (!(j13 == -1 || j13 == j16)) {
            Log.w(TAG, "VBRI data size mismatch: " + j13 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j16);
        }
        return new VbriSeeker(jArr3, jArr2, scaleLargeTimestamp, j16);
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j11, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j11 || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i11 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i11], this.positions[i11]));
    }

    public long getTimeUs(long j11) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j11, true, true)];
    }

    public boolean isSeekable() {
        return true;
    }
}
