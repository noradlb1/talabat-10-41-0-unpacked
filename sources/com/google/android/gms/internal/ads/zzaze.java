package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import org.apache.commons.lang3.StringUtils;

public final class zzaze {
    private final int zza;
    private final zzazb zzb = new zzazg();

    public zzaze(int i11) {
        this.zza = i11;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append(arrayList.get(i11).toLowerCase(Locale.US));
            sb2.append(10);
        }
        String[] split = sb2.toString().split(StringUtils.LF);
        if (split.length == 0) {
            return "";
        }
        zzazd zzazd = new zzazd();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzazc(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzazf.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzazj.zzc(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzazd.zzb.write(this.zzb.zzb(((zzazi) it.next()).zzb));
            } catch (IOException e11) {
                zzciz.zzh("Error while writing hash to byteStream", e11);
            }
        }
        return zzazd.toString();
    }
}
