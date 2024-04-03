package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "", "()V", "myVouchers", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "getMyVouchers", "()Ljava/util/List;", "setMyVouchers", "(Ljava/util/List;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewHolderDisplayModel {
    @NotNull
    private List<VoucherDisplayModel> myVouchers = new ArrayList();

    @NotNull
    public final List<VoucherDisplayModel> getMyVouchers() {
        return this.myVouchers;
    }

    public final void setMyVouchers(@NotNull List<VoucherDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.myVouchers = list;
    }
}
