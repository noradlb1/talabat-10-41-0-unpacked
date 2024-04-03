package com.huawei.location.cache;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.callback.d2;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

public class Vw {
    private d2 Vw;

    /* renamed from: yn  reason: collision with root package name */
    private RequestLocationUpdatesRequest f50003yn;

    public Vw() {
        this(new RequestLocationUpdatesRequest());
    }

    public Vw(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.f50003yn = requestLocationUpdatesRequest;
    }

    public String E5() {
        return this.f50003yn.getTid();
    }

    public int FB() {
        LocationRequest locationRequest = this.f50003yn.getLocationRequest();
        if (locationRequest == null) {
            return -1;
        }
        return locationRequest.getPriority();
    }

    public String LW() {
        LocationRequest locationRequest = this.f50003yn.getLocationRequest();
        if (locationRequest == null) {
            return "";
        }
        int priority = locationRequest.getPriority();
        if (priority == 100) {
            return "fused";
        }
        if (priority != 102) {
            if (priority == 200) {
                return "gps";
            }
            if (!(priority == 300 || priority == 104)) {
                return priority != 105 ? "" : "passive";
            }
        }
        return SDKCoreEvent.Network.TYPE_NETWORK;
    }

    public LocationRequest Vw() {
        return this.f50003yn.getLocationRequest();
    }

    public String d2() {
        return this.f50003yn.getUuid();
    }

    public RequestLocationUpdatesRequest dC() {
        return this.f50003yn;
    }

    public d2 yn() {
        return this.Vw;
    }

    public void yn(d2 d2Var) {
        this.Vw = d2Var;
    }
}
