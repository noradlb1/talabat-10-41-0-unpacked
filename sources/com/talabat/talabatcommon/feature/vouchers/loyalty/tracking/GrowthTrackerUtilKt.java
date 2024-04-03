package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.BoundsKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CartMenuItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a,\u0010\t\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001e\u0010\u000e\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a$\u0010\u000f\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002¨\u0006\u0011"}, d2 = {"getDiscountPrice", "", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "orderTotalAmount", "cartItems", "", "Ldatamodels/CartMenuItem;", "getTargetedItemsTotal", "getTotalByCategory", "categoryIds", "", "excludeCategories", "", "getTotalByProduct", "getTotalBySku", "skuIds", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GrowthTrackerUtilKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DiscountType.values().length];
            iArr[DiscountType.PERCENTAGE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float getDiscountPrice(@NotNull VoucherData voucherData, float f11, @Nullable List<? extends CartMenuItem> list) {
        float f12;
        Intrinsics.checkNotNullParameter(voucherData, "voucherData");
        boolean z11 = true;
        if (WhenMappings.$EnumSwitchMapping$0[voucherData.getDiscountType().ordinal()] == 1) {
            if (BoundsKt.hasBounds(voucherData.getBounds())) {
                Collection collection = list;
                if (collection != null && !collection.isEmpty()) {
                    z11 = false;
                }
                if (!z11) {
                    f11 = getTargetedItemsTotal(list, voucherData);
                }
            }
            if (voucherData.getMaxDiscountCap() > 0.0f) {
                f12 = Math.min(TalabatUtils.getPriceForPercentageDiscount(f11, voucherData.getDiscountValue()), voucherData.getMaxDiscountCap());
            } else {
                f12 = TalabatUtils.getPriceForPercentageDiscount(f11, voucherData.getDiscountValue());
            }
        } else {
            f12 = Math.min(f11, voucherData.getDiscountValue());
        }
        LogManager.debug("getDiscountPrice: appliedDiscountValue : " + f12);
        return f12;
    }

    private static final float getTargetedItemsTotal(List<? extends CartMenuItem> list, VoucherData voucherData) {
        boolean z11;
        boolean z12;
        Bounds bounds = voucherData.getBounds();
        Collection productIds = bounds.getProductIds();
        boolean z13 = false;
        if (productIds == null || productIds.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return getTotalByProduct(list, voucherData);
        }
        Collection skuIds = bounds.getSkuIds();
        if (skuIds == null || skuIds.isEmpty()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return getTotalBySku(list, bounds.getSkuIds());
        }
        Collection categoryIds = bounds.getCategoryIds();
        if (categoryIds == null || categoryIds.isEmpty()) {
            z13 = true;
        }
        if (!z13) {
            return getTotalByCategory(list, bounds.getCategoryIds(), bounds.getExcludeCategories());
        }
        return 0.0f;
    }

    private static final float getTotalByCategory(List<? extends CartMenuItem> list, List<String> list2, boolean z11) {
        boolean z12;
        float f11 = 0.0f;
        for (CartMenuItem cartMenuItem : list) {
            Iterable iterable = list2;
            boolean z13 = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    List<String> list3 = cartMenuItem.qcCategoryIds;
                    if (list3 == null || !list3.contains(str)) {
                        z12 = false;
                        continue;
                    } else {
                        z12 = true;
                        continue;
                    }
                    if (z12) {
                        z13 = true;
                        break;
                    }
                }
            }
            if (z13 != z11) {
                f11 += cartMenuItem.getTotalPrice();
            }
        }
        return f11;
    }

    private static final float getTotalByProduct(List<? extends CartMenuItem> list, VoucherData voucherData) {
        float f11;
        float f12 = 0.0f;
        for (CartMenuItem cartMenuItem : list) {
            if (cartMenuItem.f13861id > 0 && voucherData.getBounds().getProductIds().contains(String.valueOf(cartMenuItem.f13861id))) {
                if (VoucherDataKt.isVoucherFreeItem(voucherData)) {
                    f11 = cartMenuItem.getItemPrice();
                } else {
                    f11 = cartMenuItem.getTotalPrice();
                }
                f12 += f11;
            }
        }
        return f12;
    }

    private static final float getTotalBySku(List<? extends CartMenuItem> list, List<String> list2) {
        boolean z11;
        float f11 = 0.0f;
        for (CartMenuItem cartMenuItem : list) {
            String str = cartMenuItem.sku;
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && CollectionsKt___CollectionsKt.contains(list2, cartMenuItem.sku)) {
                f11 += cartMenuItem.getTotalPrice();
            }
        }
        return f11;
    }
}
