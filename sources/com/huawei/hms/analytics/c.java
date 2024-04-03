package com.huawei.hms.analytics;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.type.HAParamType;
import java.util.HashMap;
import java.util.Map;

public final class c {
    static c klm = new c();
    /* access modifiers changed from: private */
    public boolean abc = false;
    public final Bundle bcd = new Bundle();
    public final Bundle cde = new Bundle();
    public bl def;
    final Handler efg = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: package-private */
    public boolean fgh = false;
    public long ghi = 0;
    public lmn hij;
    public lmn ijk = new lmn("", "", "", 0);
    public lmn ikl = new lmn("", "", "", 0);
    public final Map<String, lmn> lmn = new HashMap();

    public static class lmn {
        public long ijk;
        public String ikl;
        public String klm;
        public String lmn;

        public lmn(String str, String str2, String str3, long j11) {
            this.lmn = str;
            this.klm = str2;
            this.ikl = str3;
            this.ijk = j11;
        }

        public final void lmn() {
            this.lmn = "";
            this.klm = "";
            this.ikl = "";
            this.ijk = 0;
        }
    }

    public static c lmn() {
        return klm;
    }

    public final void lmn(long j11) {
        HiLog.d("ActivityStatCommander", "onScreenExit with time: ".concat(String.valueOf(j11)));
        lmn lmn2 = this.ikl;
        if (lmn2 == null) {
            HiLog.w("ActivityStatCommander", "onScreenEnter should be invoked first.");
            return;
        }
        long j12 = lmn2.ijk;
        if (j12 == 0) {
            HiLog.w("ActivityStatCommander", "timestamp is 0.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("$CurActivityName", this.ikl.lmn);
        bundle.putString("$CurActivityClass", this.ikl.klm);
        bundle.putString("$CurActivityId", this.ikl.ikl);
        bundle.putString("$PrePageId", this.cde.getString("$PrevActivityClass", ""));
        bundle.putString("$CurrPageId", this.cde.getString("$CurActivityClass", ""));
        HiLog.d("ActivityStatCommander", "onScreenExit duration cal: 1. " + j11 + " 2. " + j12);
        bundle.putString(HAParamType.DURATION, String.valueOf(Math.min(j11 - j12, 604800000)));
        HiLog.i("ActivityStatCommander", "onScreenExit: send ScreenExit event...");
        this.def.lmn("$ExitScreen", new dt("$ExitScreen", bundle), j11);
        this.fgh = false;
    }

    public final void lmn(Activity activity, Bundle bundle, long j11) {
        HiLog.d("ActivityStatCommander", "onScreenEnterDelayed with time: ".concat(String.valueOf(j11)));
        if (!av.lmn().lmn.fgh) {
            HiLog.w("ActivityStatCommander", "auto collect is closed");
            return;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        final long j12 = j11;
        lmn lmn2 = new lmn(canonicalName, canonicalName, String.valueOf(activity.getTaskId()), j12);
        this.abc = true;
        final Activity activity2 = activity;
        final lmn lmn3 = lmn2;
        final Bundle bundle2 = bundle;
        this.efg.postDelayed(new Runnable() {
            public final void run() {
                if (c.this.abc) {
                    HiLog.d("ActivityStatCommander", "isEnterDelayed = true, no override screen event...");
                    try {
                        c.this.lmn(lmn3, bundle2, j12);
                    } catch (Throwable th2) {
                        HiLog.w("ActivityStatCommander", "onScreenEnter error: " + th2.getMessage());
                        dr.lmn(th2);
                    }
                }
            }
        }, 100);
        this.lmn.clear();
        this.ijk = null;
    }

    public final void lmn(lmn lmn2, Bundle bundle, long j11) {
        lmn lmn3;
        Bundle bundle2;
        HiLog.d("ActivityStatCommander", "onScreenEnterSend");
        lmn lmn4 = this.hij;
        if (lmn4 == null) {
            bundle.putString("$PrevActivityName", this.ikl.lmn);
            bundle.putString("$PrevActivityClass", this.ikl.klm);
            bundle.putString("$PrevActivityId", this.ikl.ikl);
            bundle.putString("$PrePageId", this.ikl.klm);
            bundle2 = this.cde;
            lmn3 = this.ikl;
        } else {
            bundle.putString("$PrevActivityName", lmn4.lmn);
            bundle.putString("$PrevActivityClass", this.hij.klm);
            bundle.putString("$PrevActivityId", this.hij.ikl);
            bundle.putString("$PrePageId", this.hij.klm);
            bundle2 = this.cde;
            lmn3 = this.hij;
        }
        bundle2.putString("$PrevActivityClass", lmn3.klm);
        bundle.putString("$CurActivityName", lmn2.lmn);
        bundle.putString("$CurActivityClass", lmn2.klm);
        bundle.putString("$CurActivityId", lmn2.ikl);
        bundle.putString("$CurrPageId", lmn2.klm);
        this.def.lmn("$EnterScreen", new dt("$EnterScreen", bundle), j11);
        this.cde.putString("$CurActivityClass", lmn2.klm);
        this.abc = false;
        this.ikl = lmn2;
    }
}
