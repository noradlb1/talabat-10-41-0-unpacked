package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzfux {
    private static final OutputStream zza = new zzfuw();

    public static byte[] zza(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i11 = 8192;
        int i12 = 0;
        while (i12 < 2147483639) {
            int min = Math.min(i11, 2147483639 - i12);
            byte[] bArr = new byte[min];
            arrayDeque.add(bArr);
            int i13 = 0;
            while (i13 < min) {
                int read = inputStream.read(bArr, i13, min - i13);
                if (read == -1) {
                    return zzb(arrayDeque, i12);
                }
                i13 += read;
                i12 += read;
            }
            long j11 = (long) i11;
            long j12 = j11 + j11;
            if (j12 > 2147483647L) {
                i11 = Integer.MAX_VALUE;
            } else if (j12 < -2147483648L) {
                i11 = Integer.MIN_VALUE;
            } else {
                i11 = (int) j12;
            }
        }
        if (inputStream.read() == -1) {
            return zzb(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzb(Queue<byte[]> queue, int i11) {
        byte[] bArr = new byte[i11];
        int i12 = i11;
        while (i12 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i12, remove.length);
            System.arraycopy(remove, 0, bArr, i11 - i12, min);
            i12 -= min;
        }
        return bArr;
    }
}
