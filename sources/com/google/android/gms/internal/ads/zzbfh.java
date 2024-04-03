package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class zzbfh {
    public static final zzbfh zza = new zzbfh();

    public final zzbfd zza(Context context, zzbjg zzbjg) {
        long j11;
        List list;
        Context context2;
        zzbeu zzbeu;
        zzbkm zzbkm;
        String str;
        String str2;
        zzbjg zzbjg2 = zzbjg;
        Date zzp = zzbjg.zzp();
        if (zzp != null) {
            j11 = zzp.getTime();
        } else {
            j11 = -1;
        }
        long j12 = j11;
        String zzm = zzbjg.zzm();
        int zza2 = zzbjg.zza();
        Set<String> zzt = zzbjg.zzt();
        if (!zzt.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zzt));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzv = zzbjg2.zzv(context2);
        Location zzd = zzbjg.zzd();
        Bundle zzg = zzbjg2.zzg(AdMobAdapter.class);
        AdInfo zzj = zzbjg.zzj();
        if (zzj != null) {
            QueryInfo queryInfo = zzj.getQueryInfo();
            if (queryInfo != null) {
                str2 = queryInfo.zza().zzc();
            } else {
                str2 = "";
            }
            zzbeu = new zzbeu(zzbjg.zzj().getAdString(), str2);
        } else {
            zzbeu = null;
        }
        String zzn = zzbjg.zzn();
        SearchAdRequest zzk = zzbjg.zzk();
        if (zzk != null) {
            zzbkm = new zzbkm(zzk);
        } else {
            zzbkm = null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzbgo.zzb();
            str = zzcis.zzl(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzu = zzbjg.zzu();
        RequestConfiguration zzc = zzbjq.zzf().zzc();
        int max = Math.max(zzbjg.zzc(), zzc.getTagForChildDirectedTreatment());
        int max2 = Math.max(-1, zzc.getTagForUnderAgeOfConsent());
        String[] strArr = {null, zzc.getMaxAdContentRating()};
        return new zzbfd(8, j12, zzg, zza2, list, zzv, max, false, zzn, zzbkm, zzd, zzm, zzbjg.zzh(), zzbjg.zzf(), Collections.unmodifiableList(new ArrayList(zzbjg.zzs())), zzbjg.zzo(), str, zzu, zzbeu, max2, (String) Collections.max(Arrays.asList(strArr), zzbfg.zza), zzbjg.zzq(), zzbjg.zzb(), zzbjg.zzl());
    }
}
