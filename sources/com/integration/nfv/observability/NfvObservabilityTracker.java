package com.integration.nfv.observability;

import androidx.exifinterface.media.ExifInterface;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ApiStatus;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J,\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/integration/nfv/observability/NfvObservabilityTracker;", "Lcom/integration/nfv/observability/NfvObservability;", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "(Lcom/talabat/core/di/ApiContainer;)V", "getBaseNfvAttributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isNfvObservabilityEnabled", "", "sendCustomObservabilityEvent", "", "eventName", "eventType", "data", "", "sendObservabilityEvent", "apiName", "apiStatus", "Lcom/talabat/observability/common/ApiStatus;", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NfvObservabilityTracker implements NfvObservability {
    @NotNull
    private final ApiContainer apiContainer;

    @Inject
    public NfvObservabilityTracker(@NotNull ApiContainer apiContainer2) {
        Intrinsics.checkNotNullParameter(apiContainer2, "apiContainer");
        this.apiContainer = apiContainer2;
    }

    @NotNull
    public HashMap<String, String> getBaseNfvAttributes() {
        HashMap<String, String> hashMap = new HashMap<>();
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        hashMap.put("latitude", String.valueOf(companion.selectedLocationLatitude()));
        hashMap.put("longitude", String.valueOf(companion.selectedLocationLongitude()));
        hashMap.put("countryId", String.valueOf(companion.selectedCountryCode()));
        hashMap.put("deviceSource", "6");
        hashMap.put("eventSource", ExifInterface.GPS_MEASUREMENT_2D);
        String appVersion = ((ConfigurationRemoteCoreLibApi) this.apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider().appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        hashMap.put("appVersion", appVersion);
        hashMap.put("customerId", companion.customerID());
        return hashMap;
    }

    public boolean isNfvObservabilityEnabled() {
        return true;
    }

    public void sendCustomObservabilityEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, "data");
        ObservabilityManager.trackEvent(str, str2, map);
    }

    public void sendObservabilityEvent(@NotNull String str, @NotNull ApiStatus apiStatus, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "apiName");
        Intrinsics.checkNotNullParameter(apiStatus, "apiStatus");
        Intrinsics.checkNotNullParameter(map, "data");
        ObservabilityManager.trackEvent(str, apiStatus, map);
    }
}
