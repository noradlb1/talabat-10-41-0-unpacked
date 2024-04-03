package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzhb extends zzfu<zzhb> implements Cloneable {
    private static volatile zzhb[] zzbkd;
    private String value = "";
    private String zzbke = "";

    public zzhb() {
        this.zzrj = null;
        this.zzrs = -1;
    }

    public static zzhb[] zzge() {
        if (zzbkd == null) {
            synchronized (zzfy.zzrr) {
                if (zzbkd == null) {
                    zzbkd = new zzhb[0];
                }
            }
        }
        return zzbkd;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzgf */
    public final zzhb clone() {
        try {
            return (zzhb) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhb)) {
            return false;
        }
        zzhb zzhb = (zzhb) obj;
        String str = this.zzbke;
        if (str == null) {
            if (zzhb.zzbke != null) {
                return false;
            }
        } else if (!str.equals(zzhb.zzbke)) {
            return false;
        }
        String str2 = this.value;
        if (str2 == null) {
            if (zzhb.value != null) {
                return false;
            }
        } else if (!str2.equals(zzhb.value)) {
            return false;
        }
        zzfw zzfw = this.zzrj;
        if (zzfw != null && !zzfw.isEmpty()) {
            return this.zzrj.equals(zzhb.zzrj);
        }
        zzfw zzfw2 = zzhb.zzrj;
        return zzfw2 == null || zzfw2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzhb.class.getName().hashCode() + 527) * 31;
        String str = this.zzbke;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        zzfw zzfw = this.zzrj;
        if (zzfw != null && !zzfw.isEmpty()) {
            i11 = this.zzrj.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void zza(zzfs zzfs) throws IOException {
        String str = this.zzbke;
        if (str != null && !str.equals("")) {
            zzfs.zza(1, this.zzbke);
        }
        String str2 = this.value;
        if (str2 != null && !str2.equals("")) {
            zzfs.zza(2, this.value);
        }
        super.zza(zzfs);
    }

    public final int zzen() {
        int zzen = super.zzen();
        String str = this.zzbke;
        if (str != null && !str.equals("")) {
            zzen += zzfs.zzb(1, this.zzbke);
        }
        String str2 = this.value;
        return (str2 == null || str2.equals("")) ? zzen : zzen + zzfs.zzb(2, this.value);
    }

    public final /* synthetic */ zzfu zzeo() throws CloneNotSupportedException {
        return (zzhb) clone();
    }

    public final /* synthetic */ zzfz zzep() throws CloneNotSupportedException {
        return (zzhb) clone();
    }
}
