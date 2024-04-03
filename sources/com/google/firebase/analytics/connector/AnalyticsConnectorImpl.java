package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zziq;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import io.flutter.plugins.firebase.crashlytics.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    @VisibleForTesting
    final AppMeasurementSdk zza;
    @VisibleForTesting
    final Map zzb = new ConcurrentHashMap();

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static /* synthetic */ void zza(Event event) {
        boolean z11 = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzc)).zza.zza(z11);
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzc(@NonNull String str) {
        return !str.isEmpty() && this.zzb.containsKey(str) && this.zzb.get(str) != null;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle next : this.zza.getConditionalUserProperties(str, str2)) {
            int i11 = zzc.zza;
            Preconditions.checkNotNull(next);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            Class<String> cls = String.class;
            conditionalUserProperty.origin = (String) Preconditions.checkNotNull((String) zzgz.zza(next, "origin", cls, (Object) null));
            conditionalUserProperty.f47318name = (String) Preconditions.checkNotNull((String) zzgz.zza(next, "name", cls, (Object) null));
            conditionalUserProperty.value = zzgz.zza(next, "value", Object.class, (Object) null);
            conditionalUserProperty.triggerEventName = (String) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls, (Object) null);
            Class<Long> cls2 = Long.class;
            conditionalUserProperty.triggerTimeout = ((Long) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls2, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls, (Object) null);
            Class<Bundle> cls3 = Bundle.class;
            conditionalUserProperty.timedOutEventParams = (Bundle) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, cls3, (Object) null);
            conditionalUserProperty.triggeredEventName = (String) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls, (Object) null);
            conditionalUserProperty.triggeredEventParams = (Bundle) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, cls3, (Object) null);
            conditionalUserProperty.timeToLive = ((Long) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls2, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls, (Object) null);
            conditionalUserProperty.expiredEventParams = (Bundle) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, cls3, (Object) null);
            conditionalUserProperty.active = ((Boolean) zzgz.zza(next, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, cls2, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) zzgz.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, cls2, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zza.getMaxUserProperties(str);
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z11) {
        return this.zza.getUserProperties((String) null, (String) null, z11);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzd(str) && zzc.zzb(str2, bundle) && zzc.zza(str, str2, bundle)) {
            if ("clx".equals(str) && Constants.FIREBASE_APPLICATION_EXCEPTION.equals(str2)) {
                bundle.putLong("_r", 1);
            }
            this.zza.logEvent(str, str2, bundle);
        }
    }

    @WorkerThread
    @NonNull
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull final String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzd(str) || zzc(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if ("fiam".equals(str)) {
            obj = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if ("clx".equals(str)) {
            obj = new zzg(appMeasurementSdk, analyticsConnectorListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.zzb.put(str, obj);
        return new AnalyticsConnector.AnalyticsConnectorHandle() {
            @KeepForSdk
            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals("fiam") && set != null && !set.isEmpty()) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzb(set);
                }
            }

            public final void unregister() {
                if (AnalyticsConnectorImpl.this.zzc(str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zza2 = ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zza();
                    if (zza2 != null) {
                        zza2.onMessageTriggered(0, (Bundle) null);
                    }
                    AnalyticsConnectorImpl.this.zzb.remove(str);
                }
            }

            @KeepForSdk
            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals("fiam")) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzc();
                }
            }
        };
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i11 = zzc.zza;
        if (conditionalUserProperty != null && (str = conditionalUserProperty.origin) != null && !str.isEmpty()) {
            Object obj = conditionalUserProperty.value;
            if ((obj == null || zziq.zza(obj) != null) && zzc.zzd(str) && zzc.zze(str, conditionalUserProperty.f47318name)) {
                String str2 = conditionalUserProperty.expiredEventName;
                if (str2 == null || (zzc.zzb(str2, conditionalUserProperty.expiredEventParams) && zzc.zza(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                    String str3 = conditionalUserProperty.triggeredEventName;
                    if (str3 == null || (zzc.zzb(str3, conditionalUserProperty.triggeredEventParams) && zzc.zza(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                        String str4 = conditionalUserProperty.timedOutEventName;
                        if (str4 == null || (zzc.zzb(str4, conditionalUserProperty.timedOutEventParams) && zzc.zza(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                            AppMeasurementSdk appMeasurementSdk = this.zza;
                            Bundle bundle = new Bundle();
                            String str5 = conditionalUserProperty.origin;
                            if (str5 != null) {
                                bundle.putString("origin", str5);
                            }
                            String str6 = conditionalUserProperty.f47318name;
                            if (str6 != null) {
                                bundle.putString("name", str6);
                            }
                            Object obj2 = conditionalUserProperty.value;
                            if (obj2 != null) {
                                zzgz.zzb(bundle, obj2);
                            }
                            String str7 = conditionalUserProperty.triggerEventName;
                            if (str7 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str7);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.triggerTimeout);
                            String str8 = conditionalUserProperty.timedOutEventName;
                            if (str8 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str8);
                            }
                            Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
                            if (bundle2 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
                            }
                            String str9 = conditionalUserProperty.triggeredEventName;
                            if (str9 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str9);
                            }
                            Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
                            if (bundle3 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.timeToLive);
                            String str10 = conditionalUserProperty.expiredEventName;
                            if (str10 != null) {
                                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str10);
                            }
                            Bundle bundle4 = conditionalUserProperty.expiredEventParams;
                            if (bundle4 != null) {
                                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
                            }
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.creationTimestamp);
                            bundle.putBoolean("active", conditionalUserProperty.active);
                            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.triggeredTimestamp);
                            appMeasurementSdk.setConditionalUserProperty(bundle);
                        }
                    }
                }
            }
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (zzc.zzd(str) && zzc.zze(str, str2)) {
            this.zza.setUserProperty(str, str2, obj);
        }
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @KeepForSdk
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp, @NonNull Context context, @NonNull Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzef.zzg(context, (String) null, (String) null, (String) null, bundle).zzd());
                }
            }
        }
        return zzc;
    }
}
