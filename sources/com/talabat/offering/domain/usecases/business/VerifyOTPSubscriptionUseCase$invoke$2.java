package com.talabat.offering.domain.usecases.business;

import com.talabat.offering.data.remote.dtos.OTPCodeModelDto;
import com.talabat.offering.domain.entities.OTPData;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/offering/domain/entities/OTPData;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.offering.domain.usecases.business.VerifyOTPSubscriptionUseCase$invoke$2", f = "VerifyOTPSubscriptionUseCase.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyOTPSubscriptionUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OTPData>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61133i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VerifyOTPSubscriptionUseCase f61134j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61135k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyOTPSubscriptionUseCase$invoke$2(String str, VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase, String str2, Continuation<? super VerifyOTPSubscriptionUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61133i = str;
        this.f61134j = verifyOTPSubscriptionUseCase;
        this.f61135k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VerifyOTPSubscriptionUseCase$invoke$2 verifyOTPSubscriptionUseCase$invoke$2 = new VerifyOTPSubscriptionUseCase$invoke$2(this.f61133i, this.f61134j, this.f61135k, continuation);
        verifyOTPSubscriptionUseCase$invoke$2.L$0 = obj;
        return verifyOTPSubscriptionUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super OTPData> continuation) {
        return ((VerifyOTPSubscriptionUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61132h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String str = this.f61133i;
            VerifyOTPSubscriptionUseCase verifyOTPSubscriptionUseCase = this.f61134j;
            String str2 = this.f61135k;
            Result.Companion companion = Result.Companion;
            OTPCodeModelDto oTPCodeModelDto = new OTPCodeModelDto(str);
            OfferCollectionRepo access$getOfferCollectionRepo$p = verifyOTPSubscriptionUseCase.offerCollectionRepo;
            this.f61132h = 1;
            obj = access$getOfferCollectionRepo$p.verifyOTP(str2, oTPCodeModelDto, this);
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
        obj2 = Result.m6329constructorimpl((OTPData) obj);
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        return new OTPData((Long) null, (String) null, (Boolean) null, (Integer) null, (String) null, 31, (DefaultConstructorMarker) null);
    }
}
