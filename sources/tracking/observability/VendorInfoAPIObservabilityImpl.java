package tracking.observability;

import androidx.exifinterface.media.ExifInterface;
import buisnessmodels.Customer;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.squads.nfv.NFVEventType;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.talabat.observability.squads.nfv.ObservableNfvApiNames;
import datamodels.CustomerInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltracking/observability/VendorInfoAPIObservabilityImpl;", "Ltracking/observability/VendorInfoAPIObservability;", "observabilityTracker", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "onVendorListTalabatBranchCodeAPIFailed", "", "isDarkStore", "", "errorCode", "", "errorMessage", "", "selectedCountryId", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoAPIObservabilityImpl implements VendorInfoAPIObservability {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final IObservabilityManager observabilityTracker;

    @Inject
    public VendorInfoAPIObservabilityImpl(@NotNull IObservabilityManager iObservabilityManager, @NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityTracker");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        this.observabilityTracker = iObservabilityManager;
        this.appVersionProvider = appVersionProvider2;
    }

    public void onVendorListTalabatBranchCodeAPIFailed(boolean z11, @Nullable Integer num, @Nullable String str, @Nullable Integer num2) {
        String str2;
        String str3;
        boolean z12;
        String str4;
        CustomerInfo customerInfo;
        Customer instance = Customer.getInstance();
        if (instance == null || (customerInfo = instance.getCustomerInfo()) == null) {
            str2 = null;
        } else {
            str2 = Integer.valueOf(customerInfo.f13850id).toString();
        }
        Pair[] pairArr = new Pair[11];
        boolean z13 = false;
        pairArr[0] = TuplesKt.to("latitude", GlobalDataModel.LATLONGFORAPI.getLatitude());
        pairArr[1] = TuplesKt.to("longitude", GlobalDataModel.LATLONGFORAPI.getLongitude());
        if (num2 == null || (str3 = num2.toString()) == null) {
            str3 = "N/A";
        }
        pairArr[2] = TuplesKt.to("countryId", str3);
        pairArr[3] = TuplesKt.to("deviceSource", "6");
        pairArr[4] = TuplesKt.to("eventSource", ExifInterface.GPS_MEASUREMENT_2D);
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "N/A";
        }
        pairArr[5] = TuplesKt.to("appVersion", appVersion);
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            str2 = "N/A";
        }
        pairArr[6] = TuplesKt.to("customerId", str2);
        if (num == null || (str4 = num.toString()) == null) {
            str4 = ObservableAttributesNames.DEFAULT_RESPONSE_CODE;
        }
        pairArr[7] = TuplesKt.to("api_response_code", str4);
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z13 = true;
        }
        if (z13) {
            str = "N/A";
        }
        pairArr[8] = TuplesKt.to("api_response_message", str);
        pairArr[9] = TuplesKt.to("isDarkStore", String.valueOf(z11));
        pairArr[10] = TuplesKt.to(ObservableAttributesNames.AREA_ID, String.valueOf(GlobalDataModel.SelectedAreaId));
        this.observabilityTracker.track(ObservableNfvApiNames.VENDORLIST_TALABAT_BRANCH_CODE_API_FAILED, NFVEventType.DarkstoreEvents.name(), MapsKt__MapsKt.mapOf(pairArr));
    }
}
