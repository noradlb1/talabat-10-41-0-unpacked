package org.apache.commons.compress.compressors.gzip;

public class GzipParameters {
    private int bufferSize = 512;
    private String comment;
    private int compressionLevel = -1;
    private String filename;
    private long modificationTime;
    private int operatingSystem = 255;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public String getComment() {
        return this.comment;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public int getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setBufferSize(int i11) {
        if (i11 > 0) {
            this.bufferSize = i11;
            return;
        }
        throw new IllegalArgumentException("invalid buffer size: " + i11);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCompressionLevel(int i11) {
        if (i11 < -1 || i11 > 9) {
            throw new IllegalArgumentException("Invalid gzip compression level: " + i11);
        }
        this.compressionLevel = i11;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setModificationTime(long j11) {
        this.modificationTime = j11;
    }

    public void setOperatingSystem(int i11) {
        this.operatingSystem = i11;
    }
}
