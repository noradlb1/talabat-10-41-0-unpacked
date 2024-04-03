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
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u000e\u0010\u0013\u001a\u00020\b*\u0004\u0018\u00010\bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/PointsCatalogueLoadedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "missions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "rewardsCatalogueOrigin", "", "attributes", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "(Lcom/talabat/feature/rewards/domain/model/MissionOrigin;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "orNA", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointsCatalogueLoadedTrackingEvent extends TalabatEvent {
    @NotNull
    private final List<TrackingAttributes> attributes;
    @Nullable
    private final String rewardsCatalogueOrigin;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointsCatalogueLoadedTrackingEvent(com.talabat.feature.rewards.domain.model.MissionOrigin r3, java.util.List r4, java.lang.String r5, java.util.List r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r2 = this;
            r7 = r7 & 8
            if (r7 == 0) goto L_0x002c
            r6 = 4
            com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[] r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[r6]
            com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes r7 = new com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes
            r8 = 0
            r0 = 1
            r7.<init>(r8, r0, r8)
            r1 = 0
            r6[r1] = r7
            com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes r7 = new com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes
            r7.<init>(r8, r0, r8)
            r6[r0] = r7
            com.talabat.feature.rewards.data.tracking.events.attributes.ScreenAttributes r7 = new com.talabat.feature.rewards.data.tracking.events.attributes.ScreenAttributes
            r7.<init>(r3)
            r8 = 2
            r6[r8] = r7
            com.talabat.feature.rewards.data.tracking.events.attributes.MissionsAttributes r7 = new com.talabat.feature.rewards.data.tracking.events.attributes.MissionsAttributes
            r7.<init>(r4)
            r8 = 3
            r6[r8] = r7
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r6)
        L_0x002c:
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.tracking.events.PointsCatalogueLoadedTrackingEvent.<init>(com.talabat.feature.rewards.domain.model.MissionOrigin, java.util.List, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final String orNA(String str) {
        return str == null || str.length() == 0 ? "N/A" : str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("eventOrigin", orNA(this.rewardsCatalogueOrigin)));
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
        return "points_catalogue_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public PointsCatalogueLoadedTrackingEvent(@Nullable MissionOrigin missionOrigin, @NotNull List<Mission> list, @Nullable String str, @NotNull List<? extends TrackingAttributes> list2) {
        Intrinsics.checkNotNullParameter(list, "missions");
        Intrinsics.checkNotNullParameter(list2, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.rewardsCatalogueOrigin = str;
        this.attributes = list2;
    }
}
