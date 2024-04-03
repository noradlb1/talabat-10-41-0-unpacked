package com.talabat.offering.presentation.viewmodel;

import com.talabat.offering.domain.entities.OTPData;
import com.talabat.offering.domain.usecases.business.VerifyOTPSubscriptionUseCase;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import com.talabat.offering.presentation.viewmodel.mapper.SendOTPDisplayModelMapper;
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
@DebugMetadata(c = "com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel$verifyOTP$1", f = "OfferCollectionViewModel.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
public final class OfferCollectionViewModel$verifyOTP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61155h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionViewModel f61156i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61157j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionViewModel$verifyOTP$1(OfferCollectionViewModel offerCollectionViewModel, String str, Continuation<? super OfferCollectionViewModel$verifyOTP$1> continuation) {
        super(2, continuation);
        this.f61156i = offerCollectionViewModel;
        this.f61157j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OfferCollectionViewModel$verifyOTP$1(this.f61156i, this.f61157j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OfferCollectionViewModel$verifyOTP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61155h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            VerifyOTPSubscriptionUseCase access$getVerifyOTPSubscriptionUseCase$p = this.f61156i.verifyOTPSubscriptionUseCase;
            OTPDisplayModel value = this.f61156i.getOtpData().getValue();
            if (value != null) {
                String valueOf = String.valueOf(((OTPDisplayModel.OTPData) value).getRequestId());
                String str = this.f61157j;
                this.f61155h = 1;
                obj = access$getVerifyOTPSubscriptionUseCase$p.invoke(valueOf, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.offering.presentation.displaymodel.OTPDisplayModel.OTPData");
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f61156i.getOtpVerification().postValue(SendOTPDisplayModelMapper.INSTANCE.mapOTPVerificationDisplayData((OTPData) obj));
        return Unit.INSTANCE;
    }
}
