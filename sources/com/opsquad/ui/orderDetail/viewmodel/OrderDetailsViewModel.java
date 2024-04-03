package com.opsquad.ui.orderDetail.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.opsquad.ui.orderDetail.model.OrderDetailDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/opsquad/ui/orderDetail/viewmodel/OrderDetailsViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "successData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "getSuccessData", "()Landroidx/lifecycle/MutableLiveData;", "setSuccessData", "(Landroidx/lifecycle/MutableLiveData;)V", "getOrderDetails", "", "orderID", "", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OrderDetailsViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<OrderDetailDisplayModel> successData = new MutableLiveData<>();

    public abstract void getOrderDetails(@NotNull String str);

    @NotNull
    public final MutableLiveData<OrderDetailDisplayModel> getSuccessData() {
        return this.successData;
    }

    public final void setSuccessData(@NotNull MutableLiveData<OrderDetailDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.successData = mutableLiveData;
    }
}
