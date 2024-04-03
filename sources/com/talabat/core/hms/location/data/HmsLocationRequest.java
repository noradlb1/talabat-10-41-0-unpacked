package com.talabat.core.hms.location.data;

import com.talabat.location.domain.LocationRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/talabat/core/hms/location/data/HmsLocationRequest;", "Lcom/talabat/location/domain/LocationRequest;", "huaweiLocationRequest", "Lcom/huawei/hms/location/LocationRequest;", "(Lcom/huawei/hms/location/LocationRequest;)V", "value", "", "fastestInterval", "getFastestInterval", "()J", "setFastestInterval", "(J)V", "getHuaweiLocationRequest", "()Lcom/huawei/hms/location/LocationRequest;", "interval", "getInterval", "setInterval", "maxWaitTime", "getMaxWaitTime", "setMaxWaitTime", "", "numUpdates", "getNumUpdates", "()I", "setNumUpdates", "(I)V", "Lcom/talabat/location/domain/LocationRequest$Priority;", "priority", "getPriority", "()Lcom/talabat/location/domain/LocationRequest$Priority;", "setPriority", "(Lcom/talabat/location/domain/LocationRequest$Priority;)V", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsLocationRequest implements LocationRequest {
    @NotNull
    private final com.huawei.hms.location.LocationRequest huaweiLocationRequest;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocationRequest.Priority.values().length];
            iArr[LocationRequest.Priority.PRIORITY_HIGH_ACCURACY.ordinal()] = 1;
            iArr[LocationRequest.Priority.PRIORITY_BALANCED_POWER_ACCURACY.ordinal()] = 2;
            iArr[LocationRequest.Priority.PRIORITY_LOW_POWER.ordinal()] = 3;
            iArr[LocationRequest.Priority.PRIORITY_NO_POWER.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public HmsLocationRequest(@NotNull com.huawei.hms.location.LocationRequest locationRequest) {
        Intrinsics.checkNotNullParameter(locationRequest, "huaweiLocationRequest");
        this.huaweiLocationRequest = locationRequest;
    }

    public long getFastestInterval() {
        return this.huaweiLocationRequest.getFastestInterval();
    }

    @NotNull
    public final com.huawei.hms.location.LocationRequest getHuaweiLocationRequest() {
        return this.huaweiLocationRequest;
    }

    public long getInterval() {
        return this.huaweiLocationRequest.getInterval();
    }

    public long getMaxWaitTime() {
        return this.huaweiLocationRequest.getMaxWaitTime();
    }

    public int getNumUpdates() {
        return this.huaweiLocationRequest.getNumUpdates();
    }

    @NotNull
    public LocationRequest.Priority getPriority() {
        int priority = this.huaweiLocationRequest.getPriority();
        if (priority == 100) {
            return LocationRequest.Priority.PRIORITY_HIGH_ACCURACY;
        }
        if (priority == 102) {
            return LocationRequest.Priority.PRIORITY_BALANCED_POWER_ACCURACY;
        }
        if (priority == 104) {
            return LocationRequest.Priority.PRIORITY_LOW_POWER;
        }
        if (priority != 105) {
            return LocationRequest.Priority.PRIORITY_NO_POWER;
        }
        return LocationRequest.Priority.PRIORITY_NO_POWER;
    }

    public void setFastestInterval(long j11) {
        this.huaweiLocationRequest.setFastestInterval(j11);
    }

    public void setInterval(long j11) {
        this.huaweiLocationRequest.setInterval(j11);
    }

    public void setMaxWaitTime(long j11) {
        this.huaweiLocationRequest.setMaxWaitTime(j11);
    }

    public void setNumUpdates(int i11) {
        this.huaweiLocationRequest.setNumUpdates(i11);
    }

    public void setPriority(@NotNull LocationRequest.Priority priority) {
        int i11;
        Intrinsics.checkNotNullParameter(priority, "value");
        com.huawei.hms.location.LocationRequest locationRequest = this.huaweiLocationRequest;
        int i12 = WhenMappings.$EnumSwitchMapping$0[priority.ordinal()];
        if (i12 == 1) {
            i11 = 100;
        } else if (i12 == 2) {
            i11 = 102;
        } else if (i12 == 3) {
            i11 = 104;
        } else if (i12 == 4) {
            i11 = 105;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        locationRequest.setPriority(i11);
    }
}
