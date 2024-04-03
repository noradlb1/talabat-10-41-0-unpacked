package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.BannerTracking;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerTrackingResponse;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/BannerResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/BannerResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "()V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerResponseMapper implements ModelMapper<BannerResponse, Banner> {
    @Nullable
    public Banner apply(@NotNull BannerResponse bannerResponse) {
        String trackingId;
        Intrinsics.checkNotNullParameter(bannerResponse, "source");
        BannerTracking bannerTracking = null;
        if (bannerResponse.getGlobalId() == null || bannerResponse.getName() == null || bannerResponse.getBannerUrl() == null || bannerResponse.getPosition() == null) {
            return null;
        }
        String globalId = bannerResponse.getGlobalId();
        String name2 = bannerResponse.getName();
        String bannerUrl = bannerResponse.getBannerUrl();
        int intValue = bannerResponse.getPosition().intValue();
        Boolean isStatic = bannerResponse.isStatic();
        boolean booleanValue = isStatic != null ? isStatic.booleanValue() : false;
        BannerTrackingResponse tracking2 = bannerResponse.getTracking();
        if (!(tracking2 == null || (trackingId = tracking2.getTrackingId()) == null)) {
            bannerTracking = new BannerTracking(trackingId);
        }
        return new Banner(globalId, name2, bannerUrl, intValue, booleanValue, bannerTracking);
    }
}
