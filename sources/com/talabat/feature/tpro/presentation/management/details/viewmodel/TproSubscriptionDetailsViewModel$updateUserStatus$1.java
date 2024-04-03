package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$updateUserStatus$1", f = "TproSubscriptionDetailsViewModel.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
public final class TproSubscriptionDetailsViewModel$updateUserStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59349h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f59350i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59351j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionDetailsViewModel$updateUserStatus$1(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, String str, Continuation<? super TproSubscriptionDetailsViewModel$updateUserStatus$1> continuation) {
        super(2, continuation);
        this.f59350i = tproSubscriptionDetailsViewModel;
        this.f59351j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproSubscriptionDetailsViewModel$updateUserStatus$1 tproSubscriptionDetailsViewModel$updateUserStatus$1 = new TproSubscriptionDetailsViewModel$updateUserStatus$1(this.f59350i, this.f59351j, continuation);
        tproSubscriptionDetailsViewModel$updateUserStatus$1.L$0 = obj;
        return tproSubscriptionDetailsViewModel$updateUserStatus$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproSubscriptionDetailsViewModel$updateUserStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59349h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel = this.f59350i;
            Result.Companion companion = Result.Companion;
            ProCentralizationStatusWrapper access$getGetProCentralizationStatusWrapper$p = tproSubscriptionDetailsViewModel.getProCentralizationStatusWrapper;
            CountryParams countryParams = new CountryParams(tproSubscriptionDetailsViewModel.configurationLocalRepository.selectedCountry());
            this.f59349h = 1;
            obj = access$getGetProCentralizationStatusWrapper$p.single(countryParams, this);
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
        obj2 = Result.m6329constructorimpl((ProCentralization) obj);
        String str = this.f59351j;
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel2 = this.f59350i;
        if (Result.m6336isSuccessimpl(obj2)) {
            ProCentralization proCentralization = (ProCentralization) obj2;
            tproSubscriptionDetailsViewModel2._postUpdatingStatus.postValue(Boxing.boxBoolean(Intrinsics.areEqual((Object) str, (Object) "success_updated")));
        }
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel3 = this.f59350i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tproSubscriptionDetailsViewModel3._postUpdatingStatus.postValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
