package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.feature.walletCardManagement.GetSetWalletDefaultCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardManagementMapper;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletSetDefaultCardDisplayModelState;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel$onLoadSetDefaultCard$1", f = "WalletCardManagementViewModel.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class WalletCardManagementViewModel$onLoadSetDefaultCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f11973h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11974i;

    /* renamed from: j  reason: collision with root package name */
    public int f11975j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementViewModel f11976k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WalletSetDefaultCardRequestModel f11977l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementViewModel$onLoadSetDefaultCard$1(WalletCardManagementViewModel walletCardManagementViewModel, WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel, Continuation<? super WalletCardManagementViewModel$onLoadSetDefaultCard$1> continuation) {
        super(2, continuation);
        this.f11976k = walletCardManagementViewModel;
        this.f11977l = walletSetDefaultCardRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletCardManagementViewModel$onLoadSetDefaultCard$1(this.f11976k, this.f11977l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletCardManagementViewModel$onLoadSetDefaultCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletSetDefaultCardDisplayModelState> mutableLiveData;
        WalletCardManagementMapper walletCardManagementMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11975j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.f11976k.getSetDefaultCardData();
            WalletCardManagementMapper walletCardManagementMapper2 = WalletCardManagementMapper.INSTANCE;
            GetSetWalletDefaultCardUseCase access$getSetWalletDefaultCardUseCase$p = this.f11976k.setWalletDefaultCardUseCase;
            WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel = this.f11977l;
            this.f11973h = mutableLiveData;
            this.f11974i = walletCardManagementMapper2;
            this.f11975j = 1;
            Object invoke = access$getSetWalletDefaultCardUseCase$p.invoke(walletSetDefaultCardRequestModel, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            walletCardManagementMapper = walletCardManagementMapper2;
            obj = invoke;
        } else if (i11 == 1) {
            walletCardManagementMapper = (WalletCardManagementMapper) this.f11974i;
            mutableLiveData = (MutableLiveData) this.f11973h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
                this.f11976k.getSetDefaultCardData().setValue(WalletSetDefaultCardDisplayModelState.ErrorSetDefaultCard.INSTANCE);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(walletCardManagementMapper.mapSetDefaultCardToDisplayModel((WalletSetDefaultCardResult) obj));
        return Unit.INSTANCE;
    }
}
