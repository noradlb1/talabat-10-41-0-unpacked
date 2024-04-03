package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.integration.IntegrationGlobalDataModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "(Lcom/integration/IntegrationGlobalDataModel$Companion;)V", "locationParams", "Landroid/os/Bundle;", "getLocationParams", "()Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationTrackingProvider {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String LOCATION_ADDRESS = "locationAddress";
    @NotNull
    @Deprecated
    public static final String LOCATION_AREA = "locationArea";
    @NotNull
    @Deprecated
    public static final String LOCATION_CITY = "locationCity";
    @NotNull
    @Deprecated
    public static final String LOCATION_COUNTRY = "locationCountry";
    @NotNull
    @Deprecated
    public static final String LOCATION_LAT = "locationLat";
    @NotNull
    @Deprecated
    public static final String LOCATION_LON = "locationLon";
    @NotNull
    @Deprecated
    public static final String USER_ID = "userId";
    @NotNull
    private final Bundle locationParams;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider$Companion;", "", "()V", "LOCATION_ADDRESS", "", "LOCATION_AREA", "LOCATION_CITY", "LOCATION_COUNTRY", "LOCATION_LAT", "LOCATION_LON", "USER_ID", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LocationTrackingProvider(@NotNull IntegrationGlobalDataModel.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        this.locationParams = BundleKt.bundleOf(TuplesKt.to("locationAddress", BaseTrackerKt.orDefault$default(companion.getCustomerAddressDescription(), (String) null, 1, (Object) null)), TuplesKt.to("locationArea", Integer.valueOf(companion.getSelectedAreaId())), TuplesKt.to("locationCity", BaseTrackerKt.orDefault$default(companion.getSelectedCityName(), (String) null, 1, (Object) null)), TuplesKt.to("locationCountry", companion.selectedCountryIsoCode()), TuplesKt.to("locationLat", BaseTrackerKt.orDefault$default(Double.valueOf(companion.selectedLocationLatitude()), (String) null, 1, (Object) null)), TuplesKt.to("locationLon", BaseTrackerKt.orDefault$default(Double.valueOf(companion.selectedLocationLongitude()), (String) null, 1, (Object) null)), TuplesKt.to("userId", BaseTrackerKt.orDefault$default(companion.customerID(), (String) null, 1, (Object) null)));
    }

    @NotNull
    public final Bundle getLocationParams() {
        return this.locationParams;
    }
}
