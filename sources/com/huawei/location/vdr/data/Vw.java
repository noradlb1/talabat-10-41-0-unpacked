package com.huawei.location.vdr.data;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput;
import com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Vw {

    /* renamed from: a  reason: collision with root package name */
    public NavigableMap<Long, SensorAccInput> f50277a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    public NavigableMap<Long, SensorGyroInput> f50278b = new TreeMap();

    /* renamed from: c  reason: collision with root package name */
    public NavigableMap<Long, SensorGyroUncalInput> f50279c = new TreeMap();

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f50280d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f50281e;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f50282f;

    /* renamed from: yn  reason: collision with root package name */
    private final Object f50283yn = new Object();

    /* renamed from: zp  reason: collision with root package name */
    private SensorEventListener f50284zp = new yn();

    public class yn implements SensorEventListener {
        public yn() {
        }

        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            Vw.this.yn(sensorEvent);
        }
    }

    public Vw() {
        yn();
    }

    private void yn() {
        HandlerThread handlerThread = new HandlerThread("Loc-Vdr-sensor");
        this.f50280d = handlerThread;
        handlerThread.start();
        this.f50281e = new Handler(this.f50280d.getLooper());
        Object systemService = ContextUtil.getContext().getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f50282f = sensorManager;
            sensorManager.registerListener(this.f50284zp, sensorManager.getDefaultSensor(1), 10000, this.f50281e);
            SensorManager sensorManager2 = this.f50282f;
            sensorManager2.registerListener(this.f50284zp, sensorManager2.getDefaultSensor(4), 10000, this.f50281e);
            SensorManager sensorManager3 = this.f50282f;
            sensorManager3.registerListener(this.f50284zp, sensorManager3.getDefaultSensor(16), 10000, this.f50281e);
        }
        LogConsole.i("SensorProvider", "RegisterSensor success.");
    }

    public void Vw() {
        SensorManager sensorManager = this.f50282f;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f50284zp);
        }
        HandlerThread handlerThread = this.f50280d;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.f50281e = null;
    }

    public MotionSensors yn(long j11, long j12) {
        boolean z11;
        synchronized (this.f50283yn) {
            if (!this.f50277a.isEmpty() || !this.f50278b.isEmpty() || !this.f50279c.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                LogConsole.i("SensorProvider", "sensor info is not ready!");
                return null;
            } else if (j11 > j12) {
                LogConsole.e("SensorProvider", "TimeStamp input illegal.");
                return null;
            } else {
                SensorAccInput[] sensorAccInputArr = (SensorAccInput[]) this.f50277a.subMap(Long.valueOf(j11), false, Long.valueOf(j12), true).values().toArray(new SensorAccInput[0]);
                SensorGyroInput[] sensorGyroInputArr = (SensorGyroInput[]) this.f50278b.subMap(Long.valueOf(j11), false, Long.valueOf(j12), true).values().toArray(new SensorGyroInput[0]);
                SensorGyroUncalInput[] sensorGyroUncalInputArr = (SensorGyroUncalInput[]) this.f50279c.subMap(Long.valueOf(j11), false, Long.valueOf(j12), true).values().toArray(new SensorGyroUncalInput[0]);
                LogConsole.i("SensorProvider", "vdr sensor info acc: " + sensorAccInputArr.length + ", gyro: " + sensorGyroInputArr.length + ", uncal: " + sensorGyroUncalInputArr.length);
                MotionSensors build = MotionSensors.Builder.aSensor().withAccInputs(sensorAccInputArr).withGyroInputs(sensorGyroInputArr).withGyroUncalInputs(sensorGyroUncalInputArr).build();
                return build;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0109, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void yn(android.hardware.SensorEvent r14) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f50283yn
            monitor-enter(r0)
            android.hardware.Sensor r1 = r14.sensor     // Catch:{ all -> 0x010a }
            int r1 = r1.getType()     // Catch:{ all -> 0x010a }
            float[] r14 = r14.values     // Catch:{ all -> 0x010a }
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ all -> 0x010a }
            r4 = 2
            r5 = 0
            r6 = 1000(0x3e8, float:1.401E-42)
            r7 = 3
            r8 = 1
            if (r1 == r8) goto L_0x00c3
            r9 = 4
            if (r1 == r9) goto L_0x007f
            r10 = 16
            if (r1 == r10) goto L_0x0020
            goto L_0x0108
        L_0x0020:
            int r1 = r14.length     // Catch:{ all -> 0x010a }
            r10 = 6
            if (r1 >= r10) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x010a }
            return
        L_0x0026:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput> r1 = r13.f50279c     // Catch:{ all -> 0x010a }
            int r1 = r1.size()     // Catch:{ all -> 0x010a }
            if (r1 <= r6) goto L_0x0037
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput> r1 = r13.f50279c     // Catch:{ all -> 0x010a }
            java.lang.Object r6 = r1.firstKey()     // Catch:{ all -> 0x010a }
            r1.remove(r6)     // Catch:{ all -> 0x010a }
        L_0x0037:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput> r1 = r13.f50279c     // Catch:{ all -> 0x010a }
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r10 = com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput.Builder.aSensorGyroUncalInput()     // Catch:{ all -> 0x010a }
            r5 = r14[r5]     // Catch:{ all -> 0x010a }
            double r11 = (double) r5     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r5 = r10.withUgx(r11)     // Catch:{ all -> 0x010a }
            r8 = r14[r8]     // Catch:{ all -> 0x010a }
            double r10 = (double) r8     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r5 = r5.withUgy(r10)     // Catch:{ all -> 0x010a }
            r4 = r14[r4]     // Catch:{ all -> 0x010a }
            double r10 = (double) r4     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r4 = r5.withUgz(r10)     // Catch:{ all -> 0x010a }
            r5 = r14[r7]     // Catch:{ all -> 0x010a }
            double r7 = (double) r5     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r4 = r4.withBiasx(r7)     // Catch:{ all -> 0x010a }
            r5 = r14[r9]     // Catch:{ all -> 0x010a }
            double r7 = (double) r5     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r4 = r4.withBiasy(r7)     // Catch:{ all -> 0x010a }
            r5 = 5
            r14 = r14[r5]     // Catch:{ all -> 0x010a }
            double r7 = (double) r14     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r14 = r4.withBiasz(r7)     // Catch:{ all -> 0x010a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x010a }
            long r2 = r4.toMillis(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput$Builder r14 = r14.withBt(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroUncalInput r14 = r14.build()     // Catch:{ all -> 0x010a }
        L_0x007a:
            r1.put(r6, r14)     // Catch:{ all -> 0x010a }
            goto L_0x0108
        L_0x007f:
            int r1 = r14.length     // Catch:{ all -> 0x010a }
            if (r1 >= r7) goto L_0x0084
            monitor-exit(r0)     // Catch:{ all -> 0x010a }
            return
        L_0x0084:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput> r1 = r13.f50278b     // Catch:{ all -> 0x010a }
            int r1 = r1.size()     // Catch:{ all -> 0x010a }
            if (r1 <= r6) goto L_0x0095
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput> r1 = r13.f50278b     // Catch:{ all -> 0x010a }
            java.lang.Object r6 = r1.firstKey()     // Catch:{ all -> 0x010a }
            r1.remove(r6)     // Catch:{ all -> 0x010a }
        L_0x0095:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput> r1 = r13.f50278b     // Catch:{ all -> 0x010a }
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput$Builder r7 = com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput.Builder.aSensorGyroInput()     // Catch:{ all -> 0x010a }
            r5 = r14[r5]     // Catch:{ all -> 0x010a }
            double r9 = (double) r5     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput$Builder r5 = r7.withGx(r9)     // Catch:{ all -> 0x010a }
            r7 = r14[r8]     // Catch:{ all -> 0x010a }
            double r7 = (double) r7     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput$Builder r5 = r5.withGy(r7)     // Catch:{ all -> 0x010a }
            r14 = r14[r4]     // Catch:{ all -> 0x010a }
            double r7 = (double) r14     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput$Builder r14 = r5.withGz(r7)     // Catch:{ all -> 0x010a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x010a }
            long r2 = r4.toMillis(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput$Builder r14 = r14.withBootTime(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorGyroInput r14 = r14.build()     // Catch:{ all -> 0x010a }
            goto L_0x007a
        L_0x00c3:
            int r1 = r14.length     // Catch:{ all -> 0x010a }
            if (r1 >= r7) goto L_0x00c8
            monitor-exit(r0)     // Catch:{ all -> 0x010a }
            return
        L_0x00c8:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput> r1 = r13.f50277a     // Catch:{ all -> 0x010a }
            int r1 = r1.size()     // Catch:{ all -> 0x010a }
            if (r1 <= r6) goto L_0x00d9
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput> r1 = r13.f50277a     // Catch:{ all -> 0x010a }
            java.lang.Object r6 = r1.firstKey()     // Catch:{ all -> 0x010a }
            r1.remove(r6)     // Catch:{ all -> 0x010a }
        L_0x00d9:
            java.util.NavigableMap<java.lang.Long, com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput> r1 = r13.f50277a     // Catch:{ all -> 0x010a }
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput$Builder r7 = com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput.Builder.aSensorAccInput()     // Catch:{ all -> 0x010a }
            r5 = r14[r5]     // Catch:{ all -> 0x010a }
            double r9 = (double) r5     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput$Builder r5 = r7.withAx(r9)     // Catch:{ all -> 0x010a }
            r7 = r14[r8]     // Catch:{ all -> 0x010a }
            double r7 = (double) r7     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput$Builder r5 = r5.withAy(r7)     // Catch:{ all -> 0x010a }
            r14 = r14[r4]     // Catch:{ all -> 0x010a }
            double r7 = (double) r14     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput$Builder r14 = r5.withAz(r7)     // Catch:{ all -> 0x010a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x010a }
            long r2 = r4.toMillis(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput$Builder r14 = r14.withBootTime(r2)     // Catch:{ all -> 0x010a }
            com.huawei.riemann.gnsslocation.core.bean.sensor.SensorAccInput r14 = r14.build()     // Catch:{ all -> 0x010a }
            goto L_0x007a
        L_0x0108:
            monitor-exit(r0)     // Catch:{ all -> 0x010a }
            return
        L_0x010a:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x010a }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.Vw.yn(android.hardware.SensorEvent):void");
    }
}
