package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.apptimize.av;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzad;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import java.util.HashMap;
import java.util.Map;

final class zzp implements Runnable {
    private final /* synthetic */ Map zzti;
    private final /* synthetic */ boolean zztj;
    private final /* synthetic */ String zztk;
    private final /* synthetic */ long zztl;
    private final /* synthetic */ boolean zztm;
    private final /* synthetic */ boolean zztn;
    private final /* synthetic */ String zzto;
    private final /* synthetic */ Tracker zztp;

    public zzp(Tracker tracker, Map map, boolean z11, String str, long j11, boolean z12, boolean z13, String str2) {
        this.zztp = tracker;
        this.zzti = map;
        this.zztj = z11;
        this.zztk = str;
        this.zztl = j11;
        this.zztm = z12;
        this.zztn = z13;
        this.zzto = str2;
    }

    public final void run() {
        boolean z11;
        if (this.zztp.zztf.zzax()) {
            this.zzti.put("sc", "start");
        }
        Map map = this.zzti;
        GoogleAnalytics zzcr = this.zztp.zzcr();
        Preconditions.checkNotMainThread("getClientId can not be called from the main thread");
        zzcz.zzc(map, "cid", zzcr.zzab().zzdh().zzeh());
        String str = (String) this.zzti.get("sf");
        if (str != null) {
            double zza = zzcz.zza(str, 100.0d);
            if (zzcz.zza(zza, (String) this.zzti.get("cid"))) {
                this.zztp.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                return;
            }
        }
        zzad zzb = this.zztp.zzcx();
        if (this.zztj) {
            zzcz.zzb((Map<String, String>) this.zzti, "ate", zzb.zzbw());
            zzcz.zzb((Map<String, String>) this.zzti, "adid", zzb.zzcd());
        } else {
            this.zzti.remove("ate");
            this.zzti.remove("adid");
        }
        zzq zzdv = this.zztp.zzcy().zzdv();
        zzcz.zzb((Map<String, String>) this.zzti, "an", zzdv.zzaz());
        zzcz.zzb((Map<String, String>) this.zzti, av.f41238a, zzdv.zzba());
        zzcz.zzb((Map<String, String>) this.zzti, "aid", zzdv.zzbb());
        zzcz.zzb((Map<String, String>) this.zzti, "aiid", zzdv.zzbc());
        this.zzti.put("v", "1");
        this.zzti.put("_v", zzao.zzwe);
        zzcz.zzb((Map<String, String>) this.zzti, "ul", this.zztp.zzcz().zzfa().getLanguage());
        zzcz.zzb((Map<String, String>) this.zzti, "sr", this.zztp.zzcz().zzfb());
        if (this.zztk.equals("transaction") || this.zztk.equals("item")) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || this.zztp.zzte.zzfm()) {
            long zzag = zzcz.zzag((String) this.zzti.get("ht"));
            if (zzag == 0) {
                zzag = this.zztl;
            }
            long j11 = zzag;
            if (this.zztm) {
                this.zztp.zzco().zzc("Dry run enabled. Would have sent hit", new zzcd(this.zztp, this.zzti, j11, this.zztn));
                return;
            }
            HashMap hashMap = new HashMap();
            zzcz.zza((Map<String, String>) hashMap, PushNotificationParser.PUSH_ID_KEY, (Map<String, String>) this.zzti);
            zzcz.zza((Map<String, String>) hashMap, "an", (Map<String, String>) this.zzti);
            zzcz.zza((Map<String, String>) hashMap, "aid", (Map<String, String>) this.zzti);
            zzcz.zza((Map<String, String>) hashMap, av.f41238a, (Map<String, String>) this.zzti);
            zzcz.zza((Map<String, String>) hashMap, "aiid", (Map<String, String>) this.zzti);
            this.zzti.put("_s", String.valueOf(this.zztp.zzcs().zza(new zzas(0, (String) this.zzti.get("cid"), this.zzto, !TextUtils.isEmpty((CharSequence) this.zzti.get("adid")), 0, hashMap))));
            this.zztp.zzcs().zza(new zzcd(this.zztp, this.zzti, j11, this.zztn));
            return;
        }
        this.zztp.zzco().zza((Map<String, String>) this.zzti, "Too many hits sent too quickly, rate limiting invoked");
    }
}
