package com.talabat.feature.tmart.growth.data.convert;

import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthTrackingInfoResponse;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthLoaderData;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0005H\u0000\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\r"}, d2 = {"toClaimConfirmation", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse;", "toClaimInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "toLoaderData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthLoaderData;", "toTrackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "voucherId", "", "title", "com_talabat_feature_tmartGrowth_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthResponseMappersKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TMartGrowthVoucherResponse.ClaimInfo.State.values().length];
            iArr[TMartGrowthVoucherResponse.ClaimInfo.State.CLAIMED.ordinal()] = 1;
            iArr[TMartGrowthVoucherResponse.ClaimInfo.State.UNCLAIMED.ordinal()] = 2;
            iArr[TMartGrowthVoucherResponse.ClaimInfo.State.OTHER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final TMartGrowthClaimConfirmation toClaimConfirmation(@NotNull TMartGrowthClaimResponse tMartGrowthClaimResponse) {
        Intrinsics.checkNotNullParameter(tMartGrowthClaimResponse, "<this>");
        return new TMartGrowthClaimConfirmation(tMartGrowthClaimResponse.getConfirmation().getDeeplink(), tMartGrowthClaimResponse.getConfirmation().getDescription(), tMartGrowthClaimResponse.getConfirmation().getLogoUrl(), tMartGrowthClaimResponse.getConfirmation().getTitle(), tMartGrowthClaimResponse.getPostConfirmation().getDescription(), tMartGrowthClaimResponse.getPostConfirmation().getImageUrl(), tMartGrowthClaimResponse.getPostConfirmation().getTitle());
    }

    @NotNull
    public static final TMartGrowthClaimInfo.Success toClaimInfo(@NotNull TMartGrowthVoucherResponse tMartGrowthVoucherResponse) {
        TMartGrowthClaimInfo.State state;
        Intrinsics.checkNotNullParameter(tMartGrowthVoucherResponse, "<this>");
        TMartGrowthVoucherResponse.ClaimInfo claimInfo = tMartGrowthVoucherResponse.getClaimInfo();
        String backgroundUrl = claimInfo.getBackgroundUrl();
        String basicImageUrl = claimInfo.getBasicImageUrl();
        String basicLoaderUrl = claimInfo.getBasicLoaderUrl();
        String buttonText = claimInfo.getButtonText();
        String deeplink = claimInfo.getDeeplink();
        String description = claimInfo.getDescription();
        String finalImageUrl = claimInfo.getFinalImageUrl();
        String finalLoaderUrl = claimInfo.getFinalLoaderUrl();
        String iconUrl = claimInfo.getIconUrl();
        String logoUrl = claimInfo.getLogoUrl();
        int i11 = WhenMappings.$EnumSwitchMapping$0[claimInfo.getState().ordinal()];
        if (i11 == 1) {
            state = TMartGrowthClaimInfo.State.CLAIMED;
        } else if (i11 == 2) {
            state = TMartGrowthClaimInfo.State.UNCLAIMED;
        } else if (i11 == 3) {
            state = TMartGrowthClaimInfo.State.OTHER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new TMartGrowthClaimInfo.Success(claimInfo.getTitle(), description, buttonText, basicImageUrl, finalImageUrl, basicLoaderUrl, finalLoaderUrl, state, deeplink, logoUrl, backgroundUrl, iconUrl);
    }

    @NotNull
    public static final TMartGrowthLoaderData toLoaderData(@NotNull TMartGrowthVoucherResponse tMartGrowthVoucherResponse) {
        Intrinsics.checkNotNullParameter(tMartGrowthVoucherResponse, "<this>");
        return new TMartGrowthLoaderData(tMartGrowthVoucherResponse.getClaimInfo().getBasicLoaderUrl(), tMartGrowthVoucherResponse.getClaimInfo().getFinalLoaderUrl());
    }

    @NotNull
    public static final TMartGrowthTrackingInfo toTrackingInfo(@NotNull TMartGrowthVoucherResponse tMartGrowthVoucherResponse, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(tMartGrowthVoucherResponse, "<this>");
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        TMartGrowthTrackingInfoResponse trackingInfo = tMartGrowthVoucherResponse.getTrackingInfo();
        return new TMartGrowthTrackingInfo(trackingInfo.getBranchId(), trackingInfo.getBranchName(), trackingInfo.getCuisines(), trackingInfo.getDeliveryTime(), trackingInfo.isDarkstore(), str, str2, trackingInfo.getVendorId(), trackingInfo.getVendorStatus(), trackingInfo.getVendorStatusType(), trackingInfo.getVerticalType());
    }
}
