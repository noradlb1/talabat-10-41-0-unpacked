package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendCancellationFeedbackUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase$Params;", "", "reasonId", "", "planId", "other", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOther", "()Ljava/lang/String;", "getPlanId", "getReasonId", "component1", "component2", "component3", "copy", "equals", "", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @NotNull
        private final String other;
        @NotNull
        private final String planId;
        @NotNull
        private final String reasonId;

        public Params(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "reasonId");
            Intrinsics.checkNotNullParameter(str2, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
            Intrinsics.checkNotNullParameter(str3, "other");
            this.reasonId = str;
            this.planId = str2;
            this.other = str3;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = params.reasonId;
            }
            if ((i11 & 2) != 0) {
                str2 = params.planId;
            }
            if ((i11 & 4) != 0) {
                str3 = params.other;
            }
            return params.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.reasonId;
        }

        @NotNull
        public final String component2() {
            return this.planId;
        }

        @NotNull
        public final String component3() {
            return this.other;
        }

        @NotNull
        public final Params copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "reasonId");
            Intrinsics.checkNotNullParameter(str2, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
            Intrinsics.checkNotNullParameter(str3, "other");
            return new Params(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual((Object) this.reasonId, (Object) params.reasonId) && Intrinsics.areEqual((Object) this.planId, (Object) params.planId) && Intrinsics.areEqual((Object) this.other, (Object) params.other);
        }

        @NotNull
        public final String getOther() {
            return this.other;
        }

        @NotNull
        public final String getPlanId() {
            return this.planId;
        }

        @NotNull
        public final String getReasonId() {
            return this.reasonId;
        }

        public int hashCode() {
            return (((this.reasonId.hashCode() * 31) + this.planId.hashCode()) * 31) + this.other.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.reasonId;
            String str2 = this.planId;
            String str3 = this.other;
            return "Params(reasonId=" + str + ", planId=" + str2 + ", other=" + str3 + ")";
        }
    }

    @Inject
    public SendCancellationFeedbackUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    @Nullable
    public final Object invoke(@NotNull Params params, @NotNull Continuation<? super Unit> continuation) {
        Object sendCancellationFeedback = this.repository.sendCancellationFeedback(params.getReasonId(), params.getPlanId(), params.getOther(), continuation);
        if (sendCancellationFeedback == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return sendCancellationFeedback;
        }
        return Unit.INSTANCE;
    }
}
