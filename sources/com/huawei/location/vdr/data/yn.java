package com.huawei.location.vdr.data;

import android.annotation.SuppressLint;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.facebook.AuthenticationTokenClaims;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.CollectionsUtils;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = 24)
public class yn {
    private final GnssMeasurementsEvent.Callback E5 = new C0092yn();
    private com.huawei.location.vdr.listener.yn LW;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f50289a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f50290b;

    /* renamed from: c  reason: collision with root package name */
    public LocationManager f50291c;
    private long dC;

    /* renamed from: com.huawei.location.vdr.data.yn$yn  reason: collision with other inner class name */
    public class C0092yn extends GnssMeasurementsEvent.Callback {
        public C0092yn() {
        }

        @RequiresApi(api = 29)
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            yn.a(yn.this, gnssMeasurementsEvent);
        }

        public void onStatusChanged(int i11) {
            LogConsole.i("GnssMeasurementsProvider", "GnssMeasurementsEvent onStatusChanged :" + i11);
            super.onStatusChanged(i11);
        }
    }

    public static void a(yn ynVar, GnssMeasurementsEvent gnssMeasurementsEvent) {
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
        yn ynVar2 = ynVar;
        ynVar.getClass();
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (elapsedRealtimeNanos - ynVar2.dC < AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED) {
            LogConsole.d("GnssMeasurementsProvider", "The interval does not meet requirements,dropping this gnssRaw");
            return;
        }
        ynVar2.dC = elapsedRealtimeNanos;
        long millis = TimeUnit.NANOSECONDS.toMillis(elapsedRealtimeNanos);
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
            GnssClock build = withTimeUncertaintyNanos.withElapsedRealtimeMillis(j11).build();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[gnssMeasurementsEvent.getMeasurements().size()];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                SatelliteMeasurement.Builder withAccumulatedDeltaRangeUncertaintyMeters = SatelliteMeasurement.Builder.aSatelliteMeasurement().withBootTime(millis).withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters());
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
                if (i13 < 26 || !gnssMeasurement.hasAutomaticGainControlLevelDb()) {
                    d19 = 0.0d;
                } else {
                    d19 = gnssMeasurement.getAutomaticGainControlLevelDb();
                }
                withSvid.withAutomaticGainControlLevelInDb(d19);
                if (i13 >= 30) {
                    if (gnssMeasurement.hasFullInterSignalBiasNanos()) {
                        d21 = gnssMeasurement.getFullInterSignalBiasNanos();
                    } else {
                        d21 = 0.0d;
                    }
                    withSvid.withFullInterSignalBiasNanos(d21);
                    if (gnssMeasurement.hasFullInterSignalBiasUncertaintyNanos()) {
                        d22 = gnssMeasurement.getFullInterSignalBiasUncertaintyNanos();
                    } else {
                        d22 = 0.0d;
                    }
                    withSvid.withFullInterSignalBiasUncertaintyNanos(d22);
                    if (gnssMeasurement.hasSatelliteInterSignalBiasNanos()) {
                        d23 = gnssMeasurement.getSatelliteInterSignalBiasNanos();
                    } else {
                        d23 = 0.0d;
                    }
                    withSvid.withSatelliteInterSignalBiasNanos(d23);
                    if (gnssMeasurement.hasSatelliteInterSignalBiasUncertaintyNanos()) {
                        d24 = gnssMeasurement.getSatelliteInterSignalBiasUncertaintyNanos();
                    } else {
                        d24 = 0.0d;
                    }
                    withSvid.withSatelliteInterSignalBiasUncertaintyNanos(d24);
                } else {
                    withSvid.withFullInterSignalBiasNanos(0.0d);
                    withSvid.withFullInterSignalBiasUncertaintyNanos(0.0d);
                    withSvid.withSatelliteInterSignalBiasNanos(0.0d);
                    withSvid.withSatelliteInterSignalBiasUncertaintyNanos(0.0d);
                }
                gnssRawObservationArr2[i12] = GnssRawObservation.Builder.aGnssRawObservation().withSatelliteMeasurement(withSvid.build()).withGnssClock(build).build();
                i12++;
            }
            gnssRawObservationArr = gnssRawObservationArr2;
        } else {
            gnssRawObservationArr = new GnssRawObservation[0];
        }
        if (((long) gnssRawObservationArr.length) < 10) {
            LogConsole.i("GnssMeasurementsProvider", "gnssRawObservations not enough, drop here. length is : " + gnssRawObservationArr.length);
            return;
        }
        com.huawei.location.vdr.listener.yn ynVar3 = ynVar2.LW;
        if (ynVar3 != null) {
            ((LW) ynVar3).Vw(gnssRawObservationArr, elapsedRealtimeNanos);
        } else {
            LogConsole.e("GnssMeasurementsProvider", "gnss listener is null!");
        }
    }

    public void Vw() {
        LocationManager locationManager = this.f50291c;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(this.E5);
        }
        this.LW = null;
        HandlerThread handlerThread = this.f50289a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.f50290b = null;
    }

    @SuppressLint({"MissingPermission"})
    public void yn() {
        boolean z11;
        HandlerThread handlerThread = new HandlerThread("Loc-Vdr-gnssMeasure");
        this.f50289a = handlerThread;
        handlerThread.start();
        this.f50290b = new Handler(this.f50289a.getLooper());
        try {
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                this.f50291c = (LocationManager) systemService;
                if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                    LogConsole.e("GnssMeasurementsProvider", "init fail because of checkSelfPermission fail");
                    return;
                }
                z11 = this.f50291c.registerGnssMeasurementsCallback(this.E5, this.f50290b);
            } else {
                z11 = false;
            }
            LogConsole.i("GnssMeasurementsProvider", "RegisterMeasurements:" + z11);
        } catch (Exception unused) {
            LogConsole.e("GnssMeasurementsProvider", "registerGnssMeasurements error.");
        }
    }

    public void yn(com.huawei.location.vdr.listener.yn ynVar) {
        this.LW = ynVar;
    }
}
