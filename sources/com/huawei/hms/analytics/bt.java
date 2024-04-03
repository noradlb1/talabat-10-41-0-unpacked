package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.type.ReportPolicy;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class bt {
    private static bt ikl = new bt();
    /* access modifiers changed from: private */
    public bl ghi = cde.lmn().lmn("_openness_config_tag");
    /* access modifiers changed from: private */
    public boolean hij = false;
    private lmn ijk;
    public boolean klm = false;
    public JSONObject lmn;

    /* renamed from: com.huawei.hms.analytics.bt$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] lmn;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huawei.hms.analytics.type.ReportPolicy[] r0 = com.huawei.hms.analytics.type.ReportPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                lmn = r0
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_APP_LAUNCH_POLICY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_SCHEDULED_TIME_POLICY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_CACHE_THRESHOLD_POLICY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = lmn     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.analytics.type.ReportPolicy r1 = com.huawei.hms.analytics.type.ReportPolicy.ON_MOVE_BACKGROUND_POLICY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bt.AnonymousClass2.<clinit>():void");
        }
    }

    public final class lmn extends TimerTask {
        private long ikl = -1;
        private Timer klm = new Timer();

        public lmn() {
        }

        public final boolean klm(long j11) {
            long j12 = this.ikl;
            return (j12 == -1 || j12 == j11) ? false : true;
        }

        public final void lmn() {
            this.klm.cancel();
            this.klm.purge();
            this.klm = null;
        }

        public final void lmn(long j11) {
            this.ikl = j11;
            long j12 = j11 * 1000;
            this.klm.schedule(this, j12, j12);
        }

        public final void run() {
            HiLog.i("PoliceCommander", "Timer report timer running");
            if (bt.this.ghi != null) {
                bt.this.ghi.lmn();
                bt.this.ghi.klm();
            }
            cde.lmn().klm();
        }
    }

    public static bt lmn() {
        return ikl;
    }

    public static void lmn(long j11) {
        av.lmn().lmn.f47856c = j11;
    }

    private void lmn(JSONObject jSONObject) {
        if (this.lmn != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.lmn.remove(keys.next());
            }
            Iterator<String> keys2 = this.lmn.keys();
            if (keys2.hasNext()) {
                String next = keys2.next();
                if ("onMoveBackgroundPolicy".equals(next)) {
                    lmn(false);
                } else if ("onScheduledTime".equals(next)) {
                    this.ijk.lmn();
                    this.ijk = null;
                } else if ("onCacheThreshold".equals(next)) {
                    lmn(30);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("save policies : ");
        boolean z11 = jSONObject instanceof JSONObject;
        sb2.append(!z11 ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        HiLog.i("PoliceCommander", sb2.toString());
        dv.lmn(av.lmn().lmn.ghi, "global_v2", "policies", !z11 ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
    }

    private static void lmn(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            HiLog.w("PoliceCommander", "jsonPut json Exception");
        }
    }

    public static void lmn(boolean z11) {
        e.lmn(av.lmn().lmn.ghi).klm = z11;
    }

    public final void ikl() {
        if (!this.hij) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (bt.this.ghi != null) {
                        boolean unused = bt.this.hij = true;
                        HiLog.i("PoliceCommander", "onAppLaunchPolicy onReport");
                        bt.this.ghi.lmn();
                        bt.this.ghi.klm();
                    }
                    cde.lmn().klm();
                }
            });
        }
    }

    public final void klm() {
        JSONObject jSONObject = new JSONObject();
        this.lmn = jSONObject;
        try {
            jSONObject.put("onMoveBackgroundPolicy", (Object) "");
            this.lmn.put("onCacheThreshold", 30);
        } catch (JSONException unused) {
            HiLog.w("PoliceCommander", "defPolicies json exception");
        }
    }

    public final void klm(long j11) {
        lmn lmn2 = this.ijk;
        if (lmn2 == null) {
            lmn lmn3 = new lmn();
            this.ijk = lmn3;
            lmn3.lmn(j11);
        } else if (lmn2.klm(j11)) {
            this.ijk.lmn();
            lmn lmn4 = new lmn();
            this.ijk = lmn4;
            lmn4.lmn(j11);
        }
    }

    public final synchronized void lmn(Set<ReportPolicy> set) {
        if (set != null) {
            if (set.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (ReportPolicy next : set) {
                    int i11 = AnonymousClass2.lmn[next.ordinal()];
                    boolean z11 = true;
                    if (i11 == 1) {
                        lmn(jSONObject, "onAppLaunch", "");
                        if (!this.lmn.has("onAppLaunch")) {
                            ikl();
                        }
                    } else if (i11 == 2) {
                        long threshold = next.getThreshold();
                        lmn(jSONObject, "onScheduledTime", Long.valueOf(threshold));
                        JSONObject jSONObject2 = this.lmn;
                        if (jSONObject2 != null && jSONObject2.optLong("onScheduledTime", -1) == threshold) {
                            z11 = false;
                        }
                        if (z11) {
                            klm(threshold);
                        }
                    } else if (i11 == 3) {
                        long threshold2 = next.getThreshold();
                        lmn(jSONObject, "onCacheThreshold", Long.valueOf(threshold2));
                        lmn(threshold2);
                    } else if (i11 == 4) {
                        lmn(jSONObject, "onMoveBackgroundPolicy", "");
                        lmn(true);
                    }
                }
                lmn(jSONObject);
                this.lmn = jSONObject;
            }
        }
    }
}
