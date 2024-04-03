package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class AviStreamHeaderChunk implements AviChunk {
    private static final String TAG = "AviStreamHeaderChunk";
    public final int initialFrames;
    public final int length;
    public final int rate;
    public final int scale;
    public final int streamType;
    public final int suggestedBufferSize;

    private AviStreamHeaderChunk(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.streamType = i11;
        this.initialFrames = i12;
        this.scale = i13;
        this.rate = i14;
        this.length = i15;
        this.suggestedBufferSize = i16;
    }

    public static AviStreamHeaderChunk parseFrom(ParsableByteArray parsableByteArray) {
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(12);
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt4 = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(4);
        int readLittleEndianInt5 = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt6 = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(8);
        return new AviStreamHeaderChunk(readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, readLittleEndianInt4, readLittleEndianInt5, readLittleEndianInt6);
    }

    public long getDurationUs() {
        return Util.scaleLargeTimestamp((long) this.length, ((long) this.scale) * 1000000, (long) this.rate);
    }

    public float getFrameRate() {
        return ((float) this.rate) / ((float) this.scale);
    }

    public int getTrackType() {
        int i11 = this.streamType;
        if (i11 == 1935960438) {
            return 2;
        }
        if (i11 == 1935963489) {
            return 1;
        }
        if (i11 == 1937012852) {
            return 3;
        }
        Log.w(TAG, "Found unsupported streamType fourCC: " + Integer.toHexString(this.streamType));
        return -1;
    }

    public int getType() {
        return AviExtractor.FOURCC_strh;
    }
}
