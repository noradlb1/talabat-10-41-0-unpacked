package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import x7.a;

public final class Id3Decoder extends SimpleMetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final FramePredicate NO_FRAMES_PREDICATE = new a();
    private static final String TAG = "Id3Decoder";
    @Nullable
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i11, int i12, int i13, int i14, int i15);
    }

    public static final class Id3Header {
        /* access modifiers changed from: private */
        public final int framesSize;
        /* access modifiers changed from: private */
        public final boolean isUnsynchronized;
        /* access modifiers changed from: private */
        public final int majorVersion;

        public Id3Header(int i11, boolean z11, int i12) {
            this.majorVersion = i11;
            this.isUnsynchronized = z11;
            this.framesSize = i12;
        }
    }

    public Id3Decoder() {
        this((FramePredicate) null);
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i11, int i12) {
        if (i12 <= i11) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(bArr, i11, i12);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i11, int i12) {
        int i13;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(readUnsignedByte);
        int i14 = i11 - 1;
        byte[] bArr = new byte[i14];
        parsableByteArray.readBytes(bArr, 0, i14);
        if (i12 == 2) {
            str = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, Charsets.ISO_8859_1));
            if ("image/jpg".equals(str)) {
                str = MimeTypes.IMAGE_JPEG;
            }
            i13 = 2;
        } else {
            i13 = indexOfZeroByte(bArr, 0);
            String lowerCase = Ascii.toLowerCase(new String(bArr, 0, i13, Charsets.ISO_8859_1));
            if (lowerCase.indexOf(47) == -1) {
                str = "image/" + lowerCase;
            } else {
                str = lowerCase;
            }
        }
        int i15 = i13 + 2;
        int indexOfTerminator = indexOfTerminator(bArr, i15, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i15, indexOfTerminator - i15, charset), bArr[i13 + 1] & 255, copyOfRangeIfValid(bArr, indexOfTerminator + delimiterLength(readUnsignedByte), i14));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i11, String str) {
        byte[] bArr = new byte[i11];
        parsableByteArray.readBytes(bArr, 0, i11);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i11, int i12, boolean z11, int i13, @Nullable FramePredicate framePredicate2) {
        long j11;
        long j12;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, indexOfZeroByte - position, Charsets.ISO_8859_1);
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            j11 = -1;
        } else {
            j11 = readUnsignedInt;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            j12 = -1;
        } else {
            j12 = readUnsignedInt2;
        }
        ArrayList arrayList = new ArrayList();
        int i14 = position + i11;
        while (parsableByteArray.getPosition() < i14) {
            Id3Frame decodeFrame = decodeFrame(i12, parsableByteArray, z11, i13, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new ChapterFrame(str, readInt, readInt2, j11, j12, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i11, int i12, boolean z11, int i13, @Nullable FramePredicate framePredicate2) {
        boolean z12;
        boolean z13;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, indexOfZeroByte - position, Charsets.ISO_8859_1);
        parsableByteArray2.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 2) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if ((readUnsignedByte & 1) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i14 = 0; i14 < readUnsignedByte2; i14++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.getData(), position2);
            strArr[i14] = new String(parsableByteArray.getData(), position2, indexOfZeroByte2 - position2, Charsets.ISO_8859_1);
            parsableByteArray2.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = position + i11;
        while (parsableByteArray.getPosition() < i15) {
            Id3Frame decodeFrame = decodeFrame(i12, parsableByteArray2, z11, i13, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new ChapterTocFrame(str, z12, z13, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i11) {
        if (i11 < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        parsableByteArray.readBytes(bArr2, 0, i12);
        int indexOfTerminator = indexOfTerminator(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfTerminator, charset);
        int delimiterLength = indexOfTerminator + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfTerminator(bArr2, delimiterLength, readUnsignedByte), charset));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0190, code lost:
        if (r13 == 67) goto L_0x0192;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r19, com.google.android.exoplayer2.util.ParsableByteArray r20, boolean r21, int r22, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r23) {
        /*
            r0 = r19
            r7 = r20
            int r8 = r20.readUnsignedByte()
            int r9 = r20.readUnsignedByte()
            int r10 = r20.readUnsignedByte()
            r12 = 3
            if (r0 < r12) goto L_0x0019
            int r1 = r20.readUnsignedByte()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r0 != r14) goto L_0x003c
            int r1 = r20.readUnsignedIntToInt()
            if (r21 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r0 != r12) goto L_0x0043
            int r1 = r20.readUnsignedIntToInt()
            goto L_0x003a
        L_0x0043:
            int r1 = r20.readUnsignedInt24()
            goto L_0x003a
        L_0x0048:
            if (r0 < r12) goto L_0x0050
            int r1 = r20.readUnsignedShort()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r8 != 0) goto L_0x0067
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r20.limit()
            r7.setPosition(r0)
            return r16
        L_0x0067:
            int r1 = r20.getPosition()
            int r5 = r1 + r15
            int r1 = r20.limit()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.exoplayer2.util.Log.w(r4, r0)
            int r0 = r20.limit()
            r7.setPosition(r0)
            return r16
        L_0x0082:
            if (r23 == 0) goto L_0x009a
            r1 = r23
            r2 = r19
            r3 = r8
            r11 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            r18 = r6
            r6 = r13
            boolean r1 = r1.evaluate(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r7.setPosition(r14)
            return r16
        L_0x009a:
            r11 = r4
            r14 = r5
            r18 = r6
        L_0x009e:
            r1 = 1
            if (r0 != r12) goto L_0x00bc
            r2 = r18
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00a9
            r3 = r1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b0
            r4 = r1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00b7
            r2 = r1
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            r17 = r3
            r6 = 0
            goto L_0x00f2
        L_0x00bc:
            r2 = r18
            r3 = 4
            if (r0 != r3) goto L_0x00ec
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00c7
            r3 = r1
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00ce
            r4 = r1
            goto L_0x00cf
        L_0x00ce:
            r4 = 0
        L_0x00cf:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00d5
            r5 = r1
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00dc
            r6 = r1
            goto L_0x00dd
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e3
            r17 = r1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            r2 = r3
            r3 = r17
            r17 = r4
            r4 = r5
            goto L_0x00f2
        L_0x00ec:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r17 = 0
        L_0x00f2:
            if (r17 != 0) goto L_0x021c
            if (r4 == 0) goto L_0x00f8
            goto L_0x021c
        L_0x00f8:
            if (r2 == 0) goto L_0x00ff
            int r15 = r15 + -1
            r7.skipBytes(r1)
        L_0x00ff:
            if (r3 == 0) goto L_0x0107
            int r15 = r15 + -4
            r1 = 4
            r7.skipBytes(r1)
        L_0x0107:
            if (r6 == 0) goto L_0x010d
            int r15 = removeUnsynchronization(r7, r15)
        L_0x010d:
            r1 = 84
            r2 = 2
            r3 = 88
            if (r8 != r1) goto L_0x0122
            if (r9 != r3) goto L_0x0122
            if (r10 != r3) goto L_0x0122
            if (r0 == r2) goto L_0x011c
            if (r13 != r3) goto L_0x0122
        L_0x011c:
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = decodeTxxxFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0122:
            if (r8 != r1) goto L_0x0131
            java.lang.String r1 = getFrameId(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = decodeTextInformationFrame(r7, r15, r1)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x012e:
            r0 = move-exception
            goto L_0x0218
        L_0x0131:
            r4 = 87
            if (r8 != r4) goto L_0x0143
            if (r9 != r3) goto L_0x0143
            if (r10 != r3) goto L_0x0143
            if (r0 == r2) goto L_0x013d
            if (r13 != r3) goto L_0x0143
        L_0x013d:
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = decodeWxxxFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0143:
            if (r8 != r4) goto L_0x014f
            java.lang.String r1 = getFrameId(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = decodeUrlLinkFrame(r7, r15, r1)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x014f:
            r3 = 73
            r4 = 80
            if (r8 != r4) goto L_0x0165
            r5 = 82
            if (r9 != r5) goto L_0x0165
            if (r10 != r3) goto L_0x0165
            r5 = 86
            if (r13 != r5) goto L_0x0165
            com.google.android.exoplayer2.metadata.id3.PrivFrame r1 = decodePrivFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0165:
            r5 = 71
            r6 = 79
            if (r8 != r5) goto L_0x017d
            r5 = 69
            if (r9 != r5) goto L_0x017d
            if (r10 != r6) goto L_0x017d
            r5 = 66
            if (r13 == r5) goto L_0x0177
            if (r0 != r2) goto L_0x017d
        L_0x0177:
            com.google.android.exoplayer2.metadata.id3.GeobFrame r1 = decodeGeobFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x017d:
            r5 = 65
            r12 = 67
            if (r0 != r2) goto L_0x018a
            if (r8 != r4) goto L_0x0198
            if (r9 != r3) goto L_0x0198
            if (r10 != r12) goto L_0x0198
            goto L_0x0192
        L_0x018a:
            if (r8 != r5) goto L_0x0198
            if (r9 != r4) goto L_0x0198
            if (r10 != r3) goto L_0x0198
            if (r13 != r12) goto L_0x0198
        L_0x0192:
            com.google.android.exoplayer2.metadata.id3.ApicFrame r1 = decodeApicFrame(r7, r15, r0)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0198:
            r3 = 77
            if (r8 != r12) goto L_0x01a9
            if (r9 != r6) goto L_0x01a9
            if (r10 != r3) goto L_0x01a9
            if (r13 == r3) goto L_0x01a4
            if (r0 != r2) goto L_0x01a9
        L_0x01a4:
            com.google.android.exoplayer2.metadata.id3.CommentFrame r1 = decodeCommentFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01a9:
            if (r8 != r12) goto L_0x01c3
            r2 = 72
            if (r9 != r2) goto L_0x01c3
            if (r10 != r5) goto L_0x01c3
            if (r13 != r4) goto L_0x01c3
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r1 = decodeChapterFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01c3:
            if (r8 != r12) goto L_0x01db
            if (r9 != r1) goto L_0x01db
            if (r10 != r6) goto L_0x01db
            if (r13 != r12) goto L_0x01db
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r1 = decodeChapterTOCFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01db:
            if (r8 != r3) goto L_0x01ea
            r2 = 76
            if (r9 != r2) goto L_0x01ea
            if (r10 != r2) goto L_0x01ea
            if (r13 != r1) goto L_0x01ea
            com.google.android.exoplayer2.metadata.id3.MlltFrame r1 = decodeMlltFrame(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01ea:
            java.lang.String r1 = getFrameId(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r1 = decodeBinaryFrame(r7, r15, r1)     // Catch:{ all -> 0x012e }
        L_0x01f2:
            if (r1 != 0) goto L_0x0214
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
            r2.<init>()     // Catch:{ all -> 0x012e }
            java.lang.String r3 = "Failed to decode frame: id="
            r2.append(r3)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = getFrameId(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            r2.append(r0)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ all -> 0x012e }
            r2.append(r15)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.util.Log.w(r11, r0)     // Catch:{ all -> 0x012e }
        L_0x0214:
            r7.setPosition(r14)
            return r1
        L_0x0218:
            r7.setPosition(r14)
            throw r0
        L_0x021c:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.exoplayer2.util.Log.w(r11, r0)
            r7.setPosition(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i11) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(readUnsignedByte);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        parsableByteArray.readBytes(bArr, 0, i12);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, Charsets.ISO_8859_1);
        int i13 = indexOfZeroByte + 1;
        int indexOfTerminator = indexOfTerminator(bArr, i13, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i13, indexOfTerminator, charset);
        int delimiterLength = indexOfTerminator + delimiterLength(readUnsignedByte);
        int indexOfTerminator2 = indexOfTerminator(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfTerminator2, charset), copyOfRangeIfValid(bArr, indexOfTerminator2 + delimiterLength(readUnsignedByte), i12));
    }

    @Nullable
    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        boolean z15 = false;
        if (readUnsignedInt24 != 4801587) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", new Object[]{Integer.valueOf(readUnsignedInt24)}));
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        if (readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0) {
            z15 = true;
        }
        return new Id3Header(readUnsignedByte, z15, readSynchSafeInt);
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray parsableByteArray, int i11) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        int readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i12 = ((i11 - 10) * 8) / (readUnsignedByte + readUnsignedByte2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int readBits = parsableBitArray.readBits(readUnsignedByte);
            int readBits2 = parsableBitArray.readBits(readUnsignedByte2);
            iArr[i13] = readBits;
            iArr2[i13] = readBits2;
        }
        return new MlltFrame(readUnsignedShort, readUnsignedInt24, readUnsignedInt242, iArr, iArr2);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i11) {
        byte[] bArr = new byte[i11];
        parsableByteArray.readBytes(bArr, 0, i11);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, Charsets.ISO_8859_1), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i11));
    }

    private static String decodeStringIfValid(byte[] bArr, int i11, int i12, Charset charset) {
        if (i12 <= i11 || i12 > bArr.length) {
            return "";
        }
        return new String(bArr, i11, i12 - i11, charset);
    }

    @Nullable
    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i11, String str) {
        if (i11 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        parsableByteArray.readBytes(bArr, 0, i12);
        return new TextInformationFrame(str, (String) null, (List<String>) decodeTextInformationFrameValues(bArr, readUnsignedByte, 0));
    }

    private static ImmutableList<String> decodeTextInformationFrameValues(byte[] bArr, int i11, int i12) {
        if (i12 >= bArr.length) {
            return ImmutableList.of("");
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int indexOfTerminator = indexOfTerminator(bArr, i12, i11);
        while (i12 < indexOfTerminator) {
            builder.add((Object) new String(bArr, i12, indexOfTerminator - i12, getCharset(i11)));
            i12 = delimiterLength(i11) + indexOfTerminator;
            indexOfTerminator = indexOfTerminator(bArr, i12, i11);
        }
        ImmutableList<String> build = builder.build();
        if (build.isEmpty()) {
            return ImmutableList.of("");
        }
        return build;
    }

    @Nullable
    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i11) {
        if (i11 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        parsableByteArray.readBytes(bArr, 0, i12);
        int indexOfTerminator = indexOfTerminator(bArr, 0, readUnsignedByte);
        return new TextInformationFrame("TXXX", new String(bArr, 0, indexOfTerminator, getCharset(readUnsignedByte)), (List<String>) decodeTextInformationFrameValues(bArr, readUnsignedByte, indexOfTerminator + delimiterLength(readUnsignedByte)));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i11, String str) {
        byte[] bArr = new byte[i11];
        parsableByteArray.readBytes(bArr, 0, i11);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, indexOfZeroByte(bArr, 0), Charsets.ISO_8859_1));
    }

    @Nullable
    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i11) {
        if (i11 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        parsableByteArray.readBytes(bArr, 0, i12);
        int indexOfTerminator = indexOfTerminator(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfTerminator, getCharset(readUnsignedByte));
        int delimiterLength = indexOfTerminator + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), Charsets.ISO_8859_1));
    }

    private static int delimiterLength(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static Charset getCharset(int i11) {
        if (i11 == 1) {
            return Charsets.UTF_16;
        }
        if (i11 == 2) {
            return Charsets.UTF_16BE;
        }
        if (i11 != 3) {
            return Charsets.ISO_8859_1;
        }
        return Charsets.UTF_8;
    }

    private static String getFrameId(int i11, int i12, int i13, int i14, int i15) {
        if (i11 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)});
    }

    private static int indexOfTerminator(byte[] bArr, int i11, int i12) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if ((indexOfZeroByte - i11) % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i11) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int i12 = position;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= position + i11) {
                return i11;
            }
            if ((data[i12] & 255) == 255 && data[i13] == 0) {
                System.arraycopy(data, i12 + 2, data, i13, (i11 - (i12 - position)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098 A[SYNTHETIC, Splitter:B:46:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean validateFrames(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.getPosition()
        L_0x0008:
            int r3 = r18.bytesLeft()     // Catch:{ all -> 0x00af }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.readInt()     // Catch:{ all -> 0x00af }
            long r8 = r18.readUnsignedInt()     // Catch:{ all -> 0x00af }
            int r10 = r18.readUnsignedShort()     // Catch:{ all -> 0x00af }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00af }
            int r8 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00af }
            long r8 = (long) r8
            r10 = r6
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.setPosition(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x004b
            r1.setPosition(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007b
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = r4
            goto L_0x0074
        L_0x0073:
            r3 = r6
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r4 = r6
            goto L_0x008b
        L_0x007b:
            if (r0 != r3) goto L_0x0089
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0083
            r3 = r4
            goto L_0x0084
        L_0x0083:
            r3 = r6
        L_0x0084:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0089:
            r3 = r6
            r4 = r3
        L_0x008b:
            if (r4 == 0) goto L_0x008f
            int r3 = r3 + 4
        L_0x008f:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0098
            r1.setPosition(r2)
            return r6
        L_0x0098:
            int r3 = r18.bytesLeft()     // Catch:{ all -> 0x00af }
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a5
            r1.setPosition(r2)
            return r6
        L_0x00a5:
            int r3 = (int) r8
            r1.skipBytes(r3)     // Catch:{ all -> 0x00af }
            goto L_0x0008
        L_0x00ab:
            r1.setPosition(r2)
            return r4
        L_0x00af:
            r0 = move-exception
            r1.setPosition(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.validateFrames(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    @Nullable
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(@Nullable FramePredicate framePredicate2) {
        this.framePredicate = framePredicate2;
    }

    @Nullable
    public Metadata decode(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i11);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i12 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int access$100 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            access$100 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + access$100);
        boolean z11 = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i12, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i12, true)) {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z11 = true;
        }
        while (parsableByteArray.bytesLeft() >= i12) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z11, i12, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }
}
