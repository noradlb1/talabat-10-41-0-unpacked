package com.talabat.darkstores.data.tracking.impression;

import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.model.Banner;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.impressiontracking.items.TrackableImpressionItem;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/impression/BannerImpressionMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/darkstores/data/tracking/impression/BannerData;", "", "Lcom/talabat/impressiontracking/items/TrackableImpressionItem;", "()V", "apply", "source", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerImpressionMapper implements ModelMapper<BannerData, List<? extends TrackableImpressionItem>> {
    @NotNull
    public List<TrackableImpressionItem> apply(@NotNull BannerData bannerData) {
        String str;
        Intrinsics.checkNotNullParameter(bannerData, "source");
        Iterable bannerList = bannerData.getBannerList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bannerList, 10));
        int i11 = 0;
        for (Object next : bannerList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Banner banner = (Banner) next;
            String globalId = banner.getGlobalId();
            Pair[] pairArr = new Pair[12];
            pairArr[0] = TuplesKt.to("bannerId", banner.getGlobalId());
            pairArr[1] = TuplesKt.to("eventName", "banner_impressions_loaded");
            pairArr[2] = TuplesKt.to("featureName", "darkstores");
            pairArr[3] = TuplesKt.to("bannerName", banner.getName());
            pairArr[4] = TuplesKt.to("shopSponsoring", ProductImpressionTrackerKt.isSponsoredCapitalized(banner));
            pairArr[5] = TuplesKt.to("bannerPosition", String.valueOf(i11));
            Tracking tracking2 = banner.getTracking();
            if (tracking2 == null || (str = tracking2.getNmrAdId()) == null) {
                str = StringUtils.notAvailable(StringCompanionObject.INSTANCE);
            }
            pairArr[6] = TuplesKt.to(ProductTrackingProvider.NMR_AD_ID, str);
            pairArr[7] = TuplesKt.to("eventOrigin", "nmr_" + bannerData.getTrackingName());
            pairArr[8] = TuplesKt.to("bannerType", bannerData.getBannerType());
            pairArr[9] = TuplesKt.to("screenName", bannerData.getScreenName());
            pairArr[10] = TuplesKt.to("screenType", bannerData.getScreenName());
            pairArr[11] = TuplesKt.to(ProductImpressionMapperKt.KEY_IMPRESSION_LIST_NAME, "banner");
            arrayList.add(new TrackableImpressionItem(globalId, MapsKt__MapsKt.mapOf(pairArr)));
            i11 = i12;
        }
        return arrayList;
    }
}
