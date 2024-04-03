package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzecc implements SensorEventListener {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzecb zzf;
    @GuardedBy("this")
    private boolean zzg;

    public zzecc(Context context) {
        this.zza = context;
    }

    public final void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgE)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0] / 9.80665f;
            float f12 = fArr[1] / 9.80665f;
            float f13 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((double) ((f11 * f11) + (f12 * f12) + (f13 * f13)))) >= ((Float) zzbgq.zzc().zzb(zzblj.zzgF)).floatValue()) {
                long currentTimeMillis = zzt.zzA().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzgG)).intValue()) <= currentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzgH)).intValue()) < currentTimeMillis) {
                        this.zze = 0;
                    }
                    zze.zza("Shake detected.");
                    this.zzd = currentTimeMillis;
                    int i11 = this.zze + 1;
                    this.zze = i11;
                    zzecb zzecb = this.zzf;
                    if (zzecb != null) {
                        if (i11 == ((Integer) zzbgq.zzc().zzb(zzblj.zzgI)).intValue()) {
                            zzebt zzebt = (zzebt) zzecb;
                            zzebt.zzg(new zzebq(zzebt), zzebs.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zza() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzgE     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x006a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x0015:
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006a }
            r1 = 1
            if (r0 != 0) goto L_0x0035
            android.content.Context r0 = r6.zza     // Catch:{ all -> 0x006a }
            java.lang.String r2 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x006a }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x006a }
            r6.zzb = r0     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = "Shake detection failed to initialize. Failed to obtain accelerometer."
            com.google.android.gms.internal.ads.zzciz.zzj(r0)     // Catch:{ all -> 0x006a }
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x002f:
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x006a }
            r6.zzc = r0     // Catch:{ all -> 0x006a }
        L_0x0035:
            boolean r0 = r6.zzg     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0068
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0068
            android.hardware.Sensor r2 = r6.zzc     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0068
            r3 = 2
            r0.registerListener(r6, r2, r3)     // Catch:{ all -> 0x006a }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ all -> 0x006a }
            long r2 = r0.currentTimeMillis()     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzblj.zzgG     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzblh r4 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r4.zzb(r0)     // Catch:{ all -> 0x006a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006a }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006a }
            long r4 = (long) r0     // Catch:{ all -> 0x006a }
            long r2 = r2 - r4
            r6.zzd = r2     // Catch:{ all -> 0x006a }
            r6.zzg = r1     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "Listening for shake gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzecc.zzb():void");
    }

    public final void zzc(zzecb zzecb) {
        this.zzf = zzecb;
    }
}
