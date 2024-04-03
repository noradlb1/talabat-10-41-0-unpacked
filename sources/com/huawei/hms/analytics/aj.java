package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.m;
import com.visa.checkout.Profile;

public final class aj implements m.lmn {
    private static ah klm;
    private static final aj lmn = new aj();

    private static void klm(String str, String str2, String str3) {
        av.lmn().lmn.f47861h = str;
        av.lmn().lmn.f47863j = str2;
        av.lmn().lmn.f47862i = str3;
    }

    public static void lmn(Context context, IConfig iConfig) {
        boolean z11;
        HiLog.d("oaidMg", "start get oaid");
        boolean z12 = false;
        ah ahVar = null;
        if (!Profile.Country.CN.equals(iConfig.getSite()) && !"RU".equals(iConfig.getSite()) && !Profile.Country.SG.equals(iConfig.getSite())) {
            if ("DE".equals(iConfig.getSite())) {
                new ce(iConfig).klm();
                z11 = av.lmn().lmn.f47866m;
            } else {
                z11 = false;
            }
            if (!z11) {
                klm((String) null, (String) null, (String) null);
                HiLog.i("oaidMg", "The current config does not support oaid collection.");
                return;
            }
        }
        if (!av.lmn().lmn.f47864k) {
            klm("", "", "");
            HiLog.i("oaidMg", "Stopped collecting oaid.");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - av.lmn().lmn.f47876w > 86400000) {
            av.lmn().lmn.f47876w = currentTimeMillis;
            ah ahVar2 = klm;
            if (ahVar2 != null) {
                ahVar = ahVar2;
            } else {
                if (!ad.lmn() && !ad.klm()) {
                    String str = Build.MANUFACTURER;
                    if (!"COOLPAD".equalsIgnoreCase(str) && !"XIAOLAJIAO".equalsIgnoreCase(str) && !"GIONEE".equalsIgnoreCase(str)) {
                        if (ad.ikl() || "ONEPLUS".equalsIgnoreCase(str)) {
                            ahVar = new ak(context, lmn);
                        } else if ("MOTOROLA".equalsIgnoreCase(str)) {
                            ahVar = new ae(context, lmn);
                        } else if (ad.ijk() || ad.ghi()) {
                            ahVar = new an(context, lmn);
                        } else if ("NUBIA".equalsIgnoreCase(str)) {
                            ahVar = new ag(context, lmn);
                        } else {
                            if (!"DOOV".equalsIgnoreCase(str)) {
                                if (!("FREEMEOS".equalsIgnoreCase(str) || !TextUtils.isEmpty(dp.lmn("ro.build.freeme.label", "")))) {
                                    if ("SAMSUNG".equalsIgnoreCase(str)) {
                                        ahVar = new al(context, lmn);
                                    } else if (ad.hij()) {
                                        ahVar = new am(context, lmn);
                                    } else {
                                        if ("MEIZU".equalsIgnoreCase(str) || "FLYME".equals(Build.DISPLAY)) {
                                            z12 = true;
                                        }
                                        if (z12) {
                                            ahVar = new af(context, lmn);
                                        }
                                    }
                                }
                            }
                            ahVar = new ac(context, lmn);
                        }
                    }
                }
                ahVar = new ac(context, lmn);
            }
            klm = ahVar;
            if (ahVar == null) {
                klm("", "", "");
            } else if (ahVar.klm()) {
                klm.lmn();
            } else {
                klm.lmn("No support collect oid");
            }
        }
    }

    public final void lmn(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str = dh.lmn().klm();
            str2 = "";
            str3 = "aaid";
        }
        klm(str, str2, str3);
    }
}
