package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public final class zzbyy {
    public static int zza(AdRequest.ErrorCode errorCode) {
        AdRequest.ErrorCode errorCode2 = AdRequest.ErrorCode.INVALID_REQUEST;
        AdRequest.Gender gender = AdRequest.Gender.UNKNOWN;
        int ordinal = errorCode.ordinal();
        if (ordinal == 0) {
            return 1;
        }
        if (ordinal != 1) {
            return ordinal != 2 ? 0 : 2;
        }
        return 3;
    }

    public static MediationAdRequest zzb(zzbfd zzbfd, boolean z11) {
        HashSet hashSet;
        AdRequest.Gender gender;
        List<String> list = zzbfd.zze;
        if (list != null) {
            hashSet = new HashSet(list);
        } else {
            hashSet = null;
        }
        HashSet hashSet2 = hashSet;
        Date date = new Date(zzbfd.zzb);
        int i11 = zzbfd.zzd;
        if (i11 == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i11 != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet2, z11, zzbfd.zzk);
    }
}
