package com.talabat.darkstores.feature.observability;

import com.integration.IntegrationGlobalDataModel;
import com.squareup.moshi.JsonDataException;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.feature.observability.PerformanceAttribute;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.observabilityNew.squads.nfv.NFVEventType;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002J4\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001fH\u0016J.\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTrackerImpl;", "Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "integrationGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "commonParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCommonParams", "()Ljava/util/HashMap;", "commonParams$delegate", "Lkotlin/Lazy;", "getErrorMessageFromHttpException", "httpException", "Lretrofit2/HttpException;", "apiName", "trackQCPerformance", "", "performance", "Lcom/talabat/darkstores/feature/observability/PerformanceAttribute;", "vendorCode", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "additionalAttributes", "", "trackUnExpectedScenarios", "error", "", "globalVendorId", "excludedHttpResponseCodes", "", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreObservabilityTrackerImpl implements DarkStoreObservabilityTracker {
    /* access modifiers changed from: private */
    @NotNull
    public final AppVersionProvider appVersionProvider;
    @NotNull
    private final Lazy commonParams$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new DarkStoreObservabilityTrackerImpl$commonParams$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationParameters configurationParameters;
    /* access modifiers changed from: private */
    @NotNull
    public final IntegrationGlobalDataModel.Companion integrationGlobalDataModel;
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Inject
    public DarkStoreObservabilityTrackerImpl(@NotNull IObservabilityManager iObservabilityManager, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull ConfigurationParameters configurationParameters2, @NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(companion, "integrationGlobalDataModel");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        this.observabilityManager = iObservabilityManager;
        this.integrationGlobalDataModel = companion;
        this.configurationParameters = configurationParameters2;
        this.appVersionProvider = appVersionProvider2;
    }

    private final HashMap<String, String> getCommonParams() {
        return (HashMap) this.commonParams$delegate.getValue();
    }

    private final String getErrorMessageFromHttpException(HttpException httpException, String str) {
        ResponseBody errorBody;
        String string;
        JSONObject optJSONObject;
        String optString;
        boolean z11;
        String str2 = "HttpException in error " + httpException.code() + " in " + str;
        try {
            Response<?> response = httpException.response();
            if (response == null || (errorBody = response.errorBody()) == null || (string = errorBody.string()) == null || (optJSONObject = new JSONObject(string).optJSONObject("data")) == null || (optString = optJSONObject.optString("message")) == null) {
                return str2;
            }
            if (optString.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
            return str2;
        } catch (JSONException unused) {
            return str2;
        }
    }

    public void trackQCPerformance(@NotNull PerformanceAttribute performanceAttribute, @NotNull String str, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(performanceAttribute, "performance");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(map, "additionalAttributes");
        if (performanceAttribute instanceof PerformanceAttribute.TimeToLoad) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(getCommonParams());
            linkedHashMap.putAll(map);
            linkedHashMap.remove("talabatBranchCode");
            linkedHashMap.put(ObservableAttributesNames.KEY_BRANCH_ID, String.valueOf(this.configurationParameters.getBranchId()));
            linkedHashMap.put(ObservableAttributesNames.VENDOR_CODE, str);
            linkedHashMap.put("screen_name", screenName.getTrackingName());
            linkedHashMap.put(ObservableAttributesNames.LOAD_TIME, String.valueOf(((PerformanceAttribute.TimeToLoad) performanceAttribute).getLoadTime()));
            this.observabilityManager.trackEvent(ObservableAttributesNames.EVENT_TIME_TO_LOAD, NFVEventType.MobilePerformanceQC.name(), (Map<String, String>) linkedHashMap);
        }
    }

    public void trackUnExpectedScenarios(@NotNull Throwable th2, @NotNull String str, @NotNull String str2, @NotNull Set<Integer> set) {
        String str3;
        Intrinsics.checkNotNullParameter(th2, "error");
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Intrinsics.checkNotNullParameter(str2, "apiName");
        Intrinsics.checkNotNullParameter(set, "excludedHttpResponseCodes");
        HashMap hashMap = new HashMap();
        hashMap.putAll(getCommonParams());
        hashMap.put("vendorID", str);
        hashMap.put("api_name", str2);
        if (th2 instanceof JsonDataException) {
            String message = th2.getMessage();
            if (message == null) {
                message = "Error in api parsing of " + str2;
            }
            hashMap.put("error_message", message);
            str3 = ObservableAttributesNames.ERROR_RESPONSE_PARSING;
        } else {
            if (th2 instanceof HttpException) {
                HttpException httpException = (HttpException) th2;
                if (!set.contains(Integer.valueOf(httpException.code()))) {
                    hashMap.put("error_message", getErrorMessageFromHttpException(httpException, str2));
                } else {
                    str3 = null;
                }
            } else if (th2 instanceof SocketTimeoutException) {
                String message2 = th2.getMessage();
                if (message2 == null) {
                    message2 = "Socket error in " + str2;
                }
                hashMap.put("error_message", message2);
            } else {
                String message3 = th2.getMessage();
                if (message3 == null) {
                    message3 = "Something went wrong in " + str2;
                }
                hashMap.put("error_message", message3);
            }
            str3 = ObservableAttributesNames.ERROR_API;
        }
        if (str3 != null) {
            this.observabilityManager.trackEvent(str3, NFVEventType.MobileUnexpectedScenariosQC.name(), (Map<String, String>) hashMap);
        }
    }
}
