package org.apache.commons.compress.archivers.cpio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;

public class CpioArchiveOutputStream extends ArchiveOutputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private final short entryFormat;
    private boolean finished;
    private final HashMap<String, CpioArchiveEntry> names;
    private long nextArtificalDeviceAndInode;
    private final OutputStream out;
    private long written;
    private final ZipEncoding zipEncoding;

    public CpioArchiveOutputStream(OutputStream outputStream, short s11) {
        this(outputStream, s11, 512, "US-ASCII");
    }

    private byte[] encode(String str) throws IOException {
        ByteBuffer encode = this.zipEncoding.encode(str);
        return Arrays.copyOfRange(encode.array(), encode.arrayOffset(), encode.arrayOffset() + (encode.limit() - encode.position()));
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    private void pad(int i11) throws IOException {
        if (i11 > 0) {
            this.out.write(new byte[i11]);
            count(i11);
        }
    }

    private void writeAsciiLong(long j11, int i11, int i12) throws IOException {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (i12 == 16) {
            sb2.append(Long.toHexString(j11));
        } else if (i12 == 8) {
            sb2.append(Long.toOctalString(j11));
        } else {
            sb2.append(Long.toString(j11));
        }
        if (sb2.length() <= i11) {
            int length = i11 - sb2.length();
            for (int i13 = 0; i13 < length; i13++) {
                sb2.insert(0, "0");
            }
            str = sb2.toString();
        } else {
            str = sb2.substring(sb2.length() - i11);
        }
        byte[] asciiBytes = ArchiveUtils.toAsciiBytes(str);
        this.out.write(asciiBytes);
        count(asciiBytes.length);
    }

    private void writeBinaryLong(long j11, int i11, boolean z11) throws IOException {
        byte[] c11 = CpioUtil.c(j11, i11, z11);
        this.out.write(c11);
        count(c11.length);
    }

    private void writeCString(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.out.write(0);
        count(bArr.length + 1);
    }

    private void writeHeader(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        short format = cpioArchiveEntry.getFormat();
        if (format == 1) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW));
            count(6);
            writeNewEntry(cpioArchiveEntry);
        } else if (format == 2) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW_CRC));
            count(6);
            writeNewEntry(cpioArchiveEntry);
        } else if (format == 4) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_OLD_ASCII));
            count(6);
            writeOldAsciiEntry(cpioArchiveEntry);
        } else if (format == 8) {
            writeBinaryLong(29127, 2, true);
            writeOldBinaryEntry(cpioArchiveEntry, true);
        } else {
            throw new IOException("Unknown format " + cpioArchiveEntry.getFormat());
        }
    }

    private void writeNewEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long deviceMin = cpioArchiveEntry.getDeviceMin();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            deviceMin = 0;
        } else if (inode == 0 && deviceMin == 0) {
            long j11 = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j11 + 1;
            deviceMin = -1 & (j11 >> 32);
            inode = j11 & -1;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (4294967296L * deviceMin) + inode) + 1;
        }
        writeAsciiLong(inode, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getMode(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getUID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getGID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getTime(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getSize(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getDeviceMaj(), 8, 16);
        writeAsciiLong(deviceMin, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMaj(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMin(), 8, 16);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) encode.length) + 1, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getChksum(), 8, 16);
        writeCString(encode);
        pad(cpioArchiveEntry.getHeaderPadCount((long) encode.length));
    }

    private void writeOldAsciiEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j11 = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j11 + 1;
            device = 262143 & (j11 >> 18);
            inode = j11 & 262143;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (PlaybackStateCompat.ACTION_SET_REPEAT_MODE * device) + inode) + 1;
        }
        writeAsciiLong(device, 6, 8);
        writeAsciiLong(inode, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getMode(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getUID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getGID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getRemoteDevice(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getTime(), 11, 8);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) encode.length) + 1, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getSize(), 11, 8);
        writeCString(encode);
    }

    private void writeOldBinaryEntry(CpioArchiveEntry cpioArchiveEntry, boolean z11) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j11 = this.nextArtificalDeviceAndInode;
            long j12 = j11 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            this.nextArtificalDeviceAndInode = j11 + 1;
            device = WebSocketProtocol.PAYLOAD_SHORT_MAX & (j11 >> 16);
            inode = j12;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH * device) + inode) + 1;
        }
        writeBinaryLong(device, 2, z11);
        writeBinaryLong(inode, 2, z11);
        writeBinaryLong(cpioArchiveEntry.getMode(), 2, z11);
        writeBinaryLong(cpioArchiveEntry.getUID(), 2, z11);
        writeBinaryLong(cpioArchiveEntry.getGID(), 2, z11);
        writeBinaryLong(cpioArchiveEntry.getNumberOfLinks(), 2, z11);
        writeBinaryLong(cpioArchiveEntry.getRemoteDevice(), 2, z11);
        writeBinaryLong(cpioArchiveEntry.getTime(), 4, z11);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeBinaryLong(((long) encode.length) + 1, 2, z11);
        writeBinaryLong(cpioArchiveEntry.getSize(), 4, z11);
        writeCString(encode);
        pad(cpioArchiveEntry.getHeaderPadCount((long) encode.length));
    }

    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            if (!this.closed) {
                this.out.close();
                this.closed = true;
            }
        }
    }

    public void closeArchiveEntry() throws IOException {
        if (!this.finished) {
            ensureOpen();
            CpioArchiveEntry cpioArchiveEntry = this.entry;
            if (cpioArchiveEntry == null) {
                throw new IOException("Trying to close non-existent entry");
            } else if (cpioArchiveEntry.getSize() == this.written) {
                pad(this.entry.getDataPadCount());
                if (this.entry.getFormat() != 2 || this.crc == this.entry.getChksum()) {
                    this.entry = null;
                    this.crc = 0;
                    this.written = 0;
                    return;
                }
                throw new IOException("CRC Error");
            } else {
                throw new IOException("Invalid entry size (expected " + this.entry.getSize() + " but got " + this.written + " bytes)");
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new CpioArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    public void finish() throws IOException {
        ensureOpen();
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (this.entry == null) {
            CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(this.entryFormat);
            this.entry = cpioArchiveEntry;
            cpioArchiveEntry.setName(CpioConstants.CPIO_TRAILER);
            this.entry.setNumberOfLinks(1);
            writeHeader(this.entry);
            closeArchiveEntry();
            long bytesWritten = getBytesWritten();
            int i11 = this.blockSize;
            int i12 = (int) (bytesWritten % ((long) i11));
            if (i12 != 0) {
                pad(i11 - i12);
            }
            this.finished = true;
        } else {
            throw new IOException("This archive contains unclosed entries.");
        }
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        if (!this.finished) {
            CpioArchiveEntry cpioArchiveEntry = (CpioArchiveEntry) archiveEntry;
            ensureOpen();
            if (this.entry != null) {
                closeArchiveEntry();
            }
            if (cpioArchiveEntry.getTime() == -1) {
                cpioArchiveEntry.setTime(System.currentTimeMillis() / 1000);
            }
            short format = cpioArchiveEntry.getFormat();
            if (format != this.entryFormat) {
                throw new IOException("Header format: " + format + " does not match existing format: " + this.entryFormat);
            } else if (this.names.put(cpioArchiveEntry.getName(), cpioArchiveEntry) == null) {
                writeHeader(cpioArchiveEntry);
                this.entry = cpioArchiveEntry;
                this.written = 0;
            } else {
                throw new IOException("Duplicate entry: " + cpioArchiveEntry.getName());
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        ensureOpen();
        if (i11 < 0 || i12 < 0 || i11 > bArr.length - i12) {
            throw new IndexOutOfBoundsException();
        } else if (i12 != 0) {
            CpioArchiveEntry cpioArchiveEntry = this.entry;
            if (cpioArchiveEntry != null) {
                long j11 = (long) i12;
                if (this.written + j11 <= cpioArchiveEntry.getSize()) {
                    this.out.write(bArr, i11, i12);
                    this.written += j11;
                    if (this.entry.getFormat() == 2) {
                        for (int i13 = 0; i13 < i12; i13++) {
                            this.crc = (this.crc + ((long) (bArr[i13] & 255))) & 4294967295L;
                        }
                    }
                    count(i12);
                    return;
                }
                throw new IOException("Attempt to write past end of STORED entry");
            }
            throw new IOException("No current CPIO entry");
        }
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s11, int i11) {
        this(outputStream, s11, i11, "US-ASCII");
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s11, int i11, String str) {
        this.names = new HashMap<>();
        this.nextArtificalDeviceAndInode = 1;
        this.out = outputStream;
        if (s11 == 1 || s11 == 2 || s11 == 4 || s11 == 8) {
            this.entryFormat = s11;
            this.blockSize = i11;
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            return;
        }
        throw new IllegalArgumentException("Unknown format: " + s11);
    }

    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (!this.finished) {
            return new CpioArchiveEntry(path, str, linkOptionArr);
        }
        throw new IOException("Stream has already been finished");
    }

    public CpioArchiveOutputStream(OutputStream outputStream) {
        this(outputStream, 1);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, String str) {
        this(outputStream, 1, 512, str);
    }
}
