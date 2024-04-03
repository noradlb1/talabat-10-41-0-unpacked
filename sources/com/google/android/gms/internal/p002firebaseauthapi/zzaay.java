package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay  reason: invalid package */
public final class zzaay {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzaay";

    private zzaay() {
    }

    public static Object zza(String str, Type type) throws zzyq {
        if (type == String.class) {
            try {
                zzacq zzacq = new zzacq();
                zzacq.zzb(str);
                if (zzacq.zzd()) {
                    return zzacq.zzc();
                }
                throw new zzyq("No error message: " + str);
            } catch (Exception e11) {
                throw new zzyq("Json conversion failed! ".concat(String.valueOf(e11.getMessage())), e11);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzaba) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e12) {
                    throw new zzyq("Json conversion failed! ".concat(String.valueOf(e12.getMessage())), e12);
                }
            } catch (Exception e13) {
                throw new zzyq("Instantiation of JsonResponse failed! ".concat(type.toString()), e13);
            }
        }
    }
}
