package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import java.util.Comparator;

public final /* synthetic */ class zzt implements Comparator {
    public static final /* synthetic */ zzt zza = new zzt();

    private /* synthetic */ zzt() {
    }

    public final int compare(Object obj, Object obj2) {
        int i11 = zzu.zza;
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }
}
