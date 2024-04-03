package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.SetTipRiderStatusUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010$\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010%\u001a\u00020\"2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/viewmodel/OrderConfirmationRiderTipViewModel;", "Landroidx/lifecycle/ViewModel;", "isRiderTipEnabledUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/business/usecase/GetOrderConfirmationRiderTipEnabledUseCase;", "setTipRiderStatusUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;", "(Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/business/usecase/GetOrderConfirmationRiderTipEnabledUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;)V", "encryptedOrderId", "", "getEncryptedOrderId", "()Ljava/lang/String;", "setEncryptedOrderId", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "getOrderStatus", "()Lcom/talabat/talabatcommon/enums/OrderStatus;", "setOrderStatus", "(Lcom/talabat/talabatcommon/enums/OrderStatus;)V", "riderTipStatusDisplayModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "getRiderTipStatusDisplayModel", "()Landroidx/lifecycle/MutableLiveData;", "source", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "getSource", "()Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "setSource", "(Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;)V", "onRiderTipGiven", "", "onShowRiderTip", "onUpdateOrderStatus", "setOrderDetails", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderConfirmationRiderTipViewModel extends ViewModel {
    @NotNull
    private String encryptedOrderId;
    /* access modifiers changed from: private */
    @NotNull
    public final GetOrderConfirmationRiderTipEnabledUseCase isRiderTipEnabledUseCase;
    @NotNull
    private String orderId;
    @Nullable
    private OrderStatus orderStatus;
    @NotNull
    private final MutableLiveData<OrderConfirmationRiderTipDisplayModel> riderTipStatusDisplayModel = new MutableLiveData<>();
    @NotNull
    private final SetTipRiderStatusUseCase setTipRiderStatusUseCase;
    @NotNull
    private TipRiderSource source;

    public OrderConfirmationRiderTipViewModel(@NotNull GetOrderConfirmationRiderTipEnabledUseCase getOrderConfirmationRiderTipEnabledUseCase, @NotNull SetTipRiderStatusUseCase setTipRiderStatusUseCase2) {
        Intrinsics.checkNotNullParameter(getOrderConfirmationRiderTipEnabledUseCase, "isRiderTipEnabledUseCase");
        Intrinsics.checkNotNullParameter(setTipRiderStatusUseCase2, "setTipRiderStatusUseCase");
        this.isRiderTipEnabledUseCase = getOrderConfirmationRiderTipEnabledUseCase;
        this.setTipRiderStatusUseCase = setTipRiderStatusUseCase2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.encryptedOrderId = StringUtils.empty(stringCompanionObject);
        this.orderId = StringUtils.empty(stringCompanionObject);
        this.source = TipRiderSource.DEFAULT;
    }

    @NotNull
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    @NotNull
    public final MutableLiveData<OrderConfirmationRiderTipDisplayModel> getRiderTipStatusDisplayModel() {
        return this.riderTipStatusDisplayModel;
    }

    @NotNull
    public final TipRiderSource getSource() {
        return this.source;
    }

    public final void onRiderTipGiven() {
        OrderConfirmationRiderTipDisplayModel value = this.riderTipStatusDisplayModel.getValue();
        OrderConfirmationRiderTipDisplayModel.ShowRiderTipGiven showRiderTipGiven = OrderConfirmationRiderTipDisplayModel.ShowRiderTipGiven.INSTANCE;
        if (!Intrinsics.areEqual((Object) value, (Object) showRiderTipGiven)) {
            this.setTipRiderStatusUseCase.invoke(this.encryptedOrderId);
        }
        this.riderTipStatusDisplayModel.postValue(showRiderTipGiven);
    }

    public final void onShowRiderTip(@Nullable OrderStatus orderStatus2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OrderConfirmationRiderTipViewModel$onShowRiderTip$1(this, orderStatus2, (Continuation<? super OrderConfirmationRiderTipViewModel$onShowRiderTip$1>) null), 3, (Object) null);
    }

    public final void onUpdateOrderStatus(@Nullable OrderStatus orderStatus2) {
        if (orderStatus2 != null) {
            this.orderStatus = orderStatus2;
        }
    }

    public final void setEncryptedOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encryptedOrderId = str;
    }

    public final void setOrderDetails(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            this.encryptedOrderId = str;
        }
        if (str2 != null) {
            this.orderId = str2;
        }
    }

    public final void setOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderId = str;
    }

    public final void setOrderStatus(@Nullable OrderStatus orderStatus2) {
        this.orderStatus = orderStatus2;
    }

    public final void setSource(@NotNull TipRiderSource tipRiderSource) {
        Intrinsics.checkNotNullParameter(tipRiderSource, "<set-?>");
        this.source = tipRiderSource;
    }
}
