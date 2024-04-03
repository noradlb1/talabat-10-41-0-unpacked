package com.talabat.growth.ui.vouchers.list.viewModel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H&J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006 "}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "successRedeemPromo", "Landroidx/lifecycle/MutableLiveData;", "", "getSuccessRedeemPromo", "()Landroidx/lifecycle/MutableLiveData;", "setSuccessRedeemPromo", "(Landroidx/lifecycle/MutableLiveData;)V", "successRedeemVoucher", "getSuccessRedeemVoucher", "setSuccessRedeemVoucher", "voucherList", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "getVoucherList", "setVoucherList", "", "pageNumber", "", "pageSize", "vouchersStatusFilter", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "countryCode", "onSuccessResult", "requestCode", "data", "Landroid/content/Intent;", "redeemVoucherCode", "code", "", "brandId", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VouchersListViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<Boolean> successRedeemPromo = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> successRedeemVoucher = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VoucherListDisplayModel> voucherList = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Boolean> getSuccessRedeemPromo() {
        return this.successRedeemPromo;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSuccessRedeemVoucher() {
        return this.successRedeemVoucher;
    }

    @NotNull
    public final MutableLiveData<VoucherListDisplayModel> getVoucherList() {
        return this.voucherList;
    }

    public abstract void getVoucherList(int i11, int i12, @NotNull VouchersStatusFilter vouchersStatusFilter, int i13);

    public abstract void onSuccessResult(int i11, @Nullable Intent intent);

    public abstract void redeemVoucherCode(@NotNull String str, @Nullable String str2);

    public final void setSuccessRedeemPromo(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.successRedeemPromo = mutableLiveData;
    }

    public final void setSuccessRedeemVoucher(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.successRedeemVoucher = mutableLiveData;
    }

    public final void setVoucherList(@NotNull MutableLiveData<VoucherListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.voucherList = mutableLiveData;
    }
}
