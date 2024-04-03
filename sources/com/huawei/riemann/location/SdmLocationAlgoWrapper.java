package com.huawei.riemann.location;

import android.content.Context;
import com.huawei.location.activity.model.Vw;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;

public class SdmLocationAlgoWrapper {
    public static final Object Vw = new Object();

    /* renamed from: yn  reason: collision with root package name */
    public static volatile SdmLocationAlgoWrapper f50396yn;
    public boolean FB = false;

    public SdmLocationAlgoWrapper(Context context, String str) {
        this.FB = Vw.Vw(context, "libSdm.so", str);
    }

    public static SdmLocationAlgoWrapper yn(Context context, String str) {
        if (f50396yn == null) {
            synchronized (Vw) {
                if (f50396yn == null) {
                    f50396yn = new SdmLocationAlgoWrapper(context, str);
                }
            }
        }
        return f50396yn;
    }

    public native Pvt sdmProcess(Pvt pvt, GnssClock[] gnssClockArr, SatelliteMeasurement[] satelliteMeasurementArr);

    public native int sdmStart(DeviceInfo deviceInfo, CityTileCallback cityTileCallback, String str);

    public native int sdmStop();

    public native void sdmUpdateEphemeris(Ephemeris ephemeris);

    public native void sdmUpdateTileById(long j11, byte[] bArr);
}
