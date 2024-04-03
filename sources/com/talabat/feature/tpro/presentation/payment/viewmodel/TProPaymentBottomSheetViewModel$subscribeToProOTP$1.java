package com.talabat.feature.tpro.presentation.payment.viewmodel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel$subscribeToProOTP$1", f = "TProPaymentBottomSheetViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class TProPaymentBottomSheetViewModel$subscribeToProOTP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59378h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetViewModel f59379i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59380j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59381k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f59382l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f59383m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f59384n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetViewModel$subscribeToProOTP$1(TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel, String str, String str2, String str3, String str4, int i11, Continuation<? super TProPaymentBottomSheetViewModel$subscribeToProOTP$1> continuation) {
        super(2, continuation);
        this.f59379i = tProPaymentBottomSheetViewModel;
        this.f59380j = str;
        this.f59381k = str2;
        this.f59382l = str3;
        this.f59383m = str4;
        this.f59384n = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TProPaymentBottomSheetViewModel$subscribeToProOTP$1 tProPaymentBottomSheetViewModel$subscribeToProOTP$1 = new TProPaymentBottomSheetViewModel$subscribeToProOTP$1(this.f59379i, this.f59380j, this.f59381k, this.f59382l, this.f59383m, this.f59384n, continuation);
        tProPaymentBottomSheetViewModel$subscribeToProOTP$1.L$0 = obj;
        return tProPaymentBottomSheetViewModel$subscribeToProOTP$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProPaymentBottomSheetViewModel$subscribeToProOTP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59378h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel = this.f59379i;
            String str = this.f59380j;
            String str2 = this.f59381k;
            String str3 = this.f59382l;
            String str4 = this.f59383m;
            int i12 = this.f59384n;
            Result.Companion companion = Result.Companion;
            SubscriptionPaymentOTPUseCase access$getSubscriptionPaymentOTPUseCase$p = tProPaymentBottomSheetViewModel.subscriptionPaymentOTPUseCase;
            this.f59378h = 1;
            obj = access$getSubscriptionPaymentOTPUseCase$p.invoke(str, str2, str3, str4, i12, this);
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
        obj2 = Result.m6329constructorimpl((SubscriptionOTPPaymentStatus) obj);
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel2 = this.f59379i;
        if (Result.m6336isSuccessimpl(obj2)) {
            tProPaymentBottomSheetViewModel2.getOtpSuccessSubscription$com_talabat_feature_tpro_presentation_presentation().postValue((SubscriptionOTPPaymentStatus) obj2);
        }
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel3 = this.f59379i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tProPaymentBottomSheetViewModel3.getOtpFailureSubscription$com_talabat_feature_tpro_presentation_presentation().postValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
