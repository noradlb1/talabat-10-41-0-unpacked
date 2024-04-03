package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzafz {
    public static long zza(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 16);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 12);
    }

    public static Pair<ByteBuffer, Long> zzc(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> zzf = zzf(randomAccessFile, 0);
        if (zzf != null) {
            return zzf;
        }
        return zzf(randomAccessFile, 65535);
    }

    public static void zzd(ByteBuffer byteBuffer, long j11) {
        zzg(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j11 < 0 || j11 > 4294967295L) {
            StringBuilder sb2 = new StringBuilder(47);
            sb2.append("uint32 value of out range: ");
            sb2.append(j11);
            throw new IllegalArgumentException(sb2.toString());
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j11);
    }

    private static long zze(ByteBuffer byteBuffer, int i11) {
        return ((long) byteBuffer.getInt(i11)) & 4294967295L;
    }

    private static Pair<ByteBuffer, Long> zzf(RandomAccessFile randomAccessFile, int i11) throws IOException {
        int i12;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i11, -22 + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        zzg(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int i13 = capacity2 - 22;
            int min = Math.min(i13, 65535);
            int i14 = 0;
            while (true) {
                if (i14 >= min) {
                    break;
                }
                i12 = i13 - i14;
                if (allocate.getInt(i12) == 101010256 && ((char) allocate.getShort(i12 + 20)) == i14) {
                    break;
                }
                i14++;
            }
        }
        i12 = -1;
        if (i12 == -1) {
            return null;
        }
        allocate.position(i12);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + ((long) i12)));
    }

    private static void zzg(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
