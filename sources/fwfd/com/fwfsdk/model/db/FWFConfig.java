package fwfd.com.fwfsdk.model.db;

import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.util.FWFLogger;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;

public class FWFConfig {
    private String accessToken;
    private String apiVersion;
    private String baseUrl;
    private final Boolean cleanDBOnVersionUpdate;
    private float connectionTimeout;
    private final List<Interceptor> customInterceptors;
    private boolean debugMode;
    private Float featureExpirationTime;
    private Float flagKeysExpirationTime;
    private String localUrl;
    private final FWFLogger.FWFLogLevel logLevel;

    public static class Builder {
        /* access modifiers changed from: private */
        public final String accessToken;
        /* access modifiers changed from: private */
        public FWFConstants.API apiVersion = FWFConstants.API.API_VERSION_V2;
        /* access modifiers changed from: private */
        public Boolean cleanDBOnVersionUpdate = Boolean.TRUE;
        /* access modifiers changed from: private */
        public float connectionTimeout = FWFConstants.Time.CONNECTIONTIMEOUT.getValue();
        /* access modifiers changed from: private */
        public boolean debugMode = false;
        /* access modifiers changed from: private */
        public Float featureExpirationTime = Float.valueOf(FWFConstants.Time.FEATUREEXPIRATIONTIME.getValue());
        /* access modifiers changed from: private */
        public Float flagKeysExpirationTime;
        /* access modifiers changed from: private */
        public String localUrl = "";
        FWFLogger.FWFLogLevel logLevel = FWFConstants.Defaults.LOG_LEVEL.getValue();
        /* access modifiers changed from: private */
        public FWFConstants.Region region;

        public Builder(String str) {
            this.accessToken = str;
        }

        public Builder apiVersion(FWFConstants.API api) {
            this.apiVersion = api;
            return this;
        }

        public FWFConfig build() {
            return new FWFConfig(this);
        }

        public Builder cleanDBOnVersionUpdate(Boolean bool) {
            this.cleanDBOnVersionUpdate = bool;
            return this;
        }

        public Builder connectionTimeout(float f11) {
            this.connectionTimeout = f11;
            return this;
        }

        public Builder debugMode(boolean z11) {
            this.debugMode = z11;
            return this;
        }

        public Builder featureExpirationTime(float f11) {
            this.featureExpirationTime = Float.valueOf(f11);
            return this;
        }

        public Builder flagKeysExpirationTime(float f11) {
            this.flagKeysExpirationTime = Float.valueOf(f11);
            return this;
        }

        public Builder localUrl(String str) {
            this.localUrl = str;
            return this;
        }

        public Builder logLevel(FWFLogger.FWFLogLevel fWFLogLevel) {
            this.logLevel = fWFLogLevel;
            return this;
        }

        public Builder region(FWFConstants.Region region2) {
            this.region = region2;
            return this;
        }
    }

    private String getApiVersionValue(FWFConstants.API api) {
        return api.getValue();
    }

    private String getBaseUrlFromRegion(FWFConstants.Region region) {
        if (region == null) {
            return "https://client-api.fwf.deliveryhero.net";
        }
        return "https://" + region.getValue() + "-client.fwf.deliveryhero.net";
    }

    private String getFormattedLocalUrl(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(str);
        if (sb2.charAt(str.length() - 1) == '/') {
            sb2.deleteCharAt(str.length() - 1);
        }
        return sb2.toString();
    }

    public void addCustomInterceptor(Interceptor interceptor) {
        this.customInterceptors.add(interceptor);
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Boolean getCleanDBOnVersionUpdate() {
        return this.cleanDBOnVersionUpdate;
    }

    public float getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public List<Interceptor> getCustomInterceptors() {
        return this.customInterceptors;
    }

    public Float getFeatureExpirationTime() {
        return this.featureExpirationTime;
    }

    public Float getFlagKeysExpirationTime() {
        return this.flagKeysExpirationTime;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public FWFLogger.FWFLogLevel getLogLevel() {
        return this.logLevel;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public void removeLocalUrl() {
        this.localUrl = "";
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setApiVersion(FWFConstants.API api) {
        this.apiVersion = getApiVersionValue(api);
    }

    public void setBaseUrl(FWFConstants.Region region) {
        this.baseUrl = getBaseUrlFromRegion(region);
    }

    public void setConnectionTimeout(float f11) {
        this.connectionTimeout = f11;
    }

    public void setDebugMode(boolean z11) {
        FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        this.debugMode = z11;
    }

    public void setFeatureExpirationTime(float f11) {
        this.featureExpirationTime = Float.valueOf(f11);
    }

    public void setFlagKeysExpirationTime(Float f11) {
        this.flagKeysExpirationTime = f11;
    }

    public void setLocalUrl(String str) {
        String formattedLocalUrl = getFormattedLocalUrl(str);
        if (!formattedLocalUrl.isEmpty()) {
            this.localUrl = formattedLocalUrl;
        }
    }

    private FWFConfig(Builder builder) {
        this.baseUrl = "";
        this.localUrl = "";
        this.apiVersion = "";
        this.accessToken = "";
        this.connectionTimeout = 0.0f;
        this.featureExpirationTime = Float.valueOf(900.0f);
        this.customInterceptors = new ArrayList();
        this.baseUrl = getBaseUrlFromRegion(builder.region);
        this.localUrl = getFormattedLocalUrl(builder.localUrl);
        this.apiVersion = getApiVersionValue(builder.apiVersion);
        this.debugMode = builder.debugMode;
        this.accessToken = builder.accessToken;
        this.connectionTimeout = builder.connectionTimeout;
        this.featureExpirationTime = builder.featureExpirationTime;
        this.flagKeysExpirationTime = builder.flagKeysExpirationTime;
        this.logLevel = builder.logLevel;
        this.cleanDBOnVersionUpdate = builder.cleanDBOnVersionUpdate;
    }
}
