package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;

    public static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
            byteBuffer2.order(ByteOrder.BIG_ENDIAN);
        }

        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() >= 1) {
                return (short) (this.byteBuffer.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public int read(byte[] bArr, int i11) {
            int min = Math.min(i11, this.byteBuffer.remaining());
            if (min == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            return min;
        }

        public long skip(long j11) {
            int min = (int) Math.min((long) this.byteBuffer.remaining(), j11);
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position(byteBuffer2.position() + min);
            return (long) min;
        }
    }

    public static final class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i11) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i11);
        }

        private boolean isAvailable(int i11, int i12) {
            return this.data.remaining() - i11 >= i12;
        }

        public short getInt16(int i11) {
            if (isAvailable(i11, 2)) {
                return this.data.getShort(i11);
            }
            return -1;
        }

        public int getInt32(int i11) {
            if (isAvailable(i11, 4)) {
                return this.data.getInt(i11);
            }
            return -1;
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i11) throws IOException;

        long skip(long j11) throws IOException;
    }

    public static final class StreamReader implements Reader {

        /* renamed from: is  reason: collision with root package name */
        private final InputStream f44196is;

        public StreamReader(InputStream inputStream) {
            this.f44196is = inputStream;
        }

        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        public short getUInt8() throws IOException {
            int read = this.f44196is.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public int read(byte[] bArr, int i11) throws IOException {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11 && (i13 = this.f44196is.read(bArr, i12, i11 - i12)) != -1) {
                i12 += i13;
            }
            if (i12 != 0 || i13 != -1) {
                return i12;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j11) throws IOException {
            if (j11 < 0) {
                return 0;
            }
            long j12 = j11;
            while (j12 > 0) {
                long skip = this.f44196is.skip(j12);
                if (skip <= 0) {
                    if (this.f44196is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j12 -= skip;
            }
            return j11 - j12;
        }
    }

    private static int calcTagOffset(int i11, int i12) {
        return i11 + 2 + (i12 * 12);
    }

    private static boolean handles(int i11) {
        return (i11 & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i11 == MOTOROLA_TIFF_MAGIC_NUMBER || i11 == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i11) {
        boolean z11;
        if (bArr == null || i11 <= JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            int i12 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i12 >= bArr2.length) {
                    break;
                } else if (bArr[i12] != bArr2[i12]) {
                    return false;
                } else {
                    i12++;
                }
            }
        }
        return z11;
    }

    private int moveToExifSegmentAndGetLength(Reader reader) throws IOException {
        short uInt8;
        int uInt16;
        long j11;
        long skip;
        do {
            short uInt82 = reader.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown segmentId=");
                    sb2.append(uInt82);
                }
                return -1;
            }
            uInt8 = reader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt8 == MARKER_EOI) {
                Log.isLoggable(TAG, 3);
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                return uInt16;
            }
            j11 = (long) uInt16;
            skip = reader.skip(j11);
        } while (skip == j11);
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to skip enough data, type: ");
            sb3.append(uInt8);
            sb3.append(", wanted to skip: ");
            sb3.append(uInt16);
            sb3.append(", but actually skipped: ");
            sb3.append(skip);
        }
        return -1;
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i11) throws IOException {
        int read = reader.read(bArr, i11);
        if (read != i11) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to read exif segment data, length: ");
                sb2.append(i11);
                sb2.append(", actually read: ");
                sb2.append(read);
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i11)) {
            return parseExifSegment(new RandomAccessReader(bArr, i11));
        } else {
            Log.isLoggable(TAG, 3);
            return -1;
        }
    }

    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation((Reader) new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType((Reader) new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType((Reader) new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.getType(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation((Reader) new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (int16 != MOTOROLA_TIFF_MAGIC_NUMBER) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown endianness = ");
                sb2.append(int16);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i11 = 0; i11 < int162; i11++) {
            int calcTagOffset = calcTagOffset(int32, i11);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 < 0) {
                        Log.isLoggable(TAG, 3);
                    } else {
                        if (Log.isLoggable(TAG, 3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Got tagIndex=");
                            sb3.append(i11);
                            sb3.append(" tagType=");
                            sb3.append(int163);
                            sb3.append(" formatCode=");
                            sb3.append(int164);
                            sb3.append(" componentCount=");
                            sb3.append(int322);
                        }
                        int i12 = int322 + BYTES_PER_FORMAT[int164];
                        if (i12 <= 4) {
                            int i13 = calcTagOffset + 8;
                            if (i13 < 0 || i13 > randomAccessReader.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal tagValueOffset=");
                                    sb4.append(i13);
                                    sb4.append(" tagType=");
                                    sb4.append(int163);
                                }
                            } else if (i12 >= 0 && i12 + i13 <= randomAccessReader.length()) {
                                return randomAccessReader.getInt16(i13);
                            } else {
                                if (Log.isLoggable(TAG, 3)) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Illegal number of bytes for TI tag data tagType=");
                                    sb5.append(int163);
                                }
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb6.append(int164);
                        }
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Got invalid format code = ");
                    sb7.append(int164);
                }
            }
        }
        return -1;
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) throws IOException {
        byte[] bArr;
        try {
            int uInt16 = reader.getUInt16();
            if (!handles(uInt16)) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parser doesn't handle magic number: ");
                    sb2.append(uInt16);
                }
                return -1;
            }
            int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader);
            if (moveToExifSegmentAndGetLength == -1) {
                Log.isLoggable(TAG, 3);
                return -1;
            }
            bArr = (byte[]) arrayPool.get(moveToExifSegmentAndGetLength, byte[].class);
            int parseExifSegment = parseExifSegment(reader, bArr, moveToExifSegmentAndGetLength);
            arrayPool.put(bArr);
            return parseExifSegment;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th2) {
            arrayPool.put(bArr);
            throw th2;
        }
    }
}
