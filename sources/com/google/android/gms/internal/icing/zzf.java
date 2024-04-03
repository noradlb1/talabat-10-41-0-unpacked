package com.google.android.gms.internal.icing;

import android.accounts.Account;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.List;

@ShowFirstParty
public final class zzf {
    private List<zzk> zza;
    private String zzb;
    private boolean zzc;
    private Account zzd;

    public final zzf zza(zzk zzk) {
        if (this.zza == null) {
            this.zza = new ArrayList();
        }
        this.zza.add(zzk);
        return this;
    }

    public final zzf zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzf zzc(boolean z11) {
        this.zzc = true;
        return this;
    }

    public final zzf zzd(Account account) {
        this.zzd = account;
        return this;
    }

    public final zzg zze() {
        zzk[] zzkArr;
        String str = this.zzb;
        boolean z11 = this.zzc;
        Account account = this.zzd;
        List<zzk> list = this.zza;
        if (list != null) {
            zzkArr = (zzk[]) list.toArray(new zzk[list.size()]);
        } else {
            zzkArr = null;
        }
        return new zzg(str, z11, account, zzkArr);
    }
}
