package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzbj implements zzau {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzbj> zzgh = new ArrayMap();
    private final Object zzfm = new Object();
    private volatile Map<String, ?> zzfn;
    @GuardedBy("this")
    private final List<zzar> zzfo = new ArrayList();
    private final SharedPreferences zzgi;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzgj;

    private zzbj(SharedPreferences sharedPreferences) {
        zzbm zzbm = new zzbm(this);
        this.zzgj = zzbm;
        this.zzgi = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzbm);
    }

    public static zzbj zzb(Context context, String str) {
        zzbj zzbj;
        SharedPreferences sharedPreferences;
        if (!((!zzan.zzs() || str.startsWith("direct_boot:")) ? true : zzan.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbj.class) {
            Map<String, zzbj> map = zzgh;
            zzbj = map.get(str);
            if (zzbj == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzan.zzs()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzbj = new zzbj(sharedPreferences);
                map.put(str, zzbj);
            }
        }
        return zzbj;
    }

    public static synchronized void zzx() {
        synchronized (zzbj.class) {
            for (zzbj next : zzgh.values()) {
                next.zzgi.unregisterOnSharedPreferenceChangeListener(next.zzgj);
            }
            zzgh.clear();
        }
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzfm) {
            this.zzfn = null;
            zzbe.zzab();
        }
        synchronized (this) {
            for (zzar zzz : this.zzfo) {
                zzz.zzz();
            }
        }
    }

    public final Object zzb(String str) {
        Map<String, ?> map = this.zzfn;
        if (map == null) {
            synchronized (this.zzfm) {
                map = this.zzfn;
                if (map == null) {
                    map = this.zzgi.getAll();
                    this.zzfn = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
