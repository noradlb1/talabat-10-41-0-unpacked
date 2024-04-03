package com.talabat.restaurants.v2.data.vendorinfo;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.v2.data.vendorinfo.VendorsInfoApi;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import lt.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendorinfo/VendorInfoRepositoryImpl;", "Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoRepository;", "vendorInfoApi", "Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoApi;", "tracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "(Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoApi;Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "getVendorsInfo", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "latitude", "", "longitude", "verticalIds", "", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoRepositoryImpl implements VendorsInfoRepository {
    @NotNull
    private final TimeTrackerImplementation tracker;
    @NotNull
    private final VendorsInfoApi vendorInfoApi;

    public VendorInfoRepositoryImpl() {
        this((VendorsInfoApi) null, (TimeTrackerImplementation) null, 3, (DefaultConstructorMarker) null);
    }

    public VendorInfoRepositoryImpl(@NotNull VendorsInfoApi vendorsInfoApi, @NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(vendorsInfoApi, "vendorInfoApi");
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "tracker");
        this.vendorInfoApi = vendorsInfoApi;
        this.tracker = timeTrackerImplementation;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorsInfo$lambda-0  reason: not valid java name */
    public static final void m10734getVendorsInfo$lambda0(VendorInfoRepositoryImpl vendorInfoRepositoryImpl, String str, RestuarntListResponse restuarntListResponse) {
        Intrinsics.checkNotNullParameter(vendorInfoRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$trackingName");
        TimeTrackerImplementation.stopTracking$default(vendorInfoRepositoryImpl.tracker, str, 0, 2, (Object) null);
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsInfo(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "latitude");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        Object obj = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (obj == null) {
            obj = "0";
        }
        String str5 = "VENDORS_INFO_REQUEST_VL" + obj;
        TimeTrackerImplementation.startTracking$default(this.tracker, str5, 0, 2, (Object) null);
        Single<RestuarntListResponse> doOnSuccess = VendorsInfoApi.DefaultImpls.getVendorsInfo$default(this.vendorInfoApi, 0, str, str2, list, 1, (Object) null).doOnSuccess(new a(this, str5));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "vendorInfoApi\n          …ackingName)\n            }");
        return doOnSuccess;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorInfoRepositoryImpl(VendorsInfoApi vendorsInfoApi, TimeTrackerImplementation timeTrackerImplementation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new VendorInfoApiImpl((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null) : vendorsInfoApi, (i11 & 2) != 0 ? TimeTrackerKt.getTimeTracker() : timeTrackerImplementation);
    }
}
