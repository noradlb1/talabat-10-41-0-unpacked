package org.apache.commons.compress.archivers.cpio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

public class CpioArchiveInputStream extends ArchiveInputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private long entryBytesRead;
    private boolean entryEOF;
    private final byte[] fourBytesBuf;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27577in;
    private final byte[] sixBytesBuf;
    private final byte[] tmpbuf;
    private final byte[] twoBytesBuf;
    private final ZipEncoding zipEncoding;

    public CpioArchiveInputStream(InputStream inputStream) {
        this(inputStream, 512, "US-ASCII");
    }

    private void closeEntry() throws IOException {
        do {
        } while (skip(2147483647L) == 2147483647L);
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < 6) {
            return false;
        }
        byte b11 = bArr[0];
        if (b11 == 113 && (bArr[1] & 255) == 199) {
            return true;
        }
        byte b12 = bArr[1];
        if (b12 == 113 && (b11 & 255) == 199) {
            return true;
        }
        if (b11 != 48 || b12 != 55 || bArr[2] != 48 || bArr[3] != 55 || bArr[4] != 48) {
            return false;
        }
        byte b13 = bArr[5];
        if (b13 == 49 || b13 == 50 || b13 == 55) {
            return true;
        }
        return false;
    }

    private long readAsciiLong(int i11, int i12) throws IOException {
        return Long.parseLong(ArchiveUtils.toAsciiString(readRange(i11)), i12);
    }

    private long readBinaryLong(int i11, boolean z11) throws IOException {
        return CpioUtil.a(readRange(i11), z11);
    }

    private String readCString(int i11) throws IOException {
        byte[] readRange = readRange(i11 - 1);
        if (this.f27577in.read() != -1) {
            return this.zipEncoding.decode(readRange);
        }
        throw new EOFException();
    }

    private final int readFully(byte[] bArr, int i11, int i12) throws IOException {
        int readFully = IOUtils.readFully(this.f27577in, bArr, i11, i12);
        count(readFully);
        if (readFully >= i12) {
            return readFully;
        }
        throw new EOFException();
    }

    private CpioArchiveEntry readNewEntry(boolean z11) throws IOException {
        CpioArchiveEntry cpioArchiveEntry;
        if (z11) {
            cpioArchiveEntry = new CpioArchiveEntry(2);
        } else {
            cpioArchiveEntry = new CpioArchiveEntry(1);
        }
        cpioArchiveEntry.setInode(readAsciiLong(8, 16));
        long readAsciiLong = readAsciiLong(8, 16);
        if (CpioUtil.b(readAsciiLong) != 0) {
            cpioArchiveEntry.setMode(readAsciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(8, 16));
        cpioArchiveEntry.setGID(readAsciiLong(8, 16));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(8, 16));
        cpioArchiveEntry.setTime(readAsciiLong(8, 16));
        cpioArchiveEntry.setSize(readAsciiLong(8, 16));
        if (cpioArchiveEntry.getSize() >= 0) {
            cpioArchiveEntry.setDeviceMaj(readAsciiLong(8, 16));
            cpioArchiveEntry.setDeviceMin(readAsciiLong(8, 16));
            cpioArchiveEntry.setRemoteDeviceMaj(readAsciiLong(8, 16));
            cpioArchiveEntry.setRemoteDeviceMin(readAsciiLong(8, 16));
            long readAsciiLong2 = readAsciiLong(8, 16);
            if (readAsciiLong2 >= 0) {
                cpioArchiveEntry.setChksum(readAsciiLong(8, 16));
                String readCString = readCString((int) readAsciiLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.b(readAsciiLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    skip(cpioArchiveEntry.getHeaderPadCount(readAsciiLong2 - 1));
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry name: " + ArchiveUtils.sanitize(readCString) + " Occurred at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative name length");
        }
        throw new IOException("Found illegal entry with negative length");
    }

    private CpioArchiveEntry readOldAsciiEntry() throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(4);
        cpioArchiveEntry.setDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setInode(readAsciiLong(6, 8));
        long readAsciiLong = readAsciiLong(6, 8);
        if (CpioUtil.b(readAsciiLong) != 0) {
            cpioArchiveEntry.setMode(readAsciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(6, 8));
        cpioArchiveEntry.setGID(readAsciiLong(6, 8));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(6, 8));
        cpioArchiveEntry.setRemoteDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setTime(readAsciiLong(11, 8));
        long readAsciiLong2 = readAsciiLong(6, 8);
        if (readAsciiLong2 >= 0) {
            cpioArchiveEntry.setSize(readAsciiLong(11, 8));
            if (cpioArchiveEntry.getSize() >= 0) {
                String readCString = readCString((int) readAsciiLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.b(readAsciiLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(readCString) + " Occurred at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative length");
        }
        throw new IOException("Found illegal entry with negative name length");
    }

    private CpioArchiveEntry readOldBinaryEntry(boolean z11) throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(8);
        cpioArchiveEntry.setDevice(readBinaryLong(2, z11));
        cpioArchiveEntry.setInode(readBinaryLong(2, z11));
        long readBinaryLong = readBinaryLong(2, z11);
        if (CpioUtil.b(readBinaryLong) != 0) {
            cpioArchiveEntry.setMode(readBinaryLong);
        }
        cpioArchiveEntry.setUID(readBinaryLong(2, z11));
        cpioArchiveEntry.setGID(readBinaryLong(2, z11));
        cpioArchiveEntry.setNumberOfLinks(readBinaryLong(2, z11));
        cpioArchiveEntry.setRemoteDevice(readBinaryLong(2, z11));
        cpioArchiveEntry.setTime(readBinaryLong(4, z11));
        long readBinaryLong2 = readBinaryLong(2, z11);
        if (readBinaryLong2 >= 0) {
            cpioArchiveEntry.setSize(readBinaryLong(4, z11));
            if (cpioArchiveEntry.getSize() >= 0) {
                String readCString = readCString((int) readBinaryLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.b(readBinaryLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    skip(cpioArchiveEntry.getHeaderPadCount(readBinaryLong2 - 1));
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(readCString) + "Occurred at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative length");
        }
        throw new IOException("Found illegal entry with negative name length");
    }

    private final byte[] readRange(int i11) throws IOException {
        byte[] readRange = IOUtils.readRange(this.f27577in, i11);
        count(readRange.length);
        if (readRange.length >= i11) {
            return readRange;
        }
        throw new EOFException();
    }

    private void skip(int i11) throws IOException {
        if (i11 > 0) {
            readFully(this.fourBytesBuf, 0, i11);
        }
    }

    private void skipRemainderOfLastBlock() throws IOException {
        long j11;
        long bytesRead = getBytesRead();
        int i11 = this.blockSize;
        long j12 = bytesRead % ((long) i11);
        if (j12 == 0) {
            j11 = 0;
        } else {
            j11 = ((long) i11) - j12;
        }
        while (j11 > 0) {
            long skip = skip(((long) this.blockSize) - j12);
            if (skip > 0) {
                j11 -= skip;
            } else {
                return;
            }
        }
    }

    public int available() throws IOException {
        ensureOpen();
        if (this.entryEOF) {
            return 0;
        }
        return 1;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.f27577in.close();
            this.closed = true;
        }
    }

    public CpioArchiveEntry getNextCPIOEntry() throws IOException {
        ensureOpen();
        if (this.entry != null) {
            closeEntry();
        }
        byte[] bArr = this.twoBytesBuf;
        readFully(bArr, 0, bArr.length);
        if (CpioUtil.a(this.twoBytesBuf, false) == 29127) {
            this.entry = readOldBinaryEntry(false);
        } else if (CpioUtil.a(this.twoBytesBuf, true) == 29127) {
            this.entry = readOldBinaryEntry(true);
        } else {
            byte[] bArr2 = this.twoBytesBuf;
            System.arraycopy(bArr2, 0, this.sixBytesBuf, 0, bArr2.length);
            readFully(this.sixBytesBuf, this.twoBytesBuf.length, this.fourBytesBuf.length);
            String asciiString = ArchiveUtils.toAsciiString(this.sixBytesBuf);
            asciiString.hashCode();
            char c11 = 65535;
            switch (asciiString.hashCode()) {
                case 1426477263:
                    if (asciiString.equals(CpioConstants.MAGIC_NEW)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1426477264:
                    if (asciiString.equals(CpioConstants.MAGIC_NEW_CRC)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1426477269:
                    if (asciiString.equals(CpioConstants.MAGIC_OLD_ASCII)) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    this.entry = readNewEntry(false);
                    break;
                case 1:
                    this.entry = readNewEntry(true);
                    break;
                case 2:
                    this.entry = readOldAsciiEntry();
                    break;
                default:
                    throw new IOException("Unknown magic [" + asciiString + "]. Occurred at byte: " + getBytesRead());
            }
        }
        this.entryBytesRead = 0;
        this.entryEOF = false;
        this.crc = 0;
        if (!this.entry.getName().equals(CpioConstants.CPIO_TRAILER)) {
            return this.entry;
        }
        this.entryEOF = true;
        skipRemainderOfLastBlock();
        return null;
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextCPIOEntry();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        ensureOpen();
        if (i11 < 0 || i12 < 0 || i11 > bArr.length - i12) {
            throw new IndexOutOfBoundsException();
        }
        if (i12 == 0) {
            return 0;
        }
        CpioArchiveEntry cpioArchiveEntry = this.entry;
        if (cpioArchiveEntry == null || this.entryEOF) {
            return -1;
        }
        if (this.entryBytesRead == cpioArchiveEntry.getSize()) {
            skip(this.entry.getDataPadCount());
            this.entryEOF = true;
            if (this.entry.getFormat() != 2 || this.crc == this.entry.getChksum()) {
                return -1;
            }
            throw new IOException("CRC Error. Occurred at byte: " + getBytesRead());
        }
        int min = (int) Math.min((long) i12, this.entry.getSize() - this.entryBytesRead);
        if (min < 0) {
            return -1;
        }
        int readFully = readFully(bArr, i11, min);
        if (this.entry.getFormat() == 2) {
            for (int i13 = 0; i13 < readFully; i13++) {
                this.crc = (this.crc + ((long) (bArr[i13] & 255))) & 4294967295L;
            }
        }
        if (readFully > 0) {
            this.entryBytesRead += (long) readFully;
        }
        return readFully;
    }

    public CpioArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, 512, str);
    }

    public long skip(long j11) throws IOException {
        if (j11 >= 0) {
            ensureOpen();
            int min = (int) Math.min(j11, 2147483647L);
            int i11 = 0;
            while (true) {
                if (i11 >= min) {
                    break;
                }
                int i12 = min - i11;
                byte[] bArr = this.tmpbuf;
                if (i12 > bArr.length) {
                    i12 = bArr.length;
                }
                int read = read(bArr, 0, i12);
                if (read == -1) {
                    this.entryEOF = true;
                    break;
                }
                i11 += read;
            }
            return (long) i11;
        }
        throw new IllegalArgumentException("Negative skip length");
    }

    public CpioArchiveInputStream(InputStream inputStream, int i11) {
        this(inputStream, i11, "US-ASCII");
    }

    public CpioArchiveInputStream(InputStream inputStream, int i11, String str) {
        this.tmpbuf = new byte[4096];
        this.twoBytesBuf = new byte[2];
        this.fourBytesBuf = new byte[4];
        this.sixBytesBuf = new byte[6];
        this.f27577in = inputStream;
        if (i11 > 0) {
            this.blockSize = i11;
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            return;
        }
        throw new IllegalArgumentException("blockSize must be bigger than 0");
    }
}
