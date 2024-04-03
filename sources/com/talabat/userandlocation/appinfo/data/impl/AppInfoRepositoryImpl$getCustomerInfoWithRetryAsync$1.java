package com.talabat.userandlocation.appinfo.data.impl;

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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ldatamodels/CustomerInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1", f = "AppInfoRepositoryImpl.kt", i = {0}, l = {77, 80}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
public final class AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CustomerInfo>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12195h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12196i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12197j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1(AppInfoRepositoryImpl appInfoRepositoryImpl, int i11, Continuation<? super AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1> continuation) {
        super(2, continuation);
        this.f12196i = appInfoRepositoryImpl;
        this.f12197j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1 appInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1 = new AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1(this.f12196i, this.f12197j, continuation);
        appInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1.L$0 = obj;
        return appInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CustomerInfo> continuation) {
        return ((AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f12195h
            java.lang.String r2 = ""
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            java.lang.Object r0 = r7.L$0
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r0 = (com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0018 }
            goto L_0x0075
        L_0x0018:
            r8 = move-exception
            goto L_0x007e
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0022:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x0042
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r1 = r7.f12196i
            int r5 = r7.f12197j
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0049 }
            r7.L$0 = r8     // Catch:{ all -> 0x0049 }
            r7.f12195h = r4     // Catch:{ all -> 0x0049 }
            java.lang.Object r8 = r1.fetchCustomerInfo(r5, r7)     // Catch:{ all -> 0x0049 }
            if (r8 != r0) goto L_0x0042
            return r0
        L_0x0042:
            datamodels.CustomerInfo r8 = (datamodels.CustomerInfo) r8     // Catch:{ all -> 0x0049 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x0054
        L_0x0049:
            r8 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0054:
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl r1 = r7.f12196i
            int r5 = r7.f12197j
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r6 != 0) goto L_0x005f
            goto L_0x009d
        L_0x005f:
            java.lang.String r8 = r6.getMessage()
            if (r8 != 0) goto L_0x0066
            r8 = r2
        L_0x0066:
            r1.trackCustomerInfoReturnedNull(r4, r8)
            r7.L$0 = r1     // Catch:{ all -> 0x007c }
            r7.f12195h = r3     // Catch:{ all -> 0x007c }
            java.lang.Object r8 = r1.fetchCustomerInfo(r5, r7)     // Catch:{ all -> 0x007c }
            if (r8 != r0) goto L_0x0074
            return r0
        L_0x0074:
            r0 = r1
        L_0x0075:
            datamodels.CustomerInfo r8 = (datamodels.CustomerInfo) r8     // Catch:{ all -> 0x0018 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0018 }
            goto L_0x0088
        L_0x007c:
            r8 = move-exception
            r0 = r1
        L_0x007e:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0088:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r1 != 0) goto L_0x008f
            goto L_0x009b
        L_0x008f:
            java.lang.String r8 = r1.getMessage()
            if (r8 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r2 = r8
        L_0x0097:
            r0.trackCustomerInfoReturnedNull(r3, r2)
            r8 = 0
        L_0x009b:
            datamodels.CustomerInfo r8 = (datamodels.CustomerInfo) r8
        L_0x009d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
