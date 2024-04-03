package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ActiveVouchersCount;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BinRestrictedVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BinRestrictionResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestVoucherResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestWelcomeVoucherResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemVoucherCodeResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ReferralSenderCampaignDetailsResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherResponseModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewModelMapperKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\u0003\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\u0003\u001a\u00020\n*\u00020\u000bH\u0000\u001a\f\u0010\u0003\u001a\u00020\f*\u00020\rH\u0000\u001a\f\u0010\u0003\u001a\u00020\u000e*\u00020\u000fH\u0000\u001a\n\u0010\u0003\u001a\u00020\u0010*\u00020\u0011¨\u0006\u0012"}, d2 = {"toDomainBinVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictionModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;", "toDomainModel", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ActiveVouchersCount;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictedVoucherModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictedVoucherResponse;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestVoucherResult;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestWelcomeVoucherResult;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemVoucherCodeResult;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/ReferralSenderCampaignDetailsDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ReferralSenderCampaignDetailsResult;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapperKt {
    @NotNull
    public static final BinRestrictionModel toDomainBinVouchers(@NotNull BinRestrictionResponse binRestrictionResponse) {
        Intrinsics.checkNotNullParameter(binRestrictionResponse, "<this>");
        boolean orFalse = BooleanKt.orFalse(Boolean.valueOf(binRestrictionResponse.isRestricted()));
        List<String> eligibleBins = binRestrictionResponse.getEligibleBins();
        if (eligibleBins == null) {
            eligibleBins = CollectionsKt__CollectionsKt.emptyList();
        }
        return new BinRestrictionModel(orFalse, eligibleBins);
    }

    @NotNull
    public static final VoucherDetailDomainModel toDomainModel(@NotNull VoucherResponseModel voucherResponseModel) {
        String str;
        Intrinsics.checkNotNullParameter(voucherResponseModel, "<this>");
        String id2 = voucherResponseModel.getId();
        if (id2 == null) {
            id2 = "";
        }
        int orZero = IntKt.orZero(voucherResponseModel.getCustomerId());
        String title = voucherResponseModel.getTitle();
        if (title == null) {
            title = "";
        }
        List<Integer> brandIds = voucherResponseModel.getBrandIds();
        if (brandIds == null) {
            brandIds = CollectionsKt__CollectionsKt.emptyList();
        }
        float orZero2 = FloatKt.orZero(voucherResponseModel.getDiscountValue());
        String discountType = voucherResponseModel.getDiscountType();
        if (discountType == null) {
            discountType = "";
        }
        DiscountType mapToDiscountType = ApplyVoucherViewModelMapperKt.mapToDiscountType(discountType);
        float orZero3 = FloatKt.orZero(voucherResponseModel.getMaxDiscountCap());
        float orZero4 = FloatKt.orZero(voucherResponseModel.getMinOrderValue());
        int orZero5 = IntKt.orZero(voucherResponseModel.getTalabatSharePercentage());
        int orZero6 = IntKt.orZero(voucherResponseModel.getPointsCost());
        String partnerUrl = voucherResponseModel.getPartnerUrl();
        if (partnerUrl == null) {
            partnerUrl = "";
        }
        String partnerUrlText = voucherResponseModel.getPartnerUrlText();
        if (partnerUrlText == null) {
            partnerUrlText = "";
        }
        String thumbnailURL = voucherResponseModel.getThumbnailURL();
        if (thumbnailURL == null) {
            thumbnailURL = "";
        }
        String imageURL = voucherResponseModel.getImageURL();
        if (imageURL == null) {
            imageURL = "";
        }
        String nfpCouponCode = voucherResponseModel.getNfpCouponCode();
        if (nfpCouponCode == null) {
            nfpCouponCode = "";
        }
        String description = voucherResponseModel.getDescription();
        if (description == null) {
            description = "";
        }
        String tag = voucherResponseModel.getTag();
        if (tag == null) {
            str = "";
        } else {
            str = tag;
        }
        return new VoucherDetailDomainModel(id2, orZero, title, brandIds, orZero2, mapToDiscountType, orZero3, orZero4, orZero5, orZero6, partnerUrl, partnerUrlText, thumbnailURL, imageURL, nfpCouponCode, description, str);
    }

    @NotNull
    public static final RedeemVoucherCodeDomainModel toDomainModel(@NotNull RedeemVoucherCodeResult redeemVoucherCodeResult) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(redeemVoucherCodeResult, "<this>");
        String customerVoucherId = redeemVoucherCodeResult.getCustomerVoucherId();
        String str9 = customerVoucherId == null ? "" : customerVoucherId;
        String title = redeemVoucherCodeResult.getTitle();
        if (title == null) {
            str = "";
        } else {
            str = title;
        }
        String tag = redeemVoucherCodeResult.getTag();
        if (tag == null) {
            str2 = "";
        } else {
            str2 = tag;
        }
        String description = redeemVoucherCodeResult.getDescription();
        if (description == null) {
            str3 = "";
        } else {
            str3 = description;
        }
        String deeplink = redeemVoucherCodeResult.getDeeplink();
        if (deeplink == null) {
            str4 = "";
        } else {
            str4 = deeplink;
        }
        String termsAndConditions = redeemVoucherCodeResult.getTermsAndConditions();
        if (termsAndConditions == null) {
            str5 = "";
        } else {
            str5 = termsAndConditions;
        }
        String thumbnailURL = redeemVoucherCodeResult.getThumbnailURL();
        if (thumbnailURL == null) {
            str6 = "";
        } else {
            str6 = thumbnailURL;
        }
        String validTillDate = redeemVoucherCodeResult.getValidTillDate();
        if (validTillDate == null) {
            str7 = "";
        } else {
            str7 = validTillDate;
        }
        float orZero = FloatKt.orZero(redeemVoucherCodeResult.getDiscountValue());
        String discountType = redeemVoucherCodeResult.getDiscountType();
        if (discountType == null) {
            discountType = "";
        }
        DiscountType mapToDiscountType = ApplyVoucherViewModelMapperKt.mapToDiscountType(discountType);
        float orZero2 = FloatKt.orZero(redeemVoucherCodeResult.getMaxDiscountCap());
        float orZero3 = FloatKt.orZero(redeemVoucherCodeResult.getMinOrderValue());
        Bounds mapBounds = ApplyVoucherViewModelMapperKt.mapBounds(redeemVoucherCodeResult.getBounds());
        String campaignReferenceId = redeemVoucherCodeResult.getCampaignReferenceId();
        if (campaignReferenceId == null) {
            str8 = "";
        } else {
            str8 = campaignReferenceId;
        }
        return new RedeemVoucherCodeDomainModel(str9, str, str2, str3, str4, str6, str5, str7, mapToDiscountType, orZero, orZero2, orZero3, mapBounds, str8, redeemVoucherCodeResult.getRedeemedVouchersCount());
    }

    @NotNull
    public static final GuestVoucherDomainModel toDomainModel(@NotNull GuestVoucherResult guestVoucherResult) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(guestVoucherResult, "<this>");
        String title = guestVoucherResult.getTitle();
        String str5 = title == null ? "" : title;
        String tag = guestVoucherResult.getTag();
        if (tag == null) {
            str = "";
        } else {
            str = tag;
        }
        String description = guestVoucherResult.getDescription();
        if (description == null) {
            str2 = "";
        } else {
            str2 = description;
        }
        String deeplink = guestVoucherResult.getDeeplink();
        if (deeplink == null) {
            str3 = "";
        } else {
            str3 = deeplink;
        }
        int orZero = IntKt.orZero(guestVoucherResult.getValidTillDays());
        float orZero2 = FloatKt.orZero(guestVoucherResult.getMinOrderValue());
        String termsAndConditions = guestVoucherResult.getTermsAndConditions();
        if (termsAndConditions == null) {
            str4 = "";
        } else {
            str4 = termsAndConditions;
        }
        String thumbnailURL = guestVoucherResult.getThumbnailURL();
        if (thumbnailURL == null) {
            thumbnailURL = "";
        }
        return new GuestVoucherDomainModel(str5, str, str2, str3, orZero, orZero2, str4, thumbnailURL);
    }

    @NotNull
    public static final GuestWelcomeVoucherDomainModel toDomainModel(@NotNull GuestWelcomeVoucherResult guestWelcomeVoucherResult) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(guestWelcomeVoucherResult, "<this>");
        String title = guestWelcomeVoucherResult.getTitle();
        String str3 = title == null ? "" : title;
        String tag = guestWelcomeVoucherResult.getTag();
        if (tag == null) {
            str = "";
        } else {
            str = tag;
        }
        String description = guestWelcomeVoucherResult.getDescription();
        if (description == null) {
            str2 = "";
        } else {
            str2 = description;
        }
        int orZero = IntKt.orZero(guestWelcomeVoucherResult.getValidTillDays());
        float orZero2 = FloatKt.orZero(guestWelcomeVoucherResult.getMinOrderValue());
        String termsAndConditions = guestWelcomeVoucherResult.getTermsAndConditions();
        if (termsAndConditions == null) {
            termsAndConditions = "";
        }
        return new GuestWelcomeVoucherDomainModel(str3, str, str2, orZero, orZero2, termsAndConditions);
    }

    @NotNull
    public static final BinRestrictedVoucherModel toDomainModel(@NotNull BinRestrictedVoucherResponse binRestrictedVoucherResponse) {
        Intrinsics.checkNotNullParameter(binRestrictedVoucherResponse, "<this>");
        boolean orFalse = BooleanKt.orFalse(binRestrictedVoucherResponse.isApplied());
        String customerVoucherId = binRestrictedVoucherResponse.getCustomerVoucherId();
        if (customerVoucherId == null) {
            customerVoucherId = "";
        }
        BinRestrictionResponse binRestriction = binRestrictedVoucherResponse.getBinRestriction();
        return new BinRestrictedVoucherModel(orFalse, customerVoucherId, binRestriction != null ? toDomainBinVouchers(binRestriction) : null);
    }

    @NotNull
    public static final ReferralSenderCampaignDetailsDomainModel toDomainModel(@NotNull ReferralSenderCampaignDetailsResult referralSenderCampaignDetailsResult) {
        Intrinsics.checkNotNullParameter(referralSenderCampaignDetailsResult, "<this>");
        String voucherValueLabel = referralSenderCampaignDetailsResult.getVoucherValueLabel();
        if (voucherValueLabel == null) {
            voucherValueLabel = "";
        }
        return new ReferralSenderCampaignDetailsDomainModel(voucherValueLabel);
    }

    @NotNull
    public static final VoucherStateDomainModel toDomainModel(@NotNull ActiveVouchersCount activeVouchersCount) {
        Intrinsics.checkNotNullParameter(activeVouchersCount, "<this>");
        int orZero = IntKt.orZero(Integer.valueOf(activeVouchersCount.getTotalActiveCount()));
        String notificationLabel = activeVouchersCount.getNotificationLabel();
        if (notificationLabel == null) {
            notificationLabel = "";
        }
        VoucherNotificationStyle notificationStyle = activeVouchersCount.getNotificationStyle();
        if (notificationStyle == null) {
            notificationStyle = VoucherNotificationStyle.NONE;
        }
        return new VoucherStateDomainModel(orZero, notificationLabel, notificationStyle);
    }
}
