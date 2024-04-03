package com.talabat.location.domain;

import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/location/domain/LocationSettingsRequest;", "", "Builder", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationSettingsRequest {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/location/domain/LocationSettingsRequest$Builder;", "", "addAllLocationRequests", "locationRequests", "", "Lcom/talabat/location/domain/LocationRequest;", "addLocationRequest", "locationRequest", "build", "Lcom/talabat/location/domain/LocationSettingsRequest;", "setAlwaysShow", "alwaysShow", "", "setNeedBle", "needBle", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Builder {
        @NotNull
        Builder addAllLocationRequests(@NotNull Collection<? extends LocationRequest> collection);

        @NotNull
        Builder addLocationRequest(@NotNull LocationRequest locationRequest);

        @NotNull
        LocationSettingsRequest build();

        @NotNull
        Builder setAlwaysShow(boolean z11);

        @NotNull
        Builder setNeedBle(boolean z11);
    }
}
