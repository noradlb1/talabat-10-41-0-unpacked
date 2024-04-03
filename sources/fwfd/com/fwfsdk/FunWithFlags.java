package fwfd.com.fwfsdk;

import android.content.Context;
import androidx.annotation.Nullable;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.manager.FWFFallbackManager;
import fwfd.com.fwfsdk.manager.FWFFeatureManager;
import fwfd.com.fwfsdk.manager.callback.FWFFeatureCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFlagKeysCallback;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.api.FlagKeysContainer;
import fwfd.com.fwfsdk.model.db.FWFConfig;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFUser;
import fwfd.com.fwfsdk.tracker.FWFTracker;
import fwfd.com.fwfsdk.util.FWFLogger;
import fwfd.com.fwfsdk.util.FWFSubscribeObserverCallback;
import fwfd.com.fwfsdk.util.FWFTimerTask;
import fwfd.com.fwfsdk.util.FWFTrackingCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;

public class FunWithFlags {
    private static FunWithFlags instance;
    private Context context;
    private FWFConfig fwfConfig = new FWFConfig.Builder("").build();
    private List<FWFTracker> trackers = new ArrayList();
    private FWFUser user = new FWFUser();

    private void getFWFVariation(String str, String str2, FWFFallback fWFFallback, boolean z11, FWFFeatureCallback fWFFeatureCallback) {
        if (!requiredValuesAreConfigured()) {
            FWFFallbackManager.createFWFResultFallback(this.context, str, str2, fWFFallback, "FunWithFlags: Required values missing", fWFFeatureCallback);
        } else if (z11) {
            FWFFeatureManager.getVariationFromApi(str, str2, fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation.SINGLE_FLAG_UPDATE, fWFFeatureCallback);
        } else {
            FWFFeatureManager.getVariationFromDB(str, str2, fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation.SINGLE_FLAG_UPDATE, fWFFeatureCallback);
        }
    }

    private void getFWFVariationWithTracking(String str, String str2, FWFFallback fWFFallback, boolean z11, @Nullable Map<String, String> map, FWFFeatureCallback fWFFeatureCallback) {
        if (!requiredValuesAreConfigured()) {
            FWFFallbackManager.createFWFResultFallback(this.context, str, str2, fWFFallback, "FunWithFlags: Required values missing", fWFFeatureCallback);
            return;
        }
        if (z11) {
            FWFFeatureManager.getVariationFromApiWithTracking(str, str2, fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation.SINGLE_FLAG_UPDATE, map, fWFFeatureCallback);
            return;
        }
        FWFFeatureManager.getVariationFromDBWithTracking(str, str2, fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation.SINGLE_FLAG_UPDATE, map, fWFFeatureCallback);
    }

    private void getFWFVariations(HashMap<String, FWFFallback> hashMap, String str, boolean z11, FWFFeaturesCallback fWFFeaturesCallback) {
        if (!requiredValuesAreConfigured()) {
            FWFFallbackManager.createFWFResultsFallback(this.context, hashMap, str, "FunWithFlags: Required values missing", fWFFeaturesCallback);
        } else if (z11) {
            FWFFeatureManager.getVariationsFromApi(hashMap, str, FWFSubscribeResult.FWFSubscribeCallbackExplanation.MULTI_FLAG_UPDATE, fWFFeaturesCallback);
        } else {
            FWFFeatureManager.getVariationsFromDB(hashMap, str, FWFSubscribeResult.FWFSubscribeCallbackExplanation.MULTI_FLAG_UPDATE, fWFFeaturesCallback);
        }
    }

    private void getFWFVariationsWithTracking(HashMap<String, FWFFallback> hashMap, String str, boolean z11, @Nullable Map<String, String> map, FWFFeaturesCallback fWFFeaturesCallback) {
        if (!requiredValuesAreConfigured()) {
            FWFFallbackManager.createFWFResultsFallback(this.context, hashMap, str, "FunWithFlags: Required values missing", fWFFeaturesCallback);
        } else if (z11) {
            FWFFeatureManager.getVariationsFromApiWithTracking(hashMap, str, FWFSubscribeResult.FWFSubscribeCallbackExplanation.MULTI_FLAG_UPDATE, map, fWFFeaturesCallback);
        } else {
            FWFFeatureManager.getVariationsFromDBWithTracking(hashMap, str, FWFSubscribeResult.FWFSubscribeCallbackExplanation.MULTI_FLAG_UPDATE, map, fWFFeaturesCallback);
        }
    }

    public static FunWithFlags getInstance() {
        if (instance == null) {
            instance = new FunWithFlags();
        }
        return instance;
    }

    public static FWFLogger.FWFLogLevel getLogLevel() {
        return FWFLogger.logLevel;
    }

    private Boolean isValidUser() {
        boolean z11;
        String userId = this.user.getUserId();
        String googleClientId = this.user.getGoogleClientId();
        boolean z12 = false;
        if (userId == null || userId.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (googleClientId == null || googleClientId.isEmpty()) {
            z12 = true;
        }
        if (!z11 || !z12) {
            return Boolean.TRUE;
        }
        FWFLogger.logWarning("FunWithFlags: you must provide an identifier (key, userId, googleClientId)\"");
        return Boolean.FALSE;
    }

    private boolean requiredValuesAreConfigured() {
        if (this.context == null) {
            FWFLogger.logWarning("FunWithFlags: you must provide application context");
            return false;
        } else if (this.fwfConfig.getBaseUrl().isEmpty() && this.fwfConfig.getLocalUrl().isEmpty()) {
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Url");
            return false;
        } else if (this.fwfConfig.getAccessToken() != null && !this.fwfConfig.getAccessToken().isEmpty()) {
            return isValidUser().booleanValue();
        } else {
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Access Token");
            return false;
        }
    }

    public static void setLogLevel(FWFLogger.FWFLogLevel fWFLogLevel) {
        FWFLogger.logLevel = fWFLogLevel;
    }

    public void addCustomHttpClientInterceptor(Interceptor interceptor) {
        this.fwfConfig.addCustomInterceptor(interceptor);
        FWFLogger.logVerbose("FunWithFlags: Adding custom HttpClient interceptor");
    }

    public void addTracker(FWFTracker fWFTracker) {
        this.trackers.add(fWFTracker);
    }

    public void cleanDBOnVersionUpdate() {
        if (this.context != null) {
            FWFFeatureManager.cleanDBOnVersionUpdate();
        }
    }

    public void configureWith(FWFConfig fWFConfig) {
        this.fwfConfig = fWFConfig;
        if (fWFConfig.isDebugMode()) {
            FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        } else {
            FWFLogger.logLevel = this.fwfConfig.getLogLevel();
        }
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + fWFConfig.getAccessToken());
        if (fWFConfig.getCleanDBOnVersionUpdate().booleanValue()) {
            cleanDBOnVersionUpdate();
        }
    }

    public void eraseData() {
        FWFFeatureManager.eraseData();
    }

    public String getAccessToken() {
        return this.fwfConfig.getAccessToken();
    }

    public String getApiVersion() {
        return this.fwfConfig.getApiVersion();
    }

    public String getBaseUrl() {
        return this.fwfConfig.getBaseUrl();
    }

    public float getConnectionTimeout() {
        return this.fwfConfig.getConnectionTimeout();
    }

    public Context getContext() {
        return this.context;
    }

    public void getExperimentsToTrack(FWFTrackingCallback fWFTrackingCallback) {
        Context context2 = this.context;
        if (context2 != null) {
            FWFFeatureManager.getExperimentsToTrack(context2, fWFTrackingCallback);
            return;
        }
        fWFTrackingCallback.onResponse("");
        FWFLogger.logError("FunWithFlags: you must provide application context");
    }

    public Float getFeatureExpirationTime() {
        return this.fwfConfig.getFeatureExpirationTime();
    }

    public void getFlagKeys(String str, FWFFlagKeysCallback fWFFlagKeysCallback) {
        if (str == null || str.isEmpty()) {
            FWFLogger.logWarning("FunWithFlags: you must provide a valid access token.");
        } else {
            FWFFeatureManager.getFlagKeys(str, fWFFlagKeysCallback);
        }
    }

    public Float getFlagKeysExpirationTime() {
        return this.fwfConfig.getFlagKeysExpirationTime();
    }

    public void getFlags(String str, Boolean bool, FWFFeaturesCallback fWFFeaturesCallback) {
        if (!getApiVersion().equals(FWFConstants.API.API_VERSION_V3.getValue())) {
            FWFLogger.logWarning("FunWithFlags: Required api version v3 for this feature to work.");
            fWFFeaturesCallback.onFwfResponse(new HashMap());
        } else if (this.context == null || str == null || str.isEmpty() || !isValidUser().booleanValue()) {
            fWFFeaturesCallback.onFwfResponse(new HashMap());
            FWFLogger.logWarning("FunWithFlags: Required values missing.");
        } else {
            FWFFeatureManager.getFlags(str, bool, fWFFeaturesCallback);
        }
    }

    public void getFlagsToTrack(FWFTrackingCallback fWFTrackingCallback) {
        Context context2 = this.context;
        if (context2 != null) {
            FWFFeatureManager.getFlagsToTrack(context2, fWFTrackingCallback);
            return;
        }
        fWFTrackingCallback.onResponse("");
        FWFLogger.logError("FunWithFlags: you must provide application context");
    }

    public void getFlagsWithTrackEvents(String str, Boolean bool, @Nullable Map<String, String> map, FWFFeaturesCallback fWFFeaturesCallback) {
        if (!getApiVersion().equals(FWFConstants.API.API_VERSION_V3.getValue())) {
            FWFLogger.logWarning("FunWithFlags: Required api version v3 for this feature to work.");
            fWFFeaturesCallback.onFwfResponse(new HashMap());
        } else if (this.context == null || str == null || str.isEmpty() || !isValidUser().booleanValue()) {
            fWFFeaturesCallback.onFwfResponse(new HashMap());
            FWFLogger.logWarning("FunWithFlags: Required values missing.");
        } else {
            FWFFeatureManager.getFlagsFromApiWithTracking(str, bool, map, fWFFeaturesCallback);
        }
    }

    public FWFConfig getFwfConfig() {
        return this.fwfConfig;
    }

    public String getLocalUrl() {
        return this.fwfConfig.getLocalUrl();
    }

    public List<FWFTracker> getTrackers() {
        return this.trackers;
    }

    public FWFUser getUser() {
        return this.user;
    }

    public void getVariation(String str, FWFFallback fWFFallback, boolean z11, FWFFeatureCallback fWFFeatureCallback) {
        getVariation(str, getAccessToken(), fWFFallback, z11, fWFFeatureCallback);
    }

    public void getVariationWithTrackEvent(String str, FWFFallback fWFFallback, boolean z11, @Nullable Map<String, String> map, FWFFeatureCallback fWFFeatureCallback) {
        getVariationWithTrackEvent(str, getAccessToken(), fWFFallback, z11, map, fWFFeatureCallback);
    }

    public void getVariations(HashMap<String, FWFFallback> hashMap, boolean z11, FWFFeaturesCallback fWFFeaturesCallback) {
        getFWFVariations(hashMap, getAccessToken(), z11, fWFFeaturesCallback);
    }

    public void getVariationsWithTrackEvents(HashMap<String, FWFFallback> hashMap, boolean z11, @Nullable Map<String, String> map, FWFFeaturesCallback fWFFeaturesCallback) {
        getFWFVariationsWithTracking(hashMap, getAccessToken(), z11, map, fWFFeaturesCallback);
    }

    public boolean isDebugMode() {
        return this.fwfConfig.isDebugMode();
    }

    public void removeLocalUrl() {
        this.fwfConfig.removeLocalUrl();
        FWFLogger.logVerbose("FunWithFlags: Local url removed");
    }

    public void setAccessToken(String str) {
        FWFLogger.logVerbose("FunWithFlags: accessToken changed to: " + str);
        this.fwfConfig.setAccessToken(str);
    }

    public void setApiVersion(FWFConstants.API api) {
        FWFLogger.logVerbose("FunWithFlags: apiVersion changed to: " + api);
        this.fwfConfig.setApiVersion(api);
    }

    public void setBaseUrl(FWFConstants.Region region) {
        this.fwfConfig.setBaseUrl(region);
        FWFLogger.logVerbose("FunWithFlags: baseUrl changed to: " + this.fwfConfig.getBaseUrl());
    }

    public void setConnectionTimeout(float f11) {
        FWFLogger.logVerbose("FunWithFlags: connectionTimeout changed to: " + f11);
        this.fwfConfig.setConnectionTimeout(f11);
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setFeatureExpirationTime(float f11) {
        FWFLogger.logVerbose("FunWithFlags: featureExpirationTime changed to: " + f11);
        this.fwfConfig.setFeatureExpirationTime(f11);
        if (this.context != null) {
            FWFTimerTask.getInstance().restartTimerOnFeatureExpirationTimeChanged();
        }
    }

    public void setLocalUrl(String str) {
        this.fwfConfig.setLocalUrl(str);
        FWFLogger.logVerbose("FunWithFlags: API Url changed to: " + this.fwfConfig.getLocalUrl());
    }

    public void setUser(FWFUser fWFUser) {
        this.user = fWFUser;
    }

    public void startTrackingSubscribedFlags() {
        if (this.context != null) {
            FWFTimerTask.getInstance().startTimer();
            FWFLogger.logDebug("FunWithFlags: Subscribed flags tracking started.");
            return;
        }
        FWFLogger.logError("FunWithFlags: Error starting flag tracking. Context is null. Flag tracking is disabled.");
    }

    public void stopTrackingSubscribedFlags() {
        if (this.context != null) {
            FWFTimerTask.getInstance().stopTimer();
            FWFLogger.logDebug("FunWithFlags: Subscribed flags tracking stopped.");
        }
    }

    public void subscribeFeatures(String[] strArr, String str) {
        if (requiredValuesAreConfigured()) {
            FWFFeatureManager.subscribeFeatures(strArr, str);
        }
    }

    public void subscribeObserver(FWFSubscribeObserverCallback fWFSubscribeObserverCallback) {
        FWFFeatureManager.subscribeObserver((String) null, fWFSubscribeObserverCallback);
    }

    public void getVariation(String str, String str2, FWFFallback fWFFallback, boolean z11, FWFFeatureCallback fWFFeatureCallback) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            FWFFallbackManager.createFWFResultFallback(this.context, str, str2, fWFFallback, "FunWithFlags: Required values missing. You must provide a valid Access Token or Flag Key", fWFFeatureCallback);
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Access Token");
            return;
        }
        getFWFVariation(str, str2, fWFFallback, z11, fWFFeatureCallback);
    }

    public void getVariationWithTrackEvent(String str, String str2, FWFFallback fWFFallback, boolean z11, @Nullable Map<String, String> map, FWFFeatureCallback fWFFeatureCallback) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            FWFFallbackManager.createFWFResultFallback(this.context, str, str2, fWFFallback, "FunWithFlags: Required values missing. You must provide a valid Access Token or Flag Key", fWFFeatureCallback);
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Access Token");
            return;
        }
        getFWFVariationWithTracking(str, str2, fWFFallback, z11, map, fWFFeatureCallback);
    }

    public void getVariations(HashMap<String, FWFFallback> hashMap, String str, boolean z11, FWFFeaturesCallback fWFFeaturesCallback) {
        if (str == null || str.isEmpty()) {
            FWFFallbackManager.createFWFResultsFallback(this.context, hashMap, str, "FunWithFlags: Required values missing", fWFFeaturesCallback);
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Access Token");
            return;
        }
        getFWFVariations(hashMap, str, z11, fWFFeaturesCallback);
    }

    public void getVariationsWithTrackEvents(HashMap<String, FWFFallback> hashMap, String str, boolean z11, @Nullable Map<String, String> map, FWFFeaturesCallback fWFFeaturesCallback) {
        if (str == null || str.isEmpty()) {
            FWFFallbackManager.createFWFResultsFallback(this.context, hashMap, str, "FunWithFlags: Required values missing", fWFFeaturesCallback);
            FWFLogger.logWarning("FunWithFlags: you must provide a valid Access Token");
            return;
        }
        getFWFVariationsWithTracking(hashMap, str, z11, map, fWFFeaturesCallback);
    }

    public void subscribeObserver(String str, FWFSubscribeObserverCallback fWFSubscribeObserverCallback) {
        FWFFeatureManager.subscribeObserver(str, fWFSubscribeObserverCallback);
    }

    public void subscribeFeatures(String[] strArr, String str, FWFFeaturesCallback fWFFeaturesCallback) {
        if (requiredValuesAreConfigured()) {
            FWFFeatureManager.subscribeFeatures(strArr, str, fWFFeaturesCallback);
        }
    }

    public void getFlagKeys(FWFFlagKeysCallback fWFFlagKeysCallback) {
        if (getAccessToken() == null || getAccessToken().isEmpty()) {
            FWFLogger.logError("FunWithFlags: you must provide a valid access token.");
            fWFFlagKeysCallback.onResponse(new FlagKeysContainer(new ArrayList()));
            return;
        }
        FWFFeatureManager.getFlagKeys(getAccessToken(), fWFFlagKeysCallback);
    }

    @Deprecated
    public void configureWith(FWFConstants.Region region, String str, FWFConstants.API api, float f11, float f12, FWFLogger.FWFLogLevel fWFLogLevel, boolean z11) {
        this.fwfConfig.setBaseUrl(region);
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(api);
        this.fwfConfig.setConnectionTimeout(f11);
        this.fwfConfig.setFeatureExpirationTime(f12);
        this.fwfConfig.setDebugMode(z11);
        if (z11) {
            FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        } else {
            FWFLogger.logLevel = fWFLogLevel;
        }
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + str);
    }

    public void getFlagKeys(String str, Float f11, FWFFlagKeysCallback fWFFlagKeysCallback) {
        if (str == null || str.isEmpty() || f11 == null) {
            FWFLogger.logError("FunWithFlags: you must provide a valid access token.");
            fWFFlagKeysCallback.onResponse(new FlagKeysContainer(new ArrayList()));
            return;
        }
        this.fwfConfig.setFlagKeysExpirationTime(f11);
        FWFFeatureManager.getFlagKeys(str, fWFFlagKeysCallback);
    }

    public void getFlags(Boolean bool, FWFFeaturesCallback fWFFeaturesCallback) {
        getFlags(getAccessToken(), bool, fWFFeaturesCallback);
    }

    public void getFlagsWithTrackEvents(Boolean bool, @Nullable Map<String, String> map, FWFFeaturesCallback fWFFeaturesCallback) {
        getFlagsWithTrackEvents(getAccessToken(), bool, map, fWFFeaturesCallback);
    }

    @Deprecated
    public void configureWith(FWFConstants.Region region, String str, FWFConstants.API api, float f11, float f12, FWFLogger.FWFLogLevel fWFLogLevel, Boolean bool, boolean z11) {
        this.fwfConfig.setBaseUrl(region);
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(api);
        this.fwfConfig.setConnectionTimeout(f11);
        this.fwfConfig.setFeatureExpirationTime(f12);
        this.fwfConfig.setDebugMode(z11);
        if (z11) {
            FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        } else {
            FWFLogger.logLevel = fWFLogLevel;
        }
        if (bool.booleanValue()) {
            cleanDBOnVersionUpdate();
        }
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + str);
    }

    @Deprecated
    public void configureWith(String str, FWFConstants.API api, float f11, float f12, FWFLogger.FWFLogLevel fWFLogLevel, Boolean bool, boolean z11) {
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(api);
        this.fwfConfig.setConnectionTimeout(f11);
        this.fwfConfig.setFeatureExpirationTime(f12);
        this.fwfConfig.setDebugMode(z11);
        if (z11) {
            FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        } else {
            FWFLogger.logLevel = fWFLogLevel;
        }
        if (bool.booleanValue()) {
            cleanDBOnVersionUpdate();
        }
    }

    @Deprecated
    public void configureWith(FWFConstants.Region region, String str, FWFConstants.API api, float f11, float f12, float f13, FWFLogger.FWFLogLevel fWFLogLevel, Boolean bool, boolean z11) {
        this.fwfConfig.setBaseUrl(region);
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(api);
        this.fwfConfig.setConnectionTimeout(f11);
        this.fwfConfig.setFlagKeysExpirationTime(Float.valueOf(f13));
        this.fwfConfig.setFeatureExpirationTime(f12);
        this.fwfConfig.setDebugMode(z11);
        if (z11) {
            FWFLogger.logLevel = FWFLogger.FWFLogLevel.debug;
        } else {
            FWFLogger.logLevel = fWFLogLevel;
        }
        if (bool.booleanValue()) {
            cleanDBOnVersionUpdate();
        }
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + str);
    }

    @Deprecated
    public void configureWith(FWFConstants.Region region, String str) {
        this.fwfConfig.setBaseUrl(region);
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(FWFConstants.API.API_VERSION_V2);
        this.fwfConfig.setConnectionTimeout(FWFConstants.Time.CONNECTIONTIMEOUT.getValue());
        this.fwfConfig.setFeatureExpirationTime(FWFConstants.Time.FEATUREEXPIRATIONTIME.getValue());
        FWFLogger.logLevel = FWFConstants.Defaults.LOG_LEVEL.getValue();
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + str);
    }

    @Deprecated
    public void configureWith(FWFConstants.Region region, String str, FWFConstants.API api) {
        this.fwfConfig.setBaseUrl(region);
        this.fwfConfig.setAccessToken(str);
        this.fwfConfig.setApiVersion(api);
        this.fwfConfig.setConnectionTimeout(FWFConstants.Time.CONNECTIONTIMEOUT.getValue());
        this.fwfConfig.setFeatureExpirationTime(FWFConstants.Time.FEATUREEXPIRATIONTIME.getValue());
        FWFLogger.logLevel = FWFConstants.Defaults.LOG_LEVEL.getValue();
        FWFLogger.logInfo("FunWithFlags: configured with Base url: " + this.fwfConfig.getBaseUrl() + " Access Token: " + str);
    }
}
