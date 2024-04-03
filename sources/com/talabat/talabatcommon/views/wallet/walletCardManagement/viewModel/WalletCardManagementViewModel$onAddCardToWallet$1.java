package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetAddCardToWalletUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardErrorState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardManagementMapper;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardModel;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel$onAddCardToWallet$1", f = "WalletCardManagementViewModel.kt", i = {}, l = {166, 182}, m = "invokeSuspend", n = {}, s = {})
public final class WalletCardManagementViewModel$onAddCardToWallet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f11962h;

    /* renamed from: i  reason: collision with root package name */
    public int f11963i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementViewModel f11964j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WalletCardModel f11965k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementViewModel$onAddCardToWallet$1(WalletCardManagementViewModel walletCardManagementViewModel, WalletCardModel walletCardModel, Continuation<? super WalletCardManagementViewModel$onAddCardToWallet$1> continuation) {
        super(2, continuation);
        this.f11964j = walletCardManagementViewModel;
        this.f11965k = walletCardModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WalletCardManagementViewModel$onAddCardToWallet$1 walletCardManagementViewModel$onAddCardToWallet$1 = new WalletCardManagementViewModel$onAddCardToWallet$1(this.f11964j, this.f11965k, continuation);
        walletCardManagementViewModel$onAddCardToWallet$1.L$0 = obj;
        return walletCardManagementViewModel$onAddCardToWallet$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletCardManagementViewModel$onAddCardToWallet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<WalletAddCardDisplayModelState> mutableLiveData;
        WalletCardManagementMapper walletCardManagementMapper;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11963i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            WalletCardManagementViewModel walletCardManagementViewModel = this.f11964j;
            WalletCardModel walletCardModel = this.f11965k;
            Result.Companion companion = Result.Companion;
            GenerateCardTokenUseCase access$getGenerateCardTokenUseCase$p = walletCardManagementViewModel.generateCardTokenUseCase;
            TokenizationCard tokenizationCard = new TokenizationCard(walletCardModel.getCardNumber(), walletCardModel.getHolderName(), walletCardModel.getMonth(), walletCardModel.getYear(), walletCardModel.getCvv());
            GenerateCardTokenUseCase.UseCase useCase = GenerateCardTokenUseCase.UseCase.WALLET;
            this.f11963i = 1;
            obj = GenerateCardTokenUseCase.invoke$default(access$getGenerateCardTokenUseCase$p, tokenizationCard, useCase, (Integer) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else if (i11 == 2) {
            walletCardManagementMapper = (WalletCardManagementMapper) this.f11962h;
            mutableLiveData = (MutableLiveData) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutableLiveData.setValue(walletCardManagementMapper.mapWalletAddCardToDisplayModel((WalletAddCardResponse) obj));
            } catch (Exception unused) {
                this.f11964j.getAddCardToWalletData().setValue(new WalletAddCardDisplayModelState.ErrorWalletAddCard(WalletAddCardErrorState.API_SERVICE_ERROR));
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((String) obj);
        if (Result.m6335isFailureimpl(obj2)) {
            obj2 = null;
        }
        String str = (String) obj2;
        if (str == null) {
            this.f11964j.getAddCardToWalletData().setValue(new WalletAddCardDisplayModelState.ErrorWalletAddCard(WalletAddCardErrorState.INVALID_INPUT));
            return Unit.INSTANCE;
        }
        mutableLiveData = this.f11964j.getAddCardToWalletData();
        WalletCardManagementMapper walletCardManagementMapper2 = WalletCardManagementMapper.INSTANCE;
        GetAddCardToWalletUseCase access$getAddCardToWalletUseCase$p = this.f11964j.addCardToWalletUseCase;
        IntegrationGlobalDataModel.Companion companion3 = IntegrationGlobalDataModel.Companion;
        WalletAddCardRequestModel walletAddCardRequestModel = new WalletAddCardRequestModel(str, String.valueOf(companion3.selectedCountryCode()), companion3.selectedLanguage(), this.f11965k.getBinNumber());
        this.L$0 = mutableLiveData;
        this.f11962h = walletCardManagementMapper2;
        this.f11963i = 2;
        obj = access$getAddCardToWalletUseCase$p.invoke(walletAddCardRequestModel, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        walletCardManagementMapper = walletCardManagementMapper2;
        mutableLiveData.setValue(walletCardManagementMapper.mapWalletAddCardToDisplayModel((WalletAddCardResponse) obj));
        return Unit.INSTANCE;
    }
}
