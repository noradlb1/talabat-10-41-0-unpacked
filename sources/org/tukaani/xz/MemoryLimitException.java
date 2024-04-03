package org.tukaani.xz;

public class MemoryLimitException extends XZIOException {
    private static final long serialVersionUID = 3;
    private final int memoryLimit;
    private final int memoryNeeded;

    public MemoryLimitException(int i11, int i12) {
        super("" + i11 + " KiB of memory would be needed; limit was " + i12 + " KiB");
        this.memoryNeeded = i11;
        this.memoryLimit = i12;
    }

    public int getMemoryLimit() {
        return this.memoryLimit;
    }

    public int getMemoryNeeded() {
        return this.memoryNeeded;
    }
}
