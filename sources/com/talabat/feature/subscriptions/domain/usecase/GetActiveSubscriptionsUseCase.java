package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetActiveSubscriptionsUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ISubscriptionsRepository repository;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase$Params;", "", "country", "Lcom/talabat/configuration/country/Country;", "(Lcom/talabat/configuration/country/Country;)V", "getCountry", "()Lcom/talabat/configuration/country/Country;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @NotNull
        private final Country country;

        public Params(@NotNull Country country2) {
            Intrinsics.checkNotNullParameter(country2, "country");
            this.country = country2;
        }

        public static /* synthetic */ Params copy$default(Params params, Country country2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                country2 = params.country;
            }
            return params.copy(country2);
        }

        @NotNull
        public final Country component1() {
            return this.country;
        }

        @NotNull
        public final Params copy(@NotNull Country country2) {
            Intrinsics.checkNotNullParameter(country2, "country");
            return new Params(country2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.country == ((Params) obj).country;
        }

        @NotNull
        public final Country getCountry() {
            return this.country;
        }

        public int hashCode() {
            return this.country.hashCode();
        }

        @NotNull
        public String toString() {
            Country country2 = this.country;
            return "Params(country=" + country2 + ")";
        }
    }

    @Inject
    public GetActiveSubscriptionsUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.repository = iSubscriptionsRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase.Params r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.Subscription> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$invoke$1 r0 = (com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$invoke$1) r0
            int r1 = r0.f58987k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58987k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$invoke$1 r0 = new com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$invoke$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f58985i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58987k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r13 = r0.f58984h
            com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase r13 = (com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r14)
            com.talabat.feature.subscriptions.domain.ISubscriptionsRepository r14 = r12.repository
            com.talabat.configuration.country.Country r13 = r13.getCountry()
            int r13 = r13.getPhoneCodeISO3166()
            r0.f58984h = r12
            r0.f58987k = r3
            java.lang.Object r14 = r14.getSubscriptionsForCountry(r13, r0)
            if (r14 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r13 = r12
        L_0x004e:
            java.util.List r14 = (java.util.List) r14
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r13 = r13.subscriptionStatusRepository
            r13.setSubscriptionsList(r14)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r13 = r14.iterator()
        L_0x005b:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x006f
            java.lang.Object r14 = r13.next()
            r0 = r14
            com.talabat.feature.subscriptions.domain.model.Subscription r0 = (com.talabat.feature.subscriptions.domain.model.Subscription) r0
            boolean r0 = r0.isActive()
            if (r0 == 0) goto L_0x005b
            goto L_0x0070
        L_0x006f:
            r14 = 0
        L_0x0070:
            com.talabat.feature.subscriptions.domain.model.Subscription r14 = (com.talabat.feature.subscriptions.domain.model.Subscription) r14
            if (r14 != 0) goto L_0x0086
            com.talabat.feature.subscriptions.domain.model.Subscription r14 = new com.talabat.feature.subscriptions.domain.model.Subscription
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 511(0x1ff, float:7.16E-43)
            r11 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0086:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase.invoke(com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
