package com.huawei.location.resp;

import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;

public class FB {
    private LocationSettingsStates Vw;

    /* renamed from: yn  reason: collision with root package name */
    private Status f50209yn;

    public Status Vw() {
        return this.f50209yn;
    }

    public LocationSettingsStates yn() {
        return this.Vw;
    }

    public void yn(LocationSettingsStates locationSettingsStates) {
        this.Vw = locationSettingsStates;
    }

    public void yn(Status status) {
        this.f50209yn = status;
    }
}
