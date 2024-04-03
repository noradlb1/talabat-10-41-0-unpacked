package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.refund.GetWalletCanRevertRefundToBankUseCase;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1", f = "WalletTransactionDetailRefundViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12842h;

    /* renamed from: i  reason: collision with root package name */
    public int f12843i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailRefundViewModel f12844j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12845k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1(WalletTransactionDetailRefundViewModel walletTransactionDetailRefundViewModel, String str, Continuation<? super WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1> continuation) {
        super(2, continuation);
        this.f12844j = walletTransactionDetailRefundViewModel;
        this.f12845k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1(this.f12844j, this.f12845k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletTransactionDetailRefundViewModel$onLoadCanRevertRefundToBank$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletRefundDisplayModelState> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12843i;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<WalletRefundDisplayModelState> walletCanRevertRefundToBankData = this.f12844j.getWalletCanRevertRefundToBankData();
            GetWalletCanRevertRefundToBankUseCase access$getWalletCanRevertRefundToBankUseCase$p = this.f12844j.walletCanRevertRefundToBankUseCase;
            String str = this.f12845k;
            this.f12842h = walletCanRevertRefundToBankData;
            this.f12843i = 1;
            Object invoke = access$getWalletCanRevertRefundToBankUseCase$p.invoke(str, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = walletCanRevertRefundToBankData;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12842h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                MutableLiveData<WalletRefundDisplayModelState> walletCanRevertRefundToBankData2 = this.f12844j.getWalletCanRevertRefundToBankData();
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                walletCanRevertRefundToBankData2.setValue(new WalletRefundDisplayModelState.Error(message));
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
