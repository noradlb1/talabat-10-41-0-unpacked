package com.huawei.hms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Field;

public final class di {
    private static String ijk(cb cbVar) {
        String str;
        String lmn = lmn(cbVar, "$CampaignPushInfo", "activityId");
        if (!TextUtils.isEmpty(lmn)) {
            str = "get taskId by camp";
        } else {
            lmn = dm.lmn(lmn(cbVar), "aid");
            if (!TextUtils.isEmpty(lmn)) {
                str = "get taskId by HMS push";
            } else {
                String lmn2 = lmn(cbVar, RemoteMessageConst.ANALYTIC_INFO, "taskId");
                if (!TextUtils.isEmpty(lmn2)) {
                    HiLog.i("ActivityReferrerToolsKit", "get taskId by push");
                    return lmn2;
                }
                HiLog.d("ActivityReferrerToolsKit", "get taskId is empty");
                return "";
            }
        }
        HiLog.i("ActivityReferrerToolsKit", str);
        return lmn;
    }

    private static String ikl(Activity activity) {
        try {
            return activity.getCallingPackage();
        } catch (Throwable th2) {
            HiLog.w("ActivityReferrerToolsKit", "getCallingPackage exception. " + th2.getMessage());
            return "";
        }
    }

    private static String ikl(cb cbVar) {
        String lmn = dm.lmn(lmn(cbVar), "s");
        return !TextUtils.isEmpty(lmn) ? lmn : lmn(cbVar, RemoteMessageConst.ANALYTIC_INFO, "source");
    }

    private static String klm(Activity activity) {
        String str;
        try {
            Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            str = (String) declaredField.get(activity);
        } catch (Throwable unused) {
            HiLog.w("ActivityReferrerToolsKit", "No referrer.");
            str = "";
        }
        return str == null ? "" : str;
    }

    private static String klm(Activity activity, cb cbVar) {
        String str;
        String str2;
        String lmn = lmn(cbVar, "AnalyticsKit-Info", "_s");
        if (!TextUtils.isEmpty(lmn)) {
            str2 = "get start info by custom";
        } else {
            lmn = lmn(cbVar, "$CampaignPushInfo", "source");
            if (!TextUtils.isEmpty(lmn)) {
                str2 = "get start info by camp";
            } else {
                String ikl = ikl(cbVar);
                if (!TextUtils.isEmpty(ikl)) {
                    str = "get start info by push";
                } else {
                    ikl = klm(activity);
                    if (!TextUtils.isEmpty(ikl)) {
                        str = "get start info by reflect";
                    } else {
                        String ikl2 = ikl(activity);
                        if (!TextUtils.isEmpty(ikl2)) {
                            HiLog.i("ActivityReferrerToolsKit", "get start info by pkg");
                            return ikl2;
                        }
                        HiLog.d("ActivityReferrerToolsKit", "get start info empty");
                        return "";
                    }
                }
                HiLog.i("ActivityReferrerToolsKit", str);
                return ikl;
            }
        }
        HiLog.i("ActivityReferrerToolsKit", str2);
        return lmn;
    }

    public static void klm(cb cbVar) {
        if (cbVar != null) {
            String ijk = ijk(cbVar);
            if (!TextUtils.isEmpty(ijk)) {
                av.lmn().lmn.f47858e = ijk;
            }
        }
    }

    public static cb lmn(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        try {
            return new cb(intent.getExtras());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String lmn(cb cbVar) {
        String lmn = dm.lmn(lmn(cbVar, RemoteMessageConst.ANALYTIC_INFO), "analyticsLabel");
        return TextUtils.isEmpty(lmn) ? "" : dm.lmn(dj.klm(lmn), "hw_hms_push_campaign");
    }

    private static String lmn(cb cbVar, String str) {
        if (cbVar == null || TextUtils.isEmpty(str)) {
            HiLog.w("ActivityReferrerToolsKit", "input bundle extras or key is empty.");
            return "";
        }
        String klm = cbVar.klm(str);
        return klm == null ? "" : klm;
    }

    private static String lmn(cb cbVar, String str, String str2) {
        return dm.lmn(lmn(cbVar, str), str2);
    }

    public static void lmn(Activity activity, cb cbVar) {
        if (activity != null || cbVar != null) {
            String klm = klm(activity, cbVar);
            if (!TextUtils.isEmpty(klm)) {
                av.lmn().lmn.f47857d = klm;
            }
        }
    }
}
