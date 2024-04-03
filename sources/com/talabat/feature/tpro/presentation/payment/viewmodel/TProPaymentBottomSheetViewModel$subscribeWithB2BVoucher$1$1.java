package com.talabat.feature.tpro.presentation.payment.viewmodel;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1", f = "TProPaymentBottomSheetViewModel.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59385h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetViewModel f59386i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59387j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59388k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f59389l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1(TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel, TProPlanDisplayModel tProPlanDisplayModel, String str, String str2, Continuation<? super TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1> continuation) {
        super(2, continuation);
        this.f59386i = tProPaymentBottomSheetViewModel;
        this.f59387j = tProPlanDisplayModel;
        this.f59388k = str;
        this.f59389l = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1 tProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1 = new TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1(this.f59386i, this.f59387j, this.f59388k, this.f59389l, continuation);
        tProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1.L$0 = obj;
        return tProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59385h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel = this.f59386i;
            TProPlanDisplayModel tProPlanDisplayModel = this.f59387j;
            String str = this.f59388k;
            String str2 = this.f59389l;
            Result.Companion companion = Result.Companion;
            GetSubscriptionWithB2BVoucherUseCase access$getSubscriptionWithB2BVoucherUseCase$p = tProPaymentBottomSheetViewModel.subscriptionWithB2BVoucherUseCase;
            GetSubscriptionWithB2BVoucherUseCase.Params params = new GetSubscriptionWithB2BVoucherUseCase.Params(tProPlanDisplayModel.getPlanId(), str, str2);
            this.f59385h = 1;
            obj = access$getSubscriptionWithB2BVoucherUseCase$p.invoke(params, this);
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
        obj2 = Result.m6329constructorimpl((String) obj);
        TProPlanDisplayModel tProPlanDisplayModel2 = this.f59387j;
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel2 = this.f59386i;
        if (Result.m6336isSuccessimpl(obj2) && Intrinsics.areEqual((Object) (String) obj2, (Object) tProPlanDisplayModel2.getPlanId())) {
            tProPaymentBottomSheetViewModel2.getSubscribedToB2b$com_talabat_feature_tpro_presentation_presentation().postValue(Boxing.boxBoolean(true));
        }
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel3 = this.f59386i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tProPaymentBottomSheetViewModel3.getFailedSubscription$com_talabat_feature_tpro_presentation_presentation().postValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
