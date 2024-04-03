package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"FREE_ITEM_DISCOUNT", "", "categoryIdsNotEmpty", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "isFreeDeliveryTypeVoucher", "isVoucherFreeItem", "productIdsNotEmpty", "skuIdsNotEmpty", "toLayoutVoucherResult", "LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VoucherDataKt {
    private static final float FREE_ITEM_DISCOUNT = 100.0f;

    public static final boolean categoryIdsNotEmpty(@NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        return !voucherData.getBounds().getCategoryIds().isEmpty();
    }

    public static final boolean isFreeDeliveryTypeVoucher(@NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        if (voucherData.getDiscountType() == DiscountType.FLAT_DELIVERY || voucherData.getDiscountType() == DiscountType.DELIVERY_PERCENTAGE) {
            return true;
        }
        return false;
    }

    public static final boolean isVoucherFreeItem(@NotNull VoucherData voucherData) {
        boolean z11;
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        if (voucherData.getDiscountType() != DiscountType.PERCENTAGE) {
            return false;
        }
        if (voucherData.getDiscountValue() == 100.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public static final boolean productIdsNotEmpty(@NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        return !voucherData.getBounds().getProductIds().isEmpty();
    }

    public static final boolean skuIdsNotEmpty(@NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        return !voucherData.getBounds().getSkuIds().isEmpty();
    }

    @NotNull
    public static final LoyaltyVoucherResult toLayoutVoucherResult(@NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "<this>");
        return new LoyaltyVoucherResult(voucherData.getId(), 0, voucherData.getTitle(), 0, voucherData.getDiscountValue(), voucherData.getDiscountType().name(), voucherData.getMaxDiscountCap(), voucherData.getMinOrderValue(), BoundsKt.toLoyaltyVoucherBounds(voucherData.getBounds()), voucherData.getVoucherOptionType().name(), 10, (DefaultConstructorMarker) null);
    }
}
