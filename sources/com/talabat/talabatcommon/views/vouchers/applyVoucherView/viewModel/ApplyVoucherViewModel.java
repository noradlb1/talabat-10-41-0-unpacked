package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "viewStateLiveData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "getViewStateLiveData", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "setViewStateLiveData", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;)V", "dispatchAction", "", "applyVouchersActions", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApplyVoucherViewModel extends BaseViewModel {
    @NotNull
    private SingleLiveEvent<ApplyVouchersViewStates> viewStateLiveData = new SingleLiveEvent<>();

    public abstract void dispatchAction(@NotNull ApplyVouchersActions applyVouchersActions);

    @NotNull
    public final SingleLiveEvent<ApplyVouchersViewStates> getViewStateLiveData() {
        return this.viewStateLiveData;
    }

    public final void setViewStateLiveData(@NotNull SingleLiveEvent<ApplyVouchersViewStates> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.viewStateLiveData = singleLiveEvent;
    }
}
