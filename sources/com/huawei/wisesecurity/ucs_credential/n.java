package com.huawei.wisesecurity.ucs_credential;

import com.huawei.location.lite.common.grs.LocationNlpGrsServiceEnum;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;

public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    public GrsCapability f44886a;

    public n(GrsCapability grsCapability) {
        this.f44886a = grsCapability;
    }

    public String a() {
        return this.f44886a.synGetGrsUrl("com.huawei.cloud.hianalytics.v2", "ROOT");
    }

    public String a(String str, String str2) {
        return this.f44886a.synGetGrsUrl(LocationNlpGrsServiceEnum.TSMS_SERVICE, "CDN") + "tsms/" + str + "/" + str2;
    }

    public String b() {
        return this.f44886a.synGetGrsUrl(LocationNlpGrsServiceEnum.TSMS_SERVICE, "ROOT") + "/tsms/v2/credentials";
    }
}
