package org.apache.commons.compress.archivers.arj;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ArjArchiveInputStream extends ArchiveInputStream {
    private static final int ARJ_MAGIC_1 = 96;
    private static final int ARJ_MAGIC_2 = 234;
    private final String charsetName;
    private InputStream currentInputStream;
    private LocalFileHeader currentLocalFileHeader;

    /* renamed from: in  reason: collision with root package name */
    private final DataInputStream f27533in;
    private final MainHeader mainHeader;

    public ArjArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.f27533in = new DataInputStream(inputStream);
        this.charsetName = str;
        try {
            MainHeader readMainHeader = readMainHeader();
            this.mainHeader = readMainHeader;
            int i11 = readMainHeader.f27559d;
            if ((i11 & 1) != 0) {
                throw new ArchiveException("Encrypted ARJ files are unsupported");
            } else if ((i11 & 4) != 0) {
                throw new ArchiveException("Multi-volume ARJ files are unsupported");
            }
        } catch (IOException e11) {
            throw new ArchiveException(e11.getMessage(), e11);
        }
    }

    public static boolean matches(byte[] bArr, int i11) {
        return i11 >= 2 && (bArr[0] & 255) == 96 && (bArr[1] & 255) == ARJ_MAGIC_2;
    }

    private int read16(DataInputStream dataInputStream) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        count(2);
        return Integer.reverseBytes(readUnsignedShort) >>> 16;
    }

    private int read32(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        count(4);
        return Integer.reverseBytes(readInt);
    }

    private int read8(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        count(1);
        return readUnsignedByte;
    }

    private void readExtraData(int i11, DataInputStream dataInputStream, LocalFileHeader localFileHeader) throws IOException {
        if (i11 >= 33) {
            localFileHeader.f27549p = read32(dataInputStream);
            if (i11 >= 45) {
                localFileHeader.f27550q = read32(dataInputStream);
                localFileHeader.f27551r = read32(dataInputStream);
                localFileHeader.f27552s = read32(dataInputStream);
                pushedBackBytes(12);
            }
            pushedBackBytes(4);
        }
    }

    private byte[] readHeader() throws IOException {
        boolean z11 = false;
        byte[] bArr = null;
        do {
            int read8 = read8(this.f27533in);
            while (true) {
                int read82 = read8(this.f27533in);
                if (read8 == 96 || read82 == ARJ_MAGIC_2) {
                    int read16 = read16(this.f27533in);
                } else {
                    read8 = read82;
                }
            }
            int read162 = read16(this.f27533in);
            if (read162 == 0) {
                return null;
            }
            if (read162 <= 2600) {
                bArr = readRange(this.f27533in, read162);
                CRC32 crc32 = new CRC32();
                crc32.update(bArr);
                if ((((long) read32(this.f27533in)) & 4294967295L) == crc32.getValue()) {
                    z11 = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (!z11);
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f4, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f9, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fd, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0100, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0105, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0109, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.archivers.arj.LocalFileHeader readLocalFileHeader() throws java.io.IOException {
        /*
            r12 = this;
            byte[] r0 = r12.readHeader()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            java.io.DataInputStream r1 = new java.io.DataInputStream
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r0)
            r1.<init>(r2)
            int r0 = r1.readUnsignedByte()     // Catch:{ all -> 0x00fe }
            int r2 = r0 + -1
            byte[] r2 = r12.readRange(r1, r2)     // Catch:{ all -> 0x00fe }
            int r3 = r2.length     // Catch:{ all -> 0x00fe }
            long r3 = (long) r3     // Catch:{ all -> 0x00fe }
            r12.pushedBackBytes(r3)     // Catch:{ all -> 0x00fe }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ all -> 0x00fe }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00fe }
            r4.<init>(r2)     // Catch:{ all -> 0x00fe }
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            org.apache.commons.compress.archivers.arj.LocalFileHeader r2 = new org.apache.commons.compress.archivers.arj.LocalFileHeader     // Catch:{ all -> 0x00f2 }
            r2.<init>()     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27534a = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27535b = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27536c = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27537d = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27538e = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27539f = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27540g = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00f2 }
            r2.f27541h = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00f2 }
            long r4 = (long) r4     // Catch:{ all -> 0x00f2 }
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            r2.f27542i = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00f2 }
            long r4 = (long) r4     // Catch:{ all -> 0x00f2 }
            long r4 = r4 & r6
            r2.f27543j = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00f2 }
            long r4 = (long) r4     // Catch:{ all -> 0x00f2 }
            long r4 = r4 & r6
            r2.f27544k = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read16(r3)     // Catch:{ all -> 0x00f2 }
            r2.f27545l = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read16(r3)     // Catch:{ all -> 0x00f2 }
            r2.f27546m = r4     // Catch:{ all -> 0x00f2 }
            r4 = 20
            r12.pushedBackBytes(r4)     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27547n = r4     // Catch:{ all -> 0x00f2 }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00f2 }
            r2.f27548o = r4     // Catch:{ all -> 0x00f2 }
            r12.readExtraData(r0, r3, r2)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = r12.readString(r1)     // Catch:{ all -> 0x00f2 }
            r2.f27553t = r0     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = r12.readString(r1)     // Catch:{ all -> 0x00f2 }
            r2.f27554u = r0     // Catch:{ all -> 0x00f2 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00f2 }
            r0.<init>()     // Catch:{ all -> 0x00f2 }
        L_0x00ae:
            java.io.DataInputStream r4 = r12.f27533in     // Catch:{ all -> 0x00f2 }
            int r4 = r12.read16(r4)     // Catch:{ all -> 0x00f2 }
            if (r4 <= 0) goto L_0x00e0
            java.io.DataInputStream r5 = r12.f27533in     // Catch:{ all -> 0x00f2 }
            byte[] r4 = r12.readRange(r5, r4)     // Catch:{ all -> 0x00f2 }
            java.io.DataInputStream r5 = r12.f27533in     // Catch:{ all -> 0x00f2 }
            int r5 = r12.read32(r5)     // Catch:{ all -> 0x00f2 }
            long r8 = (long) r5     // Catch:{ all -> 0x00f2 }
            long r8 = r8 & r6
            java.util.zip.CRC32 r5 = new java.util.zip.CRC32     // Catch:{ all -> 0x00f2 }
            r5.<init>()     // Catch:{ all -> 0x00f2 }
            r5.update(r4)     // Catch:{ all -> 0x00f2 }
            long r10 = r5.getValue()     // Catch:{ all -> 0x00f2 }
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x00d8
            r0.add(r4)     // Catch:{ all -> 0x00f2 }
            goto L_0x00ae
        L_0x00d8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00f2 }
            java.lang.String r2 = "Extended header CRC32 verification failure"
            r0.<init>(r2)     // Catch:{ all -> 0x00f2 }
            throw r0     // Catch:{ all -> 0x00f2 }
        L_0x00e0:
            r4 = 0
            byte[][] r4 = new byte[r4][]     // Catch:{ all -> 0x00f2 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ all -> 0x00f2 }
            byte[][] r0 = (byte[][]) r0     // Catch:{ all -> 0x00f2 }
            r2.f27555v = r0     // Catch:{ all -> 0x00f2 }
            r3.close()     // Catch:{ all -> 0x00fe }
            r1.close()
            return r2
        L_0x00f2:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r2 = move-exception
            r3.close()     // Catch:{ all -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r3 = move-exception
            r0.addSuppressed(r3)     // Catch:{ all -> 0x00fe }
        L_0x00fd:
            throw r2     // Catch:{ all -> 0x00fe }
        L_0x00fe:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0100 }
        L_0x0100:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0105 }
            goto L_0x0109
        L_0x0105:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0109:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.arj.ArjArchiveInputStream.readLocalFileHeader():org.apache.commons.compress.archivers.arj.LocalFileHeader");
    }

    private MainHeader readMainHeader() throws IOException {
        byte[] readHeader = readHeader();
        if (readHeader != null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(readHeader));
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte[] readRange = readRange(dataInputStream, readUnsignedByte - 1);
            pushedBackBytes((long) readRange.length);
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(readRange));
            MainHeader mainHeader2 = new MainHeader();
            mainHeader2.f27556a = dataInputStream2.readUnsignedByte();
            mainHeader2.f27557b = dataInputStream2.readUnsignedByte();
            mainHeader2.f27558c = dataInputStream2.readUnsignedByte();
            mainHeader2.f27559d = dataInputStream2.readUnsignedByte();
            mainHeader2.f27560e = dataInputStream2.readUnsignedByte();
            mainHeader2.f27561f = dataInputStream2.readUnsignedByte();
            mainHeader2.f27562g = dataInputStream2.readUnsignedByte();
            mainHeader2.f27563h = read32(dataInputStream2);
            mainHeader2.f27564i = read32(dataInputStream2);
            mainHeader2.f27565j = ((long) read32(dataInputStream2)) & 4294967295L;
            mainHeader2.f27566k = read32(dataInputStream2);
            mainHeader2.f27567l = read16(dataInputStream2);
            mainHeader2.f27568m = read16(dataInputStream2);
            pushedBackBytes(20);
            mainHeader2.f27569n = dataInputStream2.readUnsignedByte();
            mainHeader2.f27570o = dataInputStream2.readUnsignedByte();
            if (readUnsignedByte >= 33) {
                mainHeader2.f27571p = dataInputStream2.readUnsignedByte();
                mainHeader2.f27572q = dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
            }
            mainHeader2.f27573r = readString(dataInputStream);
            mainHeader2.f27574s = readString(dataInputStream);
            int read16 = read16(this.f27533in);
            if (read16 > 0) {
                mainHeader2.f27575t = readRange(this.f27533in, read16);
                CRC32 crc32 = new CRC32();
                crc32.update(mainHeader2.f27575t);
                if ((((long) read32(this.f27533in)) & 4294967295L) != crc32.getValue()) {
                    throw new IOException("Extended header CRC32 verification failure");
                }
            }
            return mainHeader2;
        }
        throw new IOException("Archive ends without any headers");
    }

    private byte[] readRange(InputStream inputStream, int i11) throws IOException {
        byte[] readRange = IOUtils.readRange(inputStream, i11);
        count(readRange.length);
        if (readRange.length >= i11) {
            return readRange;
        }
        throw new EOFException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r3 = r2.charsetName;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r3 == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r3 = r0.toString(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String readString(java.io.DataInputStream r3) throws java.io.IOException {
        /*
            r2 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0005:
            int r1 = r3.readUnsignedByte()     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000f
            r0.write(r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0005
        L_0x000f:
            java.lang.String r3 = r2.charsetName     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r0.toString(r3)     // Catch:{ all -> 0x0023 }
            r0.close()
            return r3
        L_0x001b:
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0023 }
            r0.close()
            return r3
        L_0x0023:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.arj.ArjArchiveInputStream.readString(java.io.DataInputStream):java.lang.String");
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ArjArchiveEntry) || ((ArjArchiveEntry) archiveEntry).getMethod() != 0) {
            return false;
        }
        return true;
    }

    public void close() throws IOException {
        this.f27533in.close();
    }

    public String getArchiveComment() {
        return this.mainHeader.f27574s;
    }

    public String getArchiveName() {
        return this.mainHeader.f27573r;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        LocalFileHeader localFileHeader = this.currentLocalFileHeader;
        if (localFileHeader == null) {
            throw new IllegalStateException("No current arj entry");
        } else if (localFileHeader.f27538e == 0) {
            return this.currentInputStream.read(bArr, i11, i12);
        } else {
            throw new IOException("Unsupported compression method " + this.currentLocalFileHeader.f27538e);
        }
    }

    public ArjArchiveEntry getNextEntry() throws IOException {
        InputStream inputStream = this.currentInputStream;
        if (inputStream != null) {
            IOUtils.skip(inputStream, Long.MAX_VALUE);
            this.currentInputStream.close();
            this.currentLocalFileHeader = null;
            this.currentInputStream = null;
        }
        LocalFileHeader readLocalFileHeader = readLocalFileHeader();
        this.currentLocalFileHeader = readLocalFileHeader;
        if (readLocalFileHeader != null) {
            BoundedInputStream boundedInputStream = new BoundedInputStream(this.f27533in, readLocalFileHeader.f27542i);
            this.currentInputStream = boundedInputStream;
            LocalFileHeader localFileHeader = this.currentLocalFileHeader;
            if (localFileHeader.f27538e == 0) {
                this.currentInputStream = new CRC32VerifyingInputStream((InputStream) boundedInputStream, localFileHeader.f27543j, localFileHeader.f27544k);
            }
            return new ArjArchiveEntry(this.currentLocalFileHeader);
        }
        this.currentInputStream = null;
        return null;
    }

    public ArjArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, "CP437");
    }
}
