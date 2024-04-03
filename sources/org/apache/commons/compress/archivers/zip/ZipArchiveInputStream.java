package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, TarConstants.LF_GNUTYPE_LONGLINK, 32, TarConstants.LF_GNUTYPE_SPARSE, 105, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 32, 66, 108, 111, 99, 107, 32, TarConstants.LF_BLK, TarConstants.LF_SYMLINK};
    private static final byte[] CFH = ZipLong.CFH_SIG.getBytes();
    private static final int CFH_LEN = 46;
    private static final byte[] DD = ZipLong.DD_SIG.getBytes();
    private static final byte[] LFH = ZipLong.LFH_SIG.getBytes();
    private static final int LFH_LEN = 30;
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final long TWO_EXP_32 = 4294967296L;
    private static final String USE_ZIPFILE_INSTEAD_OF_STREAM_DISCLAIMER = " while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile";
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    /* access modifiers changed from: private */
    public CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27657in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final boolean skipSplitSig;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    /* renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27658a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.apache.commons.compress.archivers.zip.ZipMethod[] r0 = org.apache.commons.compress.archivers.zip.ZipMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27658a = r0
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.UNSHRINKING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27658a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.IMPLODING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27658a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.BZIP2     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27658a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.ENHANCED_DEFLATED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bufferContainsSignature(java.io.ByteArrayOutputStream r12, int r13, int r14, int r15) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0003:
            if (r1 != 0) goto L_0x00a6
            int r3 = r13 + r14
            int r4 = r3 + -4
            if (r2 >= r4) goto L_0x00a6
            java.nio.ByteBuffer r4 = r11.buf
            byte[] r4 = r4.array()
            byte r4 = r4[r2]
            byte[] r5 = LFH
            byte r6 = r5[r0]
            if (r4 != r6) goto L_0x00a2
            java.nio.ByteBuffer r4 = r11.buf
            byte[] r4 = r4.array()
            int r6 = r2 + 1
            byte r4 = r4[r6]
            r6 = 1
            byte r7 = r5[r6]
            if (r4 != r7) goto L_0x00a2
            r4 = 2
            r7 = 3
            if (r2 < r15) goto L_0x0048
            java.nio.ByteBuffer r8 = r11.buf
            byte[] r8 = r8.array()
            int r9 = r2 + 2
            byte r8 = r8[r9]
            byte r9 = r5[r4]
            if (r8 != r9) goto L_0x0048
            java.nio.ByteBuffer r8 = r11.buf
            byte[] r8 = r8.array()
            int r9 = r2 + 3
            byte r8 = r8[r9]
            byte r5 = r5[r7]
            if (r8 == r5) goto L_0x0066
        L_0x0048:
            java.nio.ByteBuffer r5 = r11.buf
            byte[] r5 = r5.array()
            int r8 = r2 + 2
            byte r5 = r5[r8]
            byte[] r9 = CFH
            byte r10 = r9[r4]
            if (r5 != r10) goto L_0x006b
            java.nio.ByteBuffer r5 = r11.buf
            byte[] r5 = r5.array()
            int r10 = r2 + 3
            byte r5 = r5[r10]
            byte r9 = r9[r7]
            if (r5 != r9) goto L_0x006b
        L_0x0066:
            int r1 = r2 - r15
            r4 = r1
        L_0x0069:
            r1 = r6
            goto L_0x008a
        L_0x006b:
            java.nio.ByteBuffer r5 = r11.buf
            byte[] r5 = r5.array()
            byte r5 = r5[r8]
            byte[] r8 = DD
            byte r4 = r8[r4]
            if (r5 != r4) goto L_0x0089
            java.nio.ByteBuffer r4 = r11.buf
            byte[] r4 = r4.array()
            int r5 = r2 + 3
            byte r4 = r4[r5]
            byte r5 = r8[r7]
            if (r4 != r5) goto L_0x0089
            r4 = r2
            goto L_0x0069
        L_0x0089:
            r4 = r2
        L_0x008a:
            if (r1 == 0) goto L_0x00a2
            java.nio.ByteBuffer r5 = r11.buf
            byte[] r5 = r5.array()
            int r3 = r3 - r4
            r11.pushback(r5, r4, r3)
            java.nio.ByteBuffer r3 = r11.buf
            byte[] r3 = r3.array()
            r12.write(r3, r0, r4)
            r11.readDataDescriptor()
        L_0x00a2:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x00a6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.bufferContainsSignature(java.io.ByteArrayOutputStream, int, int, int):boolean");
    }

    private int cacheBytesRead(ByteArrayOutputStream byteArrayOutputStream, int i11, int i12, int i13) {
        int i14 = i11 + i12;
        int i15 = (i14 - i13) - 3;
        if (i15 <= 0) {
            return i14;
        }
        byteArrayOutputStream.write(this.buf.array(), 0, i15);
        int i16 = i13 + 3;
        System.arraycopy(this.buf.array(), i15, this.buf.array(), 0, i16);
        return i16;
    }

    private static boolean checksig(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private void closeEntry() throws IOException {
        long j11;
        if (this.closed) {
            throw new IOException("The stream is closed");
        } else if (this.current != null) {
            if (currentEntryHasOutstandingBytes()) {
                drainCurrentEntryData();
            } else {
                skip(Long.MAX_VALUE);
                if (this.current.entry.getMethod() == 8) {
                    j11 = getBytesInflated();
                } else {
                    j11 = this.current.bytesRead;
                }
                int k11 = (int) (this.current.bytesReadFromStream - j11);
                if (k11 > 0) {
                    pushback(this.buf.array(), this.buf.limit() - k11, k11);
                    CurrentEntry currentEntry = this.current;
                    long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream - ((long) k11);
                }
                if (currentEntryHasOutstandingBytes()) {
                    drainCurrentEntryData();
                }
            }
            if (this.lastStoredEntry == null && this.current.hasDataDescriptor) {
                readDataDescriptor();
            }
            this.inf.reset();
            this.buf.clear().flip();
            this.current = null;
            this.lastStoredEntry = null;
        }
    }

    private boolean currentEntryHasOutstandingBytes() {
        if (this.current.bytesReadFromStream > this.current.entry.getCompressedSize() || this.current.hasDataDescriptor) {
            return false;
        }
        return true;
    }

    private void drainCurrentEntryData() throws IOException {
        long compressedSize = this.current.entry.getCompressedSize() - this.current.bytesReadFromStream;
        while (compressedSize > 0) {
            long read = (long) this.f27657in.read(this.buf.array(), 0, (int) Math.min((long) this.buf.capacity(), compressedSize));
            if (read >= 0) {
                count(read);
                compressedSize -= read;
            } else {
                throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(this.current.entry.getName()));
            }
        }
    }

    private int fill() throws IOException {
        if (!this.closed) {
            int read = this.f27657in.read(this.buf.array());
            if (read > 0) {
                this.buf.limit(read);
                count(this.buf.limit());
                this.inf.setInput(this.buf.array(), 0, this.buf.limit());
            }
            return read;
        }
        throw new IOException("The stream is closed");
    }

    private boolean findEocdRecord() throws IOException {
        int i11 = -1;
        loop0:
        while (true) {
            boolean z11 = false;
            while (true) {
                if (!z11) {
                    i11 = readOneByte();
                    if (i11 <= -1) {
                        break loop0;
                    }
                }
                if (isFirstByteOfEocdSig(i11)) {
                    i11 = readOneByte();
                    byte[] bArr = ZipArchiveOutputStream.EOCD_SIG;
                    if (i11 == bArr[1]) {
                        i11 = readOneByte();
                        if (i11 == bArr[2]) {
                            i11 = readOneByte();
                            if (i11 == -1) {
                                break loop0;
                            } else if (i11 == bArr[3]) {
                                return true;
                            } else {
                                z11 = isFirstByteOfEocdSig(i11);
                            }
                        } else if (i11 == -1) {
                            break loop0;
                        } else {
                            z11 = isFirstByteOfEocdSig(i11);
                        }
                    } else if (i11 == -1) {
                        break loop0;
                    } else {
                        z11 = isFirstByteOfEocdSig(i11);
                    }
                }
            }
        }
        return false;
    }

    private long getBytesInflated() {
        long bytesRead = this.inf.getBytesRead();
        if (this.current.bytesReadFromStream >= TWO_EXP_32) {
            while (true) {
                long j11 = bytesRead + TWO_EXP_32;
                if (j11 > this.current.bytesReadFromStream) {
                    break;
                }
                bytesRead = j11;
            }
        }
        return bytesRead;
    }

    private boolean isApkSigningBlock(byte[] bArr) throws IOException {
        BigInteger value = ZipEightByteInteger.getValue(bArr);
        long length = (long) (8 - bArr.length);
        byte[] bArr2 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger add = value.add(BigInteger.valueOf(length - ((long) bArr2.length)));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (add.signum() < 0) {
                int length3 = bArr.length + add.intValue();
                if (length3 < 8) {
                    return false;
                }
                int abs = Math.abs(add.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(abs, length2));
                if (abs < length2) {
                    readFully(bArr3, abs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = LONG_MAX;
                    if (add.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    realSkip(Long.MAX_VALUE);
                    add = add.add(bigInteger.negate());
                }
                realSkip(add.longValue());
                readFully(bArr3);
            }
            return Arrays.equals(bArr3, APK_SIGNING_BLOCK_MAGIC);
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean isFirstByteOfEocdSig(int i11) {
        return i11 == ZipArchiveOutputStream.EOCD_SIG[0];
    }

    public static boolean matches(byte[] bArr, int i11) {
        byte[] bArr2 = ZipArchiveOutputStream.LFH_SIG;
        if (i11 < bArr2.length) {
            return false;
        }
        if (checksig(bArr, bArr2) || checksig(bArr, ZipArchiveOutputStream.EOCD_SIG) || checksig(bArr, ZipArchiveOutputStream.DD_SIG) || checksig(bArr, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes())) {
            return true;
        }
        return false;
    }

    private void processZip64Extra(ZipLong zipLong, ZipLong zipLong2) throws ZipException {
        boolean z11;
        ZipExtraField extraField = this.current.entry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (extraField == null || (extraField instanceof Zip64ExtendedInformationExtraField)) {
            Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) extraField;
            CurrentEntry currentEntry = this.current;
            if (zip64ExtendedInformationExtraField != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean unused = currentEntry.usesZip64 = z11;
            if (!this.current.hasDataDescriptor) {
                if (zip64ExtendedInformationExtraField != null) {
                    ZipLong zipLong3 = ZipLong.ZIP64_MAGIC;
                    if (zipLong3.equals(zipLong2) || zipLong3.equals(zipLong)) {
                        if (zip64ExtendedInformationExtraField.getCompressedSize() == null || zip64ExtendedInformationExtraField.getSize() == null) {
                            throw new ZipException("archive contains corrupted zip64 extra field");
                        }
                        long longValue = zip64ExtendedInformationExtraField.getCompressedSize().getLongValue();
                        if (longValue >= 0) {
                            this.current.entry.setCompressedSize(longValue);
                            long longValue2 = zip64ExtendedInformationExtraField.getSize().getLongValue();
                            if (longValue2 >= 0) {
                                this.current.entry.setSize(longValue2);
                                return;
                            }
                            throw new ZipException("broken archive, entry with negative size");
                        }
                        throw new ZipException("broken archive, entry with negative compressed size");
                    }
                }
                if (zipLong2 != null && zipLong != null) {
                    if (zipLong2.getValue() >= 0) {
                        this.current.entry.setCompressedSize(zipLong2.getValue());
                        if (zipLong.getValue() >= 0) {
                            this.current.entry.setSize(zipLong.getValue());
                            return;
                        }
                        throw new ZipException("broken archive, entry with negative size");
                    }
                    throw new ZipException("broken archive, entry with negative compressed size");
                }
                return;
            }
            return;
        }
        throw new ZipException("archive contains unparseable zip64 extra field");
    }

    private void pushback(byte[] bArr, int i11, int i12) throws IOException {
        ((PushbackInputStream) this.f27657in).unread(bArr, i11, i12);
        pushedBackBytes((long) i12);
    }

    private void readDataDescriptor() throws IOException {
        readFully(this.wordBuf);
        ZipLong zipLong = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(zipLong)) {
            readFully(this.wordBuf);
            zipLong = new ZipLong(this.wordBuf);
        }
        this.current.entry.setCrc(zipLong.getValue());
        readFully(this.twoDwordBuf);
        ZipLong zipLong2 = new ZipLong(this.twoDwordBuf, 8);
        if (zipLong2.equals(ZipLong.CFH_SIG) || zipLong2.equals(ZipLong.LFH_SIG)) {
            pushback(this.twoDwordBuf, 8, 8);
            long value = ZipLong.getValue(this.twoDwordBuf);
            if (value >= 0) {
                this.current.entry.setCompressedSize(value);
                long value2 = ZipLong.getValue(this.twoDwordBuf, 4);
                if (value2 >= 0) {
                    this.current.entry.setSize(value2);
                    return;
                }
                throw new ZipException("broken archive, entry with negative size");
            }
            throw new ZipException("broken archive, entry with negative compressed size");
        }
        long longValue = ZipEightByteInteger.getLongValue(this.twoDwordBuf);
        if (longValue >= 0) {
            this.current.entry.setCompressedSize(longValue);
            long longValue2 = ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8);
            if (longValue2 >= 0) {
                this.current.entry.setSize(longValue2);
                return;
            }
            throw new ZipException("broken archive, entry with negative size");
        }
        throw new ZipException("broken archive, entry with negative compressed size");
    }

    private int readDeflated(byte[] bArr, int i11, int i12) throws IOException {
        int readFromInflater = readFromInflater(bArr, i11, i12);
        if (readFromInflater <= 0) {
            if (this.inf.finished()) {
                return -1;
            }
            if (this.inf.needsDictionary()) {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            } else if (readFromInflater == -1) {
                throw new IOException("Truncated ZIP file");
            }
        }
        return readFromInflater;
    }

    private void readFirstLocalFileHeader() throws IOException {
        readFully(this.lfhBuf);
        ZipLong zipLong = new ZipLong(this.lfhBuf);
        if (!this.skipSplitSig && zipLong.equals(ZipLong.DD_SIG)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
        } else if (zipLong.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER) || zipLong.equals(ZipLong.DD_SIG)) {
            byte[] bArr = new byte[4];
            readFully(bArr);
            byte[] bArr2 = this.lfhBuf;
            System.arraycopy(bArr2, 4, bArr2, 0, 26);
            System.arraycopy(bArr, 0, this.lfhBuf, 26, 4);
        }
    }

    private int readFromInflater(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (true) {
            if (this.inf.needsInput()) {
                int fill = fill();
                if (fill > 0) {
                    CurrentEntry currentEntry = this.current;
                    long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream + ((long) this.buf.limit());
                } else if (fill == -1) {
                    return -1;
                }
            }
            try {
                i13 = this.inf.inflate(bArr, i11, i12);
                if (i13 == 0) {
                    if (!this.inf.needsInput()) {
                        break;
                    }
                } else {
                    break;
                }
            } catch (DataFormatException e11) {
                throw ((IOException) new ZipException(e11.getMessage()).initCause(e11));
            }
        }
        return i13;
    }

    private void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0);
    }

    private int readOneByte() throws IOException {
        int read = this.f27657in.read();
        if (read != -1) {
            count(1);
        }
        return read;
    }

    private byte[] readRange(int i11) throws IOException {
        byte[] readRange = IOUtils.readRange(this.f27657in, i11);
        count(readRange.length);
        if (readRange.length >= i11) {
            return readRange;
        }
        throw new EOFException();
    }

    private int readStored(byte[] bArr, int i11, int i12) throws IOException {
        if (this.current.hasDataDescriptor) {
            if (this.lastStoredEntry == null) {
                readStoredEntry();
            }
            return this.lastStoredEntry.read(bArr, i11, i12);
        }
        long size = this.current.entry.getSize();
        if (this.current.bytesRead >= size) {
            return -1;
        }
        if (this.buf.position() >= this.buf.limit()) {
            this.buf.position(0);
            int read = this.f27657in.read(this.buf.array());
            if (read != -1) {
                this.buf.limit(read);
                count(read);
                CurrentEntry currentEntry = this.current;
                long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream + ((long) read);
            } else {
                this.buf.limit(0);
                throw new IOException("Truncated ZIP file");
            }
        }
        int min = Math.min(this.buf.remaining(), i12);
        if (size - this.current.bytesRead < ((long) min)) {
            min = (int) (size - this.current.bytesRead);
        }
        this.buf.get(bArr, i11, min);
        CurrentEntry currentEntry2 = this.current;
        long unused2 = currentEntry2.bytesRead = currentEntry2.bytesRead + ((long) min);
        return min;
    }

    private void readStoredEntry() throws IOException {
        int i11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.current.usesZip64) {
            i11 = 20;
        } else {
            i11 = 12;
        }
        boolean z11 = false;
        int i12 = 0;
        while (!z11) {
            int read = this.f27657in.read(this.buf.array(), i12, 512 - i12);
            if (read > 0) {
                int i13 = read + i12;
                if (i13 < 4) {
                    i12 = i13;
                } else {
                    z11 = bufferContainsSignature(byteArrayOutputStream, i12, read, i11);
                    if (!z11) {
                        i12 = cacheBytesRead(byteArrayOutputStream, i12, read, i11);
                    }
                }
            } else {
                throw new IOException("Truncated ZIP file");
            }
        }
        if (this.current.entry.getCompressedSize() == this.current.entry.getSize()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (((long) byteArray.length) == this.current.entry.getSize()) {
                this.lastStoredEntry = new ByteArrayInputStream(byteArray);
                return;
            }
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
    }

    private void realSkip(long j11) throws IOException {
        long j12 = 0;
        if (j11 >= 0) {
            while (j12 < j11) {
                long j13 = j11 - j12;
                InputStream inputStream = this.f27657in;
                byte[] bArr = this.skipBuf;
                if (((long) bArr.length) <= j13) {
                    j13 = (long) bArr.length;
                }
                int read = inputStream.read(bArr, 0, (int) j13);
                if (read != -1) {
                    count(read);
                    j12 += (long) read;
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private void skipRemainderOfArchive() throws IOException {
        int i11 = this.entriesRead;
        if (i11 > 0) {
            realSkip((((long) i11) * 46) - 30);
            if (findEocdRecord()) {
                realSkip(16);
                readFully(this.shortBuf);
                int value = ZipShort.getValue(this.shortBuf);
                if (value >= 0) {
                    realSkip((long) value);
                    return;
                }
            }
        }
        throw new IOException("Truncated ZIP file");
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getCompressedSize() != -1 || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || (zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() && this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0)) {
            return true;
        }
        return false;
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry zipArchiveEntry) {
        if (!zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() || ((this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0) || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode())) {
            return true;
        }
        return false;
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        if (!ZipUtil.canHandleEntryData(zipArchiveEntry) || !supportsDataDescriptorFor(zipArchiveEntry) || !supportsCompressedSizeFor(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            try {
                this.f27657in.close();
            } finally {
                this.inf.end();
            }
        }
    }

    public long getCompressedCount() {
        if (this.current.entry.getMethod() == 0) {
            return this.current.bytesRead;
        }
        if (this.current.entry.getMethod() == 8) {
            return getBytesInflated();
        }
        if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) {
            return ((UnshrinkingInputStream) this.current.f27661in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode()) {
            return ((ExplodingInputStream) this.current.f27661in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return ((Deflate64CompressorInputStream) this.current.f27661in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return ((BZip2CompressorInputStream) this.current.f27661in).getCompressedCount();
        }
        return -1;
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextZipEntry();
    }

    public ZipArchiveEntry getNextZipEntry() throws IOException {
        boolean z11;
        ZipEncoding zipEncoding2;
        ZipLong zipLong;
        ZipLong zipLong2;
        this.uncompressedCount = 0;
        if (!this.closed && !this.hitCentralDirectory) {
            if (this.current != null) {
                closeEntry();
                z11 = false;
            } else {
                z11 = true;
            }
            long bytesRead = getBytesRead();
            if (z11) {
                try {
                    readFirstLocalFileHeader();
                } catch (EOFException unused) {
                }
            } else {
                readFully(this.lfhBuf);
            }
            ZipLong zipLong3 = new ZipLong(this.lfhBuf);
            if (zipLong3.equals(ZipLong.LFH_SIG)) {
                this.current = new CurrentEntry((AnonymousClass1) null);
                this.current.entry.setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
                GeneralPurposeBit parse = GeneralPurposeBit.parse(this.lfhBuf, 6);
                boolean usesUTF8ForNames = parse.usesUTF8ForNames();
                if (usesUTF8ForNames) {
                    zipEncoding2 = ZipEncodingHelper.UTF8_ZIP_ENCODING;
                } else {
                    zipEncoding2 = this.zipEncoding;
                }
                boolean unused2 = this.current.hasDataDescriptor = parse.usesDataDescriptor();
                this.current.entry.setGeneralPurposeBit(parse);
                this.current.entry.setMethod(ZipShort.getValue(this.lfhBuf, 8));
                this.current.entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
                if (!this.current.hasDataDescriptor) {
                    this.current.entry.setCrc(ZipLong.getValue(this.lfhBuf, 14));
                    zipLong2 = new ZipLong(this.lfhBuf, 18);
                    zipLong = new ZipLong(this.lfhBuf, 22);
                } else {
                    zipLong2 = null;
                    zipLong = null;
                }
                int value = ZipShort.getValue(this.lfhBuf, 26);
                int value2 = ZipShort.getValue(this.lfhBuf, 28);
                byte[] readRange = readRange(value);
                this.current.entry.setName(zipEncoding2.decode(readRange), readRange);
                if (usesUTF8ForNames) {
                    this.current.entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
                }
                try {
                    this.current.entry.setExtra(readRange(value2));
                    if (!usesUTF8ForNames && this.useUnicodeExtraFields) {
                        ZipUtil.setNameAndCommentFromExtraFields(this.current.entry, readRange, (byte[]) null);
                    }
                    processZip64Extra(zipLong, zipLong2);
                    this.current.entry.setLocalHeaderOffset(bytesRead);
                    this.current.entry.setDataOffset(getBytesRead());
                    this.current.entry.setStreamContiguous(true);
                    ZipMethod methodByCode = ZipMethod.getMethodByCode(this.current.entry.getMethod());
                    if (this.current.entry.getCompressedSize() != -1) {
                        if (!(!ZipUtil.canHandleEntryData(this.current.entry) || methodByCode == ZipMethod.STORED || methodByCode == ZipMethod.DEFLATED)) {
                            BoundedInputStream boundedInputStream = new BoundedInputStream(this.f27657in, this.current.entry.getCompressedSize());
                            int i11 = AnonymousClass1.f27658a[methodByCode.ordinal()];
                            if (i11 == 1) {
                                InputStream unused3 = this.current.f27661in = new UnshrinkingInputStream(boundedInputStream);
                            } else if (i11 == 2) {
                                try {
                                    CurrentEntry currentEntry = this.current;
                                    InputStream unused4 = currentEntry.f27661in = new ExplodingInputStream(currentEntry.entry.getGeneralPurposeBit().getSlidingDictionarySize(), this.current.entry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), boundedInputStream);
                                } catch (IllegalArgumentException e11) {
                                    throw new IOException("bad IMPLODE data", e11);
                                }
                            } else if (i11 == 3) {
                                InputStream unused5 = this.current.f27661in = new BZip2CompressorInputStream(boundedInputStream);
                            } else if (i11 == 4) {
                                InputStream unused6 = this.current.f27661in = new Deflate64CompressorInputStream((InputStream) boundedInputStream);
                            }
                        }
                    } else if (methodByCode == ZipMethod.ENHANCED_DEFLATED) {
                        InputStream unused7 = this.current.f27661in = new Deflate64CompressorInputStream(this.f27657in);
                    }
                    this.entriesRead++;
                    return this.current.entry;
                } catch (RuntimeException e12) {
                    ZipException zipException = new ZipException("Invalid extra data in entry " + this.current.entry.getName());
                    zipException.initCause(e12);
                    throw zipException;
                }
            } else if (zipLong3.equals(ZipLong.CFH_SIG) || zipLong3.equals(ZipLong.AED_SIG) || isApkSigningBlock(this.lfhBuf)) {
                this.hitCentralDirectory = true;
                skipRemainderOfArchive();
                return null;
            } else {
                throw new ZipException(String.format("Unexpected record signature: 0X%X", new Object[]{Long.valueOf(zipLong3.getValue())}));
            }
        }
        return null;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i12 == 0) {
            return 0;
        }
        if (!this.closed) {
            CurrentEntry currentEntry = this.current;
            if (currentEntry == null) {
                return -1;
            }
            if (i11 > bArr.length || i12 < 0 || i11 < 0 || bArr.length - i11 < i12) {
                throw new ArrayIndexOutOfBoundsException();
            }
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            if (!supportsDataDescriptorFor(this.current.entry)) {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, this.current.entry);
            } else if (supportsCompressedSizeFor(this.current.entry)) {
                if (this.current.entry.getMethod() == 0) {
                    i13 = readStored(bArr, i11, i12);
                } else if (this.current.entry.getMethod() == 8) {
                    i13 = readDeflated(bArr, i11, i12);
                } else if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode() || this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode() || this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
                    i13 = this.current.f27661in.read(bArr, i11, i12);
                } else {
                    throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(this.current.entry.getMethod()), this.current.entry);
                }
                if (i13 >= 0) {
                    this.current.crc.update(bArr, i11, i13);
                    this.uncompressedCount += (long) i13;
                }
                return i13;
            } else {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, this.current.entry);
            }
        } else {
            throw new IOException("The stream is closed");
        }
    }

    public long skip(long j11) throws IOException {
        long j12 = 0;
        if (j11 >= 0) {
            while (j12 < j11) {
                long j13 = j11 - j12;
                byte[] bArr = this.skipBuf;
                if (((long) bArr.length) <= j13) {
                    j13 = (long) bArr.length;
                }
                int read = read(bArr, 0, (int) j13);
                if (read == -1) {
                    return j12;
                }
                j12 += (long) read;
            }
            return j12;
        }
        throw new IllegalArgumentException();
    }

    public ZipArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    private void readFully(byte[] bArr, int i11) throws IOException {
        int length = bArr.length - i11;
        int readFully = IOUtils.readFully(this.f27657in, bArr, i11, length);
        count(readFully);
        if (readFully < length) {
            throw new EOFException();
        }
    }

    public static final class CurrentEntry {
        /* access modifiers changed from: private */
        public long bytesRead;
        /* access modifiers changed from: private */
        public long bytesReadFromStream;
        /* access modifiers changed from: private */
        public final CRC32 crc;
        /* access modifiers changed from: private */
        public final ZipArchiveEntry entry;
        /* access modifiers changed from: private */
        public boolean hasDataDescriptor;
        /* access modifiers changed from: private */

        /* renamed from: in  reason: collision with root package name */
        public InputStream f27661in;
        /* access modifiers changed from: private */
        public boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        public static /* synthetic */ long m(CurrentEntry currentEntry) {
            long j11 = currentEntry.bytesReadFromStream;
            currentEntry.bytesReadFromStream = 1 + j11;
            return j11;
        }

        public /* synthetic */ CurrentEntry(AnonymousClass1 r12) {
            this();
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z11) {
        this(inputStream, str, z11, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z11, boolean z12) {
        this(inputStream, str, z11, z12, false);
    }

    public class BoundedInputStream extends InputStream {

        /* renamed from: in  reason: collision with root package name */
        private final InputStream f27660in;
        private final long max;
        private long pos;

        public BoundedInputStream(InputStream inputStream, long j11) {
            this.max = j11;
            this.f27660in = inputStream;
        }

        public int available() throws IOException {
            long j11 = this.max;
            if (j11 < 0 || this.pos < j11) {
                return this.f27660in.available();
            }
            return 0;
        }

        public int read() throws IOException {
            long j11 = this.max;
            if (j11 >= 0 && this.pos >= j11) {
                return -1;
            }
            int read = this.f27660in.read();
            this.pos++;
            ZipArchiveInputStream.this.count(1);
            CurrentEntry.m(ZipArchiveInputStream.this.current);
            return read;
        }

        public long skip(long j11) throws IOException {
            long j12 = this.max;
            if (j12 >= 0) {
                j11 = Math.min(j11, j12 - this.pos);
            }
            long skip = IOUtils.skip(this.f27660in, j11);
            this.pos += skip;
            return skip;
        }

        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 == 0) {
                return 0;
            }
            long j11 = this.max;
            if (j11 >= 0 && this.pos >= j11) {
                return -1;
            }
            int read = this.f27660in.read(bArr, i11, (int) (j11 >= 0 ? Math.min((long) i12, j11 - this.pos) : (long) i12));
            if (read == -1) {
                return -1;
            }
            long j12 = (long) read;
            this.pos += j12;
            ZipArchiveInputStream.this.count(read);
            CurrentEntry access$900 = ZipArchiveInputStream.this.current;
            long unused = access$900.bytesReadFromStream = access$900.bytesReadFromStream + j12;
            return read;
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z11, boolean z12, boolean z13) {
        this.inf = new Inflater(true);
        ByteBuffer allocate = ByteBuffer.allocate(512);
        this.buf = allocate;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z11;
        this.f27657in = new PushbackInputStream(inputStream, allocate.capacity());
        this.allowStoredEntriesWithDataDescriptor = z12;
        this.skipSplitSig = z13;
        allocate.limit(0);
    }
}
