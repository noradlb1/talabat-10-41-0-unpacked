package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacn  reason: invalid package */
public final class zzacn {
    private static final Map zza = new ArrayMap();
    private static final Map zzb = new ArrayMap();

    @NonNull
    public static String zza(String str) {
        zzacl zzacl;
        Map map = zza;
        synchronized (map) {
            zzacl = (zzacl) map.get(str);
        }
        if (zzacl != null) {
            return zzh(zzacl.zzb(), zzacl.zza(), zzacl.zzb().contains(CertificateUtil.DELIMITER)).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    @NonNull
    public static String zzb(String str) {
        zzacl zzacl;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacl = (zzacl) map.get(str);
        }
        if (zzacl != null) {
            str2 = "".concat(zzh(zzacl.zzb(), zzacl.zza(), zzacl.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    @NonNull
    public static String zzc(String str) {
        zzacl zzacl;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacl = (zzacl) map.get(str);
        }
        if (zzacl != null) {
            str2 = "".concat(zzh(zzacl.zzb(), zzacl.zza(), zzacl.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("identitytoolkit.googleapis.com/v2");
    }

    @NonNull
    public static String zzd(String str) {
        zzacl zzacl;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacl = (zzacl) map.get(str);
        }
        if (zzacl != null) {
            str2 = "".concat(zzh(zzacl.zzb(), zzacl.zza(), zzacl.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzacm zzacm) {
        Map map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                ((List) map.get(str)).add(new WeakReference(zzacm));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzacm));
                map.put(str, arrayList);
            }
        }
    }

    public static void zzf(@NonNull FirebaseApp firebaseApp, @NonNull String str, int i11) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzacl(str, i11));
        }
        Map map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z11 = false;
                for (WeakReference weakReference : (List) map2.get(apiKey)) {
                    zzacm zzacm = (zzacm) weakReference.get();
                    if (zzacm != null) {
                        zzacm.zzk();
                        z11 = true;
                    }
                }
                if (!z11) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzg(@NonNull FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String zzh(String str, int i11, boolean z11) {
        if (z11) {
            return "http://[" + str + "]:" + i11 + "/";
        }
        return "http://" + str + CertificateUtil.DELIMITER + i11 + "/";
    }
}
