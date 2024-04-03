package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.viewmodel.mapper.DebitCardBinsDetailDisplayModelMapper;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel$validateQPayBinNumber$1", f = "WalletCardManagementViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
public final class WalletCardManagementViewModel$validateQPayBinNumber$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11979h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementViewModel f11980i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f11981j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementViewModel$validateQPayBinNumber$1(WalletCardManagementViewModel walletCardManagementViewModel, String str, Continuation<? super WalletCardManagementViewModel$validateQPayBinNumber$1> continuation) {
        super(2, continuation);
        this.f11980i = walletCardManagementViewModel;
        this.f11981j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletCardManagementViewModel$validateQPayBinNumber$1(this.f11980i, this.f11981j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletCardManagementViewModel$validateQPayBinNumber$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11979h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DebitCardDeflectionUseCase access$getDebitCardDeflectionUseCase$p = this.f11980i.debitCardDeflectionUseCase;
            String take = StringsKt___StringsKt.take(this.f11981j, 6);
            this.f11979h = 1;
            obj = access$getDebitCardDeflectionUseCase$p.invoke(take, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f11980i.getDebitCardBinVerificationData().postValue(DebitCardBinsDetailDisplayModelMapper.INSTANCE.mapDeflectionInfoDisplayModel((DeflectionInfoDisplayModel) obj));
        this.f11980i.setDebitCardBinAPICalled(false);
        return Unit.INSTANCE;
    }
}
