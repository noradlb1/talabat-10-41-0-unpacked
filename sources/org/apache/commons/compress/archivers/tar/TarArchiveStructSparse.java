package org.apache.commons.compress.archivers.tar;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class TarArchiveStructSparse {
    private final long numbytes;
    private final long offset;

    public TarArchiveStructSparse(long j11, long j12) {
        if (j11 < 0) {
            throw new IllegalArgumentException("offset must not be negative");
        } else if (j12 >= 0) {
            this.offset = j11;
            this.numbytes = j12;
        } else {
            throw new IllegalArgumentException("numbytes must not be negative");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TarArchiveStructSparse.class != obj.getClass()) {
            return false;
        }
        TarArchiveStructSparse tarArchiveStructSparse = (TarArchiveStructSparse) obj;
        if (this.offset == tarArchiveStructSparse.offset && this.numbytes == tarArchiveStructSparse.numbytes) {
            return true;
        }
        return false;
    }

    public long getNumbytes() {
        return this.numbytes;
    }

    public long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.offset), Long.valueOf(this.numbytes)});
    }

    public String toString() {
        return "TarArchiveStructSparse{offset=" + this.offset + ", numbytes=" + this.numbytes + AbstractJsonLexerKt.END_OBJ;
    }
}
