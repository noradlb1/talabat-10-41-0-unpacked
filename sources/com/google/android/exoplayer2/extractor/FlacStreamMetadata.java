package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FlacStreamMetadata {
    public static final int NOT_IN_LOOKUP_TABLE = -1;
    private static final String TAG = "FlacStreamMetadata";
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    @Nullable
    private final Metadata metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    @Nullable
    public final SeekTable seekTable;
    public final long totalSamples;

    public static class SeekTable {
        public final long[] pointOffsets;
        public final long[] pointSampleNumbers;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.pointSampleNumbers = jArr;
            this.pointOffsets = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i11) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.setPosition(i11 * 8);
        this.minBlockSizeSamples = parsableBitArray.readBits(16);
        this.maxBlockSizeSamples = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        int readBits = parsableBitArray.readBits(20);
        this.sampleRate = readBits;
        this.sampleRateLookupKey = getSampleRateLookupKey(readBits);
        this.channels = parsableBitArray.readBits(3) + 1;
        int readBits2 = parsableBitArray.readBits(5) + 1;
        this.bitsPerSample = readBits2;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(readBits2);
        this.totalSamples = parsableBitArray.readBitsToLong(36);
        this.seekTable = null;
        this.metadata = null;
    }

    @Nullable
    private static Metadata concatenateVorbisMetadata(List<String> list, List<PictureFrame> list2) {
        Metadata parseVorbisComments = VorbisUtil.parseVorbisComments(list);
        if (parseVorbisComments != null || !list2.isEmpty()) {
            return new Metadata((List<? extends Metadata.Entry>) list2).copyWithAppendedEntriesFrom(parseVorbisComments);
        }
        return null;
    }

    private static int getBitsPerSampleLookupKey(int i11) {
        if (i11 == 8) {
            return 1;
        }
        if (i11 == 12) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 != 20) {
            return i11 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int getSampleRateLookupKey(int i11) {
        switch (i11) {
            case 8000:
                return 4;
            case AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.SAMPLE_RATE:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata copyWithPictureFrames(List<PictureFrame> list) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(new Metadata((List<? extends Metadata.Entry>) list)));
    }

    public FlacStreamMetadata copyWithSeekTable(@Nullable SeekTable seekTable2) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, seekTable2, this.metadata);
    }

    public FlacStreamMetadata copyWithVorbisComments(List<String> list) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(VorbisUtil.parseVorbisComments(list)));
    }

    public long getApproxBytesPerFrame() {
        long j11;
        long j12;
        long j13;
        int i11 = this.maxFrameSize;
        if (i11 > 0) {
            j12 = (((long) i11) + ((long) this.minFrameSize)) / 2;
            j13 = 1;
        } else {
            int i12 = this.minBlockSizeSamples;
            if (i12 != this.maxBlockSizeSamples || i12 <= 0) {
                j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            } else {
                j11 = (long) i12;
            }
            j12 = ((j11 * ((long) this.channels)) * ((long) this.bitsPerSample)) / 8;
            j13 = 64;
        }
        return j12 + j13;
    }

    public int getDecodedBitrate() {
        return this.bitsPerSample * this.sampleRate * this.channels;
    }

    public long getDurationUs() {
        long j11 = this.totalSamples;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.sampleRate);
    }

    public Format getFormat(byte[] bArr, @Nullable Metadata metadata2) {
        bArr[4] = Byte.MIN_VALUE;
        int i11 = this.maxFrameSize;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_FLAC).setMaxInputSize(i11).setChannelCount(this.channels).setSampleRate(this.sampleRate).setInitializationData(Collections.singletonList(bArr)).setMetadata(getMetadataCopyWithAppendedEntriesFrom(metadata2)).build();
    }

    public int getMaxDecodedFrameSize() {
        return this.maxBlockSizeSamples * this.channels * (this.bitsPerSample / 8);
    }

    @Nullable
    public Metadata getMetadataCopyWithAppendedEntriesFrom(@Nullable Metadata metadata2) {
        Metadata metadata3 = this.metadata;
        return metadata3 == null ? metadata2 : metadata3.copyWithAppendedEntriesFrom(metadata2);
    }

    public long getSampleNumber(long j11) {
        return Util.constrainValue((j11 * ((long) this.sampleRate)) / 1000000, 0, this.totalSamples - 1);
    }

    public FlacStreamMetadata(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, ArrayList<String> arrayList, ArrayList<PictureFrame> arrayList2) {
        this(i11, i12, i13, i14, i15, i16, i17, j11, (SeekTable) null, concatenateVorbisMetadata(arrayList, arrayList2));
    }

    private FlacStreamMetadata(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, @Nullable SeekTable seekTable2, @Nullable Metadata metadata2) {
        this.minBlockSizeSamples = i11;
        this.maxBlockSizeSamples = i12;
        this.minFrameSize = i13;
        this.maxFrameSize = i14;
        this.sampleRate = i15;
        this.sampleRateLookupKey = getSampleRateLookupKey(i15);
        this.channels = i16;
        this.bitsPerSample = i17;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(i17);
        this.totalSamples = j11;
        this.seekTable = seekTable2;
        this.metadata = metadata2;
    }
}
