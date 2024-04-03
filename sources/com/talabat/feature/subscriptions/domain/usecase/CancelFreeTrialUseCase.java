package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.talabatlife.features.UrlConstantsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancelFreeTrialUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase$Params;", "", "membershipId", "", "(Ljava/lang/String;)V", "getMembershipId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @NotNull
        private final String membershipId;

        public Params(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            this.membershipId = str;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = params.membershipId;
            }
            return params.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.membershipId;
        }

        @NotNull
        public final Params copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            return new Params(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual((Object) this.membershipId, (Object) ((Params) obj).membershipId);
        }

        @NotNull
        public final String getMembershipId() {
            return this.membershipId;
        }

        public int hashCode() {
            return this.membershipId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.membershipId;
            return "Params(membershipId=" + str + ")";
        }
    }

    @Inject
    public CancelFreeTrialUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    @Nullable
    public final Object invoke(@NotNull Params params, @NotNull Continuation<? super Unit> continuation) {
        Object cancelFreeTrial = this.repository.cancelFreeTrial(params.getMembershipId(), continuation);
        if (cancelFreeTrial == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return cancelFreeTrial;
        }
        return Unit.INSTANCE;
    }
}
