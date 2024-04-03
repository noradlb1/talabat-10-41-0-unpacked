package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import datamodels.CartMenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"createCartMenuItem", "Ldatamodels/CartMenuItem;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsDisplayModelKt {
    @NotNull
    public static final CartMenuItem createCartMenuItem(@NotNull VoucherItemsDisplayModel voucherItemsDisplayModel) {
        Intrinsics.checkNotNullParameter(voucherItemsDisplayModel, "<this>");
        CartMenuItem cartMenuItem = new CartMenuItem();
        cartMenuItem.f13861id = voucherItemsDisplayModel.getResult().getId();
        cartMenuItem.specialRequest = "";
        cartMenuItem.setQuantity(1);
        cartMenuItem.f13862name = voucherItemsDisplayModel.getResult().getName();
        cartMenuItem.price = voucherItemsDisplayModel.getResult().getPrice();
        cartMenuItem.setItemPrice(voucherItemsDisplayModel.getResult().getPrice());
        cartMenuItem.setItemTotalPrice(voucherItemsDisplayModel.getResult().getPrice());
        cartMenuItem.desc = voucherItemsDisplayModel.getResult().getDescription();
        return cartMenuItem;
    }
}
