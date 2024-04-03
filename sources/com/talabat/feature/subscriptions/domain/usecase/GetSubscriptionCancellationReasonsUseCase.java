package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionCancellationReasonsUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionCancellationReasonsUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Inject
    public GetSubscriptionCancellationReasonsUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$1 r0 = (com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$1) r0
            int r1 = r0.f58990j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58990j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$1 r0 = new com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58988h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58990j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.feature.subscriptions.domain.ISubscriptionsRepository r5 = r4.repository
            r0.f58990j = r3
            java.lang.Object r5 = r5.getSubscriptionCancellationReasons(r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$$inlined$sortedBy$1 r0 = new com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase$invoke$$inlined$sortedBy$1
            r0.<init>()
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
