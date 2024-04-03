package com.talabat.userandlocation.appinfo.data.impl;

import JsonModels.Response.AppInitRM;
import com.talabat.domain.address.Address;
import datamodels.CustomerInfo;
import java.util.List;
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
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$cacheApplicationInformation$2", f = "AppInfoRepositoryImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class AppInfoRepositoryImpl$cacheApplicationInformation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12174h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12175i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AppInitRM f12176j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<Address> f12177k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CustomerInfo f12178l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$cacheApplicationInformation$2(AppInfoRepositoryImpl appInfoRepositoryImpl, AppInitRM appInitRM, List<Address> list, CustomerInfo customerInfo, Continuation<? super AppInfoRepositoryImpl$cacheApplicationInformation$2> continuation) {
        super(2, continuation);
        this.f12175i = appInfoRepositoryImpl;
        this.f12176j = appInitRM;
        this.f12177k = list;
        this.f12178l = customerInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AppInfoRepositoryImpl$cacheApplicationInformation$2 appInfoRepositoryImpl$cacheApplicationInformation$2 = new AppInfoRepositoryImpl$cacheApplicationInformation$2(this.f12175i, this.f12176j, this.f12177k, this.f12178l, continuation);
        appInfoRepositoryImpl$cacheApplicationInformation$2.L$0 = obj;
        return appInfoRepositoryImpl$cacheApplicationInformation$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppInfoRepositoryImpl$cacheApplicationInformation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f12174h
            r2 = 1
            if (r1 == 0) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            java.lang.Object r0 = r6.L$0
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = (library.talabat.mvp.login.domain.repository.CustomerRepository) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0013 }
            goto L_0x0071
        L_0x0013:
            r7 = move-exception
            goto L_0x007c
        L_0x0015:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r6.f12175i
            JsonModels.Response.AppInitRM r1 = r6.f12176j
            JsonModels.AppInitResponse r1 = r1.result
            java.lang.String r3 = "appInitResponse.result"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            JsonModels.Response.AppInitRM r3 = r6.f12176j
            java.lang.String r3 = r3.baseUrl
            java.lang.String r4 = "appInitResponse.baseUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r7.cacheApplicationInformation(r1, r3)
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r6.f12175i
            library.talabat.mvp.login.domain.repository.CustomerRepository r7 = r7.customerRepository
            java.util.List<com.talabat.domain.address.Address> r1 = r6.f12177k
            if (r1 != 0) goto L_0x004f
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r1 = r6.f12175i
            com.talabat.configuration.MutableLocationConfigurationRepository r1 = r1.mutableLocationConfigRepository
            java.util.List r1 = r1.addresses()
        L_0x004f:
            r7.setCustomerAddresses(r1)
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r7 = r6.f12175i
            library.talabat.mvp.login.domain.repository.CustomerRepository r7 = r7.customerRepository
            datamodels.CustomerInfo r1 = r6.f12178l
            if (r1 != 0) goto L_0x0091
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r1 = r6.f12175i
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0078 }
            com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r1 = r1.customerInfoRepository     // Catch:{ all -> 0x0078 }
            r6.L$0 = r7     // Catch:{ all -> 0x0078 }
            r6.f12174h = r2     // Catch:{ all -> 0x0078 }
            java.lang.Object r1 = r1.getCachedCustomerInfo(r6)     // Catch:{ all -> 0x0078 }
            if (r1 != r0) goto L_0x006f
            return r0
        L_0x006f:
            r0 = r7
            r7 = r1
        L_0x0071:
            datamodels.CustomerInfo r7 = (datamodels.CustomerInfo) r7     // Catch:{ all -> 0x0013 }
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)     // Catch:{ all -> 0x0013 }
            goto L_0x0086
        L_0x0078:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x007c:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)
        L_0x0086:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r7)
            if (r1 == 0) goto L_0x008d
            r7 = 0
        L_0x008d:
            r1 = r7
            datamodels.CustomerInfo r1 = (datamodels.CustomerInfo) r1
            r7 = r0
        L_0x0091:
            r7.saveCustomerInfo(r1)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$cacheApplicationInformation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
