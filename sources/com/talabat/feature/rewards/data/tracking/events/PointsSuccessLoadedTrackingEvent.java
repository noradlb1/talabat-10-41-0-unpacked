package com.talabat.feature.rewards.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.feature.rewards.domain.model.ButtonType;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0016J\u000e\u0010\u0011\u001a\u00020\u0003*\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/PointsSuccessLoadedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "offerVoucherId", "", "buttonType", "Lcom/talabat/feature/rewards/domain/model/ButtonType;", "attributes", "", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "(Ljava/lang/String;Lcom/talabat/feature/rewards/domain/model/ButtonType;Ljava/util/List;)V", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "orNA", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointsSuccessLoadedTrackingEvent extends TalabatEvent {
    @NotNull
    private final List<TrackingAttributes> attributes;
    @NotNull
    private final ButtonType buttonType;
    @Nullable
    private final String offerVoucherId;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointsSuccessLoadedTrackingEvent(java.lang.String r3, com.talabat.feature.rewards.domain.model.ButtonType r4, java.util.List r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r6 = r6 & 4
            if (r6 == 0) goto L_0x001c
            r5 = 2
            com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[] r5 = new com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[r5]
            com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes
            r7 = 0
            r0 = 1
            r6.<init>(r7, r0, r7)
            r1 = 0
            r5[r1] = r6
            com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes
            r6.<init>(r7, r0, r7)
            r5[r0] = r6
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r5)
        L_0x001c:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.tracking.events.PointsSuccessLoadedTrackingEvent.<init>(java.lang.String, com.talabat.feature.rewards.domain.model.ButtonType, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final String orNA(String str) {
        return str == null || str.length() == 0 ? "N/A" : str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("offerVoucherId", orNA(this.offerVoucherId)), TuplesKt.to("buttonType", this.buttonType.getTypeName()));
        Iterable<TrackingAttributes> iterable = this.attributes;
        ArrayList<Map> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TrackingAttributes attributes2 : iterable) {
            arrayList.add(attributes2.getAttributes());
        }
        Map emptyMap = MapsKt__MapsKt.emptyMap();
        for (Map plus : arrayList) {
            emptyMap = MapsKt__MapsKt.plus(emptyMap, plus);
        }
        return MapsKt__MapsKt.plus(mapOf, emptyMap);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rewards";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "points_success_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public PointsSuccessLoadedTrackingEvent(@Nullable String str, @NotNull ButtonType buttonType2, @NotNull List<? extends TrackingAttributes> list) {
        Intrinsics.checkNotNullParameter(buttonType2, "buttonType");
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.offerVoucherId = str;
        this.buttonType = buttonType2;
        this.attributes = list;
    }
}
