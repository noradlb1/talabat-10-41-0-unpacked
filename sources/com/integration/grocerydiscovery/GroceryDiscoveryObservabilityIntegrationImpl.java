package com.integration.grocerydiscovery;

import androidx.exifinterface.media.ExifInterface;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.observability.ObservabilityManager;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegrationImpl;", "Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegration;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "(Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;)V", "createBaseAttributes", "", "", "onRecentSearchStorageError", "", "errorMessage", "trackEvent", "eventName", "eventType", "attributes", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDiscoveryObservabilityIntegrationImpl implements GroceryDiscoveryObservabilityIntegration {
    @NotNull
    private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

    @Inject
    public GroceryDiscoveryObservabilityIntegrationImpl(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi2, "configurationRemoteCoreLibApi");
        this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
    }

    private final Map<String, String> createBaseAttributes() {
        Pair[] pairArr = new Pair[7];
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        pairArr[0] = TuplesKt.to("latitude", String.valueOf(companion.selectedLocationLatitude()));
        pairArr[1] = TuplesKt.to("longitude", String.valueOf(companion.selectedLocationLongitude()));
        pairArr[2] = TuplesKt.to("countryId", String.valueOf(companion.selectedCountryCode()));
        pairArr[3] = TuplesKt.to("deviceSource", "6");
        pairArr[4] = TuplesKt.to("eventSource", ExifInterface.GPS_MEASUREMENT_2D);
        String appVersion = this.configurationRemoteCoreLibApi.getAppVersionProvider().appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        pairArr[5] = TuplesKt.to("appVersion", appVersion);
        pairArr[6] = TuplesKt.to("customerId", companion.customerID());
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    private final void trackEvent(String str, String str2, Map<String, String> map) {
        ObservabilityManager.trackEvent(str, str2, (Map<String, String>) MapsKt__MapsKt.plus(createBaseAttributes(), map));
    }

    public void onRecentSearchStorageError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        trackEvent("RecentSearchStorageError", "GroceryDiscovery", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("message", str)));
    }
}
