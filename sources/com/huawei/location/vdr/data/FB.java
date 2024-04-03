package com.huawei.location.vdr.data;

import android.location.Location;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

public class FB {
    private Location FB;
    private MotionSensors Vw;

    /* renamed from: yn  reason: collision with root package name */
    private GnssRawObservation[] f50273yn;

    public FB(GnssRawObservation[] gnssRawObservationArr, MotionSensors motionSensors, Location location) {
        this.f50273yn = gnssRawObservationArr;
        this.Vw = motionSensors;
        this.FB = location;
    }

    public MotionSensors FB() {
        return this.Vw;
    }

    public Location Vw() {
        return this.FB;
    }

    public GnssRawObservation[] yn() {
        return this.f50273yn;
    }
}
