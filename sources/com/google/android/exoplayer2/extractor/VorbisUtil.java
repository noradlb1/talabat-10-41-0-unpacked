package com.google.android.exoplayer2.extractor;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i11, int i12, long[] jArr, int i13, boolean z11) {
            this.dimensions = i11;
            this.entries = i12;
            this.lengthMap = jArr;
            this.lookupType = i13;
            this.isOrdered = z11;
        }
    }

    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i11) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i11;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z11, int i11, int i12, int i13) {
            this.blockFlag = z11;
            this.windowType = i11;
            this.transformType = i12;
            this.mapping = i13;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMaximum;
        public final int bitrateMinimum;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final int sampleRate;
        public final int version;

        public VorbisIdHeader(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11, byte[] bArr) {
            this.version = i11;
            this.channels = i12;
            this.sampleRate = i13;
            this.bitrateMaximum = i14;
            this.bitrateNominal = i15;
            this.bitrateMinimum = i16;
            this.blockSize0 = i17;
            this.blockSize1 = i18;
            this.framingFlag = z11;
            this.data = bArr;
        }
    }

    private VorbisUtil() {
    }

    public static int iLog(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    private static long mapType1QuantValues(long j11, long j12) {
        return (long) Math.floor(Math.pow((double) j11, 1.0d / ((double) j12)));
    }

    @Nullable
    public static Metadata parseVorbisComments(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            String[] splitAtFirst = Util.splitAtFirst(str, "=");
            if (splitAtFirst.length != 2) {
                Log.w(TAG, "Failed to parse Vorbis comment: " + str);
            } else if (splitAtFirst[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new ParsableByteArray(Base64.decode(splitAtFirst[1], 0))));
                } catch (RuntimeException e11) {
                    Log.w(TAG, "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new VorbisComment(splitAtFirst[0], splitAtFirst[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) == 5653314) {
            int readBits = vorbisBitArray.readBits(16);
            int readBits2 = vorbisBitArray.readBits(24);
            long[] jArr = new long[readBits2];
            boolean readBit = vorbisBitArray.readBit();
            long j11 = 0;
            if (!readBit) {
                boolean readBit2 = vorbisBitArray.readBit();
                for (int i11 = 0; i11 < readBits2; i11++) {
                    if (!readBit2) {
                        jArr[i11] = (long) (vorbisBitArray.readBits(5) + 1);
                    } else if (vorbisBitArray.readBit()) {
                        jArr[i11] = (long) (vorbisBitArray.readBits(5) + 1);
                    } else {
                        jArr[i11] = 0;
                    }
                }
            } else {
                int readBits3 = vorbisBitArray.readBits(5) + 1;
                int i12 = 0;
                while (i12 < readBits2) {
                    int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i12));
                    for (int i13 = 0; i13 < readBits4 && i12 < readBits2; i13++) {
                        jArr[i12] = (long) readBits3;
                        i12++;
                    }
                    readBits3++;
                }
            }
            int readBits5 = vorbisBitArray.readBits(4);
            if (readBits5 <= 2) {
                if (readBits5 == 1 || readBits5 == 2) {
                    vorbisBitArray.skipBits(32);
                    vorbisBitArray.skipBits(32);
                    int readBits6 = vorbisBitArray.readBits(4) + 1;
                    vorbisBitArray.skipBits(1);
                    if (readBits5 != 1) {
                        j11 = ((long) readBits2) * ((long) readBits);
                    } else if (readBits != 0) {
                        j11 = mapType1QuantValues((long) readBits2, (long) readBits);
                    }
                    vorbisBitArray.skipBits((int) (j11 * ((long) readBits6)));
                }
                return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
            }
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + readBits5, (Throwable) null);
        }
        throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition(), (Throwable) null);
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i11 = 0; i11 < readBits; i11++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits3 = vorbisBitArray.readBits(4) + 1;
                for (int i12 = 0; i12 < readBits3; i12++) {
                    vorbisBitArray.skipBits(8);
                }
            } else if (readBits2 == 1) {
                int readBits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[readBits4];
                int i13 = -1;
                for (int i14 = 0; i14 < readBits4; i14++) {
                    int readBits5 = vorbisBitArray.readBits(4);
                    iArr[i14] = readBits5;
                    if (readBits5 > i13) {
                        i13 = readBits5;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = vorbisBitArray.readBits(3) + 1;
                    int readBits6 = vorbisBitArray.readBits(2);
                    if (readBits6 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i17 = 0; i17 < (1 << readBits6); i17++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int readBits7 = vorbisBitArray.readBits(4);
                int i18 = 0;
                int i19 = 0;
                for (int i21 = 0; i21 < readBits4; i21++) {
                    i18 += iArr2[iArr[i21]];
                    while (i19 < i18) {
                        vorbisBitArray.skipBits(readBits7);
                        i19++;
                    }
                }
            } else {
                throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + readBits2, (Throwable) null);
            }
        }
    }

    private static void readMappings(int i11, VorbisBitArray vorbisBitArray) throws ParserException {
        int i12;
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i13 = 0; i13 < readBits; i13++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                Log.e(TAG, "mapping type other than 0 not supported: " + readBits2);
            } else {
                if (vorbisBitArray.readBit()) {
                    i12 = vorbisBitArray.readBits(4) + 1;
                } else {
                    i12 = 1;
                }
                if (vorbisBitArray.readBit()) {
                    int readBits3 = vorbisBitArray.readBits(8) + 1;
                    for (int i14 = 0; i14 < readBits3; i14++) {
                        int i15 = i11 - 1;
                        vorbisBitArray.skipBits(iLog(i15));
                        vorbisBitArray.skipBits(iLog(i15));
                    }
                }
                if (vorbisBitArray.readBits(2) == 0) {
                    if (i12 > 1) {
                        for (int i16 = 0; i16 < i11; i16++) {
                            vorbisBitArray.skipBits(4);
                        }
                    }
                    for (int i17 = 0; i17 < i12; i17++) {
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                    }
                } else {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                }
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[readBits];
        for (int i11 = 0; i11 < readBits; i11++) {
            modeArr[i11] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int i11;
        int readBits = vorbisBitArray.readBits(6) + 1;
        int i12 = 0;
        while (i12 < readBits) {
            if (vorbisBitArray.readBits(16) <= 2) {
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                int readBits2 = vorbisBitArray.readBits(6) + 1;
                vorbisBitArray.skipBits(8);
                int[] iArr = new int[readBits2];
                for (int i13 = 0; i13 < readBits2; i13++) {
                    int readBits3 = vorbisBitArray.readBits(3);
                    if (vorbisBitArray.readBit()) {
                        i11 = vorbisBitArray.readBits(5);
                    } else {
                        i11 = 0;
                    }
                    iArr[i13] = (i11 * 8) + readBits3;
                }
                for (int i14 = 0; i14 < readBits2; i14++) {
                    for (int i15 = 0; i15 < 8; i15++) {
                        if ((iArr[i14] & (1 << i15)) != 0) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                }
                i12++;
            } else {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", (Throwable) null);
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        return readVorbisCommentHeader(parsableByteArray, true, true);
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z11 = true;
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt <= 0) {
            readLittleEndianInt = -1;
        }
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt2 <= 0) {
            readLittleEndianInt2 = -1;
        }
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt3 <= 0) {
            readLittleEndianInt3 = -1;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int pow = (int) Math.pow(2.0d, (double) (readUnsignedByte2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((readUnsignedByte2 & PsExtractor.VIDEO_STREAM_MASK) >> 4));
        if ((parsableByteArray.readUnsignedByte() & 1) <= 0) {
            z11 = false;
        }
        return new VorbisIdHeader(readLittleEndianUnsignedIntToInt, readUnsignedByte, readLittleEndianUnsignedIntToInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, pow, pow2, z11, Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i11) throws ParserException {
        int i12 = 0;
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.getData());
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i13 = 0; i13 < readUnsignedByte; i13++) {
            readBook(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        while (i12 < readBits) {
            if (vorbisBitArray.readBits(16) == 0) {
                i12++;
            } else {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i11, vorbisBitArray);
        Mode[] readModes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return readModes;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", (Throwable) null);
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i11, ParsableByteArray parsableByteArray, boolean z11) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + parsableByteArray.bytesLeft(), (Throwable) null);
        } else if (parsableByteArray.readUnsignedByte() != i11) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i11), (Throwable) null);
        } else if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        } else {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected characters 'vorbis'", (Throwable) null);
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray, boolean z11, boolean z12) throws ParserException {
        if (z11) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        }
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = 11 + readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[((int) readLittleEndianUnsignedInt)];
        int i11 = length + 4;
        for (int i12 = 0; ((long) i12) < readLittleEndianUnsignedInt; i12++) {
            String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i12] = readString2;
            i11 = i11 + 4 + readString2.length();
        }
        if (!z12 || (parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, i11 + 1);
        }
        throw ParserException.createForMalformedContainer("framing bit expected to be set", (Throwable) null);
    }
}
