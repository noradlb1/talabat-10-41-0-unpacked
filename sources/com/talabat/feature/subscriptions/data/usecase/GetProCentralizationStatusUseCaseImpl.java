package com.talabat.feature.subscriptions.data.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/data/usecase/GetProCentralizationStatusUseCaseImpl;", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "params", "Lcom/talabat/feature/subscriptions/domain/model/CountryParams;", "(Lcom/talabat/feature/subscriptions/domain/model/CountryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetProCentralizationStatusUseCaseImpl implements GetProCentralizationStatusUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;

    @Inject
    public GetProCentralizationStatusUseCaseImpl(@NotNull ISubscriptionsRepository iSubscriptionsRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.repository = iSubscriptionsRepository;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.model.CountryParams r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.ProCentralization> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl$invoke$1 r0 = (com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl$invoke$1) r0
            int r1 = r0.f58959k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58959k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl$invoke$1 r0 = new com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl$invoke$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58957i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58959k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f58956h
            com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl r5 = (com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.feature.subscriptions.domain.ISubscriptionsRepository r6 = r4.repository
            com.talabat.configuration.country.Country r5 = r5.getCountry()
            int r5 = r5.getPhoneCodeISO3166()
            r0.f58956h = r4
            r0.f58959k = r3
            java.lang.Object r6 = r6.getProCentralizationStatusForCountry(r5, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r4
        L_0x004e:
            com.talabat.feature.subscriptions.domain.model.ProCentralization r6 = (com.talabat.feature.subscriptions.domain.model.ProCentralization) r6
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r5 = r5.subscriptionStatusRepository
            java.util.List r0 = r6.getSubscriptionList()
            r5.setSubscriptionsList(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl.invoke(com.talabat.feature.subscriptions.domain.model.CountryParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
