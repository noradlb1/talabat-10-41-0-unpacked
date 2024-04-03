package com.huawei.riemann.common.api.location;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.huawei.riemann.location.SdmLocationAlgoWrapper;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.location.yn;

public class SdmLocationClient {
    public static final String TAG = "SdmLocationClient";
    public Context mContext;
    public yn mSdmLocManager;

    public SdmLocationClient(Context context, Intent intent, String str) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                this.mContext = applicationContext;
                this.mSdmLocManager = new yn(applicationContext, intent, str);
            } catch (IllegalArgumentException e11) {
                Log.e(TAG, e11.getMessage() != null ? e11.getMessage() : "IllegalArgumentException2");
            }
        } else {
            throw new IllegalArgumentException("Context can not be null");
        }
    }

    public SdmLocationClient(Context context, Looper looper, String str) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                this.mContext = applicationContext;
                this.mSdmLocManager = new yn(applicationContext, looper, str);
            } catch (IllegalArgumentException e11) {
                Log.e(TAG, e11.getMessage() != null ? e11.getMessage() : "IllegalArgumentException3");
            }
        } else {
            throw new IllegalArgumentException("Context can not be null");
        }
    }

    public SdmLocationClient(Context context, String str) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                this.mContext = applicationContext;
                this.mSdmLocManager = new yn(applicationContext, str);
            } catch (IllegalArgumentException e11) {
                Log.e(TAG, e11.getMessage() != null ? e11.getMessage() : "IllegalArgumentException1");
            }
        } else {
            throw new IllegalArgumentException("Context can not be null");
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr) {
        String str;
        String str2;
        yn ynVar = this.mSdmLocManager;
        if (ynVar != null) {
            if (pvt == null) {
                str2 = "pvt null";
            } else if (gnssRawObservationArr == null) {
                str2 = "obs null";
            } else {
                SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
                if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                    str = "wp is null";
                } else {
                    GnssClock[] gnssClockArr = new GnssClock[gnssRawObservationArr.length];
                    SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
                    for (int i11 = 0; i11 < gnssRawObservationArr.length; i11++) {
                        gnssClockArr[i11] = gnssRawObservationArr[i11].getGnssClock();
                        satelliteMeasurementArr[i11] = gnssRawObservationArr[i11].getSatelliteMeasurement();
                    }
                    pvt = ynVar.G3.sdmProcess(pvt, gnssClockArr, satelliteMeasurementArr);
                    if (ynVar.f50489zp != null) {
                        return pvt;
                    }
                    str = "p ops null";
                }
                Log.e("SdmLocationManager", str);
                return pvt;
            }
            Log.e("SdmLocationManager", str2);
            return null;
        }
        Log.e(TAG, "proc n");
        return pvt;
    }

    public int startLocation(DeviceInfo deviceInfo, CityTileCallback cityTileCallback) {
        String str;
        yn ynVar = this.mSdmLocManager;
        if (ynVar != null) {
            if (!ynVar.dW) {
                ynVar.yn((Looper) null);
                yn.LW lw2 = ynVar.f50489zp;
                if (lw2 != null) {
                    ynVar.f50485h1 = cityTileCallback;
                    ynVar.Yx = new yn.Vw(lw2, cityTileCallback);
                } else {
                    ynVar.Yx = new yn.Vw(new Handler(Looper.getMainLooper()), cityTileCallback);
                }
                SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
                if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                    str = "wp is null";
                } else {
                    sdmLocationAlgoWrapper.sdmStart(deviceInfo, ynVar.Yx, "");
                    ynVar.dW = true;
                    return 0;
                }
            } else {
                str = "already started";
            }
            Log.e("SdmLocationManager", str);
            ynVar.dW = true;
            return 0;
        }
        Log.e(TAG, "start n");
        return -1;
    }

    public void stopLocation() {
        yn ynVar = this.mSdmLocManager;
        if (ynVar != null) {
            if (ynVar.dW) {
                SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
                if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                    Log.e("SdmLocationManager", "wp is null");
                } else {
                    sdmLocationAlgoWrapper.sdmStop();
                }
                ynVar.f50485h1 = null;
                ynVar.Yx = null;
                if (ynVar.Ot) {
                    yn.dC dCVar = ynVar.E5;
                    if (dCVar != null) {
                        dCVar.removeCallbacksAndMessages((Object) null);
                    }
                    yn.LW lw2 = ynVar.f50489zp;
                    if (lw2 != null) {
                        lw2.removeCallbacksAndMessages((Object) null);
                    }
                    yn.FB fb2 = ynVar.f50484d2;
                    if (fb2 != null) {
                        fb2.quitSafely();
                    }
                    ynVar.E5 = null;
                    ynVar.f50489zp = null;
                    ynVar.f50484d2 = null;
                }
                ynVar.Ot = false;
            } else {
                Log.e("SdmLocationManager", "already stopped");
            }
            ynVar.dW = false;
            return;
        }
        Log.e(TAG, "stop n");
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        yn ynVar = this.mSdmLocManager;
        if (ynVar != null) {
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                Log.e("SdmLocationManager", "wp is null");
                return;
            }
            if (ynVar.f50489zp == null) {
                Log.e("SdmLocationManager", "e ops null");
            }
            ynVar.G3.sdmUpdateEphemeris(ephemeris);
            return;
        }
        Log.e(TAG, "eph n");
    }
}
