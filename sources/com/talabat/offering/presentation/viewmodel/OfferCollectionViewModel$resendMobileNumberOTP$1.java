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
@DebugMetadata(c = "com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel$resendMobileNumberOTP$1", f = "OfferCollectionViewModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
public final class OfferCollectionViewModel$resendMobileNumberOTP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61146h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionViewModel f61147i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61148j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61149k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ConfigurationLocalRepository f61150l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionViewModel$resendMobileNumberOTP$1(OfferCollectionViewModel offerCollectionViewModel, String str, String str2, ConfigurationLocalRepository configurationLocalRepository, Continuation<? super OfferCollectionViewModel$resendMobileNumberOTP$1> continuation) {
        super(2, continuation);
        this.f61147i = offerCollectionViewModel;
        this.f61148j = str;
        this.f61149k = str2;
        this.f61150l = configurationLocalRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OfferCollectionViewModel$resendMobileNumberOTP$1(this.f61147i, this.f61148j, this.f61149k, this.f61150l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OfferCollectionViewModel$resendMobileNumberOTP$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61146h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SendMobileOTPUseCase access$getSendMobileOTPUseCase$p = this.f61147i.sendMobileOTPUseCase;
            String str = this.f61148j;
            String valueOf = String.valueOf(this.f61147i.getProductIdData().getValue());
            String str2 = this.f61149k;
            ConfigurationLocalRepository configurationLocalRepository = this.f61150l;
            this.f61146h = 1;
            obj = access$getSendMobileOTPUseCase$p.invoke(str, valueOf, str2, configurationLocalRepository, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f61147i.getOtpData().postValue(SendOTPDisplayModelMapper.INSTANCE.mapOTPDisplayData((OTPData) obj, this.f61148j));
        return Unit.INSTANCE;
    }
}
