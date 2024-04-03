package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadv;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeq;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public final class zzbc {
    @Nullable
    public static MultiFactorInfo zza(zzadv zzadv) {
        if (zzadv == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzadv.zzf())) {
            return new PhoneMultiFactorInfo(zzadv.zze(), zzadv.zzd(), zzadv.zza(), Preconditions.checkNotEmpty(zzadv.zzf()));
        }
        if (zzadv.zzc() != null) {
            return new TotpMultiFactorInfo(zzadv.zze(), zzadv.zzd(), zzadv.zza(), (zzaeq) Preconditions.checkNotNull(zzadv.zzc(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List zzb(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo zza = zza((zzadv) it.next());
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        return arrayList;
    }
}
