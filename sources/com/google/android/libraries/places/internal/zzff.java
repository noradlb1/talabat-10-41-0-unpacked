package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class zzff {
    public static final <A extends Appendable> A zza(A a11, Iterator<? extends Map.Entry> it, zzfh zzfh, String str) throws IOException {
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            a11.append(zzfh.zzf(entry.getKey()));
            a11.append("=");
            a11.append(zzfh.zzf(entry.getValue()));
            while (it.hasNext()) {
                a11.append(zzfh.zza);
                Map.Entry entry2 = (Map.Entry) it.next();
                a11.append(zzfh.zzf(entry2.getKey()));
                a11.append("=");
                a11.append(zzfh.zzf(entry2.getValue()));
            }
        }
        return a11;
    }
}
