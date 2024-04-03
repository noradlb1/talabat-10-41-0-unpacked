package com.google.android.gms.internal.vision;

final class zzda {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("null key in entry: null=");
            sb2.append(valueOf);
            throw new NullPointerException(sb2.toString());
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 26);
            sb3.append("null value in entry: ");
            sb3.append(valueOf2);
            sb3.append("=null");
            throw new NullPointerException(sb3.toString());
        }
    }
}
