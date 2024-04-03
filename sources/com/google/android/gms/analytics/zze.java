package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@VisibleForTesting
public final class zze implements zzo {
    private static final Uri zzrh;
    private final LogPrinter zzsb = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority(ImagesContract.LOCAL);
        zzrh = builder.build();
    }

    public final Uri zzae() {
        return zzrh;
    }

    public final void zzb(zzg zzg) {
        ArrayList arrayList = new ArrayList(zzg.zzaj());
        Collections.sort(arrayList, new zzf(this));
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            String obj2 = ((zzi) obj).toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb2.length() != 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(obj2);
            }
        }
        this.zzsb.println(sb2.toString());
    }
}
