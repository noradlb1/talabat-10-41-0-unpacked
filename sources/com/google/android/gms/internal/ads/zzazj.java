package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzazj {
    @VisibleForTesting
    public static long zza(long j11, int i11) {
        if (i11 == 1) {
            return j11;
        }
        return ((i11 & 1) == 0 ? zza((j11 * j11) % 1073807359, i11 >> 1) : j11 * (zza((j11 * j11) % 1073807359, i11 >> 1) % 1073807359)) % 1073807359;
    }

    @VisibleForTesting
    public static String zzb(String[] strArr, int i11, int i12) {
        int i13 = i12 + i11;
        if (strArr.length < i13) {
            zzciz.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i14 = i13 - 1;
            if (i11 < i14) {
                sb2.append(strArr[i11]);
                sb2.append(' ');
                i11++;
            } else {
                sb2.append(strArr[i14]);
                return sb2.toString();
            }
        }
    }

    public static void zzc(String[] strArr, int i11, int i12, PriorityQueue<zzazi> priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        if (length < 6) {
            zzd(i11, zze(strArr2, 0, length), zzb(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzd(i11, zze, zzb(strArr2, 0, 6), 6, priorityQueue);
        long zza = zza(16785407, 5);
        int i13 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i13 < length2 - 5) {
                zze = ((((((zze + 1073807359) - ((((((long) zzazf.zza(strArr2[i13 - 1])) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzazf.zza(strArr2[i13 + 5])) + 2147483647L) % 1073807359)) % 1073807359;
                zzd(i11, zze, zzb(strArr2, i13, 6), length2, priorityQueue);
                i13++;
            } else {
                return;
            }
        }
    }

    @VisibleForTesting
    public static void zzd(int i11, long j11, String str, int i12, PriorityQueue<zzazi> priorityQueue) {
        zzazi zzazi = new zzazi(j11, str, i12);
        if ((priorityQueue.size() != i11 || (priorityQueue.peek().zzc <= zzazi.zzc && priorityQueue.peek().zza <= zzazi.zza)) && !priorityQueue.contains(zzazi)) {
            priorityQueue.add(zzazi);
            if (priorityQueue.size() > i11) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i11, int i12) {
        long zza = (((long) zzazf.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i13 = 1; i13 < i12; i13++) {
            zza = (((zza * 16785407) % 1073807359) + ((((long) zzazf.zza(strArr[i13])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
