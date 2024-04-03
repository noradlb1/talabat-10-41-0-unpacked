package com.talabat.splash.domain.usecase;

import com.talabat.splash.data.repositories.Params;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import datamodels.CustomerInfo;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ldatamodels/CustomerInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCustomerInfoAsync$1", f = "GetAppInfoUseCase.kt", i = {}, l = {137, 133}, m = "invokeSuspend", n = {}, s = {})
public final class GetAppInfoUseCase$getCustomerInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CustomerInfo>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public boolean f61478h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61479i;

    /* renamed from: j  reason: collision with root package name */
    public int f61480j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetAppInfoUseCase f61481k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f61482l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAppInfoUseCase$getCustomerInfoAsync$1(GetAppInfoUseCase getAppInfoUseCase, int i11, Continuation<? super GetAppInfoUseCase$getCustomerInfoAsync$1> continuation) {
        super(2, continuation);
        this.f61481k = getAppInfoUseCase;
        this.f61482l = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetAppInfoUseCase$getCustomerInfoAsync$1(this.f61481k, this.f61482l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CustomerInfo> continuation) {
        return ((GetAppInfoUseCase$getCustomerInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SplashCustomerInfoRepository splashCustomerInfoRepository;
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61480j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SplashCustomerInfoRepository access$getSplashCustomerInfoRepository$p = this.f61481k.splashCustomerInfoRepository;
            z11 = this.f61481k.customerRepository.isLoggedIn();
            GetAppInfoUseCase getAppInfoUseCase = this.f61481k;
            this.f61479i = access$getSplashCustomerInfoRepository$p;
            this.f61478h = z11;
            this.f61480j = 1;
            Object access$getCachedCustomerInfo = getAppInfoUseCase.getCachedCustomerInfo(this);
            if (access$getCachedCustomerInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = access$getCachedCustomerInfo;
            splashCustomerInfoRepository = access$getSplashCustomerInfoRepository$p;
            obj = obj2;
        } else if (i11 == 1) {
            z11 = this.f61478h;
            splashCustomerInfoRepository = (SplashCustomerInfoRepository) this.f61479i;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Params params = new Params(this.f61482l, (CustomerInfo) obj, z11);
        this.f61479i = null;
        this.f61480j = 2;
        obj = splashCustomerInfoRepository.getCustomerInfo(params, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return obj;
    }
}
