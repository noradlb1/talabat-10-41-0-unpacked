package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public class SnappyCompressorInputStream extends AbstractLZ77CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private boolean endReached;
    private final int size;
    private State state;
    private int uncompressedBytesRemaining;

    /* renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27721a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State[] r0 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27721a = r0
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.NO_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27721a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.IN_LITERAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27721a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.IN_BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        NO_BLOCK,
        IN_LITERAL,
        IN_BACK_REFERENCE
    }

    public SnappyCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 32768);
    }

    private void fill() throws IOException {
        if (this.uncompressedBytesRemaining == 0) {
            this.endReached = true;
            return;
        }
        int readOneByte = readOneByte();
        if (readOneByte != -1) {
            int i11 = readOneByte & 3;
            if (i11 == 0) {
                int readLiteralLength = readLiteralLength(readOneByte);
                if (readLiteralLength >= 0) {
                    this.uncompressedBytesRemaining -= readLiteralLength;
                    startLiteral((long) readLiteralLength);
                    this.state = State.IN_LITERAL;
                    return;
                }
                throw new IOException("Illegal block with a negative literal size found");
            } else if (i11 == 1) {
                int i12 = ((readOneByte >> 2) & 7) + 4;
                if (i12 >= 0) {
                    this.uncompressedBytesRemaining -= i12;
                    int i13 = (readOneByte & 224) << 3;
                    int readOneByte2 = readOneByte();
                    if (readOneByte2 != -1) {
                        try {
                            startBackReference(i13 | readOneByte2, (long) i12);
                            this.state = State.IN_BACK_REFERENCE;
                        } catch (IllegalArgumentException e11) {
                            throw new IOException("Illegal block with bad offset found", e11);
                        }
                    } else {
                        throw new IOException("Premature end of stream reading back-reference length");
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            } else if (i11 == 2) {
                int i14 = (readOneByte >> 2) + 1;
                if (i14 >= 0) {
                    this.uncompressedBytesRemaining -= i14;
                    try {
                        startBackReference((int) ByteUtils.fromLittleEndian(this.supplier, 2), (long) i14);
                        this.state = State.IN_BACK_REFERENCE;
                    } catch (IllegalArgumentException e12) {
                        throw new IOException("Illegal block with bad offset found", e12);
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            } else if (i11 == 3) {
                int i15 = (readOneByte >> 2) + 1;
                if (i15 >= 0) {
                    this.uncompressedBytesRemaining -= i15;
                    try {
                        startBackReference(((int) ByteUtils.fromLittleEndian(this.supplier, 4)) & Integer.MAX_VALUE, (long) i15);
                        this.state = State.IN_BACK_REFERENCE;
                    } catch (IllegalArgumentException e13) {
                        throw new IOException("Illegal block with bad offset found", e13);
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            }
        } else {
            throw new IOException("Premature end of stream reading block start");
        }
    }

    private int readLiteralLength(int i11) throws IOException {
        long j11;
        int i12 = i11 >> 2;
        switch (i12) {
            case 60:
                i12 = readOneByte();
                if (i12 == -1) {
                    throw new IOException("Premature end of stream reading literal length");
                }
                break;
            case 61:
                j11 = ByteUtils.fromLittleEndian(this.supplier, 2);
                break;
            case 62:
                j11 = ByteUtils.fromLittleEndian(this.supplier, 3);
                break;
            case 63:
                j11 = ByteUtils.fromLittleEndian(this.supplier, 4);
                break;
        }
        i12 = (int) j11;
        return i12 + 1;
    }

    private long readSize() throws IOException {
        int i11 = 0;
        long j11 = 0;
        while (true) {
            int readOneByte = readOneByte();
            if (readOneByte != -1) {
                int i12 = i11 + 1;
                j11 |= (long) ((readOneByte & 127) << (i11 * 7));
                if ((readOneByte & 128) == 0) {
                    return j11;
                }
                i11 = i12;
            } else {
                throw new IOException("Premature end of stream reading size");
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        if (this.endReached) {
            return -1;
        }
        int i13 = AnonymousClass1.f27721a[this.state.ordinal()];
        if (i13 == 1) {
            fill();
            return read(bArr, i11, i12);
        } else if (i13 == 2) {
            int readLiteral = readLiteral(bArr, i11, i12);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            if (readLiteral > 0) {
                return readLiteral;
            }
            return read(bArr, i11, i12);
        } else if (i13 == 3) {
            int readBackReference = readBackReference(bArr, i11, i12);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            if (readBackReference > 0) {
                return readBackReference;
            }
            return read(bArr, i11, i12);
        } else {
            throw new IOException("Unknown stream state " + this.state);
        }
    }

    public SnappyCompressorInputStream(InputStream inputStream, int i11) throws IOException {
        super(inputStream, i11);
        this.state = State.NO_BLOCK;
        int readSize = (int) readSize();
        this.size = readSize;
        this.uncompressedBytesRemaining = readSize;
    }
}
