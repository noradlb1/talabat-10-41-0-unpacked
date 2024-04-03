package org.apache.commons.compress.changes;

import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

class Change {
    private final ArchiveEntry entry;
    private final InputStream input;
    private final boolean replaceMode;
    private final String targetFile;
    private final int type;

    public Change(String str, int i11) {
        Objects.requireNonNull(str, "fileName");
        this.targetFile = str;
        this.type = i11;
        this.input = null;
        this.entry = null;
        this.replaceMode = true;
    }

    public ArchiveEntry a() {
        return this.entry;
    }

    public InputStream b() {
        return this.input;
    }

    public boolean c() {
        return this.replaceMode;
    }

    public String d() {
        return this.targetFile;
    }

    public int e() {
        return this.type;
    }

    public Change(ArchiveEntry archiveEntry, InputStream inputStream, boolean z11) {
        Objects.requireNonNull(archiveEntry, "archiveEntry");
        Objects.requireNonNull(inputStream, "inputStream");
        this.entry = archiveEntry;
        this.input = inputStream;
        this.type = 2;
        this.targetFile = null;
        this.replaceMode = z11;
    }
}
