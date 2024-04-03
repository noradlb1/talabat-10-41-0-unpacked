package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModelImpl$setDefaultCard$1", f = "CardViewWidgetsViewModelImpl.kt", i = {0, 0}, l = {171}, m = "invokeSuspend", n = {"firstCard", "defaultPosition"}, s = {"L$0", "I$0"})
public final class CardViewWidgetsViewModelImpl$setDefaultCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11905h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11906i;

    /* renamed from: j  reason: collision with root package name */
    public int f11907j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WalletCardListDisplayModel f11908k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CardViewWidgetsViewModelImpl f11909l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardViewWidgetsViewModelImpl$setDefaultCard$1(WalletCardListDisplayModel walletCardListDisplayModel, CardViewWidgetsViewModelImpl cardViewWidgetsViewModelImpl, Continuation<? super CardViewWidgetsViewModelImpl$setDefaultCard$1> continuation) {
        super(2, continuation);
        this.f11908k = walletCardListDisplayModel;
        this.f11909l = cardViewWidgetsViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CardViewWidgetsViewModelImpl$setDefaultCard$1(this.f11908k, this.f11909l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CardViewWidgetsViewModelImpl$setDefaultCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        WalletCardDisplayModel walletCardDisplayModel;
        int i11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = this.f11907j;
        int i13 = 0;
        if (i12 == 0) {
            ResultKt.throwOnFailure(obj);
            List<WalletCardDisplayModel> cardList = this.f11908k.getCardList();
            if (!cardList.isEmpty()) {
                walletCardDisplayModel = cardList.get(0);
                if (!Intrinsics.areEqual((Object) this.f11909l.source, (Object) "tpro")) {
                    DebitCardDeflectionUseCase access$getDebitCardDeflectionUseCase$p = this.f11909l.debitCardDeflectionUseCase;
                    String binNumber = walletCardDisplayModel.getBinNumber();
                    this.f11906i = walletCardDisplayModel;
                    this.f11905h = 0;
                    this.f11907j = 1;
                    obj = access$getDebitCardDeflectionUseCase$p.invoke(binNumber, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i11 = 0;
                }
                this.f11909l.isPaymentMethodAvailable().postValue(Boxing.boxBoolean(true));
                this.f11909l.getSelectedCard().postValue(walletCardDisplayModel);
                this.f11908k.setSelectedPosition(i13);
                this.f11909l.getLoadingCardStatus().postValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            this.f11909l.isPaymentMethodAvailable().postValue(Boxing.boxBoolean(false));
            this.f11909l.getLoadingCardStatus().postValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        } else if (i12 == 1) {
            i11 = this.f11905h;
            walletCardDisplayModel = (WalletCardDisplayModel) this.f11906i;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!Intrinsics.areEqual((Object) (DeflectionInfoDisplayModel) obj, (Object) DeflectionInfoDisplayModel.Hidden.INSTANCE)) {
            walletCardDisplayModel.setSupported(false);
        }
        i13 = i11;
        this.f11909l.isPaymentMethodAvailable().postValue(Boxing.boxBoolean(true));
        this.f11909l.getSelectedCard().postValue(walletCardDisplayModel);
        this.f11908k.setSelectedPosition(i13);
        this.f11909l.getLoadingCardStatus().postValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
