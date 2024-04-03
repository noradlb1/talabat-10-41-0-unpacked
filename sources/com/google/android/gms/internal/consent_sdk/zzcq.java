package com.google.android.gms.internal.consent_sdk;

public final class zzcq<T> implements zzct<T> {
    private static final Object zza = new Object();
    private volatile zzct<T> zzb;
    private volatile Object zzc = zza;

    private zzcq(zzct<T> zzct) {
        this.zzb = zzct;
    }

    public final T zza() {
        T t11 = this.zzc;
        T t12 = zza;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.zzc;
                if (t11 == t12) {
                    t11 = this.zzb.zza();
                    T t13 = this.zzc;
                    if (t13 != t12 && !(t13 instanceof zzcr)) {
                        if (t13 != t11) {
                            String valueOf = String.valueOf(t13);
                            String valueOf2 = String.valueOf(t11);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb2.append("Scoped provider was invoked recursively returning different results: ");
                            sb2.append(valueOf);
                            sb2.append(" & ");
                            sb2.append(valueOf2);
                            sb2.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb2.toString());
                        }
                    }
                    this.zzc = t11;
                    this.zzb = null;
                }
            }
        }
        return t11;
    }

    public static <P extends zzct<T>, T> zzct<T> zza(P p11) {
        zzcu.zza(p11);
        if (p11 instanceof zzcq) {
            return p11;
        }
        return new zzcq(p11);
    }
}
