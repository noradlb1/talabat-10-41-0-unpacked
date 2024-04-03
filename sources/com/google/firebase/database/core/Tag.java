package com.google.firebase.database.core;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Tag {
    private final long tagNumber;

    public Tag(long j11) {
        this.tagNumber = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Tag.class == obj.getClass() && this.tagNumber == ((Tag) obj).tagNumber) {
            return true;
        }
        return false;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public int hashCode() {
        long j11 = this.tagNumber;
        return (int) (j11 ^ (j11 >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.tagNumber + AbstractJsonLexerKt.END_OBJ;
    }
}
