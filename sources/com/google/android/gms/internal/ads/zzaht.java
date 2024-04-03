package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class zzaht extends zzahg {
    public zzaht() {
    }

    public zzaht(zzahs zzahs, SSLSocketFactory sSLSocketFactory) {
    }

    @VisibleForTesting
    public static List<zzagk> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String zzagk : (List) next.getValue()) {
                    arrayList.add(new zzagk((String) next.getKey(), zzagk));
                }
            }
        }
        return arrayList;
    }
}
