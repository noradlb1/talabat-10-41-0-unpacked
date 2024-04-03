package org.apache.commons.compress;

import java.io.IOException;

public class MemoryLimitException extends IOException {
    private static final long serialVersionUID = 1;
    private final int memoryLimitInKb;
    private final long memoryNeededInKb;

    public MemoryLimitException(long j11, int i11) {
        super(buildMessage(j11, i11));
        this.memoryNeededInKb = j11;
        this.memoryLimitInKb = i11;
    }

    private static String buildMessage(long j11, int i11) {
        return j11 + " kb of memory would be needed; limit was " + i11 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }

    public int getMemoryLimitInKb() {
        return this.memoryLimitInKb;
    }

    public long getMemoryNeededInKb() {
        return this.memoryNeededInKb;
    }

    public MemoryLimitException(long j11, int i11, Exception exc) {
        super(buildMessage(j11, i11), exc);
        this.memoryNeededInKb = j11;
        this.memoryLimitInKb = i11;
    }
}
