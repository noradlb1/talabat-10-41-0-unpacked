package com.talabat.splash.data.repositories;

import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.data.repositories.SplashCustomerInfoRepositoryImp$getCustomerInfo$3", f = "SplashCustomerInfoRepositoryImp.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class SplashCustomerInfoRepositoryImp$getCustomerInfo$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61464h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashCustomerInfoRepositoryImp f61465i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Params f61466j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashCustomerInfoRepositoryImp$getCustomerInfo$3(SplashCustomerInfoRepositoryImp splashCustomerInfoRepositoryImp, Params params, Continuation<? super SplashCustomerInfoRepositoryImp$getCustomerInfo$3> continuation) {
        super(1, continuation);
        this.f61465i = splashCustomerInfoRepositoryImp;
        this.f61466j = params;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new SplashCustomerInfoRepositoryImp$getCustomerInfo$3(this.f61465i, this.f61466j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((SplashCustomerInfoRepositoryImp$getCustomerInfo$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61464h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerInfoRepository access$getCustomerInfoRepository$p = this.f61465i.customerInfoRepository;
            int countryId = this.f61466j.getCountryId();
            this.f61464h = 1;
            if (access$getCustomerInfoRepository$p.fetchCustomerInfo(countryId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
