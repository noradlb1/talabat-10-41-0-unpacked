package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.location.lite.common.grs.LocationNlpGrsServiceEnum;

public class m implements l {

    /* renamed from: a  reason: collision with root package name */
    public GrsClient f44885a;

    public m(Context context, String str) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        this.f44885a = new GrsClient(context, grsBaseInfo);
    }

    public String a() {
        return this.f44885a.synGetGrsUrl("com.huawei.cloud.hianalytics.v2", "ROOT");
    }

    public String a(String str, String str2) {
        return this.f44885a.synGetGrsUrl(LocationNlpGrsServiceEnum.TSMS_SERVICE, "CDN") + "tsms/" + str + "/" + str2;
    }

    public String b() {
        return this.f44885a.synGetGrsUrl(LocationNlpGrsServiceEnum.TSMS_SERVICE, "ROOT") + "/tsms/v2/credentials";
    }
}
