package com.talabat.impressiontracking;

import com.deliveryhero.impression.Impression;
import com.deliveryhero.impression.ImpressionRemote;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.impressiontracking.events.TalabatImpressionTrackingEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/impressiontracking/TalabatImpressionRemote;", "Lcom/deliveryhero/impression/ImpressionRemote;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "send", "", "impression", "Lcom/deliveryhero/impression/Impression;", "Companion", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImpressionRemote implements ImpressionRemote {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String KEY_EVENT_NAME = "eventName";
    @NotNull
    public static final String KEY_FEATURE_NAME = "featureName";
    @NotNull
    private final TalabatTracker tracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/impressiontracking/TalabatImpressionRemote$Companion;", "", "()V", "KEY_EVENT_NAME", "", "KEY_FEATURE_NAME", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TalabatImpressionRemote(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        this.tracker = talabatTracker;
    }

    public void send(@NotNull Impression impression) {
        Intrinsics.checkNotNullParameter(impression, "impression");
        TalabatTracker talabatTracker = this.tracker;
        String str = impression.getPayload().get("eventName");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = impression.getPayload().get("featureName");
        if (str3 != null) {
            str2 = str3;
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(impression.getPayload());
        mutableMap.remove("eventName");
        mutableMap.remove("featureName");
        Unit unit = Unit.INSTANCE;
        talabatTracker.track(new TalabatImpressionTrackingEvent(str, str2, mutableMap));
    }
}
