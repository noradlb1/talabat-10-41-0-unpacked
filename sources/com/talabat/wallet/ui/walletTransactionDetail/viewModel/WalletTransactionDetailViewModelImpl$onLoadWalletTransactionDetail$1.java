package com.talabat.wallet.ui.walletTransactionDetail.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.wallet.features.walletTransactionDetail.GetWalletTransactionDetailUseCase;
import com.talabat.wallet.features.walletTransactionDetail.WalletTransactionDetailParam;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailMapper;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDisplayModelState;
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
@DebugMetadata(c = "com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1", f = "WalletTransactionDetailViewModelImpl.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12850h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailViewModelImpl f12851i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12852j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12853k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1(WalletTransactionDetailViewModelImpl walletTransactionDetailViewModelImpl, int i11, int i12, Continuation<? super WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1> continuation) {
        super(2, continuation);
        this.f12851i = walletTransactionDetailViewModelImpl;
        this.f12852j = i11;
        this.f12853k = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1(this.f12851i, this.f12852j, this.f12853k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletTransactionDetailViewModelImpl$onLoadWalletTransactionDetail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12850h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetWalletTransactionDetailUseCase access$getGetWalletTransactionDetailUseCase$p = this.f12851i.getWalletTransactionDetailUseCase;
            WalletTransactionDetailParam walletTransactionDetailParam = new WalletTransactionDetailParam(this.f12852j, this.f12853k);
            this.f12850h = 1;
            obj = access$getGetWalletTransactionDetailUseCase$p.invoke(walletTransactionDetailParam, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                MutableLiveData<WalletTransactionDisplayModelState> walletTransactionDetailData = this.f12851i.getWalletTransactionDetailData();
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                walletTransactionDetailData.setValue(new WalletTransactionDisplayModelState.Error(message));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        WalletTransactionDetail walletTransactionDetail = (WalletTransactionDetail) obj;
        MutableLiveData<WalletTransactionDetailHeaderDisplayModel> walletTransactionDetailHeaderData = this.f12851i.getWalletTransactionDetailHeaderData();
        WalletTransactionDetailMapper.Companion companion = WalletTransactionDetailMapper.Companion;
        walletTransactionDetailHeaderData.setValue(companion.mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
        this.f12851i.getWalletTransactionDetailData().setValue(companion.mapWalletTransactionDetailTypeToDisplayModel(walletTransactionDetail, this.f12851i.configurationLocalRepository.selectedCountry()));
        return Unit.INSTANCE;
    }
}
