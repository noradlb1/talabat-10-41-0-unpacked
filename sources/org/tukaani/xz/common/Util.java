package org.tukaani.xz.common;

public class Util {
    public static final long BACKWARD_SIZE_MAX = 17179869184L;
    public static final int BLOCK_HEADER_SIZE_MAX = 1024;
    public static final int STREAM_HEADER_SIZE = 12;
    public static final long VLI_MAX = Long.MAX_VALUE;
    public static final int VLI_SIZE_MAX = 9;

    public static int getVLISize(long j11) {
        int i11 = 0;
        do {
            i11++;
            j11 >>= 7;
        } while (j11 != 0);
        return i11;
    }
}
