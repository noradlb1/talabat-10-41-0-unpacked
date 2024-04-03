package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.b;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AGConnectOptionsBuilder {
    private static final String API_KEY_PATH = "/client/api_key";
    private static final String APP_ID_PATH = "/client/app_id";
    private static final String CLIENT_ID_PATH = "/client/client_id";
    private static final String CLIENT_SECRET_PATH = "/client/client_secret";
    private static final String CP_ID_PATH = "/client/cp_id";
    private static final String PRODUCT_ID_PATH = "/client/product_id";
    private final Map<String, String> customConfigMap = new HashMap();
    private final List<Service> customServices = new ArrayList();
    private InputStream inputStream;
    private String packageName;
    private AGCRoutePolicy routePolicy = AGCRoutePolicy.UNKNOWN;

    public AGConnectOptions build(Context context) {
        return new b(context, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, (String) null);
    }

    public AGConnectOptions build(Context context, String str) {
        return new b(context, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, str);
    }

    public Map<String, String> getCustomConfigMap() {
        return new HashMap(this.customConfigMap);
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public AGCRoutePolicy getRoutePolicy() {
        return this.routePolicy;
    }

    public AGConnectOptionsBuilder setApiKey(String str) {
        this.customConfigMap.put(API_KEY_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setAppId(String str) {
        this.customConfigMap.put(APP_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setCPId(String str) {
        this.customConfigMap.put(CP_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setClientId(String str) {
        this.customConfigMap.put(CLIENT_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setClientSecret(String str) {
        this.customConfigMap.put(CLIENT_SECRET_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setCustomAuthProvider(final CustomAuthProvider customAuthProvider) {
        if (customAuthProvider != null) {
            this.customServices.add(Service.builder((Class<?>) AuthProvider.class, (Object) new AuthProvider() {
                public void addTokenListener(OnTokenListener onTokenListener) {
                }

                public Task<Token> getTokens() {
                    return customAuthProvider.getTokens(false);
                }

                public Task<Token> getTokens(boolean z11) {
                    return customAuthProvider.getTokens(z11);
                }

                public String getUid() {
                    return customAuthProvider.getUid();
                }

                public void removeTokenListener(OnTokenListener onTokenListener) {
                }
            }).build());
        }
        return this;
    }

    public AGConnectOptionsBuilder setCustomCredentialProvider(final CustomCredentialsProvider customCredentialsProvider) {
        if (customCredentialsProvider != null) {
            this.customServices.add(Service.builder((Class<?>) CredentialsProvider.class, (Object) new CredentialsProvider() {
                public Task<Token> getTokens() {
                    return customCredentialsProvider.getTokens(false);
                }

                public Task<Token> getTokens(boolean z11) {
                    return customCredentialsProvider.getTokens(z11);
                }
            }).build());
        }
        return this;
    }

    public AGConnectOptionsBuilder setCustomValue(String str, String str2) {
        this.customConfigMap.put(str, str2);
        return this;
    }

    public AGConnectOptionsBuilder setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
        return this;
    }

    public AGConnectOptionsBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public AGConnectOptionsBuilder setProductId(String str) {
        this.customConfigMap.put(PRODUCT_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.routePolicy = aGCRoutePolicy;
        return this;
    }
}
