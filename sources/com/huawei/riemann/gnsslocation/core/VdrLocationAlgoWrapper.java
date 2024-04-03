package com.huawei.riemann.gnsslocation.core;

import android.content.Context;
import com.huawei.location.activity.model.Vw;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;

public class VdrLocationAlgoWrapper {
    public static boolean FB = false;
    public static final Object Vw = new Object();

    /* renamed from: yn  reason: collision with root package name */
    public static volatile VdrLocationAlgoWrapper f50301yn;

    public VdrLocationAlgoWrapper(Context context, String str) {
        FB = Vw.yn(context, "libVdr.so", str);
    }

    public static VdrLocationAlgoWrapper yn(Context context, String str) {
        if (f50301yn == null) {
            synchronized (Vw) {
                if (f50301yn == null) {
                    f50301yn = new VdrLocationAlgoWrapper(context, str);
                }
            }
        }
        return f50301yn;
    }

    public native Pvt vdrProcess(Pvt pvt, GnssClock[] gnssClockArr, SatelliteMeasurement[] satelliteMeasurementArr, MotionSensors motionSensors, Pvt pvt2);

    public native int vdrStart(DeviceInfo deviceInfo, String str);

    public native int vdrStop();

    public native void vdrUpdateEphemeris(Ephemeris ephemeris);
}
