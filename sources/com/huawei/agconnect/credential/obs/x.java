package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.common.api.BaseRequest;
import com.huawei.agconnect.https.annotation.Field;
import com.huawei.agconnect.https.annotation.Header;
import com.huawei.agconnect.https.annotation.Url;
import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;

public class x extends BaseRequest {
    @Url
    private static final String REQUEST_URL = "http://localhost/agc/apigw/oauth2/v1/token";
    @Header("app_id")
    private String app_id;
    @Field("client_id")
    private String client_id;
    @Field("client_secret")
    private String client_secret;
    @Field("grant_type")
    private String grant_type = TokenRemoteDataSourceImpl.GRANT_TYPE_VALUE;
    @Field("useJwt")
    private int useJwt = 1;

    public x(AGConnectInstance aGConnectInstance) {
        super(aGConnectInstance);
        setSdkServiceName("agconnect-credential");
        setSdkVersion("1.6.5.300");
        AGConnectOptions options = aGConnectInstance.getOptions();
        this.app_id = options.getString("client/app_id");
        this.client_id = options.getString("client/client_id");
        this.client_secret = options.getString("client/client_secret");
    }

    public String getAppId() {
        return this.app_id;
    }

    public String getClientId() {
        return this.client_id;
    }

    public String getClientSecret() {
        return this.client_secret;
    }

    public String getGrantType() {
        return this.grant_type;
    }

    public void setAppId(String str) {
        this.app_id = str;
    }

    public void setClientId(String str) {
        this.client_id = str;
    }

    public void setClientSecret(String str) {
        this.client_secret = str;
    }
}
