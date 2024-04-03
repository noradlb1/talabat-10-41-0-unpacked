package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "subscriptionsCustomerHelper", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;)V", "single", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "params", "Lcom/talabat/feature/subscriptions/domain/model/CountryParams;", "(Lcom/talabat/feature/subscriptions/domain/model/CountryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProCentralizationStatusWrapper {
    @NotNull
    private final GetProCentralizationStatusUseCase getProCentralizationStatusUseCase;
    @NotNull
    private final ISubscriptionsCustomerRepository subscriptionsCustomerHelper;

    @Inject
    public ProCentralizationStatusWrapper(@NotNull GetProCentralizationStatusUseCase getProCentralizationStatusUseCase2, @NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        Intrinsics.checkNotNullParameter(getProCentralizationStatusUseCase2, "getProCentralizationStatusUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository, "subscriptionsCustomerHelper");
        this.getProCentralizationStatusUseCase = getProCentralizationStatusUseCase2;
        this.subscriptionsCustomerHelper = iSubscriptionsCustomerRepository;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.talabat.feature.subscriptions.domain.model.Subscription} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0081 A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object single(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.model.CountryParams r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.ProCentralization> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper$single$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper$single$1 r0 = (com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper$single$1) r0
            int r1 = r0.f59009k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59009k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper$single$1 r0 = new com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper$single$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f59007i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59009k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f59006h
            com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper r7 = (com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x00a0 }
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x00a0 }
            com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase r8 = r6.getProCentralizationStatusUseCase     // Catch:{ all -> 0x00a0 }
            r0.f59006h = r6     // Catch:{ all -> 0x00a0 }
            r0.f59009k = r3     // Catch:{ all -> 0x00a0 }
            java.lang.Object r8 = r8.invoke(r7, r0)     // Catch:{ all -> 0x00a0 }
            if (r8 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r7 = r6
        L_0x0048:
            com.talabat.feature.subscriptions.domain.model.ProCentralization r8 = (com.talabat.feature.subscriptions.domain.model.ProCentralization) r8     // Catch:{ all -> 0x00a0 }
            java.util.List r0 = r8.getSubscriptionList()     // Catch:{ all -> 0x00a0 }
            r1 = 0
            if (r0 == 0) goto L_0x006d
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x00a0 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a0 }
        L_0x0057:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a0 }
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a0 }
            r4 = r2
            com.talabat.feature.subscriptions.domain.model.Subscription r4 = (com.talabat.feature.subscriptions.domain.model.Subscription) r4     // Catch:{ all -> 0x00a0 }
            boolean r4 = r4.isActive()     // Catch:{ all -> 0x00a0 }
            if (r4 == 0) goto L_0x0057
            r1 = r2
        L_0x006b:
            com.talabat.feature.subscriptions.domain.model.Subscription r1 = (com.talabat.feature.subscriptions.domain.model.Subscription) r1     // Catch:{ all -> 0x00a0 }
        L_0x006d:
            r0 = 0
            if (r1 == 0) goto L_0x007e
            java.lang.String r2 = r1.getMembershipId()     // Catch:{ all -> 0x00a0 }
            if (r2 == 0) goto L_0x007e
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)     // Catch:{ all -> 0x00a0 }
            r2 = r2 ^ r3
            if (r2 != r3) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r3 = r0
        L_0x007f:
            if (r3 == 0) goto L_0x0086
            com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository r0 = r7.subscriptionsCustomerHelper     // Catch:{ all -> 0x00a0 }
            r0.saveSubscriptionInfo(r1)     // Catch:{ all -> 0x00a0 }
        L_0x0086:
            com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository r7 = r7.subscriptionsCustomerHelper     // Catch:{ all -> 0x00a0 }
            boolean r0 = r8.isPro()     // Catch:{ all -> 0x00a0 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x00a0 }
            boolean r1 = r8.getShowPro()     // Catch:{ all -> 0x00a0 }
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)     // Catch:{ all -> 0x00a0 }
            r7.saveProStatus(r0, r1)     // Catch:{ all -> 0x00a0 }
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x00a0 }
            goto L_0x00ab
        L_0x00a0:
            r7 = move-exception
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)
        L_0x00ab:
            java.lang.Throwable r8 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            if (r8 != 0) goto L_0x00b2
            goto L_0x00bd
        L_0x00b2:
            com.talabat.feature.subscriptions.domain.model.ProCentralization r7 = new com.talabat.feature.subscriptions.domain.model.ProCentralization
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x00bd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper.single(com.talabat.feature.subscriptions.domain.model.CountryParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
