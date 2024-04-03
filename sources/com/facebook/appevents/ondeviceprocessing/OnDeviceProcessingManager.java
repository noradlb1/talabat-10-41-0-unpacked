package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s6.a;
import s6.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "()V", "ALLOWED_IMPLICIT_EVENTS", "", "", "isEventEligibleForOnDeviceProcessing", "", "event", "Lcom/facebook/appevents/AppEvent;", "isOnDeviceProcessingEnabled", "sendCustomEventAsync", "", "applicationId", "sendInstallEventAsync", "preferencesName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class OnDeviceProcessingManager {
    @NotNull
    private static final Set<String> ALLOWED_IMPLICIT_EVENTS = SetsKt__SetsKt.setOf(AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE);
    @NotNull
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();

    private OnDeviceProcessingManager() {
    }

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent) {
        boolean z11;
        if (!appEvent.isImplicit() || !ALLOWED_IMPLICIT_EVENTS.contains(appEvent.getName())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if ((!appEvent.isImplicit()) || z11) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isOnDeviceProcessingEnabled() {
        boolean z11;
        if (FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext()) || Utility.isDataProcessingRestricted()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || !RemoteServiceWrapper.isServiceAvailable()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void sendCustomEventAsync(@NotNull String str, @NotNull AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(appEvent, "event");
        if (INSTANCE.isEventEligibleForOnDeviceProcessing(appEvent)) {
            FacebookSdk.getExecutor().execute(new b(str, appEvent));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendCustomEventAsync$lambda-1  reason: not valid java name */
    public static final void m8926sendCustomEventAsync$lambda1(String str, AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        Intrinsics.checkNotNullParameter(appEvent, "$event");
        RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
        RemoteServiceWrapper.sendCustomEvents(str, CollectionsKt__CollectionsJVMKt.listOf(appEvent));
    }

    @JvmStatic
    public static final void sendInstallEventAsync(@Nullable String str, @Nullable String str2) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext != null && str != null && str2 != null) {
            FacebookSdk.getExecutor().execute(new a(applicationContext, str2, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendInstallEventAsync$lambda-0  reason: not valid java name */
    public static final void m8927sendInstallEventAsync$lambda0(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "$context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        String stringPlus = Intrinsics.stringPlus(str2, "pingForOnDevice");
        if (sharedPreferences.getLong(stringPlus, 0) == 0) {
            RemoteServiceWrapper.sendInstallEvent(str2);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(stringPlus, System.currentTimeMillis());
            edit.apply();
        }
    }
}
