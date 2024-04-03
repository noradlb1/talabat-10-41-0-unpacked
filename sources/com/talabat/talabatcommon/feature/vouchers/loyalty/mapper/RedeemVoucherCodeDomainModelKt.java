package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\b"}, d2 = {"toMap", "", "", "", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "voucherCode", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherCodeDomainModelKt {
    @NotNull
    public static final Map<String, Object> toMap(@NotNull RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel) {
        Intrinsics.checkNotNullParameter(redeemVoucherCodeDomainModel, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("isSuccess", Boolean.TRUE), TuplesKt.to(VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID, redeemVoucherCodeDomainModel.getCustomerVoucherId()), TuplesKt.to("title", redeemVoucherCodeDomainModel.getTitle()), TuplesKt.to("discountValue", Float.valueOf(redeemVoucherCodeDomainModel.getDiscountValue())), TuplesKt.to("discountType", redeemVoucherCodeDomainModel.getDiscountType().name()), TuplesKt.to("maxDiscountCap", Float.valueOf(redeemVoucherCodeDomainModel.getMaxDiscountCap())), TuplesKt.to("minOrderValue", Float.valueOf(redeemVoucherCodeDomainModel.getMinOrderValue())), TuplesKt.to("tag", redeemVoucherCodeDomainModel.getTag()), TuplesKt.to("deeplink", redeemVoucherCodeDomainModel.getDeepLink()), TuplesKt.to("description", redeemVoucherCodeDomainModel.getDescription()), TuplesKt.to("termsAndConditions", redeemVoucherCodeDomainModel.getTermsAndConditions()), TuplesKt.to("validTillDate", redeemVoucherCodeDomainModel.getValidTil()), TuplesKt.to("campaignReferenceId", redeemVoucherCodeDomainModel.getCampaignReferenceId()), TuplesKt.to("thumbnailURL", redeemVoucherCodeDomainModel.getVoucherImage()), TuplesKt.to("redeemedVouchersCount", redeemVoucherCodeDomainModel.getRedeemedVouchersCount()));
    }

    @NotNull
    public static final VoucherData voucherData(@NotNull RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel, @NotNull String str) {
        Intrinsics.checkNotNullParameter(redeemVoucherCodeDomainModel, "<this>");
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        String customerVoucherId = redeemVoucherCodeDomainModel.getCustomerVoucherId();
        String title = redeemVoucherCodeDomainModel.getTitle();
        float discountValue = redeemVoucherCodeDomainModel.getDiscountValue();
        DiscountType discountType = redeemVoucherCodeDomainModel.getDiscountType();
        float maxDiscountCap = redeemVoucherCodeDomainModel.getMaxDiscountCap();
        float minOrderValue = redeemVoucherCodeDomainModel.getMinOrderValue();
        Bounds bounds = redeemVoucherCodeDomainModel.getBounds();
        VoucherOptionType voucherOptionType = VoucherOptionType.VOUCHER_CODE;
        String tag = redeemVoucherCodeDomainModel.getTag();
        String deepLink = redeemVoucherCodeDomainModel.getDeepLink();
        String description = redeemVoucherCodeDomainModel.getDescription();
        String termsAndConditions = redeemVoucherCodeDomainModel.getTermsAndConditions();
        return new VoucherData(customerVoucherId, title, 0, discountValue, discountType, maxDiscountCap, minOrderValue, bounds, voucherOptionType, tag, redeemVoucherCodeDomainModel.getValidTil(), termsAndConditions, deepLink, description, str, redeemVoucherCodeDomainModel.getCampaignReferenceId(), redeemVoucherCodeDomainModel.getRedeemedVouchersCount(), 4, (DefaultConstructorMarker) null);
    }
}
