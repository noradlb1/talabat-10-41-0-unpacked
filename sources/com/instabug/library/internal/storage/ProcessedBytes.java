package com.instabug.library.internal.storage;

import java.util.Arrays;

public class ProcessedBytes {
    private final byte[] fileBytes;
    private final boolean isProcessSuccessful;

    public ProcessedBytes(byte[] bArr, boolean z11) {
        this.fileBytes = Arrays.copyOf(bArr, bArr.length);
        this.isProcessSuccessful = z11;
    }

    public byte[] getFileBytes() {
        byte[] bArr = this.fileBytes;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean isProcessSuccessful() {
        return this.isProcessSuccessful;
    }
}
