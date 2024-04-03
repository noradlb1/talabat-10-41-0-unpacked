package com.talabat.userandlocation.customerinfo.data.impl;

import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ldatamodels/CustomerInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl$fetchCustomerInfo$2", f = "CustomerInfoRepositoryImpl.kt", i = {1}, l = {26, 29}, m = "invokeSuspend", n = {"customerInfo"}, s = {"L$0"})
public final class CustomerInfoRepositoryImpl$fetchCustomerInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CustomerInfo>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12328h;

    /* renamed from: i  reason: collision with root package name */
    public int f12329i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CustomerInfoRepositoryImpl f12330j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12331k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerInfoRepositoryImpl$fetchCustomerInfo$2(CustomerInfoRepositoryImpl customerInfoRepositoryImpl, int i11, Continuation<? super CustomerInfoRepositoryImpl$fetchCustomerInfo$2> continuation) {
        super(2, continuation);
        this.f12330j = customerInfoRepositoryImpl;
        this.f12331k = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CustomerInfoRepositoryImpl$fetchCustomerInfo$2 customerInfoRepositoryImpl$fetchCustomerInfo$2 = new CustomerInfoRepositoryImpl$fetchCustomerInfo$2(this.f12330j, this.f12331k, continuation);
        customerInfoRepositoryImpl$fetchCustomerInfo$2.L$0 = obj;
        return customerInfoRepositoryImpl$fetchCustomerInfo$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CustomerInfo> continuation) {
        return ((CustomerInfoRepositoryImpl$fetchCustomerInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f12329i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r7.L$0
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0073 }
            goto L_0x0067
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            int r1 = r7.f12328h
            java.lang.Object r3 = r7.L$0
            com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl r3 = (com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl) r3
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0073 }
            goto L_0x0049
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl r8 = r7.f12330j
            int r1 = r7.f12331k
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0073 }
            com.talabat.userandlocation.customerinfo.data.remote.CustomerInfoRemoteDataSource r4 = r8.customerInfoRemoteDataSource     // Catch:{ all -> 0x0073 }
            r7.L$0 = r8     // Catch:{ all -> 0x0073 }
            r7.f12328h = r1     // Catch:{ all -> 0x0073 }
            r7.f12329i = r3     // Catch:{ all -> 0x0073 }
            java.lang.Object r3 = r4.getCustomerInfo(r1, r7)     // Catch:{ all -> 0x0073 }
            if (r3 != r0) goto L_0x0046
            return r0
        L_0x0046:
            r6 = r3
            r3 = r8
            r8 = r6
        L_0x0049:
            datamodels.CustomerInfo r8 = (datamodels.CustomerInfo) r8     // Catch:{ all -> 0x0073 }
            com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper r3 = r3.proCentralizationStatusWrapper     // Catch:{ all -> 0x0073 }
            com.talabat.feature.subscriptions.domain.model.CountryParams r4 = new com.talabat.feature.subscriptions.domain.model.CountryParams     // Catch:{ all -> 0x0073 }
            com.talabat.configuration.country.Country$Companion r5 = com.talabat.configuration.country.Country.Companion     // Catch:{ all -> 0x0073 }
            com.talabat.configuration.country.Country r1 = r5.from(r1)     // Catch:{ all -> 0x0073 }
            r4.<init>(r1)     // Catch:{ all -> 0x0073 }
            r7.L$0 = r8     // Catch:{ all -> 0x0073 }
            r7.f12329i = r2     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = r3.single(r4, r7)     // Catch:{ all -> 0x0073 }
            if (r1 != r0) goto L_0x0065
            return r0
        L_0x0065:
            r0 = r8
            r8 = r1
        L_0x0067:
            com.talabat.feature.subscriptions.domain.model.ProCentralization r8 = (com.talabat.feature.subscriptions.domain.model.ProCentralization) r8     // Catch:{ all -> 0x0073 }
            kotlin.Pair r1 = new kotlin.Pair     // Catch:{ all -> 0x0073 }
            r1.<init>(r0, r8)     // Catch:{ all -> 0x0073 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0073 }
            goto L_0x007e
        L_0x0073:
            r8 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x007e:
            com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl r0 = r7.f12330j
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r8)
            if (r1 == 0) goto L_0x0096
            r1 = r8
            kotlin.Pair r1 = (kotlin.Pair) r1
            com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource r0 = r0.customerInfoLocalDataSource
            java.lang.Object r1 = r1.getFirst()
            datamodels.CustomerInfo r1 = (datamodels.CustomerInfo) r1
            r0.setCustomerInfo(r1)
        L_0x0096:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r0 != 0) goto L_0x00a3
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r8 = r8.getFirst()
            return r8
        L_0x00a3:
            com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRetrievalException r8 = new com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRetrievalException
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl$fetchCustomerInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
