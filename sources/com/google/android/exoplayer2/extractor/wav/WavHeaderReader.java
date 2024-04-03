package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";

    public static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;

        /* renamed from: id  reason: collision with root package name */
        public final int f34936id;
        public final long size;

        private ChunkHeader(int i11, long j11) {
            this.f34936id = i11;
            this.size = j11;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    private WavHeaderReader() {
    }

    public static boolean checkFileType(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i11 = ChunkHeader.peek(extractorInput, parsableByteArray).f34936id;
        if (i11 != 1380533830 && i11 != 1380333108) {
            return false;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt == 1463899717) {
            return true;
        }
        Log.e(TAG, "Unsupported form type: " + readInt);
        return false;
    }

    public static WavFormat readFormat(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        byte[] bArr;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        ChunkHeader skipToChunk = skipToChunk(WavUtil.FMT_FOURCC, extractorInput, parsableByteArray);
        if (skipToChunk.size >= 16) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
        parsableByteArray.setPosition(0);
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i11 = ((int) skipToChunk.size) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            extractorInput.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
        return new WavFormat(readLittleEndianUnsignedShort, readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, bArr);
    }

    public static long readRf64SampleDataSize(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        if (peek.f34936id != 1685272116) {
            extractorInput.resetPeekPosition();
            return -1;
        }
        extractorInput.advancePeekPosition(8);
        parsableByteArray.setPosition(0);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
        long readLittleEndianLong = parsableByteArray.readLittleEndianLong();
        extractorInput.skipFully(((int) peek.size) + 8);
        return readLittleEndianLong;
    }

    private static ChunkHeader skipToChunk(int i11, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.f34936id != i11) {
            Log.w(TAG, "Ignoring unknown WAV chunk: " + peek.f34936id);
            long j11 = peek.size + 8;
            if (j11 <= 2147483647L) {
                extractorInput.skipFully((int) j11);
                peek = ChunkHeader.peek(extractorInput, parsableByteArray);
            } else {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + peek.f34936id);
            }
        }
        return peek;
    }

    public static Pair<Long, Long> skipToSampleData(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        ChunkHeader skipToChunk = skipToChunk(1684108385, extractorInput, new ParsableByteArray(8));
        extractorInput.skipFully(8);
        return Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(skipToChunk.size));
    }
}
