package com.huawei.location.req;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import java.util.List;

public class CheckLocationSettingsReq extends LocationBaseRequest {
    @Packed
    private boolean alwaysShow;
    @Packed
    private boolean needBle;
    @Packed
    private List<LocationRequest> requests;

    public List<LocationRequest> getRequests() {
        return this.requests;
    }

    public boolean isAlwaysShow() {
        return this.alwaysShow;
    }

    public boolean isNeedBle() {
        return this.needBle;
    }

    public void setAlwaysShow(boolean z11) {
        this.alwaysShow = z11;
    }

    public void setNeedBle(boolean z11) {
        this.needBle = z11;
    }

    public void setRequests(List<LocationRequest> list) {
        this.requests = list;
    }
}
