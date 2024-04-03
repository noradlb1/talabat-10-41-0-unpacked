package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$getSavingsInfo$1", f = "TproSubscriptionDetailsViewModel.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
public final class TproSubscriptionDetailsViewModel$getSavingsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59337h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f59338i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionDetailsViewModel$getSavingsInfo$1(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, Continuation<? super TproSubscriptionDetailsViewModel$getSavingsInfo$1> continuation) {
        super(2, continuation);
        this.f59338i = tproSubscriptionDetailsViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproSubscriptionDetailsViewModel$getSavingsInfo$1 tproSubscriptionDetailsViewModel$getSavingsInfo$1 = new TproSubscriptionDetailsViewModel$getSavingsInfo$1(this.f59338i, continuation);
        tproSubscriptionDetailsViewModel$getSavingsInfo$1.L$0 = obj;
        return tproSubscriptionDetailsViewModel$getSavingsInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproSubscriptionDetailsViewModel$getSavingsInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59337h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel = this.f59338i;
            Result.Companion companion = Result.Companion;
            tproSubscriptionDetailsViewModel.isSavingsDataLoaded.setValue(Boxing.boxBoolean(false));
            GetSavingsInfoUseCase access$getGetSavingsInfoUseCase$p = tproSubscriptionDetailsViewModel.getSavingsInfoUseCase;
            GetSavingsInfoUseCase.Params params = new GetSavingsInfoUseCase.Params(tproSubscriptionDetailsViewModel.configurationLocalRepository.selectedCountry().getCountryId());
            this.f59337h = 1;
            obj = access$getGetSavingsInfoUseCase$p.invoke(params, this);
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
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((SubscriptionSavingsInfo) obj);
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel2 = this.f59338i;
        if (Result.m6336isSuccessimpl(obj2)) {
            tproSubscriptionDetailsViewModel2._subscriptionsSaving.setValue((SubscriptionSavingsInfo) obj2);
            tproSubscriptionDetailsViewModel2.isSavingsDataLoaded.setValue(Boxing.boxBoolean(true));
        }
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel3 = this.f59338i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tproSubscriptionDetailsViewModel3._subscriptionsSaving.setValue(null);
            tproSubscriptionDetailsViewModel3.isSavingsDataLoaded.setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
