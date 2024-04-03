package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@VisibleForTesting
public abstract class zzi<T extends zzi> {
    public static String zza(Map map) {
        return zza(map, 1);
    }

    public abstract void zzb(T t11);

    public static String zza(Object obj) {
        return zza(obj, 0);
    }

    private static String zza(Object obj, int i11) {
        if (i11 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof List) {
            StringBuilder sb2 = new StringBuilder();
            if (i11 > 0) {
                sb2.append("[");
            }
            int length = sb2.length();
            for (Object next : (List) obj) {
                if (sb2.length() > length) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(zza(next, i11 + 1));
            }
            if (i11 > 0) {
                sb2.append("]");
            }
            return sb2.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            boolean z11 = false;
            int i12 = 0;
            for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
                String zza = zza(entry.getValue(), i11 + 1);
                if (!TextUtils.isEmpty(zza)) {
                    if (i11 > 0 && !z11) {
                        sb3.append("{");
                        i12 = sb3.length();
                        z11 = true;
                    }
                    if (sb3.length() > i12) {
                        sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    sb3.append((String) entry.getKey());
                    sb3.append(SignatureVisitor.INSTANCEOF);
                    sb3.append(zza);
                }
            }
            if (z11) {
                sb3.append("}");
            }
            return sb3.toString();
        }
    }
}
