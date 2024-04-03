package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArArchiveEntry implements ArchiveEntry {
    private static final int DEFAULT_MODE = 33188;
    public static final String HEADER = "!<arch>\n";
    public static final String TRAILER = "`\n";
    private final int groupId;
    private final long lastModified;
    private final long length;
    private final int mode;

    /* renamed from: name  reason: collision with root package name */
    private final String f27532name;
    private final int userId;

    public ArArchiveEntry(String str, long j11) {
        this(str, j11, 0, 0, 33188, System.currentTimeMillis() / 1000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArArchiveEntry arArchiveEntry = (ArArchiveEntry) obj;
        String str = this.f27532name;
        if (str != null) {
            return str.equals(arArchiveEntry.f27532name);
        }
        if (arArchiveEntry.f27532name == null) {
            return true;
        }
        return false;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public Date getLastModifiedDate() {
        return new Date(getLastModified() * 1000);
    }

    public long getLength() {
        return this.length;
    }

    public int getMode() {
        return this.mode;
    }

    public String getName() {
        return this.f27532name;
    }

    public long getSize() {
        return getLength();
    }

    public int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f27532name});
    }

    public boolean isDirectory() {
        return false;
    }

    public ArArchiveEntry(String str, long j11, int i11, int i12, int i13, long j12) {
        this.f27532name = str;
        if (j11 >= 0) {
            this.length = j11;
            this.userId = i11;
            this.groupId = i12;
            this.mode = i13;
            this.lastModified = j12;
            return;
        }
        throw new IllegalArgumentException("length must not be negative");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ArArchiveEntry(File file, String str) {
        this(str, file.isFile() ? file.length() : 0, 0, 0, 33188, file.lastModified() / 1000);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ArArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        this(str, Files.isRegularFile(path, linkOptionArr) ? Files.size(path) : 0, 0, 0, 33188, Files.getLastModifiedTime(path, linkOptionArr).toMillis() / 1000);
    }
}
