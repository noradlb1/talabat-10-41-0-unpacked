package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.talabatlife.features.UrlConstantsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "subscriptionsStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateAutoRenewalUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final GetSubscriptionsUseCase getSubscriptionsUseCase;
    @NotNull
    private final ISubscriptionsRepository repository;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionsStatusRepository;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase$Params;", "", "membershipId", "", "autoRenewal", "", "isImmediateCancelDisable", "(Ljava/lang/String;ZZ)V", "getAutoRenewal", "()Z", "getMembershipId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final boolean autoRenewal;
        private final boolean isImmediateCancelDisable;
        @NotNull
        private final String membershipId;

        public Params(@NotNull String str, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            this.membershipId = str;
            this.autoRenewal = z11;
            this.isImmediateCancelDisable = z12;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, boolean z11, boolean z12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = params.membershipId;
            }
            if ((i11 & 2) != 0) {
                z11 = params.autoRenewal;
            }
            if ((i11 & 4) != 0) {
                z12 = params.isImmediateCancelDisable;
            }
            return params.copy(str, z11, z12);
        }

        @NotNull
        public final String component1() {
            return this.membershipId;
        }

        public final boolean component2() {
            return this.autoRenewal;
        }

        public final boolean component3() {
            return this.isImmediateCancelDisable;
        }

        @NotNull
        public final Params copy(@NotNull String str, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            return new Params(str, z11, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual((Object) this.membershipId, (Object) params.membershipId) && this.autoRenewal == params.autoRenewal && this.isImmediateCancelDisable == params.isImmediateCancelDisable;
        }

        public final boolean getAutoRenewal() {
            return this.autoRenewal;
        }

        @NotNull
        public final String getMembershipId() {
            return this.membershipId;
        }

        public int hashCode() {
            int hashCode = this.membershipId.hashCode() * 31;
            boolean z11 = this.autoRenewal;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isImmediateCancelDisable;
            if (!z13) {
                z12 = z13;
            }
            return i11 + (z12 ? 1 : 0);
        }

        public final boolean isImmediateCancelDisable() {
            return this.isImmediateCancelDisable;
        }

        @NotNull
        public String toString() {
            String str = this.membershipId;
            boolean z11 = this.autoRenewal;
            boolean z12 = this.isImmediateCancelDisable;
            return "Params(membershipId=" + str + ", autoRenewal=" + z11 + ", isImmediateCancelDisable=" + z12 + ")";
        }
    }

    @Inject
    public UpdateAutoRenewalUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull GetSubscriptionsUseCase getSubscriptionsUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionsStatusRepository");
        Intrinsics.checkNotNullParameter(getSubscriptionsUseCase2, "getSubscriptionsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.repository = iSubscriptionsRepository;
        this.subscriptionsStatusRepository = iSubscriptionStatusRepository;
        this.getSubscriptionsUseCase = getSubscriptionsUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase.Params r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$invoke$1 r0 = (com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$invoke$1) r0
            int r1 = r0.f58999l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58999l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$invoke$1 r0 = new com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$invoke$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58997j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58999l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.f58996i
            kotlin.Unit r7 = (kotlin.Unit) r7
            java.lang.Object r7 = r0.f58995h
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase r7 = (com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007d
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            java.lang.Object r7 = r0.f58995h
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase r7 = (com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.feature.subscriptions.domain.ISubscriptionsRepository r8 = r6.repository
            java.lang.String r2 = r7.getMembershipId()
            boolean r5 = r7.getAutoRenewal()
            boolean r7 = r7.isImmediateCancelDisable()
            r0.f58995h = r6
            r0.f58999l = r4
            java.lang.Object r7 = r8.updateAutoRenew(r2, r5, r7, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r7 = r6
        L_0x0061:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase r2 = r7.getSubscriptionsUseCase
            com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase$Params r4 = new com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase$Params
            com.talabat.configuration.ConfigurationLocalRepository r5 = r7.configurationLocalRepository
            com.talabat.configuration.country.Country r5 = r5.selectedCountry()
            r4.<init>(r5)
            r0.f58995h = r7
            r0.f58996i = r8
            r0.f58999l = r3
            java.lang.Object r8 = r2.invoke(r4, r0)
            if (r8 != r1) goto L_0x007d
            return r1
        L_0x007d:
            java.util.List r8 = (java.util.List) r8
            r0 = r8
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0086:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.talabat.feature.subscriptions.domain.model.Subscription r2 = (com.talabat.feature.subscriptions.domain.model.Subscription) r2
            boolean r2 = r2.isActive()
            if (r2 == 0) goto L_0x0086
            goto L_0x009b
        L_0x009a:
            r1 = 0
        L_0x009b:
            com.talabat.feature.subscriptions.domain.model.Subscription r1 = (com.talabat.feature.subscriptions.domain.model.Subscription) r1
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r0 = r7.subscriptionsStatusRepository
            r0.setTProSubscriptionInfo(r1)
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r7 = r7.subscriptionsStatusRepository
            r7.setSubscriptionsList(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase.invoke(com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
