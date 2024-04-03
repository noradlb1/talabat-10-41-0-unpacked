package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

public class OpusUtil {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int FULL_CODEC_INITIALIZATION_DATA_BUFFER_COUNT = 3;
    public static final int MAX_BYTES_PER_SECOND = 63750;
    public static final int SAMPLE_RATE = 48000;

    private OpusUtil() {
    }

    public static List<byte[]> buildInitializationData(byte[] bArr) {
        long sampleCountToNanoseconds = sampleCountToNanoseconds((long) getPreSkipSamples(bArr));
        long sampleCountToNanoseconds2 = sampleCountToNanoseconds(3840);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(buildNativeOrderByteArray(sampleCountToNanoseconds));
        arrayList.add(buildNativeOrderByteArray(sampleCountToNanoseconds2));
        return arrayList;
    }

    private static byte[] buildNativeOrderByteArray(long j11) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j11).array();
    }

    public static int getChannelCount(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long getPacketDurationUs(byte b11, byte b12) {
        byte b13;
        byte b14 = b11 & 255;
        byte b15 = b14 & 3;
        if (b15 != 0) {
            b13 = 2;
            if (!(b15 == 1 || b15 == 2)) {
                b13 = b12 & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            b13 = 1;
        }
        int i11 = b14 >> 3;
        int i12 = i11 & 3;
        return ((long) b13) * ((long) (i11 >= 16 ? 2500 << i12 : i11 >= 12 ? 10000 << (i12 & 1) : i12 == 3 ? 60000 : 10000 << i12));
    }

    public static long getPacketDurationUs(byte[] bArr) {
        byte b11 = 0;
        byte b12 = bArr[0];
        if (bArr.length > 1) {
            b11 = bArr[1];
        }
        return getPacketDurationUs(b12, b11);
    }

    private static int getPreSkipSamples(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int parsePacketAudioSampleCount(ByteBuffer byteBuffer) {
        byte b11 = 0;
        byte b12 = byteBuffer.get(0);
        if (byteBuffer.limit() > 1) {
            b11 = byteBuffer.get(1);
        }
        return (int) ((getPacketDurationUs(b12, b11) * 48000) / 1000000);
    }

    private static long sampleCountToNanoseconds(long j11) {
        return (j11 * C.NANOS_PER_SECOND) / 48000;
    }
}
