package com.talabat.feature.rewards.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/MissionDetailLoadedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "attributes", "", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "(Lcom/talabat/feature/rewards/domain/model/MissionOrigin;Lcom/talabat/feature/rewards/domain/model/Mission;Ljava/util/List;)V", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionDetailLoadedTrackingEvent extends TalabatEvent {
    @NotNull
    private final List<TrackingAttributes> attributes;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MissionDetailLoadedTrackingEvent(com.talabat.feature.rewards.domain.model.MissionOrigin r3, com.talabat.feature.rewards.domain.model.Mission r4, java.util.List r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = 4
            r6 = r6 & r7
            if (r6 == 0) goto L_0x002b
            com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[] r5 = new com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[r7]
            com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes
            r7 = 0
            r0 = 1
            r6.<init>(r7, r0, r7)
            r1 = 0
            r5[r1] = r6
            com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes
            r6.<init>(r7, r0, r7)
            r5[r0] = r6
            com.talabat.feature.rewards.data.tracking.events.attributes.ScreenAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.ScreenAttributes
            r6.<init>(r3)
            r7 = 2
            r5[r7] = r6
            com.talabat.feature.rewards.data.tracking.events.attributes.MissionAttributes r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.MissionAttributes
            r6.<init>(r4)
            r7 = 3
            r5[r7] = r6
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r5)
        L_0x002b:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.tracking.events.MissionDetailLoadedTrackingEvent.<init>(com.talabat.feature.rewards.domain.model.MissionOrigin, com.talabat.feature.rewards.domain.model.Mission, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Iterable<TrackingAttributes> iterable = this.attributes;
        ArrayList<Map> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TrackingAttributes attributes2 : iterable) {
            arrayList.add(attributes2.getAttributes());
        }
        Map<String, Object> emptyMap = MapsKt__MapsKt.emptyMap();
        for (Map plus : arrayList) {
            emptyMap = MapsKt__MapsKt.plus(emptyMap, (Map<String, Object>) plus);
        }
        return emptyMap;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rewards";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "mission_detail_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public MissionDetailLoadedTrackingEvent(@Nullable MissionOrigin missionOrigin, @Nullable Mission mission, @NotNull List<? extends TrackingAttributes> list) {
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.attributes = list;
    }
}
