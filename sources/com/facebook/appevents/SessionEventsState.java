package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bJ0\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u001bH\u0002R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/appevents/SessionEventsState;", "", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "accumulatedEventCount", "", "getAccumulatedEventCount", "()I", "accumulatedEvents", "", "Lcom/facebook/appevents/AppEvent;", "eventsToPersist", "", "getEventsToPersist", "()Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "accumulatePersistedEvents", "", "events", "addEvent", "event", "clearInFlightAndStats", "moveToAccumulated", "", "populateRequest", "request", "Lcom/facebook/GraphRequest;", "applicationContext", "Landroid/content/Context;", "includeImplicitEvents", "limitEventUsage", "numSkipped", "Lorg/json/JSONArray;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class SessionEventsState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private static final String TAG = SessionEventsState.class.getSimpleName();
    @NotNull
    private List<AppEvent> accumulatedEvents = new ArrayList();
    @NotNull
    private final String anonymousAppDeviceGUID;
    @NotNull
    private final AttributionIdentifiers attributionIdentifiers;
    @NotNull
    private final List<AppEvent> inFlightEvents = new ArrayList();
    private int numSkippedEventsDueToFullBuffer;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/SessionEventsState$Companion;", "", "()V", "MAX_ACCUMULATED_LOG_EVENTS", "", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionEventsState(@NotNull AttributionIdentifiers attributionIdentifiers2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(attributionIdentifiers2, "attributionIdentifiers");
        Intrinsics.checkNotNullParameter(str, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers2;
        this.anonymousAppDeviceGUID = str;
    }

    public final synchronized void accumulatePersistedEvents(@NotNull List<AppEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        this.accumulatedEvents.addAll(list);
    }

    public final synchronized void addEvent(@NotNull AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= MAX_ACCUMULATED_LOG_EVENTS) {
            this.numSkippedEventsDueToFullBuffer++;
        } else {
            this.accumulatedEvents.add(appEvent);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean z11) {
        if (z11) {
            this.accumulatedEvents.addAll(this.inFlightEvents);
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
    }

    public final synchronized int getAccumulatedEventCount() {
        return this.accumulatedEvents.size();
    }

    @NotNull
    public final synchronized List<AppEvent> getEventsToPersist() {
        List<AppEvent> list;
        list = this.accumulatedEvents;
        this.accumulatedEvents = new ArrayList();
        return list;
    }

    public final int populateRequest(@NotNull GraphRequest graphRequest, @NotNull Context context, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        synchronized (this) {
            int i11 = this.numSkippedEventsDueToFullBuffer;
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            EventDeactivationManager.processEvents(this.accumulatedEvents);
            this.inFlightEvents.addAll(this.accumulatedEvents);
            this.accumulatedEvents.clear();
            JSONArray jSONArray = new JSONArray();
            for (AppEvent next : this.inFlightEvents) {
                if (!next.isChecksumValid()) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, Intrinsics.stringPlus("Event with invalid checksum: ", next));
                } else if (z11 || !next.isImplicit()) {
                    jSONArray.put((Object) next.getJsonObject());
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            Unit unit = Unit.INSTANCE;
            populateRequest(graphRequest, context, i11, jSONArray, z12);
            return jSONArray.length();
        }
    }

    private final void populateRequest(GraphRequest graphRequest, Context context, int i11, JSONArray jSONArray, boolean z11) {
        JSONObject jSONObject;
        try {
            AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
            jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z11, context);
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                jSONObject.put("num_skipped_events", i11);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        graphRequest.setGraphObject(jSONObject);
        Bundle parameters = graphRequest.getParameters();
        String jSONArray2 = !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "events.toString()");
        parameters.putString("custom_events", jSONArray2);
        graphRequest.setTag(jSONArray2);
        graphRequest.setParameters(parameters);
    }
}
