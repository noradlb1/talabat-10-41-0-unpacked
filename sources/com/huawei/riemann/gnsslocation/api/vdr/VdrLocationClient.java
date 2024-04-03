package com.huawei.riemann.gnsslocation.api.vdr;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.huawei.location.FB;
import com.huawei.riemann.gnsslocation.core.VdrLocationAlgoWrapper;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;
import com.huawei.riemann.gnsslocation.core.yn;

public class VdrLocationClient {
    public static final String TAG = "com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient";
    public yn mVdrLocManager;

    public VdrLocationClient(Context context, String str) {
        if (context != null) {
            try {
                this.mVdrLocManager = new yn(context.getApplicationContext(), str);
                Log.i(TAG, "VDR version time: 20211124");
            } catch (IllegalArgumentException e11) {
                String str2 = TAG;
                Log.e(str2, "vdr client error: " + e11.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Context can not be null");
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr, MotionSensors motionSensors, Pvt pvt2) {
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "proc manager null");
            return pvt;
        }
        if (pvt == null) {
            Log.w("VdrLocationManager", "pvt null in proc");
        }
        if (gnssRawObservationArr == null) {
            Log.w("VdrLocationManager", "obs null in proc");
        }
        if (motionSensors == null) {
            Log.e("VdrLocationManager", "sensors null in proc");
            return null;
        } else if (yn.f50395yn == null || !VdrLocationAlgoWrapper.FB) {
            Log.e("VdrLocationManager", "wp is null in proc");
            return pvt;
        } else {
            GnssClock[] gnssClockArr = new GnssClock[0];
            SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[0];
            if (gnssRawObservationArr != null) {
                gnssClockArr = new GnssClock[gnssRawObservationArr.length];
                satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
                for (int i11 = 0; i11 < gnssRawObservationArr.length; i11++) {
                    GnssRawObservation gnssRawObservation = gnssRawObservationArr[i11];
                    if (gnssRawObservation == null) {
                        Log.w("VdrLocationManager", "rawMeasurements[" + i11 + "] is null");
                    } else {
                        gnssClockArr[i11] = gnssRawObservation.getGnssClock();
                        satelliteMeasurementArr[i11] = gnssRawObservationArr[i11].getSatelliteMeasurement();
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("vdr process algo start: ");
            int i12 = ynVar.LW + 1;
            ynVar.LW = i12;
            sb2.append(i12);
            Pvt vdrProcess = yn.f50395yn.vdrProcess(pvt, gnssClockArr, satelliteMeasurementArr, motionSensors, pvt2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("vdr process algo finished: ");
            int i13 = ynVar.dC + 1;
            ynVar.dC = i13;
            sb3.append(i13);
            if (ynVar.Vw == null) {
                return vdrProcess;
            }
            Log.e("LogPersistenceManager", "log p helper null when proc");
            return vdrProcess;
        }
    }

    public int startLocation(DeviceInfo deviceInfo) {
        String str;
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "start n");
            return -1;
        }
        if (ynVar.FB) {
            str = "already started";
        } else {
            ynVar.FB = true;
            FB fb2 = ynVar.Vw;
            if (fb2 != null) {
                fb2.yn();
            }
            if (yn.f50395yn == null || !VdrLocationAlgoWrapper.FB) {
                str = "start: wp is null";
            } else {
                yn.f50395yn.vdrStart(deviceInfo, "");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("start vdr location finished, transPath: ");
                sb2.append("");
                return 0;
            }
        }
        Log.e("VdrLocationManager", str);
        return 0;
    }

    public void stopLocation() {
        String str;
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "stop n");
            return;
        }
        if (!ynVar.FB) {
            str = "already stopped";
        } else {
            ynVar.FB = false;
            if (yn.f50395yn == null || !VdrLocationAlgoWrapper.FB) {
                str = "stop: wp is null";
            } else {
                yn.f50395yn.vdrStop();
                FB fb2 = ynVar.Vw;
                if (fb2 != null && fb2.dC) {
                    fb2.dC = false;
                    Handler handler = fb2.LW;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                    FB.yn ynVar2 = fb2.FB;
                    if (ynVar2 != null) {
                        ynVar2.quitSafely();
                    }
                    fb2.LW = null;
                    fb2.FB = null;
                    return;
                }
                return;
            }
        }
        Log.e("VdrLocationManager", str);
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        String str;
        if (this.mVdrLocManager == null) {
            Log.e(TAG, "no ephemeris data");
            return;
        }
        yn ynVar = this.mVdrLocManager;
        ynVar.getClass();
        if (yn.f50395yn == null || !VdrLocationAlgoWrapper.FB) {
            str = "update: wp is null";
        } else {
            yn.f50395yn.vdrUpdateEphemeris(ephemeris);
            if (ynVar.Vw == null) {
                str = "lpm is null";
            } else {
                Log.e("LogPersistenceManager", "log p helper null when eph");
                return;
            }
        }
        Log.e("VdrLocationManager", str);
    }
}
