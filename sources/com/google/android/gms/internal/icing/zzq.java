package com.google.android.gms.internal.icing;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
public final class zzq {
    @VisibleForTesting
    static final String[] zza = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
    private static final Map<String, Integer> zzb = new HashMap(10);

    static {
        int i11 = 0;
        while (true) {
            String[] strArr = zza;
            int length = strArr.length;
            if (i11 < 10) {
                zzb.put(strArr[i11], Integer.valueOf(i11));
                i11++;
            } else {
                return;
            }
        }
    }

    public static String zza(int i11) {
        if (i11 < 0) {
            return null;
        }
        String[] strArr = zza;
        int length = strArr.length;
        if (i11 >= 10) {
            return null;
        }
        return strArr[i11];
    }

    public static int zzb(String str) {
        Integer num = zzb.get(str);
        if (num != null) {
            return num.intValue();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 44);
        sb2.append("[");
        sb2.append(str);
        sb2.append("] is not a valid global search section name");
        throw new IllegalArgumentException(sb2.toString());
    }
}
