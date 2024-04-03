package com.talabat.core.tracking.data.platform.impl;

import com.talabat.core.tracking.data.logger.LogManager;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.newrelic.NewRelic;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/NewRelicTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "newRelic", "Lcom/talabat/newrelic/NewRelic;", "(Lcom/talabat/newrelic/NewRelic;)V", "track", "", "eventName", "", "attributes", "", "", "Companion", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRelicTrackingPlatform implements TrackingPlatform {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String FEATURE_NAME_KEY = "featureName";
    @NotNull
    private final NewRelic newRelic;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/NewRelicTrackingPlatform$Companion;", "", "()V", "FEATURE_NAME_KEY", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NewRelicTrackingPlatform() {
        this((NewRelic) null, 1, (DefaultConstructorMarker) null);
    }

    public NewRelicTrackingPlatform(@NotNull NewRelic newRelic2) {
        Intrinsics.checkNotNullParameter(newRelic2, "newRelic");
        this.newRelic = newRelic2;
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        return TrackingPlatform.DefaultImpls.getCommonAttributes(this, str);
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        LogManager.debug("Android::Sending to NewRelic, eventName: " + str + " with params " + map);
        NewRelic newRelic2 = this.newRelic;
        String valueOf = String.valueOf(map.get("featureName"));
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        newRelic2.recordCustomEvent(valueOf, str, linkedHashMap);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewRelicTrackingPlatform(NewRelic newRelic2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? NewRelic.INSTANCE : newRelic2);
    }
}
