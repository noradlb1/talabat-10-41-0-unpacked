package org.apache.commons.compress.archivers.cpio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class CpioArchiveEntry implements CpioConstants, ArchiveEntry {
    private final int alignmentBoundary;
    private long chksum;
    private final short fileFormat;
    private long filesize;
    private long gid;
    private final int headerSize;
    private long inode;
    private long maj;
    private long min;
    private long mode;
    private long mtime;

    /* renamed from: name  reason: collision with root package name */
    private String f27576name;
    private long nlink;
    private long rmaj;
    private long rmin;
    private long uid;

    public CpioArchiveEntry(short s11) {
        if (s11 == 1) {
            this.headerSize = 110;
            this.alignmentBoundary = 4;
        } else if (s11 == 2) {
            this.headerSize = 110;
            this.alignmentBoundary = 4;
        } else if (s11 == 4) {
            this.headerSize = 76;
            this.alignmentBoundary = 0;
        } else if (s11 == 8) {
            this.headerSize = 26;
            this.alignmentBoundary = 2;
        } else {
            throw new IllegalArgumentException("Unknown header type");
        }
        this.fileFormat = s11;
    }

    private void checkNewFormat() {
        if ((this.fileFormat & 3) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    private void checkOldFormat() {
        if ((this.fileFormat & 12) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CpioArchiveEntry cpioArchiveEntry = (CpioArchiveEntry) obj;
        String str = this.f27576name;
        if (str != null) {
            return str.equals(cpioArchiveEntry.f27576name);
        }
        if (cpioArchiveEntry.f27576name == null) {
            return true;
        }
        return false;
    }

    public int getAlignmentBoundary() {
        return this.alignmentBoundary;
    }

    public long getChksum() {
        checkNewFormat();
        return this.chksum & 4294967295L;
    }

    public int getDataPadCount() {
        int i11;
        int i12 = this.alignmentBoundary;
        if (i12 != 0 && (i11 = (int) (this.filesize % ((long) i12))) > 0) {
            return i12 - i11;
        }
        return 0;
    }

    public long getDevice() {
        checkOldFormat();
        return this.min;
    }

    public long getDeviceMaj() {
        checkNewFormat();
        return this.maj;
    }

    public long getDeviceMin() {
        checkNewFormat();
        return this.min;
    }

    public short getFormat() {
        return this.fileFormat;
    }

    public long getGID() {
        return this.gid;
    }

    @Deprecated
    public int getHeaderPadCount() {
        return getHeaderPadCount((Charset) null);
    }

    public int getHeaderSize() {
        return this.headerSize;
    }

    public long getInode() {
        return this.inode;
    }

    public Date getLastModifiedDate() {
        return new Date(getTime() * 1000);
    }

    public long getMode() {
        return (this.mode != 0 || CpioConstants.CPIO_TRAILER.equals(this.f27576name)) ? this.mode : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
    }

    public String getName() {
        return this.f27576name;
    }

    public long getNumberOfLinks() {
        long j11 = this.nlink;
        if (j11 != 0) {
            return j11;
        }
        if (isDirectory()) {
            return 2;
        }
        return 1;
    }

    public long getRemoteDevice() {
        checkOldFormat();
        return this.rmin;
    }

    public long getRemoteDeviceMaj() {
        checkNewFormat();
        return this.rmaj;
    }

    public long getRemoteDeviceMin() {
        checkNewFormat();
        return this.rmin;
    }

    public long getSize() {
        return this.filesize;
    }

    public long getTime() {
        return this.mtime;
    }

    public long getUID() {
        return this.uid;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f27576name});
    }

    public boolean isBlockDevice() {
        return CpioUtil.b(this.mode) == 24576;
    }

    public boolean isCharacterDevice() {
        return CpioUtil.b(this.mode) == PlaybackStateCompat.ACTION_PLAY_FROM_URI;
    }

    public boolean isDirectory() {
        return CpioUtil.b(this.mode) == 16384;
    }

    public boolean isNetwork() {
        return CpioUtil.b(this.mode) == 36864;
    }

    public boolean isPipe() {
        return CpioUtil.b(this.mode) == PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    }

    public boolean isRegularFile() {
        return CpioUtil.b(this.mode) == PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
    }

    public boolean isSocket() {
        return CpioUtil.b(this.mode) == 49152;
    }

    public boolean isSymbolicLink() {
        return CpioUtil.b(this.mode) == 40960;
    }

    public void setChksum(long j11) {
        checkNewFormat();
        this.chksum = j11 & 4294967295L;
    }

    public void setDevice(long j11) {
        checkOldFormat();
        this.min = j11;
    }

    public void setDeviceMaj(long j11) {
        checkNewFormat();
        this.maj = j11;
    }

    public void setDeviceMin(long j11) {
        checkNewFormat();
        this.min = j11;
    }

    public void setGID(long j11) {
        this.gid = j11;
    }

    public void setInode(long j11) {
        this.inode = j11;
    }

    public void setMode(long j11) {
        long j12 = 61440 & j11;
        switch ((int) j12) {
            case 4096:
            case 8192:
            case 16384:
            case CpioConstants.C_ISBLK:
            case 32768:
            case CpioConstants.C_ISNWK:
            case 40960:
            case CpioConstants.C_ISSOCK:
                this.mode = j11;
                return;
            default:
                throw new IllegalArgumentException("Unknown mode. Full: " + Long.toHexString(j11) + " Masked: " + Long.toHexString(j12));
        }
    }

    public void setName(String str) {
        this.f27576name = str;
    }

    public void setNumberOfLinks(long j11) {
        this.nlink = j11;
    }

    public void setRemoteDevice(long j11) {
        checkOldFormat();
        this.rmin = j11;
    }

    public void setRemoteDeviceMaj(long j11) {
        checkNewFormat();
        this.rmaj = j11;
    }

    public void setRemoteDeviceMin(long j11) {
        checkNewFormat();
        this.rmin = j11;
    }

    public void setSize(long j11) {
        if (j11 < 0 || j11 > 4294967295L) {
            throw new IllegalArgumentException("Invalid entry size <" + j11 + ">");
        }
        this.filesize = j11;
    }

    public void setTime(long j11) {
        this.mtime = j11;
    }

    public void setUID(long j11) {
        this.uid = j11;
    }

    public int getHeaderPadCount(Charset charset) {
        String str = this.f27576name;
        if (str == null) {
            return 0;
        }
        if (charset == null) {
            return getHeaderPadCount((long) str.length());
        }
        return getHeaderPadCount((long) str.getBytes(charset).length);
    }

    public void setTime(FileTime fileTime) {
        this.mtime = fileTime.to(TimeUnit.SECONDS);
    }

    public int getHeaderPadCount(long j11) {
        int i11 = this.alignmentBoundary;
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.headerSize + 1;
        if (this.f27576name != null) {
            i12 = (int) (((long) i12) + j11);
        }
        int i13 = i12 % i11;
        if (i13 > 0) {
            return i11 - i13;
        }
        return 0;
    }

    public CpioArchiveEntry(String str) {
        this(1, str);
    }

    public CpioArchiveEntry(short s11, String str) {
        this(s11);
        this.f27576name = str;
    }

    public CpioArchiveEntry(String str, long j11) {
        this(str);
        setSize(j11);
    }

    public CpioArchiveEntry(short s11, String str, long j11) {
        this(s11, str);
        setSize(j11);
    }

    public CpioArchiveEntry(File file, String str) {
        this(1, file, str);
    }

    public CpioArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        this(1, path, str, linkOptionArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CpioArchiveEntry(short s11, File file, String str) {
        this(s11, str, file.isFile() ? file.length() : 0);
        if (file.isDirectory()) {
            setMode(16384);
        } else if (file.isFile()) {
            setMode(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        } else {
            throw new IllegalArgumentException("Cannot determine type of file " + file.getName());
        }
        setTime(file.lastModified() / 1000);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CpioArchiveEntry(short s11, Path path, String str, LinkOption... linkOptionArr) throws IOException {
        this(s11, str, Files.isRegularFile(path, linkOptionArr) ? Files.size(path) : 0);
        if (Files.isDirectory(path, linkOptionArr)) {
            setMode(16384);
        } else if (Files.isRegularFile(path, linkOptionArr)) {
            setMode(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        } else {
            throw new IllegalArgumentException("Cannot determine type of file " + path);
        }
        setTime(Files.getLastModifiedTime(path, linkOptionArr));
    }
}
