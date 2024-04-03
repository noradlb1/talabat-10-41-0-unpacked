package com.talabat.core.hms.location.data;

import com.huawei.hms.location.LocationSettingsRequest;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationSettingsRequestBuilderWrapper;", "Lcom/talabat/location/domain/LocationSettingsRequest$Builder;", "builder", "Lcom/huawei/hms/location/LocationSettingsRequest$Builder;", "(Lcom/huawei/hms/location/LocationSettingsRequest$Builder;)V", "addAllLocationRequests", "locationRequests", "", "Lcom/talabat/location/domain/LocationRequest;", "addLocationRequest", "locationRequest", "build", "Lcom/talabat/location/domain/LocationSettingsRequest;", "setAlwaysShow", "alwaysShow", "", "setNeedBle", "needBle", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationSettingsRequestBuilderWrapper implements LocationSettingsRequest.Builder {
    @NotNull
    private final LocationSettingsRequest.Builder builder;

    @Inject
    public HmsLocationSettingsRequestBuilderWrapper(@NotNull LocationSettingsRequest.Builder builder2) {
        Intrinsics.checkNotNullParameter(builder2, "builder");
        this.builder = builder2;
    }

    @NotNull
    public LocationSettingsRequest.Builder addAllLocationRequests(@NotNull Collection<? extends LocationRequest> collection) {
        Intrinsics.checkNotNullParameter(collection, "locationRequests");
        LocationSettingsRequest.Builder builder2 = this.builder;
        Iterable<LocationRequest> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (LocationRequest locationRequest : iterable) {
            if (locationRequest != null) {
                arrayList.add(((HmsLocationRequest) locationRequest).getHuaweiLocationRequest());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.hms.location.data.HmsLocationRequest");
            }
        }
        builder2.addAllLocationRequests(arrayList);
        return this;
    }

    @NotNull
    public LocationSettingsRequest.Builder addLocationRequest(@NotNull LocationRequest locationRequest) {
        Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
        this.builder.addLocationRequest(((HmsLocationRequest) locationRequest).getHuaweiLocationRequest());
        return this;
    }

    @NotNull
    public com.talabat.location.domain.LocationSettingsRequest build() {
        com.huawei.hms.location.LocationSettingsRequest build = this.builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return new HmsLocationSettingsRequestWrapper(build);
    }

    @NotNull
    public LocationSettingsRequest.Builder setAlwaysShow(boolean z11) {
        this.builder.setAlwaysShow(z11);
        return this;
    }

    @NotNull
    public LocationSettingsRequest.Builder setNeedBle(boolean z11) {
        this.builder.setNeedBle(z11);
        return this;
    }
}
