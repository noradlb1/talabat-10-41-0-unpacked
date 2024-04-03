package org.apache.commons.compress.archivers.arj;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipUtil;

public class ArjArchiveEntry implements ArchiveEntry {
    private final LocalFileHeader localFileHeader;

    public static class HostOs {
        public static final int AMIGA = 3;
        public static final int APPLE_GS = 6;
        public static final int ATARI_ST = 7;
        public static final int DOS = 0;
        public static final int MAC_OS = 4;
        public static final int NEXT = 8;
        public static final int OS_2 = 5;
        public static final int PRIMOS = 1;
        public static final int UNIX = 2;
        public static final int VAX_VMS = 9;
        public static final int WIN32 = 11;
        public static final int WIN95 = 10;
    }

    public ArjArchiveEntry() {
        this.localFileHeader = new LocalFileHeader();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.localFileHeader.equals(((ArjArchiveEntry) obj).localFileHeader);
    }

    public int getHostOs() {
        return this.localFileHeader.f27536c;
    }

    public Date getLastModifiedDate() {
        long j11;
        if (isHostOsUnix()) {
            j11 = ((long) this.localFileHeader.f27541h) * 1000;
        } else {
            j11 = ZipUtil.dosToJavaTime(((long) this.localFileHeader.f27541h) & 4294967295L);
        }
        return new Date(j11);
    }

    public int getMethod() {
        return this.localFileHeader.f27538e;
    }

    public int getMode() {
        return this.localFileHeader.f27546m;
    }

    public String getName() {
        LocalFileHeader localFileHeader2 = this.localFileHeader;
        if ((localFileHeader2.f27537d & 16) != 0) {
            return localFileHeader2.f27553t.replaceAll("/", Matcher.quoteReplacement(File.separator));
        }
        return localFileHeader2.f27553t;
    }

    public long getSize() {
        return this.localFileHeader.f27543j;
    }

    public int getUnixMode() {
        if (isHostOsUnix()) {
            return getMode();
        }
        return 0;
    }

    public int hashCode() {
        String name2 = getName();
        if (name2 == null) {
            return 0;
        }
        return name2.hashCode();
    }

    public boolean isDirectory() {
        return this.localFileHeader.f27539f == 3;
    }

    public boolean isHostOsUnix() {
        return getHostOs() == 2 || getHostOs() == 8;
    }

    public ArjArchiveEntry(LocalFileHeader localFileHeader2) {
        this.localFileHeader = localFileHeader2;
    }
}
