package com.talabat.userandlocation.appinfo.domain.repo;

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
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepositoryKt$fetchAppInfoCompletable$1", f = "AppInfoRepository.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
public final class AppInfoRepositoryKt$fetchAppInfoCompletable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12202h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepository f12203i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12204j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryKt$fetchAppInfoCompletable$1(AppInfoRepository appInfoRepository, int i11, Continuation<? super AppInfoRepositoryKt$fetchAppInfoCompletable$1> continuation) {
        super(2, continuation);
        this.f12203i = appInfoRepository;
        this.f12204j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppInfoRepositoryKt$fetchAppInfoCompletable$1(this.f12203i, this.f12204j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppInfoRepositoryKt$fetchAppInfoCompletable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12202h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            AppInfoRepository appInfoRepository = this.f12203i;
            int i12 = this.f12204j;
            this.f12202h = 1;
            if (appInfoRepository.fetchAppInfo(i12, this) == coroutine_suspended) {
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
