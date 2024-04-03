package com.google.ads.mediation;

import android.location.Location;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zza;
    private final AdRequest.Gender zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;

    public MediationAdRequest(@RecentlyNonNull Date date, @RecentlyNonNull AdRequest.Gender gender, @RecentlyNonNull Set<String> set, boolean z11, @RecentlyNonNull Location location) {
        this.zza = date;
        this.zzb = gender;
        this.zzc = set;
        this.zzd = z11;
        this.zze = location;
    }

    @RecentlyNonNull
    public Integer getAgeInYears() {
        if (this.zza == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zza);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    @RecentlyNonNull
    public Date getBirthday() {
        return this.zza;
    }

    @RecentlyNonNull
    public AdRequest.Gender getGender() {
        return this.zzb;
    }

    @RecentlyNonNull
    public Set<String> getKeywords() {
        return this.zzc;
    }

    @RecentlyNonNull
    public Location getLocation() {
        return this.zze;
    }

    public boolean isTesting() {
        return this.zzd;
    }
}
