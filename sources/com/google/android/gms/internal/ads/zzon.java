package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzon implements zzox {
    public static final /* synthetic */ zzon zza = new zzon();

    private /* synthetic */ zzon() {
    }

    public final int zza(Object obj) {
        int i11 = zzoy.zza;
        String str = ((zzoh) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzfn.zza >= 26) {
            return 0;
        }
        if (str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return -1;
        }
        return 0;
    }
}
