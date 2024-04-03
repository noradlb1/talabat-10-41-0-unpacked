package com.google.android.gms.internal.ads;

public final class zzpl implements zzrp {
    protected final zzrp[] zza;

    public zzpl(zzrp[] zzrpArr) {
        this.zza = zzrpArr;
    }

    public final long zzb() {
        long j11 = Long.MAX_VALUE;
        for (zzrp zzb : this.zza) {
            long zzb2 = zzb.zzb();
            if (zzb2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, zzb2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final long zzc() {
        long j11 = Long.MAX_VALUE;
        for (zzrp zzc : this.zza) {
            long zzc2 = zzc.zzc();
            if (zzc2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, zzc2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final void zzl(long j11) {
        for (zzrp zzl : this.zza) {
            zzl.zzl(j11);
        }
    }

    public final boolean zzn(long j11) {
        boolean z11;
        long j12 = j11;
        boolean z12 = false;
        while (true) {
            long zzc = zzc();
            if (zzc != Long.MIN_VALUE) {
                boolean z13 = false;
                for (zzrp zzrp : this.zza) {
                    long zzc2 = zzrp.zzc();
                    if (zzc2 == Long.MIN_VALUE || zzc2 > j12) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (zzc2 == zzc || z11) {
                        z13 |= zzrp.zzn(j12);
                    }
                }
                z12 |= z13;
                if (!z13) {
                    break;
                }
            } else {
                break;
            }
        }
        return z12;
    }

    public final boolean zzo() {
        for (zzrp zzo : this.zza) {
            if (zzo.zzo()) {
                return true;
            }
        }
        return false;
    }
}
