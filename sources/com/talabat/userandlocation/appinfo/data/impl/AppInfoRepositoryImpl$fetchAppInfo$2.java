package com.talabat.userandlocation.appinfo.data.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchAppInfo$2", f = "AppInfoRepositoryImpl.kt", i = {0, 0, 1, 1, 2, 2}, l = {63, 67, 70, 73}, m = "invokeSuspend", n = {"$this$withContext", "deferredAddresses", "deferredAddresses", "appInitResponse", "appInitResponse", "customerInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class AppInfoRepositoryImpl$fetchAppInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f12182h;

    /* renamed from: i  reason: collision with root package name */
    public int f12183i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12184j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12185k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$fetchAppInfo$2(int i11, AppInfoRepositoryImpl appInfoRepositoryImpl, Continuation<? super AppInfoRepositoryImpl$fetchAppInfo$2> continuation) {
        super(2, continuation);
        this.f12184j = i11;
        this.f12185k = appInfoRepositoryImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AppInfoRepositoryImpl$fetchAppInfo$2 appInfoRepositoryImpl$fetchAppInfo$2 = new AppInfoRepositoryImpl$fetchAppInfo$2(this.f12184j, this.f12185k, continuation);
        appInfoRepositoryImpl$fetchAppInfo$2.L$0 = obj;
        return appInfoRepositoryImpl$fetchAppInfo$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppInfoRepositoryImpl$fetchAppInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00de A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f12183i
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0048
            if (r1 == r5) goto L_0x003c
            if (r1 == r4) goto L_0x002f
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00df
        L_0x001a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0022:
            java.lang.Object r1 = r10.f12182h
            datamodels.CustomerInfo r1 = (datamodels.CustomerInfo) r1
            java.lang.Object r3 = r10.L$0
            JsonModels.Response.AppInitRM r3 = (JsonModels.Response.AppInitRM) r3
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c5
        L_0x002f:
            java.lang.Object r1 = r10.f12182h
            JsonModels.Response.AppInitRM r1 = (JsonModels.Response.AppInitRM) r1
            java.lang.Object r4 = r10.L$0
            kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ac
        L_0x003c:
            java.lang.Object r1 = r10.f12182h
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0085
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            int r1 = r10.f12184j
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "[ALOVx]: fetchAppInfo "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            com.talabat.talabatcore.logger.LogManager.debug(r1)
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r1 = r10.f12185k
            int r7 = r10.f12184j
            kotlinx.coroutines.Deferred r1 = r1.fetchAppInfoAsync(r11, r7)
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r10.f12185k
            int r8 = r10.f12184j
            kotlinx.coroutines.Deferred r7 = r7.fetchAddressesAsync(r11, r8)
            r10.L$0 = r11
            r10.f12182h = r7
            r10.f12183i = r5
            java.lang.Object r1 = r1.await(r10)
            if (r1 != r0) goto L_0x0082
            return r0
        L_0x0082:
            r5 = r11
            r11 = r1
            r1 = r7
        L_0x0085:
            JsonModels.Response.AppInitRM r11 = (JsonModels.Response.AppInitRM) r11
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r10.f12185k
            library.talabat.mvp.login.domain.repository.CustomerRepository r7 = r7.customerRepository
            boolean r7 = r7.isLoggedIn()
            if (r7 == 0) goto L_0x00b2
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r10.f12185k
            int r8 = r10.f12184j
            kotlinx.coroutines.Deferred r5 = r7.getCustomerInfoWithRetryAsync(r5, r8)
            r10.L$0 = r1
            r10.f12182h = r11
            r10.f12183i = r4
            java.lang.Object r4 = r5.await(r10)
            if (r4 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r9 = r1
            r1 = r11
            r11 = r4
            r4 = r9
        L_0x00ac:
            datamodels.CustomerInfo r11 = (datamodels.CustomerInfo) r11
            r9 = r4
            r4 = r1
            r1 = r9
            goto L_0x00b4
        L_0x00b2:
            r4 = r11
            r11 = r6
        L_0x00b4:
            r10.L$0 = r4
            r10.f12182h = r11
            r10.f12183i = r3
            java.lang.Object r1 = r1.await(r10)
            if (r1 != r0) goto L_0x00c1
            return r0
        L_0x00c1:
            r3 = r4
            r9 = r1
            r1 = r11
            r11 = r9
        L_0x00c5:
            java.util.List r11 = (java.util.List) r11
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r4 = r10.f12185k
            com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource r4 = r4.appInfoLocalDataSource
            r4.invalidateAppInfoCash()
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r4 = r10.f12185k
            r10.L$0 = r6
            r10.f12182h = r6
            r10.f12183i = r2
            java.lang.Object r11 = r4.cacheApplicationInformation(r3, r11, r1, r10)
            if (r11 != r0) goto L_0x00df
            return r0
        L_0x00df:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchAppInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
