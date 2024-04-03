package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.visa.checkout.Profile;
import java.util.Map;

public final class cg {
    private final Context lmn;

    public cg(Context context) {
        this.lmn = context;
    }

    private static Pair<String, String[]> lmn(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return new Pair<>(str, new String[]{str2});
        } else if (dz.lmn(str3)) {
            return new Pair<>(str, new String[]{str2, str3});
        } else {
            HiLog.w("GrsReq", "Invalid sync get grs urls");
            return null;
        }
    }

    private static String lmn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\.");
        String str2 = split[split.length - 1];
        return "cn".equals(str2) ? Profile.Country.CN : "asia".equals(str2) ? Profile.Country.SG : "eu".equals(str2) ? "DE" : "ru".equals(str2) ? "RU" : "";
    }

    public final Pair<String, String[]> lmn() {
        String str;
        Map<String, String> synGetGrsUrls = new GrsClient(this.lmn, new GrsBaseInfo(this.lmn)).synGetGrsUrls("com.huawei.cloud.hms.analytics");
        if (synGetGrsUrls == null || synGetGrsUrls.size() == 0) {
            str = "sync get grs urls is empty";
        } else {
            String str2 = synGetGrsUrls.get("collectionURL");
            String str3 = synGetGrsUrls.get("collectionURLBank");
            String lmn2 = lmn(synGetGrsUrls.get("siteInfo"));
            if (!TextUtils.isEmpty(lmn2) && dz.lmn(str2)) {
                return lmn(lmn2, str2, str3);
            }
            str = "Invalid sync get grs urls";
        }
        HiLog.w("GrsReq", str);
        return null;
    }
}
