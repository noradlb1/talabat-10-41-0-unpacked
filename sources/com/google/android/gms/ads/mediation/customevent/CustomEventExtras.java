package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zza = new HashMap<>();

    @RecentlyNullable
    public Object getExtra(@RecentlyNonNull String str) {
        return this.zza.get(str);
    }

    public void setExtra(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
        this.zza.put(str, obj);
    }
}
