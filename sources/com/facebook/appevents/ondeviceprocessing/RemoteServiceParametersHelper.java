package com.facebook.appevents.ondeviceprocessing;

import android.os.Bundle;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceParametersHelper;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "buildEventsBundle", "Landroid/os/Bundle;", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "buildEventsJson", "Lorg/json/JSONArray;", "includeImplicitEvents", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class RemoteServiceParametersHelper {
    @NotNull
    public static final RemoteServiceParametersHelper INSTANCE = new RemoteServiceParametersHelper();
    private static final String TAG = RemoteServiceWrapper.class.getSimpleName();

    private RemoteServiceParametersHelper() {
    }

    @JvmStatic
    @Nullable
    public static final Bundle buildEventsBundle(@NotNull RemoteServiceWrapper.EventType eventType, @NotNull String str, @NotNull List<AppEvent> list) {
        Intrinsics.checkNotNullParameter(eventType, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(list, "appEvents");
        Bundle bundle = new Bundle();
        bundle.putString("event", eventType.toString());
        bundle.putString("app_id", str);
        if (RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS == eventType) {
            JSONArray buildEventsJson = INSTANCE.buildEventsJson(list, str);
            if (buildEventsJson.length() == 0) {
                return null;
            }
            bundle.putString("custom_events", JSONArrayInstrumentation.toString(buildEventsJson));
        }
        return bundle;
    }

    private final JSONArray buildEventsJson(List<AppEvent> list, String str) {
        JSONArray jSONArray = new JSONArray();
        List<AppEvent> mutableList = CollectionsKt___CollectionsKt.toMutableList(list);
        EventDeactivationManager.processEvents(mutableList);
        boolean includeImplicitEvents = includeImplicitEvents(str);
        for (AppEvent appEvent : mutableList) {
            if (!appEvent.isChecksumValid()) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, Intrinsics.stringPlus("Event with invalid checksum: ", appEvent));
            } else if ((!appEvent.isImplicit()) || (appEvent.isImplicit() && includeImplicitEvents)) {
                jSONArray.put((Object) appEvent.getJsonObject());
            }
        }
        return jSONArray;
    }

    private final boolean includeImplicitEvents(String str) {
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
        if (queryAppSettings != null) {
            return queryAppSettings.supportsImplicitLogging();
        }
        return false;
    }
}
