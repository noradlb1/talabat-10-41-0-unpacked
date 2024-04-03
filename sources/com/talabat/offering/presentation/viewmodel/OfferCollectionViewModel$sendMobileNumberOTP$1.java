package com.talabat.offering.presentation.viewmodel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.domain.entities.OTPData;
import com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase;
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
@DebugMetadata(c = "com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel$sendMobileNumberOTP$1", f = "OfferCollectionViewModel.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class OfferCollectionViewModel$sendMobileNumberOTP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61151h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionViewModel f61152i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61153j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ConfigurationLocalRepository f61154k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionViewModel$sendMobileNumberOTP$1(OfferCollectionViewModel offerCollectionViewModel, String str, ConfigurationLocalRepository configurationLocalRepository, Continuation<? super OfferCollectionViewModel$sendMobileNumberOTP$1> continuation) {
        super(2, continuation);
        this.f61152i = offerCollectionViewModel;
        this.f61153j = str;
        this.f61154k = configurationLocalRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OfferCollectionViewModel$sendMobileNumberOTP$1(this.f61152i, this.f61153j, this.f61154k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OfferCollectionViewModel$sendMobileNumberOTP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61151h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SendMobileOTPUseCase access$getSendMobileOTPUseCase$p = this.f61152i.sendMobileOTPUseCase;
            String str = this.f61153j;
            String valueOf = String.valueOf(this.f61152i.getProductIdData().getValue());
            ConfigurationLocalRepository configurationLocalRepository = this.f61154k;
            this.f61151h = 1;
            obj = SendMobileOTPUseCase.invoke$default(access$getSendMobileOTPUseCase$p, str, valueOf, (String) null, configurationLocalRepository, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f61152i.getOtpData().postValue(SendOTPDisplayModelMapper.INSTANCE.mapOTPDisplayData((OTPData) obj, this.f61153j));
        return Unit.INSTANCE;
    }
}
