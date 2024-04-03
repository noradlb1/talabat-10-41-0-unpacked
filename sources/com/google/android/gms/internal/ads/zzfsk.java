package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

final class zzfsk {
    public static int zza(int i11) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i11) * -862048943), 15)) * 461845907);
    }

    public static int zzb(@CheckForNull Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
