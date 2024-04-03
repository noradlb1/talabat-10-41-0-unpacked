package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardErrorResult;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardManagementMapper;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletDeleteCardDisplayModelState;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel$onLoadDeleteCard$1", f = "WalletCardManagementViewModel.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
public final class WalletCardManagementViewModel$onLoadDeleteCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f11968h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11969i;

    /* renamed from: j  reason: collision with root package name */
    public int f11970j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementViewModel f11971k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WalletDeleteCardRequestModel f11972l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementViewModel$onLoadDeleteCard$1(WalletCardManagementViewModel walletCardManagementViewModel, WalletDeleteCardRequestModel walletDeleteCardRequestModel, Continuation<? super WalletCardManagementViewModel$onLoadDeleteCard$1> continuation) {
        super(2, continuation);
        this.f11971k = walletCardManagementViewModel;
        this.f11972l = walletDeleteCardRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletCardManagementViewModel$onLoadDeleteCard$1(this.f11971k, this.f11972l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletCardManagementViewModel$onLoadDeleteCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletDeleteCardDisplayModelState> mutableLiveData;
        WalletCardManagementMapper walletCardManagementMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11970j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.f11971k.getDeleteCardData();
            WalletCardManagementMapper walletCardManagementMapper2 = WalletCardManagementMapper.INSTANCE;
            GetDeleteWalletCardUseCase access$getDeleteWalletCardUseCase$p = this.f11971k.deleteWalletCardUseCase;
            WalletDeleteCardRequestModel walletDeleteCardRequestModel = this.f11972l;
            this.f11968h = mutableLiveData;
            this.f11969i = walletCardManagementMapper2;
            this.f11970j = 1;
            Object invoke = access$getDeleteWalletCardUseCase$p.invoke(walletDeleteCardRequestModel, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            walletCardManagementMapper = walletCardManagementMapper2;
            obj = invoke;
        } else if (i11 == 1) {
            walletCardManagementMapper = (WalletCardManagementMapper) this.f11969i;
            mutableLiveData = (MutableLiveData) this.f11968h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
                this.f11971k.getDeleteCardData().setValue(new WalletDeleteCardDisplayModelState.ErrorDeleteCard((WalletDeleteCardErrorResult) null));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(walletCardManagementMapper.mapDeleteCardToDisplayModel((WalletDeleteCardResult) obj));
        return Unit.INSTANCE;
    }
}
