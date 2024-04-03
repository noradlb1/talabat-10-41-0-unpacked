package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfu;
import java.io.IOException;

public class zzfu<M extends zzfu<M>> extends zzfz {
    protected zzfw zzrj;

    public void zza(zzfs zzfs) throws IOException {
        if (this.zzrj != null) {
            for (int i11 = 0; i11 < this.zzrj.size(); i11++) {
                this.zzrj.zzaq(i11).zza(zzfs);
            }
        }
    }

    public int zzen() {
        if (this.zzrj != null) {
            for (int i11 = 0; i11 < this.zzrj.size(); i11++) {
                this.zzrj.zzaq(i11).zzen();
            }
        }
        return 0;
    }

    /* renamed from: zzeo */
    public M clone() throws CloneNotSupportedException {
        M m11 = (zzfu) super.clone();
        zzfy.zza(this, (zzfu) m11);
        return m11;
    }

    public /* synthetic */ zzfz zzep() throws CloneNotSupportedException {
        return (zzfu) clone();
    }
}
