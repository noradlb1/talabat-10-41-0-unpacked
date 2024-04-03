package com.google.android.gms.internal.ads;

public final class zzgpq<T> implements zzgqe, zzgpl {
    private static final Object zza = new Object();
    private volatile zzgqe<T> zzb;
    private volatile Object zzc = zza;

    private zzgpq(zzgqe<T> zzgqe) {
        this.zzb = zzgqe;
    }

    public static <P extends zzgqe<T>, T> zzgpl<T> zza(P p11) {
        if (p11 instanceof zzgpl) {
            return (zzgpl) p11;
        }
        p11.getClass();
        return new zzgpq(p11);
    }

    public static <P extends zzgqe<T>, T> zzgqe<T> zzc(P p11) {
        p11.getClass();
        if (p11 instanceof zzgpq) {
            return p11;
        }
        return new zzgpq(p11);
    }

    public final T zzb() {
        T t11 = this.zzc;
        T t12 = zza;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.zzc;
                if (t11 == t12) {
                    t11 = this.zzb.zzb();
                    T t13 = this.zzc;
                    if (t13 != t12) {
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
}
