package com.instabug.library.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.exoplayer2.ExoPlayer;

public class r implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final SensorManager f52083a;

    /* renamed from: b  reason: collision with root package name */
    private final Sensor f52084b;

    /* renamed from: c  reason: collision with root package name */
    private long f52085c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f52086d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f52087e;

    /* renamed from: f  reason: collision with root package name */
    private float f52088f;

    /* renamed from: g  reason: collision with root package name */
    private float f52089g;

    /* renamed from: h  reason: collision with root package name */
    private q f52090h;

    /* renamed from: i  reason: collision with root package name */
    private int f52091i = 650;

    public r(Context context, q qVar) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f52083a = sensorManager;
        this.f52084b = sensorManager.getDefaultSensor(1);
        this.f52090h = qVar;
    }

    public void a() {
        this.f52086d = System.currentTimeMillis();
        this.f52083a.registerListener(this, this.f52084b, 3);
    }

    public void b() {
        this.f52083a.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            long currentTimeMillis = System.currentTimeMillis();
            long j11 = currentTimeMillis - this.f52085c;
            if (j11 > 400) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                float abs = (Math.abs(((((f11 + f12) + f13) - this.f52087e) - this.f52088f) - this.f52089g) / ((float) j11)) * 10000.0f;
                if (currentTimeMillis - this.f52086d > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (abs <= ((float) this.f52091i)) {
                    z13 = false;
                }
                if (z13 && z12) {
                    InstabugSDKLogger.d("IBG-Core", "shake detected, invoking shakeDetectedListener");
                    this.f52090h.a();
                }
                this.f52085c = currentTimeMillis;
                this.f52087e = f11;
                this.f52088f = f12;
                this.f52089g = f13;
            }
        }
    }

    public void a(int i11) {
        this.f52091i = i11;
    }
}
