package com.talabat.core.hms.location.data;

import com.talabat.location.domain.LocationAvailability;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationAvailabilityWrapper;", "Lcom/talabat/location/domain/LocationAvailability;", "locationAvailability", "Lcom/huawei/hms/location/LocationAvailability;", "(Lcom/huawei/hms/location/LocationAvailability;)V", "isLocationAvailable", "", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationAvailabilityWrapper implements LocationAvailability {
    @Nullable
    private final com.huawei.hms.location.LocationAvailability locationAvailability;

    public HmsLocationAvailabilityWrapper(@Nullable com.huawei.hms.location.LocationAvailability locationAvailability2) {
        this.locationAvailability = locationAvailability2;
    }

    public boolean isLocationAvailable() {
        com.huawei.hms.location.LocationAvailability locationAvailability2 = this.locationAvailability;
        if (locationAvailability2 != null) {
            return locationAvailability2.isLocationAvailable();
        }
        return false;
    }
}
