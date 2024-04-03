package com.talabat.feature.rewards.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.helpers.GlobalDataModel;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016J\u0013\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/ShopClickedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "offerVoucherId", "", "restaurant", "Ldatamodels/Restaurant;", "attributes", "", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "(Ljava/lang/String;Ldatamodels/Restaurant;Ljava/util/List;Ltracking/gtm/TalabatGTM$Companion;)V", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "or0", "", "(Ljava/lang/Integer;)I", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopClickedTrackingEvent extends TalabatEvent {
    @NotNull
    private final List<TrackingAttributes> attributes;
    @NotNull
    private final String offerVoucherId;
    @Nullable
    private final Restaurant restaurant;
    @NotNull
    private final TalabatGTM.Companion talabatGTM;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClickedTrackingEvent(java.lang.String r4, datamodels.Restaurant r5, java.util.List r6, tracking.gtm.TalabatGTM.Companion r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r3 = this;
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r9 = r8 & 4
            if (r9 == 0) goto L_0x0039
            r6 = 5
            com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[] r6 = new com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes[r6]
            com.talabat.feature.rewards.data.tracking.events.attributes.ChainAttributes r9 = new com.talabat.feature.rewards.data.tracking.events.attributes.ChainAttributes
            r9.<init>(r5)
            r1 = 0
            r6[r1] = r9
            com.talabat.feature.rewards.data.tracking.events.attributes.FloodAttributes r9 = new com.talabat.feature.rewards.data.tracking.events.attributes.FloodAttributes
            r9.<init>()
            r1 = 1
            r6[r1] = r9
            com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes r9 = new com.talabat.feature.rewards.data.tracking.events.attributes.LocationAttributes
            r9.<init>(r0, r1, r0)
            r2 = 2
            r6[r2] = r9
            com.talabat.feature.rewards.data.tracking.events.attributes.ShopAttributes r9 = new com.talabat.feature.rewards.data.tracking.events.attributes.ShopAttributes
            r9.<init>(r5, r0, r2, r0)
            r2 = 3
            r6[r2] = r9
            com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes r9 = new com.talabat.feature.rewards.data.tracking.events.attributes.UserAttributes
            r9.<init>(r0, r1, r0)
            r0 = 4
            r6[r0] = r9
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r6)
        L_0x0039:
            r8 = r8 & 8
            if (r8 == 0) goto L_0x003f
            tracking.gtm.TalabatGTM$Companion r7 = tracking.gtm.TalabatGTM.Companion
        L_0x003f:
            r3.<init>(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.tracking.events.ShopClickedTrackingEvent.<init>(java.lang.String, datamodels.Restaurant, java.util.List, tracking.gtm.TalabatGTM$Companion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final int or0(Integer num) {
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Integer num;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("shopClickOrigin", "rewards");
        pairArr[1] = TuplesKt.to("deliveryProvider", this.talabatGTM.restaurantType(this.restaurant));
        pairArr[2] = TuplesKt.to("eventOrigin", "rewards");
        pairArr[3] = TuplesKt.to("listingPageType", this.talabatGTM.listingType(this.restaurant));
        pairArr[4] = TuplesKt.to("offerVoucherId", this.offerVoucherId);
        CartMenuItem cartMenuItem = GlobalDataModel.SELECTED.cartMenuItem;
        if (cartMenuItem != null) {
            num = Integer.valueOf(cartMenuItem.f13861id);
        } else {
            num = null;
        }
        pairArr[5] = TuplesKt.to("productSku", Integer.valueOf(or0(num)));
        Map mapOf = MapsKt__MapsKt.mapOf(pairArr);
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
        return "shop_clicked";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public ShopClickedTrackingEvent(@NotNull String str, @Nullable Restaurant restaurant2, @NotNull List<? extends TrackingAttributes> list, @NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(str, "offerVoucherId");
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(companion, "talabatGTM");
        this.offerVoucherId = str;
        this.restaurant = restaurant2;
        this.attributes = list;
        this.talabatGTM = companion;
    }
}
