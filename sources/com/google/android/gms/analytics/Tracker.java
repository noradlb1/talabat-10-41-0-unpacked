package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzan;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzcg;
import com.google.android.gms.internal.gtm.zzcy;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ContainerUtils;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@VisibleForTesting
public class Tracker extends zzan {
    private boolean zztb;
    private final Map<String, String> zztc;
    private final Map<String, String> zztd = new HashMap();
    /* access modifiers changed from: private */
    public final zzcg zzte;
    /* access modifiers changed from: private */
    public final zza zztf;
    private ExceptionReporter zztg;
    /* access modifiers changed from: private */
    public zzcy zzth;

    public class zza extends zzan implements GoogleAnalytics.zza {
        private boolean zztq;
        private int zztr;
        private long zzts = -1;
        private boolean zztt;
        private long zztu;

        public zza(zzap zzap) {
            super(zzap);
        }

        private final void zzay() {
            if (this.zzts >= 0 || this.zztq) {
                zzcr().zza((GoogleAnalytics.zza) Tracker.this.zztf);
            } else {
                zzcr().zzb((GoogleAnalytics.zza) Tracker.this.zztf);
            }
        }

        public final void enableAutoActivityTracking(boolean z11) {
            this.zztq = z11;
            zzay();
        }

        public final void setSessionTimeout(long j11) {
            this.zzts = j11;
            zzay();
        }

        public final void zzaw() {
        }

        public final synchronized boolean zzax() {
            boolean z11;
            z11 = this.zztt;
            this.zztt = false;
            return z11;
        }

        public final void zzc(Activity activity) {
            String str;
            boolean z11;
            if (this.zztr == 0) {
                if (zzcn().elapsedRealtime() >= this.zztu + Math.max(1000, this.zzts)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    this.zztt = true;
                }
            }
            this.zztr++;
            if (this.zztq) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker tracker = Tracker.this;
                if (tracker.zzth != null) {
                    zzcy zzk = Tracker.this.zzth;
                    str = activity.getClass().getCanonicalName();
                    String str2 = zzk.zzacs.get(str);
                    if (str2 != null) {
                        str = str2;
                    }
                } else {
                    str = activity.getClass().getCanonicalName();
                }
                tracker.set("&cd", str);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    Preconditions.checkNotNull(activity);
                    Intent intent2 = activity.getIntent();
                    String str3 = null;
                    if (intent2 != null) {
                        String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str3 = stringExtra;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        hashMap.put("&dr", str3);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        public final void zzd(Activity activity) {
            int i11 = this.zztr - 1;
            this.zztr = i11;
            int max = Math.max(0, i11);
            this.zztr = max;
            if (max == 0) {
                this.zztu = zzcn().elapsedRealtime();
            }
        }
    }

    public Tracker(zzap zzap, String str, zzcg zzcg) {
        super(zzap);
        HashMap hashMap = new HashMap();
        this.zztc = hashMap;
        if (str != null) {
            hashMap.put("&tid", str);
        }
        hashMap.put("useSecure", "1");
        hashMap.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.zzte = new zzcg("tracking", zzcn());
        this.zztf = new zza(zzap);
    }

    public void enableAdvertisingIdCollection(boolean z11) {
        this.zztb = z11;
    }

    public void enableAutoActivityTracking(boolean z11) {
        this.zztf.enableAutoActivityTracking(z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.analytics.ExceptionReporter r0 = r2.zztg     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0007
            r1 = 1
            goto L_0x0008
        L_0x0007:
            r1 = 0
        L_0x0008:
            if (r1 != r3) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            if (r3 == 0) goto L_0x0026
            android.content.Context r3 = r2.getContext()     // Catch:{ all -> 0x0034 }
            java.lang.Thread$UncaughtExceptionHandler r0 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.analytics.ExceptionReporter r1 = new com.google.android.gms.analytics.ExceptionReporter     // Catch:{ all -> 0x0034 }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x0034 }
            r2.zztg = r1     // Catch:{ all -> 0x0034 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "Uncaught exceptions will be reported to Google Analytics"
            r2.zzq(r3)     // Catch:{ all -> 0x0034 }
            goto L_0x0032
        L_0x0026:
            java.lang.Thread$UncaughtExceptionHandler r3 = r0.zzaf()     // Catch:{ all -> 0x0034 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r3)     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "Uncaught exceptions will not be reported to Google Analytics"
            r2.zzq(r3)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public String get(String str) {
        zzdb();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zztc.containsKey(str)) {
            return this.zztc.get(str);
        }
        if (str.equals("&ul")) {
            return zzcz.zza(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzcw().zzeh();
        }
        if (str.equals("&sr")) {
            return zzcz().zzfb();
        }
        if (str.equals("&aid")) {
            return zzcy().zzdv().zzbb();
        }
        if (str.equals("&an")) {
            return zzcy().zzdv().zzaz();
        }
        if (str.equals("&av")) {
            return zzcy().zzdv().zzba();
        }
        if (str.equals("&aiid")) {
            return zzcy().zzdv().zzbc();
        }
        return null;
    }

    public void send(Map<String, String> map) {
        long currentTimeMillis = zzcn().currentTimeMillis();
        if (zzcr().getAppOptOut()) {
            zzr("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzcr().isDryRunEnabled();
        HashMap hashMap = new HashMap();
        zza(this.zztc, hashMap);
        zza(map, hashMap);
        int i11 = 1;
        boolean zzb = zzcz.zzb(this.zztc.get("useSecure"), true);
        Map<String, String> map2 = this.zztd;
        Preconditions.checkNotNull(hashMap);
        if (map2 != null) {
            for (Map.Entry next : map2.entrySet()) {
                String zza2 = zza((Map.Entry<String, String>) next);
                if (zza2 != null && !hashMap.containsKey(zza2)) {
                    hashMap.put(zza2, (String) next.getValue());
                }
            }
        }
        this.zztd.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzco().zza((Map<String, String>) hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzco().zza((Map<String, String>) hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z11 = this.zztb;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.zztc.get("&a")) + 1;
                if (parseInt < Integer.MAX_VALUE) {
                    i11 = parseInt;
                }
                this.zztc.put("&a", Integer.toString(i11));
            }
        }
        zzcq().zza((Runnable) new zzp(this, hashMap, z11, str, currentTimeMillis, isDryRunEnabled, zzb, str2));
    }

    public void set(String str, String str2) {
        Preconditions.checkNotNull(str, "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.zztc.put(str, str2);
        }
    }

    public void setAnonymizeIp(boolean z11) {
        set("&aip", zzcz.zzc(z11));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        String str;
        if (uri != null && !uri.isOpaque()) {
            String queryParameter = uri.getQueryParameter(Constants.REFERRER);
            if (!TextUtils.isEmpty(queryParameter)) {
                String valueOf = String.valueOf(queryParameter);
                if (valueOf.length() != 0) {
                    str = "http://hostname/?".concat(valueOf);
                } else {
                    str = new String("http://hostname/?");
                }
                Uri parse = Uri.parse(str);
                String queryParameter2 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_ID);
                if (queryParameter2 != null) {
                    this.zztd.put("&ci", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.zztd.put("&anid", queryParameter3);
                }
                String queryParameter4 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_CAMPAIGN);
                if (queryParameter4 != null) {
                    this.zztd.put("&cn", queryParameter4);
                }
                String queryParameter5 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_CONTENT);
                if (queryParameter5 != null) {
                    this.zztd.put("&cc", queryParameter5);
                }
                String queryParameter6 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_MEDIUM);
                if (queryParameter6 != null) {
                    this.zztd.put("&cm", queryParameter6);
                }
                String queryParameter7 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_SOURCE);
                if (queryParameter7 != null) {
                    this.zztd.put("&cs", queryParameter7);
                }
                String queryParameter8 = parse.getQueryParameter(ConstantsKt.DEEPLINK_UTM_TERM);
                if (queryParameter8 != null) {
                    this.zztd.put("&ck", queryParameter8);
                }
                String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.zztd.put("&dclid", queryParameter9);
                }
                String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.zztd.put("&gclid", queryParameter10);
                }
                String queryParameter11 = parse.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (queryParameter11 != null) {
                    this.zztd.put("&aclid", queryParameter11);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d11) {
        set("&sf", Double.toString(d11));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i11, int i12) {
        if (i11 >= 0 || i12 >= 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            set("&sr", sb2.toString());
            return;
        }
        zzt("Invalid width or height. The values should be non-negative.");
    }

    public void setSessionTimeout(long j11) {
        this.zztf.setSessionTimeout(j11 * 1000);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z11) {
        set("useSecure", zzcz.zzc(z11));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    public final void zza(zzcy zzcy) {
        zzq("Loading Tracker config values");
        this.zzth = zzcy;
        String str = zzcy.zzacm;
        boolean z11 = false;
        if (str != null) {
            set("&tid", str);
            zza("trackingId loaded", str);
        }
        double d11 = this.zzth.zzacn;
        if (d11 >= 0.0d) {
            String d12 = Double.toString(d11);
            set("&sf", d12);
            zza("Sample frequency loaded", d12);
        }
        int i11 = this.zzth.zzaco;
        if (i11 >= 0) {
            setSessionTimeout((long) i11);
            zza("Session timeout loaded", Integer.valueOf(i11));
        }
        int i12 = this.zzth.zzacp;
        if (i12 != -1) {
            boolean z12 = i12 == 1;
            enableAutoActivityTracking(z12);
            zza("Auto activity tracking loaded", Boolean.valueOf(z12));
        }
        int i13 = this.zzth.zzacq;
        if (i13 != -1) {
            boolean z13 = i13 == 1;
            if (z13) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(z13));
        }
        if (this.zzth.zzacr == 1) {
            z11 = true;
        }
        enableExceptionReporting(z11);
    }

    public final void zzaw() {
        this.zztf.zzag();
        String zzaz = zzcu().zzaz();
        if (zzaz != null) {
            set("&an", zzaz);
        }
        String zzba = zzcu().zzba();
        if (zzba != null) {
            set("&av", zzba);
        }
    }

    private static String zza(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (!(key.startsWith(ContainerUtils.FIELD_DELIMITER) && key.length() >= 2)) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    private static void zza(Map<String, String> map, Map<String, String> map2) {
        Preconditions.checkNotNull(map2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String zza2 = zza((Map.Entry<String, String>) next);
                if (zza2 != null) {
                    map2.put(zza2, (String) next.getValue());
                }
            }
        }
    }
}
