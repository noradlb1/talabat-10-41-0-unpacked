package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VoucherListRequestModel;", "", "country", "", "voucherStatus", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "pageNumber", "pageSize", "(ILcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;II)V", "getCountry", "()I", "setCountry", "(I)V", "getPageNumber", "setPageNumber", "getPageSize", "setPageSize", "getVoucherStatus", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "setVoucherStatus", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherListRequestModel {
    private int country;
    private int pageNumber;
    private int pageSize;
    @NotNull
    private VouchersStatusFilter voucherStatus;

    public VoucherListRequestModel() {
        this(0, (VouchersStatusFilter) null, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public VoucherListRequestModel(int i11, @NotNull VouchersStatusFilter vouchersStatusFilter, int i12, int i13) {
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, VoucherUrlConstantsKt.QUERY_VOUCHER_STATUS);
        this.country = i11;
        this.voucherStatus = vouchersStatusFilter;
        this.pageNumber = i12;
        this.pageSize = i13;
    }

    public final int getCountry() {
        return this.country;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final VouchersStatusFilter getVoucherStatus() {
        return this.voucherStatus;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setVoucherStatus(@NotNull VouchersStatusFilter vouchersStatusFilter) {
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, "<set-?>");
        this.voucherStatus = vouchersStatusFilter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherListRequestModel(int i11, VouchersStatusFilter vouchersStatusFilter, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? -1 : i11, (i14 & 2) != 0 ? VouchersStatusFilter.ALL : vouchersStatusFilter, (i14 & 4) != 0 ? 1 : i12, (i14 & 8) != 0 ? 20 : i13);
    }
}
