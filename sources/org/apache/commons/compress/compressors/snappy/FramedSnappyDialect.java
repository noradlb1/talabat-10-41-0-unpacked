package org.apache.commons.compress.compressors.snappy;

public enum FramedSnappyDialect {
    STANDARD(true, true),
    IWORK_ARCHIVE(false, false);
    
    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    private FramedSnappyDialect(boolean z11, boolean z12) {
        this.streamIdentifier = z11;
        this.checksumWithCompressedChunks = z12;
    }

    public boolean hasStreamIdentifier() {
        return this.streamIdentifier;
    }

    public boolean usesChecksumWithCompressedChunks() {
        return this.checksumWithCompressedChunks;
    }
}
