package com.talabat.talabatcommon.feature.vendorTags.data;

import androidx.annotation.VisibleForTesting;
import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import dv.a;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsRepository;", "vendorTagsApi", "Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsApi;", "tracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "(Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsApi;Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "getVendorTags", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "latitude", "", "longitude", "verticalIds", "", "", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorTagsRepositoryImpl implements VendorTagsRepository {
    @NotNull
    private final TimeTrackerImplementation tracker;
    @NotNull
    private final VendorTagsApi vendorTagsApi;

    public VendorTagsRepositoryImpl() {
        this((VendorTagsApi) null, (TimeTrackerImplementation) null, 3, (DefaultConstructorMarker) null);
    }

    public VendorTagsRepositoryImpl(@NotNull @VisibleForTesting VendorTagsApi vendorTagsApi2, @NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(vendorTagsApi2, "vendorTagsApi");
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "tracker");
        this.vendorTagsApi = vendorTagsApi2;
        this.tracker = timeTrackerImplementation;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorTags$lambda-0  reason: not valid java name */
    public static final void m10930getVendorTags$lambda0(VendorTagsRepositoryImpl vendorTagsRepositoryImpl, String str, VendorTagsResponse vendorTagsResponse) {
        Intrinsics.checkNotNullParameter(vendorTagsRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$trackingName");
        TimeTrackerImplementation.stopTracking$default(vendorTagsRepositoryImpl.tracker, str, 0, 2, (Object) null);
    }

    @NotNull
    public Single<VendorTagsResponse> getVendorTags(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list, int i11) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        Object obj = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (obj == null) {
            obj = "0";
        }
        String str3 = "VENDOR_TAGS_REQUEST_VL" + obj;
        TimeTrackerImplementation.startTracking$default(this.tracker, str3, 0, 2, (Object) null);
        Single<VendorTagsResponse> doOnSuccess = this.vendorTagsApi.getSmartVendorTags(str, str2, list, i11).doOnSuccess(new a(this, str3));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "vendorTagsApi\n          …ackingName)\n            }");
        return doOnSuccess;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorTagsRepositoryImpl(VendorTagsApi vendorTagsApi2, TimeTrackerImplementation timeTrackerImplementation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? (VendorTagsApi) NetworkBuilder.Companion.getService(VendorEndPointProvider.INSTANCE.getBaseUrl(), VendorTagsApi.class) : vendorTagsApi2, (i11 & 2) != 0 ? TimeTrackerKt.getTimeTracker() : timeTrackerImplementation);
    }
}
