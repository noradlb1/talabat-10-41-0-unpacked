package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyActiveVouchersResponse;", "", "()V", "activeCustomerVouchers", "", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherItemResponse;", "getActiveCustomerVouchers", "()Ljava/util/List;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyActiveVouchersResponse {
    @SerializedName("activeCustomerVouchers")
    @Nullable
    private final List<VoucherItemResponse> activeCustomerVouchers;

    @Nullable
    public final List<VoucherItemResponse> getActiveCustomerVouchers() {
        return this.activeCustomerVouchers;
    }
}
