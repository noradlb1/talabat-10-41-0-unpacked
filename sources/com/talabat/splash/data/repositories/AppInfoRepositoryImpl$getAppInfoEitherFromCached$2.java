package com.talabat.splash.data.repositories;

import com.talabat.splash.core.functional.Either;
import com.talabat.splash.domain.model.AppInfoRequestModel;
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
@DebugMetadata(c = "com.talabat.splash.data.repositories.AppInfoRepositoryImpl$getAppInfoEitherFromCached$2", f = "AppInfoRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppInfoRepositoryImpl$getAppInfoEitherFromCached$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61452h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f61453i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AppInfoRequestModel f61454j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$getAppInfoEitherFromCached$2(AppInfoRepositoryImpl appInfoRepositoryImpl, AppInfoRequestModel appInfoRequestModel, Continuation<? super AppInfoRepositoryImpl$getAppInfoEitherFromCached$2> continuation) {
        super(2, continuation);
        this.f61453i = appInfoRepositoryImpl;
        this.f61454j = appInfoRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppInfoRepositoryImpl$getAppInfoEitherFromCached$2(this.f61453i, this.f61454j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppInfoRepositoryImpl$getAppInfoEitherFromCached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61452h == 0) {
            ResultKt.throwOnFailure(obj);
            Either unused2 = this.f61453i.makeAppInfoRequest(this.f61454j);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
