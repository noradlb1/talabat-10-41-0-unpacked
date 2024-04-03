package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.refund.GetWalletRevertRefundToBankUseCase;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundDisplayModelState;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1", f = "WalletTransactionDetailRefundViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12846h;

    /* renamed from: i  reason: collision with root package name */
    public int f12847i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailRefundViewModel f12848j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12849k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1(WalletTransactionDetailRefundViewModel walletTransactionDetailRefundViewModel, String str, Continuation<? super WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1> continuation) {
        super(2, continuation);
        this.f12848j = walletTransactionDetailRefundViewModel;
        this.f12849k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1(this.f12848j, this.f12849k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletTransactionDetailRefundViewModel$onLoadRevertRefundToBank$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletRefundDisplayModelState> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12847i;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<WalletRefundDisplayModelState> walletRevertRefundToBankData = this.f12848j.getWalletRevertRefundToBankData();
            GetWalletRevertRefundToBankUseCase access$getWalletRevertRefundToBankUseCase$p = this.f12848j.walletRevertRefundToBankUseCase;
            String str = this.f12849k;
            this.f12846h = walletRevertRefundToBankData;
            this.f12847i = 1;
            Object invoke = access$getWalletRevertRefundToBankUseCase$p.invoke(str, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = walletRevertRefundToBankData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12846h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                MutableLiveData<WalletRefundDisplayModelState> walletRevertRefundToBankData2 = this.f12848j.getWalletRevertRefundToBankData();
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                walletRevertRefundToBankData2.setValue(new WalletRefundDisplayModelState.Error(message));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            z11 = false;
        }
        mutableLiveData.setValue(new WalletRefundDisplayModelState.SuccessRefundApiCall(z11));
        return Unit.INSTANCE;
    }
}
