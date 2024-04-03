package com.talabat.splash.domain.usecase;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
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

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAppInfoUseCase$getAppInfoAsync$1", f = "GetAppInfoUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GetAppInfoUseCase$getAppInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends AppInfoResponseWrapper>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61472h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetAppInfoUseCase f61473i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AppInfoRequestModel f61474j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAppInfoUseCase$getAppInfoAsync$1(GetAppInfoUseCase getAppInfoUseCase, AppInfoRequestModel appInfoRequestModel, Continuation<? super GetAppInfoUseCase$getAppInfoAsync$1> continuation) {
        super(2, continuation);
        this.f61473i = getAppInfoUseCase;
        this.f61474j = appInfoRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetAppInfoUseCase$getAppInfoAsync$1(this.f61473i, this.f61474j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Either<? extends Failure, AppInfoResponseWrapper>> continuation) {
        return ((GetAppInfoUseCase$getAppInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61472h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f61473i.appInfoRepository.getAppInfo(this.f61474j);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
