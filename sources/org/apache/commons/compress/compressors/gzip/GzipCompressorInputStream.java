package org.apache.commons.compress.compressors.gzip;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class GzipCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final byte[] buf;
    private int bufUsed;
    private final CountingInputStream countingStream;
    private final CRC32 crc;
    private final boolean decompressConcatenated;
    private boolean endReached;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27712in;
    private Inflater inf;
    private final byte[] oneByte;
    private final GzipParameters parameters;

    public GzipCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private boolean init(boolean z11) throws IOException {
        String str;
        int read = this.f27712in.read();
        if (read == -1 && !z11) {
            return false;
        }
        if (read == 31 && this.f27712in.read() == 139) {
            DataInputStream dataInputStream = new DataInputStream(this.f27712in);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte == 8) {
                int readUnsignedByte2 = dataInputStream.readUnsignedByte();
                if ((readUnsignedByte2 & 224) == 0) {
                    this.parameters.setModificationTime(ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) * 1000);
                    int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                    if (readUnsignedByte3 == 2) {
                        this.parameters.setCompressionLevel(9);
                    } else if (readUnsignedByte3 == 4) {
                        this.parameters.setCompressionLevel(1);
                    }
                    this.parameters.setOperatingSystem(dataInputStream.readUnsignedByte());
                    if ((readUnsignedByte2 & 4) != 0) {
                        int readUnsignedByte4 = (dataInputStream.readUnsignedByte() << 8) | dataInputStream.readUnsignedByte();
                        while (true) {
                            int i11 = readUnsignedByte4 - 1;
                            if (readUnsignedByte4 <= 0) {
                                break;
                            }
                            dataInputStream.readUnsignedByte();
                            readUnsignedByte4 = i11;
                        }
                    }
                    if ((readUnsignedByte2 & 8) != 0) {
                        this.parameters.setFilename(new String(readToNull(dataInputStream), StandardCharsets.ISO_8859_1));
                    }
                    if ((readUnsignedByte2 & 16) != 0) {
                        this.parameters.setComment(new String(readToNull(dataInputStream), StandardCharsets.ISO_8859_1));
                    }
                    if ((readUnsignedByte2 & 2) != 0) {
                        dataInputStream.readShort();
                    }
                    this.inf.reset();
                    this.crc.reset();
                    return true;
                }
                throw new IOException("Reserved flags are set in the .gz header");
            }
            throw new IOException("Unsupported compression method " + readUnsignedByte + " in the .gz header");
        }
        if (z11) {
            str = "Input is not in the .gz format";
        } else {
            str = "Garbage after a valid .gz stream";
        }
        throw new IOException(str);
    }

    public static boolean matches(byte[] bArr, int i11) {
        return i11 >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] readToNull(java.io.DataInput r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0005:
            int r1 = r2.readUnsignedByte()     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x000f
            r0.write(r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0005
        L_0x000f:
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0017 }
            r0.close()
            return r2
        L_0x0017:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x0022:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream.readToNull(java.io.DataInput):byte[]");
    }

    public void close() throws IOException {
        Inflater inflater = this.inf;
        if (inflater != null) {
            inflater.end();
            this.inf = null;
        }
        InputStream inputStream = this.f27712in;
        if (inputStream != System.in) {
            inputStream.close();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public GzipParameters getMetaData() {
        return this.parameters;
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public GzipCompressorInputStream(InputStream inputStream, boolean z11) throws IOException {
        this.buf = new byte[8192];
        this.inf = new Inflater(true);
        this.crc = new CRC32();
        this.oneByte = new byte[1];
        this.parameters = new GzipParameters();
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (countingInputStream.markSupported()) {
            this.f27712in = countingInputStream;
        } else {
            this.f27712in = new BufferedInputStream(countingInputStream);
        }
        this.decompressConcatenated = z11;
        init(true);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        if (this.endReached) {
            return -1;
        }
        int i13 = 0;
        while (i12 > 0) {
            if (this.inf.needsInput()) {
                this.f27712in.mark(this.buf.length);
                int read = this.f27712in.read(this.buf);
                this.bufUsed = read;
                if (read != -1) {
                    this.inf.setInput(this.buf, 0, read);
                } else {
                    throw new EOFException();
                }
            }
            try {
                int inflate = this.inf.inflate(bArr, i11, i12);
                this.crc.update(bArr, i11, inflate);
                i11 += inflate;
                i12 -= inflate;
                i13 += inflate;
                count(inflate);
                if (this.inf.finished()) {
                    this.f27712in.reset();
                    long remaining = (long) (this.bufUsed - this.inf.getRemaining());
                    if (IOUtils.skip(this.f27712in, remaining) == remaining) {
                        this.bufUsed = 0;
                        DataInputStream dataInputStream = new DataInputStream(this.f27712in);
                        if (ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) != this.crc.getValue()) {
                            throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
                        } else if (ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) != (this.inf.getBytesWritten() & 4294967295L)) {
                            throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
                        } else if (!this.decompressConcatenated || !init(false)) {
                            this.inf.end();
                            this.inf = null;
                            this.endReached = true;
                            if (i13 == 0) {
                                return -1;
                            }
                            return i13;
                        }
                    } else {
                        throw new IOException();
                    }
                }
            } catch (DataFormatException unused) {
                throw new IOException("Gzip-compressed data is corrupt");
            }
        }
        return i13;
    }
}
