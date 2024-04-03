package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.feature.orderDetail.GetOrderDetailUseCase;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import datamodels.OrderDetails;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1", f = "WalletTransactionDetailPaymentViewModel.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12838h;

    /* renamed from: i  reason: collision with root package name */
    public int f12839i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailPaymentViewModel f12840j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12841k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1(WalletTransactionDetailPaymentViewModel walletTransactionDetailPaymentViewModel, String str, Continuation<? super WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1> continuation) {
        super(2, continuation);
        this.f12840j = walletTransactionDetailPaymentViewModel;
        this.f12841k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1(this.f12840j, this.f12841k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletTransactionDetailPaymentViewModel$onLoadOrderDetail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletOrderDetailModelState> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12839i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<WalletOrderDetailModelState> orderDetailData = this.f12840j.getOrderDetailData();
            GetOrderDetailUseCase access$getGetGetOrderDetailUseCase$p = this.f12840j.getGetOrderDetailUseCase;
            String str = this.f12841k;
            this.f12838h = orderDetailData;
            this.f12839i = 1;
            Object invoke = access$getGetGetOrderDetailUseCase$p.invoke(str, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = orderDetailData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12838h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                MutableLiveData<WalletOrderDetailModelState> orderDetailData2 = this.f12840j.getOrderDetailData();
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                orderDetailData2.setValue(new WalletOrderDetailModelState.Error(message));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(new WalletOrderDetailModelState.SuccessOrderDetail((OrderDetails) obj));
        return Unit.INSTANCE;
    }
}
