package org.apache.commons.compress.archivers.dump;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.utils.IOUtils;

class TapeInputStream extends FilterInputStream {
    private static final int RECORD_SIZE = 1024;
    private byte[] blockBuffer = new byte[1024];
    private int blockSize = 1024;
    private long bytesRead;
    private int currBlkIdx = -1;
    private boolean isCompressed;
    private int readOffset = 1024;

    /* renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27580a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE[] r0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27580a = r0
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27580a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.BZLIB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27580a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.dump.TapeInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public TapeInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void readBlock(boolean z11) throws IOException {
        boolean z12;
        if (this.in != null) {
            if (!this.isCompressed || this.currBlkIdx == -1) {
                readFully(this.blockBuffer, 0, this.blockSize);
                this.bytesRead += (long) this.blockSize;
            } else {
                readFully(this.blockBuffer, 0, 4);
                this.bytesRead += 4;
                int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, 0);
                if ((convert32 & 1) == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    readFully(this.blockBuffer, 0, this.blockSize);
                    this.bytesRead += (long) this.blockSize;
                } else {
                    int i11 = (convert32 >> 1) & 7;
                    int i12 = (convert32 >> 4) & 268435455;
                    byte[] readRange = readRange(i12);
                    this.bytesRead += (long) i12;
                    if (!z11) {
                        Arrays.fill(this.blockBuffer, (byte) 0);
                    } else {
                        int i13 = AnonymousClass1.f27580a[DumpArchiveConstants.COMPRESSION_TYPE.find(i11 & 3).ordinal()];
                        if (i13 == 1) {
                            Inflater inflater = new Inflater();
                            try {
                                inflater.setInput(readRange, 0, readRange.length);
                                if (inflater.inflate(this.blockBuffer) == this.blockSize) {
                                    inflater.end();
                                } else {
                                    throw new ShortFileException();
                                }
                            } catch (DataFormatException e11) {
                                throw new DumpArchiveException("Bad data", e11);
                            } catch (Throwable th2) {
                                inflater.end();
                                throw th2;
                            }
                        } else if (i13 == 2) {
                            throw new UnsupportedCompressionAlgorithmException("BZLIB2");
                        } else if (i13 != 3) {
                            throw new UnsupportedCompressionAlgorithmException();
                        } else {
                            throw new UnsupportedCompressionAlgorithmException("LZO");
                        }
                    }
                }
            }
            this.currBlkIdx++;
            this.readOffset = 0;
            return;
        }
        throw new IOException("Input buffer is closed");
    }

    private void readFully(byte[] bArr, int i11, int i12) throws IOException {
        if (IOUtils.readFully(this.in, bArr, i11, i12) < i12) {
            throw new ShortFileException();
        }
    }

    private byte[] readRange(int i11) throws IOException {
        byte[] readRange = IOUtils.readRange(this.in, i11);
        if (readRange.length >= i11) {
            return readRange;
        }
        throw new ShortFileException();
    }

    public int available() throws IOException {
        int i11 = this.readOffset;
        int i12 = this.blockSize;
        if (i11 < i12) {
            return i12 - i11;
        }
        return this.in.available();
    }

    public void close() throws IOException {
        if (this.in != null && this.in != System.in) {
            this.in.close();
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public byte[] peek() throws IOException {
        if (this.readOffset == this.blockSize) {
            try {
                readBlock(true);
            } catch (ShortFileException unused) {
                return null;
            }
        }
        byte[] bArr = new byte[1024];
        System.arraycopy(this.blockBuffer, this.readOffset, bArr, 0, 1024);
        return bArr;
    }

    public int read() throws IOException {
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public byte[] readRecord() throws IOException {
        byte[] bArr = new byte[1024];
        if (-1 != read(bArr, 0, 1024)) {
            return bArr;
        }
        throw new ShortFileException();
    }

    public void resetBlockSize(int i11, boolean z11) throws IOException {
        this.isCompressed = z11;
        if (i11 >= 1) {
            int i12 = i11 * 1024;
            this.blockSize = i12;
            byte[] bArr = this.blockBuffer;
            byte[] bArr2 = new byte[i12];
            this.blockBuffer = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 1024);
            readFully(this.blockBuffer, 1024, this.blockSize - 1024);
            this.currBlkIdx = 0;
            this.readOffset = 1024;
            return;
        }
        throw new IOException("Block with " + i11 + " records found, must be at least 1");
    }

    public long skip(long j11) throws IOException {
        boolean z11;
        long j12 = 0;
        if (j11 % 1024 == 0) {
            while (j12 < j11) {
                int i11 = this.readOffset;
                int i12 = this.blockSize;
                if (i11 == i12) {
                    if (j11 - j12 < ((long) i12)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    try {
                        readBlock(z11);
                    } catch (ShortFileException unused) {
                        return -1;
                    }
                }
                int i13 = this.readOffset;
                long j13 = j11 - j12;
                int i14 = this.blockSize;
                if (((long) i13) + j13 > ((long) i14)) {
                    j13 = ((long) i14) - ((long) i13);
                }
                this.readOffset = (int) (((long) i13) + j13);
                j12 += j13;
            }
            return j12;
        }
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        if (i12 == 0) {
            return 0;
        }
        if (i12 % 1024 == 0) {
            while (i13 < i12) {
                if (this.readOffset == this.blockSize) {
                    try {
                        readBlock(true);
                    } catch (ShortFileException unused) {
                        return -1;
                    }
                }
                int i14 = this.readOffset;
                int i15 = i12 - i13;
                int i16 = i14 + i15;
                int i17 = this.blockSize;
                if (i16 > i17) {
                    i15 = i17 - i14;
                }
                System.arraycopy(this.blockBuffer, i14, bArr, i11, i15);
                this.readOffset += i15;
                i13 += i15;
                i11 += i15;
            }
            return i13;
        }
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }
}
