package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.BaseRequest;
import com.huawei.agconnect.https.annotation.Field;
import com.huawei.agconnect.https.annotation.Url;

public class af extends BaseRequest {
    @Url
    private static final String REQUEST_URL = "http://localhost/agc/apigw/router";
    @Field("appId")
    private String appId = getHeaderAppId();
    @Field("appVersion")
    private String appVersion = getAppVersion();
    @Field("clientId")
    private String clientId = getHeaderClientId();
    @Field("packageName")
    private String packageName = getPackageName();
    @Field("productId")
    private String productId = getHeaderProductId();
    @Field("serviceName")
    String serviceName = "agconnect-credential";

    public af(AGConnectInstance aGConnectInstance) {
        super(aGConnectInstance);
    }

    public void a(String str) {
        if (str != null) {
            this.serviceName = str;
        }
    }
}
