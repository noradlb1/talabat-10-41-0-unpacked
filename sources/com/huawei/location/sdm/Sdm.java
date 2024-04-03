package com.huawei.location.sdm;

import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.CollectionsUtils;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.riemann.common.api.location.SdmLocationClient;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.Collection;

@RequiresApi(api = 24)
public class Sdm {
    private HandlerThread E5;
    private com.huawei.location.sdm.utils.yn EF;
    private GnssMeasurementsEvent.Callback Eu = new yn();
    /* access modifiers changed from: private */
    public FB FB;
    /* access modifiers changed from: private */
    public int G3 = 1;
    /* access modifiers changed from: private */
    public yn LW;
    private com.huawei.location.tiles.callback.yn OB;
    private DeviceInfo Ot;
    private com.huawei.location.ephemeris.yn SI;
    /* access modifiers changed from: private */
    public LocationManager Vw;
    /* access modifiers changed from: private */
    public com.huawei.location.support.yn Wf;
    /* access modifiers changed from: private */
    public Boolean Yx = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: d2  reason: collision with root package name */
    public HandlerThread f50215d2;
    private Location dC;
    /* access modifiers changed from: private */
    public long dW = 0;
    /* access modifiers changed from: private */

    /* renamed from: h1  reason: collision with root package name */
    public long f50216h1 = 0;

    /* renamed from: oc  reason: collision with root package name */
    private Config f50217oc = null;
    /* access modifiers changed from: private */

    /* renamed from: ut  reason: collision with root package name */
    public SdmLocationClient f50218ut;
    /* access modifiers changed from: private */

    /* renamed from: yn  reason: collision with root package name */
    public long f50219yn = -1;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: zp  reason: collision with root package name */
    public Vw f50220zp;

    public class FB extends Handler {

        /* renamed from: yn  reason: collision with root package name */
        public static final /* synthetic */ int f50221yn = 0;

        public FB(Looper looper) {
            super(looper);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
        public void handleMessage(@NonNull Message message) {
            String str;
            String str2;
            int i11 = message.what;
            if (i11 == 1) {
                LogConsole.i("Sdm", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (!(obj instanceof Location)) {
                    str2 = "handleMessage not location obj";
                } else {
                    Sdm.t(Sdm.this, (Location) obj);
                    return;
                }
            } else if (i11 == 3) {
                LogConsole.i("Sdm", "handleMessage: LOCATION_PROCESS");
                Object obj2 = message.obj;
                if (!(obj2 instanceof GnssMeasurementsEvent)) {
                    str2 = "handleMessage not GnssMeasurementsEvent obj";
                } else {
                    Sdm.s(Sdm.this, (GnssMeasurementsEvent) obj2);
                    return;
                }
            } else if (i11 == 2) {
                LogConsole.i("Sdm", "stop begin");
                Object obj3 = message.obj;
                if (!(obj3 instanceof yn)) {
                    LogConsole.e("Sdm", "handleMessage not SdmListener obj");
                    return;
                }
                if (((yn) obj3).equals(Sdm.this.LW)) {
                    yn unused = Sdm.this.LW = null;
                    Sdm.this.Wf.Vw();
                    if (Sdm.this.f50218ut != null) {
                        Sdm.this.f50218ut.stopLocation();
                    }
                    LogConsole.i("Sdm", "The algorithm is disabled");
                    if (Sdm.this.f50220zp != null) {
                        Vw i12 = Sdm.this.f50220zp;
                        Sdm.this.Vw.removeUpdates(i12);
                    }
                    Sdm.f(Sdm.this);
                    int unused2 = Sdm.this.G3 = 1;
                    Boolean unused3 = Sdm.this.Yx = Boolean.FALSE;
                    long unused4 = Sdm.this.f50216h1 = 0;
                    long unused5 = Sdm.this.dW = 0;
                }
                LogConsole.i("Sdm", "stop end");
                return;
            } else if (i11 == 4) {
                LogConsole.i("Sdm", "add listener");
                Object obj4 = message.obj;
                if (!(obj4 instanceof yn)) {
                    LogConsole.e("Sdm", "handleMessage not SdmListener obj");
                    return;
                }
                yn ynVar = (yn) obj4;
                if (Sdm.this.LW == null) {
                    Sdm sdm = Sdm.this;
                    Vw unused6 = sdm.f50220zp = new Vw(sdm, (yn) null);
                    Vw i13 = Sdm.this.f50220zp;
                    Looper looper = getLooper();
                    i13.getClass();
                    try {
                        Sdm.this.Vw.requestLocationUpdates("gps", 1000, 0.0f, i13, looper);
                        LogConsole.i("Sdm", "location listener register success");
                    } catch (SecurityException unused7) {
                        str = "LocationManager requestLocationUpdates throw SecurityException";
                        LogConsole.e("Sdm", str);
                        Sdm.c(Sdm.this);
                        yn unused8 = Sdm.this.LW = ynVar;
                        LogConsole.i("Sdm", "add listener success");
                        return;
                    } catch (IllegalArgumentException unused9) {
                        str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                        LogConsole.e("Sdm", str);
                        Sdm.c(Sdm.this);
                        yn unused10 = Sdm.this.LW = ynVar;
                        LogConsole.i("Sdm", "add listener success");
                        return;
                    } catch (Exception unused11) {
                        str = "LocationManager requestLocationUpdates throw other exception";
                        LogConsole.e("Sdm", str);
                        Sdm.c(Sdm.this);
                        yn unused12 = Sdm.this.LW = ynVar;
                        LogConsole.i("Sdm", "add listener success");
                        return;
                    }
                    Sdm.c(Sdm.this);
                    yn unused13 = Sdm.this.LW = ynVar;
                    LogConsole.i("Sdm", "add listener success");
                    return;
                }
                return;
            } else {
                LogConsole.e("Sdm", "unknown msg:" + message.what);
                return;
            }
            LogConsole.e("Sdm", str2);
        }
    }

    public class Vw implements LocationListener {
        private Vw() {
        }

        public /* synthetic */ Vw(Sdm sdm, yn ynVar) {
            this();
        }

        public void onLocationChanged(Location location) {
            if (location == null) {
                LogConsole.e("Sdm", "location null");
                return;
            }
            if (Sdm.this.FB == null || Sdm.this.f50215d2 == null || !Sdm.this.f50215d2.isAlive()) {
                HandlerThread unused = Sdm.this.f50215d2 = new HandlerThread("Sdm");
                Sdm.this.f50215d2.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                FB unused2 = sdm.FB = new FB(sdm2.f50215d2.getLooper());
            }
            Sdm.this.FB.obtainMessage(1, location).sendToTarget();
        }

        public void onProviderDisabled(String str) {
            LogConsole.d("Sdm", "onProviderDisabled");
        }

        public void onProviderEnabled(String str) {
            LogConsole.d("Sdm", "onProviderEnabled");
        }

        public void onStatusChanged(String str, int i11, Bundle bundle) {
            LogConsole.d("Sdm", "onStatusChanged");
        }
    }

    public class yn extends GnssMeasurementsEvent.Callback {
        public yn() {
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (System.currentTimeMillis() - Sdm.this.f50219yn < 900) {
                LogConsole.i("Sdm", "do nothing because MeasurementsEvent is too fast");
                return;
            }
            long unused = Sdm.this.f50219yn = System.currentTimeMillis();
            if (Sdm.this.FB == null || Sdm.this.f50215d2 == null || !Sdm.this.f50215d2.isAlive()) {
                HandlerThread unused2 = Sdm.this.f50215d2 = new HandlerThread("Sdm");
                Sdm.this.f50215d2.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                FB unused3 = sdm.FB = new FB(sdm2.f50215d2.getLooper());
            }
            Sdm.this.FB.obtainMessage(3, gnssMeasurementsEvent).sendToTarget();
        }

        public void onStatusChanged(int i11) {
            LogConsole.i("Sdm", "GnssMeasurementsEvent onStatusChanged :" + i11);
            super.onStatusChanged(i11);
        }
    }

    public Sdm() {
        yn();
    }

    public static void c(Sdm sdm) {
        sdm.getClass();
        try {
            boolean a11 = sdm.Vw.registerGnssMeasurementsCallback(sdm.Eu);
            LogConsole.i("Sdm", "RegisterMeasurements:" + a11);
        } catch (Exception unused) {
            LogConsole.e("Sdm", "registerGnssMeasurements error.");
        }
    }

    public static void f(Sdm sdm) {
        LocationManager locationManager = sdm.Vw;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(sdm.Eu);
        }
    }

    public static void s(Sdm sdm, GnssMeasurementsEvent gnssMeasurementsEvent) {
        Location location = sdm.dC;
        if (location == null) {
            LogConsole.e("Sdm", "location is null");
        } else if (SystemClock.elapsedRealtime() - sdm.dW > 15000) {
            LogConsole.e("Sdm", "location is invalidation");
            sdm.dC = null;
            sdm.dW = 0;
        } else if (sdm.Wf.yn(location.getLongitude(), location.getLatitude(), location.getSpeed())) {
            if (sdm.f50218ut == null && sdm.EF.Vw()) {
                sdm.f50218ut = new SdmLocationClient(ContextUtil.getContext(), com.huawei.location.sdm.constant.FB.Vw);
            }
            SdmLocationClient sdmLocationClient = sdm.f50218ut;
            if (sdmLocationClient == null) {
                LogConsole.i("Sdm", "SdmLocationClient init failed");
                return;
            }
            if (sdm.G3 == 0) {
                long j11 = sdm.f50216h1;
                if (j11 == 0 || j11 != sdm.SI.FB()) {
                    sdm.f50216h1 = sdm.SI.FB();
                    sdm.f50218ut.updateEphemeris(sdm.SI.Vw());
                }
            } else if (sdmLocationClient.startLocation(sdm.Ot, sdm.OB) == 0) {
                LogConsole.i("Sdm", "The algorithm is enabled");
                long j12 = sdm.f50216h1;
                if (j12 == 0 || j12 != sdm.SI.FB()) {
                    sdm.f50216h1 = sdm.SI.FB();
                    sdm.f50218ut.updateEphemeris(sdm.SI.Vw());
                }
                sdm.G3 = 0;
            } else {
                return;
            }
            sdm.dC = sdm.yn(gnssMeasurementsEvent, location);
            sdm.dW = SystemClock.elapsedRealtime();
        } else {
            int i11 = sdm.G3 + 1;
            sdm.G3 = i11;
            if (i11 == 1) {
                SdmLocationClient sdmLocationClient2 = sdm.f50218ut;
                if (sdmLocationClient2 != null) {
                    sdmLocationClient2.stopLocation();
                    sdm.f50216h1 = 0;
                    return;
                }
                return;
            }
            sdm.G3 = 2;
        }
    }

    public static void t(Sdm sdm, Location location) {
        sdm.getClass();
        if (location == null) {
            LogConsole.i("Sdm", "location is null");
            return;
        }
        if (sdm.dC != null && SystemClock.elapsedRealtime() - sdm.dW <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && sdm.Yx.booleanValue()) {
            yn ynVar = sdm.LW;
            if (ynVar != null) {
                ynVar.onLocationChanged(sdm.dC);
            }
        } else {
            yn ynVar2 = sdm.LW;
            if (ynVar2 != null) {
                ynVar2.onLocationChanged(location);
            }
        }
        sdm.dC = location;
        sdm.dW = SystemClock.elapsedRealtime();
        sdm.Yx = Boolean.FALSE;
    }

    private Location yn(GnssMeasurementsEvent gnssMeasurementsEvent, Location location) {
        GnssRawObservation[] gnssRawObservationArr;
        double d11;
        double d12;
        double d13;
        double d14;
        int i11;
        double d15;
        long j11;
        long j12;
        float f11;
        double d16;
        double d17;
        double d18;
        double d19;
        double d21;
        double d22;
        double d23;
        double d24;
        Location location2 = location;
        Pvt.Builder.aPvt();
        Pvt build = Pvt.Builder.aPvt().withAccuracy(location.getAccuracy()).withAltitude(location.getAltitude()).withLatitude(location.getLatitude()).withBearing(location.getBearing()).withLongitude(location.getLongitude()).withSpeed(location.getSpeed()).withTime(location.getTime()).build();
        int i12 = 0;
        if (!CollectionsUtils.isEmpty((Collection<?>) gnssMeasurementsEvent.getMeasurements()) && gnssMeasurementsEvent.getClock() != null) {
            GnssClock.Builder aGnssClock = GnssClock.Builder.aGnssClock();
            if (gnssMeasurementsEvent.getClock().hasBiasNanos()) {
                d11 = gnssMeasurementsEvent.getClock().getBiasNanos();
            } else {
                d11 = 0.0d;
            }
            GnssClock.Builder withBiasNanos = aGnssClock.withBiasNanos(d11);
            if (gnssMeasurementsEvent.getClock().hasBiasUncertaintyNanos()) {
                d12 = gnssMeasurementsEvent.getClock().getBiasUncertaintyNanos();
            } else {
                d12 = 0.0d;
            }
            GnssClock.Builder withBiasUncertaintyNanos = withBiasNanos.withBiasUncertaintyNanos(d12);
            if (gnssMeasurementsEvent.getClock().hasDriftNanosPerSecond()) {
                d13 = gnssMeasurementsEvent.getClock().getDriftNanosPerSecond();
            } else {
                d13 = 0.0d;
            }
            GnssClock.Builder withDriftNanosPerSecond = withBiasUncertaintyNanos.withDriftNanosPerSecond(d13);
            if (gnssMeasurementsEvent.getClock().hasDriftUncertaintyNanosPerSecond()) {
                d14 = gnssMeasurementsEvent.getClock().getDriftUncertaintyNanosPerSecond();
            } else {
                d14 = 0.0d;
            }
            GnssClock.Builder withHardwareClockDiscontinuityCount = withDriftNanosPerSecond.withDriftUncertaintyNanosPerSecond(d14).withFullBiasNanos(gnssMeasurementsEvent.getClock().getFullBiasNanos()).withHardwareClockDiscontinuityCount(gnssMeasurementsEvent.getClock().getHardwareClockDiscontinuityCount());
            if (gnssMeasurementsEvent.getClock().hasLeapSecond()) {
                i11 = gnssMeasurementsEvent.getClock().getLeapSecond();
            } else {
                i11 = 0;
            }
            GnssClock.Builder withTimeNanos = withHardwareClockDiscontinuityCount.withLeapSecond(i11).withTimeNanos(gnssMeasurementsEvent.getClock().getTimeNanos());
            if (gnssMeasurementsEvent.getClock().hasTimeUncertaintyNanos()) {
                d15 = gnssMeasurementsEvent.getClock().getTimeUncertaintyNanos();
            } else {
                d15 = 0.0d;
            }
            GnssClock.Builder withTimeUncertaintyNanos = withTimeNanos.withTimeUncertaintyNanos(d15);
            if (Build.VERSION.SDK_INT >= 29) {
                j11 = gnssMeasurementsEvent.getClock().getElapsedRealtimeNanos();
            } else {
                j11 = 0;
            }
            GnssClock build2 = withTimeUncertaintyNanos.withElapsedRealtimeMillis(j11).build();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[gnssMeasurementsEvent.getMeasurements().size()];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                SatelliteMeasurement.Builder withAccumulatedDeltaRangeUncertaintyMeters = SatelliteMeasurement.Builder.aSatelliteMeasurement().withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters());
                if (gnssMeasurement.hasCarrierCycles()) {
                    j12 = gnssMeasurement.getCarrierCycles();
                } else {
                    j12 = 0;
                }
                SatelliteMeasurement.Builder withCarrierCycles = withAccumulatedDeltaRangeUncertaintyMeters.withCarrierCycles(j12);
                if (gnssMeasurement.hasCarrierFrequencyHz()) {
                    f11 = gnssMeasurement.getCarrierFrequencyHz();
                } else {
                    f11 = 0.0f;
                }
                SatelliteMeasurement.Builder withCarrierFrequencyHz = withCarrierCycles.withCarrierFrequencyHz(f11);
                if (gnssMeasurement.hasCarrierPhase()) {
                    d16 = gnssMeasurement.getCarrierPhase();
                } else {
                    d16 = 0.0d;
                }
                SatelliteMeasurement.Builder withCarrierPhase = withCarrierFrequencyHz.withCarrierPhase(d16);
                if (gnssMeasurement.hasCarrierPhaseUncertainty()) {
                    d17 = gnssMeasurement.getCarrierPhaseUncertainty();
                } else {
                    d17 = 0.0d;
                }
                SatelliteMeasurement.Builder withConstellationType = withCarrierPhase.withCarrierPhaseUncertainty(d17).withCn0DbHz(gnssMeasurement.getCn0DbHz()).withConstellationType(gnssMeasurement.getConstellationType());
                if (gnssMeasurement.hasSnrInDb()) {
                    d18 = gnssMeasurement.getSnrInDb();
                } else {
                    d18 = 0.0d;
                }
                SatelliteMeasurement.Builder withSvid = withConstellationType.withSnrInDb(d18).withMultipathIndicator(gnssMeasurement.getMultipathIndicator()).withTimeOffsetNanos(gnssMeasurement.getTimeOffsetNanos()).withPseudorangeRateMetersPerSecond(gnssMeasurement.getPseudorangeRateMetersPerSecond()).withPseudorangeRateUncertaintyMetersPerSecond(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()).withReceivedSvTimeNanos(gnssMeasurement.getReceivedSvTimeNanos()).withReceivedSvTimeUncertaintyNanos(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()).withState(gnssMeasurement.getState()).withSvid(gnssMeasurement.getSvid());
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 26) {
                    if (gnssMeasurement.hasAutomaticGainControlLevelDb()) {
                        d24 = gnssMeasurement.getAutomaticGainControlLevelDb();
                    } else {
                        d24 = 0.0d;
                    }
                    withSvid.withAutomaticGainControlLevelInDb(d24);
                } else {
                    withSvid.withAutomaticGainControlLevelInDb(0.0d);
                }
                if (i13 >= 30) {
                    if (gnssMeasurement.hasFullInterSignalBiasNanos()) {
                        d19 = gnssMeasurement.getFullInterSignalBiasNanos();
                    } else {
                        d19 = 0.0d;
                    }
                    withSvid.withFullInterSignalBiasNanos(d19);
                    if (gnssMeasurement.hasFullInterSignalBiasUncertaintyNanos()) {
                        d21 = gnssMeasurement.getFullInterSignalBiasUncertaintyNanos();
                    } else {
                        d21 = 0.0d;
                    }
                    withSvid.withFullInterSignalBiasUncertaintyNanos(d21);
                    if (gnssMeasurement.hasSatelliteInterSignalBiasNanos()) {
                        d22 = gnssMeasurement.getSatelliteInterSignalBiasNanos();
                    } else {
                        d22 = 0.0d;
                    }
                    withSvid.withSatelliteInterSignalBiasNanos(d22);
                    if (gnssMeasurement.hasSatelliteInterSignalBiasUncertaintyNanos()) {
                        d23 = gnssMeasurement.getSatelliteInterSignalBiasUncertaintyNanos();
                    } else {
                        d23 = 0.0d;
                    }
                    withSvid.withSatelliteInterSignalBiasUncertaintyNanos(d23);
                } else {
                    withSvid.withFullInterSignalBiasNanos(0.0d);
                    withSvid.withFullInterSignalBiasUncertaintyNanos(0.0d);
                    withSvid.withSatelliteInterSignalBiasNanos(0.0d);
                    withSvid.withSatelliteInterSignalBiasUncertaintyNanos(0.0d);
                }
                gnssRawObservationArr2[i12] = GnssRawObservation.Builder.aGnssRawObservation().withSatelliteMeasurement(withSvid.build()).withGnssClock(build2).build();
                i12++;
            }
            gnssRawObservationArr = gnssRawObservationArr2;
        } else {
            gnssRawObservationArr = new GnssRawObservation[0];
        }
        if (!CollectionsUtil.isEmpty((Object[]) gnssRawObservationArr) && gnssRawObservationArr.length >= 10) {
            Pvt process = this.f50218ut.process(build, gnssRawObservationArr);
            if (process.getErrCode() != 0) {
                this.Yx = Boolean.FALSE;
                LogConsole.i("Sdm", "pvt handle error,errorCode is :" + process.getErrCode());
                return location2;
            }
            this.Yx = Boolean.TRUE;
            location2.setLongitude(process.getLongitude());
            location2.setLatitude(process.getLatitude());
            location2.setAccuracy(process.getAccuracy());
            location2.setBearing(process.getBearing());
            location2.setAltitude(process.getAltitude());
            location2.setSpeed(process.getSpeed());
            Bundle extras = location.getExtras();
            SafeBundle safeBundle = new SafeBundle(extras);
            if (safeBundle.containsKey("LocationSource")) {
                safeBundle.putInt("LocationSource", extras.getInt("LocationSource") | 1);
            } else {
                safeBundle.putInt("LocationSource", 1);
            }
            location2.setExtras(safeBundle.getBundle());
            LogConsole.i("Sdm", "processLocation success here, the location has been deflected");
        }
        return location2;
    }

    private void yn() {
        Config config = new Config();
        this.f50217oc = config;
        if (!config.a()) {
            this.f50217oc = null;
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public void remove(yn ynVar) {
        HandlerThread handlerThread;
        if (ynVar == null) {
            LogConsole.w("Sdm", "no has listener");
            return;
        }
        if (!(this.FB == null || (handlerThread = this.f50215d2) == null || !handlerThread.isAlive())) {
            FB fb2 = this.FB;
            int i11 = FB.f50221yn;
            fb2.obtainMessage(2, ynVar).sendToTarget();
        }
        this.E5.quitSafely();
        this.E5 = null;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION"})
    public void request(yn ynVar) {
        HandlerThread handlerThread;
        if (ynVar == null) {
            LogConsole.w("Sdm", "no has listener");
        } else if (this.LW == null) {
            if (this.OB == null) {
                this.OB = new com.huawei.location.tiles.callback.yn(this.f50217oc.b(), this.f50217oc.c());
            }
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                this.Vw = (LocationManager) systemService;
            }
            if (this.SI == null) {
                this.SI = new com.huawei.location.ephemeris.yn();
            }
            if (this.Wf == null) {
                this.Wf = new com.huawei.location.support.yn();
            }
            if (this.EF == null) {
                this.EF = new com.huawei.location.sdm.utils.yn();
            }
            if (this.Ot == null) {
                DeviceInfo.Builder aDeviceInfo = DeviceInfo.Builder.aDeviceInfo();
                aDeviceInfo.withChipName(com.huawei.location.sdm.constant.yn.Vw(SystemPropertiesUtil.getPlatform()));
                aDeviceInfo.withManufacturer(Build.MANUFACTURER);
                aDeviceInfo.withSdkLevel(Build.VERSION.SDK_INT);
                this.Ot = aDeviceInfo.build();
            }
            this.EF.yn();
            HandlerThread handlerThread2 = this.E5;
            if (handlerThread2 == null || !handlerThread2.isAlive()) {
                HandlerThread handlerThread3 = new HandlerThread("Location-SDM-SUPPORT");
                this.E5 = handlerThread3;
                handlerThread3.start();
            }
            this.Wf.yn(this.E5.getLooper(), this.SI, this.f50217oc);
            if (this.FB == null || (handlerThread = this.f50215d2) == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread4 = new HandlerThread("Sdm");
                this.f50215d2 = handlerThread4;
                handlerThread4.start();
                this.FB = new FB(this.f50215d2.getLooper());
            }
            this.FB.obtainMessage(4, ynVar).sendToTarget();
        }
    }

    public boolean support(long j11, float f11) {
        boolean z11 = false;
        if (this.f50217oc == null) {
            LogConsole.w("Sdm", "no config");
            return false;
        } else if (j11 > 10000 || f11 > 10.0f) {
            LogConsole.i("Sdm", "not support sdm, minTime:" + j11 + ",minDistance:" + f11);
            return false;
        } else {
            String yn2 = com.huawei.location.sdm.constant.yn.yn(SystemPropertiesUtil.getPlatform());
            boolean z12 = !"".equals(yn2) && this.f50217oc.d(yn2, com.huawei.location.sdm.constant.Vw.yn(Build.VERSION.SDK_INT));
            if (ROMUtil.getHuaweiPlatformROMType() != 3) {
                z11 = z12;
            }
            LogConsole.i("Sdm", "SDM support:" + z11 + ",The phone ChipType:" + yn2 + ",The phone OsVersion:" + com.huawei.location.sdm.constant.Vw.yn(Build.VERSION.SDK_INT));
            return z11;
        }
    }
}
