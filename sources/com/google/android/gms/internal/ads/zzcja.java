package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcja {
    public static boolean zza(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            if (bundle == null && bundle2 == null) {
                return true;
            }
            return false;
        } else if (bundle.size() != bundle2.size()) {
            return false;
        } else {
            for (String next : bundle.keySet()) {
                if (!bundle2.containsKey(next)) {
                    return false;
                }
                Object obj = bundle.get(next);
                Object obj2 = bundle2.get(next);
                if (obj == null || obj2 == null) {
                    if (obj == null && obj2 == null) {
                        return true;
                    }
                    return false;
                } else if (obj instanceof Bundle) {
                    if (!(obj2 instanceof Bundle) || !zza((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    if (!obj2.getClass().isArray() || length != Array.getLength(obj2)) {
                        return false;
                    }
                    for (int i11 = 0; i11 < length; i11++) {
                        if (!Objects.equal(Array.get(obj, i11), Array.get(obj2, i11))) {
                            return false;
                        }
                    }
                    continue;
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
