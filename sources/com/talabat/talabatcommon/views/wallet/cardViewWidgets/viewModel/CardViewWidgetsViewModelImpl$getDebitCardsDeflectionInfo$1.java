package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import java.util.List;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1", f = "CardViewWidgetsViewModelImpl.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11901h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CardViewWidgetsViewModelImpl f11902i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<WalletCardDisplayModel> f11903j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1(CardViewWidgetsViewModelImpl cardViewWidgetsViewModelImpl, List<WalletCardDisplayModel> list, Continuation<? super CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1> continuation) {
        super(2, continuation);
        this.f11902i = cardViewWidgetsViewModelImpl;
        this.f11903j = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1(this.f11902i, this.f11903j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11901h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DebitCardDeflectionUseCase access$getDebitCardDeflectionUseCase$p = this.f11902i.debitCardDeflectionUseCase;
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.f11903j, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1$deflectionInfoDisplayModel$1.INSTANCE, 30, (Object) null);
            this.f11901h = 1;
            obj = access$getDebitCardDeflectionUseCase$p.invoke(joinToString$default, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f11902i.getDeflectionInfoDisplayModelData().setValue((DeflectionInfoDisplayModel) obj);
        return Unit.INSTANCE;
    }
}
