package com.talabat.userandlocation.appinfo.data.impl;

import JsonModels.Response.AppInitRM;
import com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepositoryException;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LJsonModels/Response/AppInitRM;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchAppInfoAsync$1", f = "AppInfoRepositoryImpl.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class AppInfoRepositoryImpl$fetchAppInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppInitRM>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12186h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12187i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12188j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$fetchAppInfoAsync$1(AppInfoRepositoryImpl appInfoRepositoryImpl, int i11, Continuation<? super AppInfoRepositoryImpl$fetchAppInfoAsync$1> continuation) {
        super(2, continuation);
        this.f12187i = appInfoRepositoryImpl;
        this.f12188j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AppInfoRepositoryImpl$fetchAppInfoAsync$1 appInfoRepositoryImpl$fetchAppInfoAsync$1 = new AppInfoRepositoryImpl$fetchAppInfoAsync$1(this.f12187i, this.f12188j, continuation);
        appInfoRepositoryImpl$fetchAppInfoAsync$1.L$0 = obj;
        return appInfoRepositoryImpl$fetchAppInfoAsync$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AppInitRM> continuation) {
        return ((AppInfoRepositoryImpl$fetchAppInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12186h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AppInfoRepositoryImpl appInfoRepositoryImpl = this.f12187i;
            int i12 = this.f12188j;
            Result.Companion companion = Result.Companion;
            AppInfoRemoteDataSource access$getAppInfoRemoteDataSource$p = appInfoRepositoryImpl.appInfoRemoteDataSource;
            this.f12186h = 1;
            obj = access$getAppInfoRemoteDataSource$p.getAppInfo(i12, this);
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
        obj2 = Result.m6329constructorimpl((AppInitRM) obj);
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj2);
        if (r02 == null) {
            return obj2;
        }
        throw new AppInfoRepositoryException(r02);
    }
}
