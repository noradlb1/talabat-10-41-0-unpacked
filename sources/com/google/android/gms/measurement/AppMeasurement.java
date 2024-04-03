package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzil;
import com.google.android.gms.measurement.internal.zziq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
@Deprecated
public class AppMeasurement {
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zzd zzb;

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzhf {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j11);
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzhg {
        @WorkerThread
        @ShowFirstParty
        @KeepForSdk
        void onEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j11);
    }

    public AppMeasurement(zzgd zzgd) {
        this.zzb = new zza(zzgd);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @com.google.android.gms.common.internal.ShowFirstParty
    @androidx.annotation.Keep
    @androidx.annotation.RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(@androidx.annotation.NonNull android.content.Context r14) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = zza
            if (r0 != 0) goto L_0x0059
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r0)
            com.google.android.gms.measurement.AppMeasurement r1 = zza     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0054
            r1 = 0
            java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r2 = com.google.firebase.analytics.FirebaseAnalytics.class
            java.lang.String r3 = "getScionFrontendApiImplementation"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{  }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch:{  }
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            r8 = 1
            r5[r8] = r6     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{  }
            r3[r7] = r14     // Catch:{  }
            r3[r8] = r1     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r1, r3)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzil r2 = (com.google.android.gms.measurement.internal.zzil) r2     // Catch:{  }
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.AppMeasurement r14 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0056 }
            r14.<init>((com.google.android.gms.measurement.internal.zzil) r2)     // Catch:{ all -> 0x0056 }
            zza = r14     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x0039:
            com.google.android.gms.internal.measurement.zzcl r13 = new com.google.android.gms.internal.measurement.zzcl     // Catch:{ all -> 0x0056 }
            r3 = 0
            r5 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r13
            r2.<init>(r3, r5, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzgd r14 = com.google.android.gms.measurement.internal.zzgd.zzp(r14, r13, r1)     // Catch:{ all -> 0x0056 }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0056 }
            r1.<init>((com.google.android.gms.measurement.internal.zzgd) r14)     // Catch:{ all -> 0x0056 }
            zza = r1     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r14
        L_0x0059:
            com.google.android.gms.measurement.AppMeasurement r14 = zza
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzb.zzp(str);
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.zzb.zzq(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzb.zzr(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzb.zzb();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.zzb.zzh();
    }

    @NonNull
    @KeepForSdk
    public Boolean getBoolean() {
        return this.zzb.zzc();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @NonNull
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        int i11;
        List<Bundle> zzm = this.zzb.zzm(str, str2);
        if (zzm == null) {
            i11 = 0;
        } else {
            i11 = zzm.size();
        }
        ArrayList arrayList = new ArrayList(i11);
        for (Bundle conditionalUserProperty : zzm) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.zzb.zzj();
    }

    @NonNull
    @KeepForSdk
    public Double getDouble() {
        return this.zzb.zzd();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    @NonNull
    @KeepForSdk
    public Integer getInteger() {
        return this.zzb.zze();
    }

    @NonNull
    @KeepForSdk
    public Long getLong() {
        return this.zzb.zzf();
    }

    @WorkerThread
    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzb.zza(str);
    }

    @NonNull
    @KeepForSdk
    public String getString() {
        return this.zzb.zzl();
    }

    @WorkerThread
    @Keep
    @VisibleForTesting
    @NonNull
    public Map<String, Object> getUserProperties(@NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, boolean z11) {
        return this.zzb.zzo(str, str2, z11);
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.zzb.zzs(str, str2, bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j11) {
        this.zzb.zzt(str, str2, bundle, j11);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zzb.zzu(onEventListener);
    }

    @ShowFirstParty
    @KeepForSdk
    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzd zzd = this.zzb;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzgz.zzb(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        zzd.zzv(bundle);
    }

    @WorkerThread
    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.zzb.zzw(eventInterceptor);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zzb.zzx(onEventListener);
    }

    public AppMeasurement(zzil zzil) {
        this.zzb = new zzb(zzil);
    }

    @WorkerThread
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z11) {
        return this.zzb.zzn(z11);
    }

    @ShowFirstParty
    @KeepForSdk
    public static class ConditionalUserProperty {
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public boolean mActive;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mAppId;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mCreationTimestamp;
        @NonNull
        @Keep
        public String mExpiredEventName;
        @NonNull
        @Keep
        public Bundle mExpiredEventParams;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mName;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mOrigin;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTimeToLive;
        @NonNull
        @Keep
        public String mTimedOutEventName;
        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public String mTriggerEventName;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggerTimeout;
        @NonNull
        @Keep
        public String mTriggeredEventName;
        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @ShowFirstParty
        @KeepForSdk
        @Keep
        public long mTriggeredTimestamp;
        @ShowFirstParty
        @Keep
        @NonNull
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        @VisibleForTesting
        public ConditionalUserProperty(@NonNull Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            Class<String> cls = String.class;
            this.mAppId = (String) zzgz.zza(bundle, "app_id", cls, (Object) null);
            this.mOrigin = (String) zzgz.zza(bundle, "origin", cls, (Object) null);
            this.mName = (String) zzgz.zza(bundle, "name", cls, (Object) null);
            this.mValue = zzgz.zza(bundle, "value", Object.class, (Object) null);
            this.mTriggerEventName = (String) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls, (Object) null);
            Class<Long> cls2 = Long.class;
            this.mTriggerTimeout = ((Long) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls2, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls, (Object) null);
            Class<Bundle> cls3 = Bundle.class;
            this.mTimedOutEventParams = (Bundle) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, cls3, (Object) null);
            this.mTriggeredEventName = (String) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls, (Object) null);
            this.mTriggeredEventParams = (Bundle) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, cls3, (Object) null);
            this.mTimeToLive = ((Long) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls2, 0L)).longValue();
            this.mExpiredEventName = (String) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls, (Object) null);
            this.mExpiredEventParams = (Bundle) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, cls3, (Object) null);
            this.mActive = ((Boolean) zzgz.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, cls2, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, cls2, 0L)).longValue();
        }

        @KeepForSdk
        public ConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zza = zziq.zza(obj);
                this.mValue = zza;
                if (zza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }
}
