package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.Random;
import net.bytebuddy.utility.JavaConstant;

public final class a {
    private static a klm;
    private String[] ghi;
    private boolean hij;
    private String ijk;
    private final String ikl = "_openness_config_tag";
    final ax lmn = av.lmn().lmn;

    private a() {
    }

    private boolean fgh() {
        Pair<String, String[]> lmn2 = new cg(this.lmn.ghi).lmn();
        if (lmn2 == null) {
            return false;
        }
        IConfig klm2 = this.lmn.f47867n.klm(this.ikl);
        ca caVar = new ca((String) lmn2.first, (String[]) lmn2.second);
        if (klm2 != null && !((String) lmn2.first).equals(klm2.getSite())) {
            lmn(klm2);
            ch.lmn(this.lmn.ghi, caVar, System.currentTimeMillis());
        }
        this.lmn.f47867n.lmn(this.ikl, (IConfig) caVar);
        ds.lmn(this.lmn.ghi, caVar.getSite(), caVar.getServiceUrls());
        return true;
    }

    private IConfig ghi() {
        if (TextUtils.isEmpty(this.ijk)) {
            bc bcVar = this.lmn.f47867n;
            String str = bcVar.hij;
            return new ca(str, bcVar.lmn.get(str));
        }
        String str2 = this.ijk;
        return new ca(str2, this.lmn.f47867n.lmn.get(str2));
    }

    private void hij() {
        if (!this.hij) {
            String[] lmn2 = ds.lmn(this.lmn.ghi);
            if (lmn2.length != 0) {
                this.lmn.f47867n.lmn(this.ikl, (IConfig) new ca(lmn2[0], lmn2[1].split(",")));
                return;
            }
            throw new IllegalArgumentException("No last report address available");
        }
    }

    private IConfig ijk() {
        IConfig klm2 = this.lmn.f47867n.klm(this.ikl);
        if (klm2 != null) {
            return klm2;
        }
        String str = this.ijk;
        if (TextUtils.isEmpty(str)) {
            str = this.lmn.f47867n.hij;
        }
        return new ca(str, this.lmn.f47867n.lmn.get(str));
    }

    private void ikl(String str) {
        this.hij = be.lmn();
        this.ijk = str;
        this.ghi = ds.klm(this.lmn.ghi);
        if (!ikl()) {
            lmn();
        } else {
            new cd(ijk()) {
                public final void lmn(boolean z11, String str) {
                    if (z11) {
                        Context context = a.this.lmn.ghi;
                        dv.lmn(context, "latest_upload_time", "lct_policy_time", str + JavaConstant.Dynamic.DEFAULT_NAME + (System.currentTimeMillis() + (((long) new Random().nextInt(1380)) * 60000)));
                        a.this.klm(str);
                        return;
                    }
                    try {
                        a.this.lmn();
                    } catch (IllegalArgumentException e11) {
                        HiLog.i("RequestBas", e11.getMessage());
                        a.this.klm();
                    }
                }
            }.klm();
        }
    }

    private boolean ikl() {
        return this.ghi.length == 0 || System.currentTimeMillis() - Long.parseLong(this.ghi[1]) > 86400000;
    }

    private void lmn(IConfig iConfig) {
        cde.lmn().lmn(this.ikl).klm(iConfig);
    }

    public static void lmn(String str) {
        if (klm == null) {
            klm = new a();
        }
        klm.ikl(str);
    }

    public final void klm() {
        String str;
        if (TextUtils.isEmpty(this.ijk) || aq.hij.contains(this.ijk)) {
            IConfig klm2 = this.lmn.f47867n.klm(this.ikl);
            if (klm2 != null) {
                str = klm2.getSite();
            } else {
                Context context = this.lmn.ghi;
                str = dv.klm(context, "Privacy_MY", this.ikl + "_region", "");
            }
            IConfig ghi2 = ghi();
            if (!TextUtils.isEmpty(str) && !str.equals(this.ijk)) {
                if (klm2 == null) {
                    klm2 = new ca(str, this.lmn.f47867n.lmn.get(str));
                }
                lmn(klm2);
                ch.lmn(this.lmn.ghi, ghi2, System.currentTimeMillis());
            }
            this.lmn.f47867n.lmn(this.ikl, ghi2);
            Context context2 = this.lmn.ghi;
            dv.lmn(context2, "Privacy_MY", this.ikl + "_region", ghi2.getSite());
            return;
        }
        throw new IllegalArgumentException("The serviceCountryCode invalid, init failed");
    }

    public final void klm(String str) {
        if (!str.equals("0")) {
            if (str.equals(ExifInterface.GPS_MEASUREMENT_2D) && !this.ijk.equals(this.lmn.f47867n.hij)) {
                HiLog.w("LocationPolyHand", "The location policy configuration is different from the site that is transferred.");
            }
            klm();
        } else if (!fgh()) {
            HiLog.w("LocationPolyHand", "Grs request failed");
            hij();
        }
    }

    public final void lmn() {
        String[] strArr = this.ghi;
        if (strArr.length == 0) {
            klm();
        } else {
            klm(strArr[0]);
        }
    }
}
