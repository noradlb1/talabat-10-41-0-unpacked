package org.apache.commons.compress.archivers.zip;

public class ScatterStatistics {
    private final long compressionElapsed;
    private final long mergingElapsed;

    public ScatterStatistics(long j11, long j12) {
        this.compressionElapsed = j11;
        this.mergingElapsed = j12;
    }

    public long getCompressionElapsed() {
        return this.compressionElapsed;
    }

    public long getMergingElapsed() {
        return this.mergingElapsed;
    }

    public String toString() {
        return "compressionElapsed=" + this.compressionElapsed + "ms, mergingElapsed=" + this.mergingElapsed + "ms";
    }
}
