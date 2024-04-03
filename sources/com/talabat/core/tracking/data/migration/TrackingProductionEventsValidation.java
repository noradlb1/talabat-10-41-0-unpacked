package com.talabat.core.tracking.data.migration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\rH\u0002J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0004J\b\u0010\"\u001a\u00020\rH\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/talabat/core/tracking/data/migration/TrackingProductionEventsValidation;", "", "remoteConfigResponse", "", "", "(Ljava/util/Map;)V", "events", "", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "logToNewRelic", "", "getLogToNewRelic", "()Z", "setLogToNewRelic", "(Z)V", "validateOnFirebase", "getValidateOnFirebase", "setValidateOnFirebase", "validateOnPerseus", "getValidateOnPerseus", "setValidateOnPerseus", "variationName", "getVariationName", "()Ljava/lang/String;", "setVariationName", "(Ljava/lang/String;)V", "isFlagEnabled", "shouldEventBeValidatedInProduction", "eventName", "shouldEventBeValidatedInProductionOnFirebase", "shouldEventBeValidatedInProductionOnPerseus", "validateAllEvents", "Companion", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingProductionEventsValidation {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private List<String> events;
    private boolean logToNewRelic;
    private boolean validateOnFirebase;
    private boolean validateOnPerseus;
    @NotNull
    private String variationName;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/core/tracking/data/migration/TrackingProductionEventsValidation$Companion;", "", "()V", "defaultRemoteConfig", "", "", "defaultRemoteConfigObject", "Lcom/talabat/core/tracking/data/migration/TrackingProductionEventsValidation;", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, Object> defaultRemoteConfig() {
            Boolean bool = Boolean.FALSE;
            return MapsKt__MapsKt.mapOf(TuplesKt.to("events", CollectionsKt__CollectionsKt.emptyList()), TuplesKt.to("logToNewRelic", bool), TuplesKt.to("variationName", "Default RC"), TuplesKt.to("validateOnPerseus", bool), TuplesKt.to("validateOnFirebase", bool));
        }

        @NotNull
        public final TrackingProductionEventsValidation defaultRemoteConfigObject() {
            return new TrackingProductionEventsValidation(defaultRemoteConfig());
        }
    }

    public TrackingProductionEventsValidation(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "remoteConfigResponse");
        Object obj = map.get("events");
        if (obj != null) {
            Iterable<Object> iterable = (List) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Object valueOf : iterable) {
                arrayList.add(String.valueOf(valueOf));
            }
            this.events = arrayList;
            Object obj2 = map.get("variationName");
            if (obj2 != null) {
                this.variationName = (String) obj2;
                Object obj3 = map.get("validateOnPerseus");
                if (obj3 != null) {
                    this.validateOnPerseus = ((Boolean) obj3).booleanValue();
                    Object obj4 = map.get("validateOnFirebase");
                    if (obj4 != null) {
                        this.validateOnFirebase = ((Boolean) obj4).booleanValue();
                        Object obj5 = map.get("logToNewRelic");
                        if (obj5 != null) {
                            this.logToNewRelic = ((Boolean) obj5).booleanValue();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    private final boolean isFlagEnabled() {
        return this.logToNewRelic || this.validateOnFirebase || this.validateOnPerseus;
    }

    private final boolean validateAllEvents() {
        return isFlagEnabled() && this.events.size() == 1 && Intrinsics.areEqual(CollectionsKt___CollectionsKt.first(this.events), (Object) "*");
    }

    @NotNull
    public final List<String> getEvents() {
        return this.events;
    }

    public final boolean getLogToNewRelic() {
        return this.logToNewRelic;
    }

    public final boolean getValidateOnFirebase() {
        return this.validateOnFirebase;
    }

    public final boolean getValidateOnPerseus() {
        return this.validateOnPerseus;
    }

    @NotNull
    public final String getVariationName() {
        return this.variationName;
    }

    public final void setEvents(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.events = list;
    }

    public final void setLogToNewRelic(boolean z11) {
        this.logToNewRelic = z11;
    }

    public final void setValidateOnFirebase(boolean z11) {
        this.validateOnFirebase = z11;
    }

    public final void setValidateOnPerseus(boolean z11) {
        this.validateOnPerseus = z11;
    }

    public final void setVariationName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.variationName = str;
    }

    public final boolean shouldEventBeValidatedInProduction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (validateAllEvents()) {
            return true;
        }
        return this.events.contains(str);
    }

    public final boolean shouldEventBeValidatedInProductionOnFirebase(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (!shouldEventBeValidatedInProduction(str) || !this.validateOnFirebase) {
            return false;
        }
        return true;
    }

    public final boolean shouldEventBeValidatedInProductionOnPerseus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (!shouldEventBeValidatedInProduction(str) || !this.validateOnPerseus) {
            return false;
        }
        return true;
    }
}
