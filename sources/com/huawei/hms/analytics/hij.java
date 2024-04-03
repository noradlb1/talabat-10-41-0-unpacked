package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.visa.checkout.Profile;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class hij implements Runnable {
    protected String fgh;
    protected cj ghi;
    protected String hij;
    protected ikl ijk;
    protected String ikl;
    protected Context klm;
    protected ax lmn;

    public hij(Context context, String str, String str2, String str3) {
        this.klm = context;
        this.ikl = str;
        this.hij = TextUtils.isEmpty(str2) ? "" : str2.toUpperCase(Locale.ENGLISH);
        this.lmn = av.lmn().lmn;
        this.fgh = str3;
    }

    public final IConfig klm() {
        bc bcVar = av.lmn().lmn.f47867n;
        if (TextUtils.isEmpty(this.hij)) {
            String str = bcVar.hij;
            return new ca(str, bcVar.lmn.get(str));
        }
        String[] strArr = bcVar.lmn.get(this.hij);
        return strArr != null ? new ca(this.hij, strArr) : new ca(this.hij, bcVar.lmn.get(bcVar.hij));
    }

    public final void lmn() {
        SyncManager.getInstance().start(this.fgh);
        if (!be.klm()) {
            new klm();
            AGConnectOptions lmn2 = klm.lmn(this.klm);
            if (lmn2 != null) {
                String string = lmn2.getString("client/app_id");
                String string2 = lmn2.getString("client/product_id", "");
                String string3 = lmn2.getString("service/analytics/resource_id", "");
                String string4 = lmn2.getString("client/client_id", "");
                String string5 = lmn2.getString("region", "");
                if (!TextUtils.isEmpty(string2)) {
                    bc bcVar = new bc();
                    String string6 = lmn2.getString("service/analytics/collector_url");
                    String string7 = lmn2.getString("service/analytics/collector_url_cn", "");
                    String string8 = lmn2.getString("service/analytics/collector_url_de", "");
                    String string9 = lmn2.getString("service/analytics/collector_url_ru", "");
                    String str = "onCacheThreshold";
                    String string10 = lmn2.getString("service/analytics/collector_url_sg", "");
                    String[] lmn3 = klm.lmn(string6);
                    HashMap hashMap = new HashMap();
                    String str2 = "onScheduledTime";
                    klm.lmn(hashMap, Profile.Country.CN, klm.lmn(string7));
                    klm.lmn(hashMap, "DE", klm.lmn(string8));
                    klm.lmn(hashMap, "RU", klm.lmn(string9));
                    klm.lmn(hashMap, Profile.Country.SG, klm.lmn(string10));
                    klm.lmn(hashMap, string5, lmn3);
                    bcVar.lmn = hashMap;
                    bcVar.klm = string;
                    bcVar.hij = string5;
                    bcVar.ikl = string2;
                    bcVar.ghi = string4;
                    bcVar.ijk = string3;
                    lmn(bcVar);
                    this.lmn.f47867n = bcVar;
                    String hij2 = dp.hij(this.klm);
                    String klm2 = dv.klm(this.klm, "global_v2", "ab_info", "");
                    String klm3 = dv.klm(this.klm, "global_v2", "app_ver", "");
                    dv.lmn(this.klm, "global_v2", "app_ver", hij2);
                    boolean klm4 = dv.klm(this.klm, "global_v2", "is_analytics_enabled", true);
                    boolean klm5 = dv.lmn(this.klm, "global_v2", "is_restriction_enabled") ? dv.klm(this.klm, "global_v2", "is_restriction_enabled", false) : !klm4;
                    boolean klm6 = dv.klm(this.klm, "global_v2", "is_restriction_shared", false);
                    String klm7 = dv.klm(this.klm, "global_v2", "w_app_id", "");
                    Context context = this.klm;
                    if (!dv.lmn(context, "global_v2", "dis_pros")) {
                        String ijk2 = dp.ijk(context);
                        if (!TextUtils.isEmpty(ijk2) && dl.lmn(ijk2, 256)) {
                            dq.lmn(context, dq.lmn(ijk2.toUpperCase(Locale.ENGLISH)));
                        }
                    }
                    ax axVar = this.lmn;
                    axVar.klm = hij2;
                    axVar.ikl = klm3;
                    String ikl2 = dp.ikl(this.klm);
                    String klm8 = dv.klm(this.klm, "global_v2", "api_channel", "");
                    this.lmn.f47875v = klm8;
                    if (!TextUtils.isEmpty(ikl2)) {
                        if (!TextUtils.isEmpty(klm8)) {
                            dv.lmn(this.klm, "global_v2", "api_channel", "");
                            this.lmn.f47875v = "";
                        }
                        this.lmn.ijk = ikl2;
                    }
                    this.lmn.f47860g = klm2;
                    if (dv.lmn(this.klm, "global_v2", "push_token_collection_enable")) {
                        this.lmn.f47877x = dv.klm(this.klm, "global_v2", "push_token_collection_enable", true);
                    } else {
                        this.lmn.f47877x = dp.lmn(this.klm, "analyticskit_pushtoken_collection_enabled");
                    }
                    if (dv.lmn(this.klm, "global_v2", "is_enabled_adsid")) {
                        this.lmn.f47864k = dv.klm(this.klm, "global_v2", "is_enabled_adsid", true);
                    } else {
                        this.lmn.f47864k = dp.lmn(this.klm, "analyticskit_adsid_collection_enabled");
                    }
                    ax axVar2 = this.lmn;
                    axVar2.fgh = klm4;
                    axVar2.efg = klm5;
                    axVar2.def = klm6;
                    axVar2.f47874u = klm7;
                    String[] lmn4 = ds.lmn(this.klm);
                    if (lmn4.length != 0) {
                        this.lmn.f47867n.lmn(this.ikl, (IConfig) new ca(lmn4[0], lmn4[1].split(",")));
                    }
                    dh.lmn().lmn(this.klm);
                    new Thread(new co(this.klm)).start();
                    bt lmn5 = bt.lmn();
                    if (!lmn5.klm) {
                        lmn5.klm = true;
                        Context context2 = av.lmn().lmn.ghi;
                        String klm9 = dv.klm(context2, "global_v2", "policies", "");
                        if (!klm9.isEmpty()) {
                            try {
                                JSONObject jSONObject = new JSONObject(klm9);
                                lmn5.lmn = jSONObject;
                                if (jSONObject.has("onAppLaunch")) {
                                    lmn5.ikl();
                                }
                                if (!lmn5.lmn.has("onMoveBackgroundPolicy")) {
                                    bt.lmn(false);
                                }
                                String str3 = str2;
                                if (lmn5.lmn.has(str3)) {
                                    lmn5.klm(lmn5.lmn.optLong(str3, 60));
                                }
                                String str4 = str;
                                if (lmn5.lmn.has(str4)) {
                                    bt.lmn(lmn5.lmn.optLong(str4, 30));
                                }
                            } catch (JSONException unused) {
                                HiLog.w("PoliceCommander", "cache policies is error, begin clear it");
                                dv.lmn(context2, "global_v2", "policies");
                            }
                        }
                        lmn5.klm();
                    }
                    new dy().lmn();
                    be.ikl();
                } else {
                    HiLog.e("jsonParses", HiLog.ErrorCode.CE001, "Cannot find productId from agconnect-services.json");
                    throw new IllegalArgumentException("config params is error");
                }
            } else {
                throw new IllegalArgumentException("options is null");
            }
        }
        if ("UNKNOWN".equals(this.hij)) {
            this.hij = this.lmn.f47867n.hij;
        }
        if (("_openness_config_tag".equals(this.ikl) || aq.fgh.contains(this.ikl)) && TextUtils.isEmpty(dv.klm(this.klm, "global_v2", "firstRunTime", ""))) {
            dv.lmn(this.klm, "global_v2", "firstRunTime", String.valueOf(System.currentTimeMillis()));
        }
    }

    public abstract void lmn(bc bcVar);

    public final void lmn(cj cjVar) {
        this.ghi = cjVar;
    }

    public final void lmn(ikl ikl2) {
        this.ijk = ikl2;
    }
}
