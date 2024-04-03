package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionMultiPlanUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Inject
    public GetSubscriptionMultiPlanUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    @Nullable
    public final Object invoke(@NotNull Params params, @NotNull Continuation<? super SubscriptionMultiPlan> continuation) {
        Object multiPlan = this.repository.getMultiPlan(params.getCountry(), params.getDuration(), params.getFreeCoffee(), params.getVoucherCode(), params.getRequestingPage(), continuation);
        if (multiPlan == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return multiPlan;
        }
        return (SubscriptionMultiPlan) multiPlan;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003JH\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006 "}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase$Params;", "", "country", "", "(I)V", "duration", "", "freeCoffee", "", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()I", "getDuration", "()Ljava/lang/String;", "getFreeCoffee", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRequestingPage", "getVoucherCode", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase$Params;", "equals", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int country;
        @Nullable
        private final String duration;
        @Nullable
        private final Boolean freeCoffee;
        @Nullable
        private final String requestingPage;
        @Nullable
        private final String voucherCode;

        public Params(int i11, @Nullable @androidx.annotation.Nullable String str, @Nullable @androidx.annotation.Nullable Boolean bool, @Nullable @androidx.annotation.Nullable String str2, @Nullable @androidx.annotation.Nullable String str3) {
            this.country = i11;
            this.duration = str;
            this.freeCoffee = bool;
            this.voucherCode = str2;
            this.requestingPage = str3;
        }

        public static /* synthetic */ Params copy$default(Params params, int i11, String str, Boolean bool, String str2, String str3, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = params.country;
            }
            if ((i12 & 2) != 0) {
                str = params.duration;
            }
            String str4 = str;
            if ((i12 & 4) != 0) {
                bool = params.freeCoffee;
            }
            Boolean bool2 = bool;
            if ((i12 & 8) != 0) {
                str2 = params.voucherCode;
            }
            String str5 = str2;
            if ((i12 & 16) != 0) {
                str3 = params.requestingPage;
            }
            return params.copy(i11, str4, bool2, str5, str3);
        }

        public final int component1() {
            return this.country;
        }

        @Nullable
        public final String component2() {
            return this.duration;
        }

        @Nullable
        public final Boolean component3() {
            return this.freeCoffee;
        }

        @Nullable
        public final String component4() {
            return this.voucherCode;
        }

        @Nullable
        public final String component5() {
            return this.requestingPage;
        }

        @NotNull
        public final Params copy(int i11, @Nullable @androidx.annotation.Nullable String str, @Nullable @androidx.annotation.Nullable Boolean bool, @Nullable @androidx.annotation.Nullable String str2, @Nullable @androidx.annotation.Nullable String str3) {
            return new Params(i11, str, bool, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.country == params.country && Intrinsics.areEqual((Object) this.duration, (Object) params.duration) && Intrinsics.areEqual((Object) this.freeCoffee, (Object) params.freeCoffee) && Intrinsics.areEqual((Object) this.voucherCode, (Object) params.voucherCode) && Intrinsics.areEqual((Object) this.requestingPage, (Object) params.requestingPage);
        }

        public final int getCountry() {
            return this.country;
        }

        @Nullable
        public final String getDuration() {
            return this.duration;
        }

        @Nullable
        public final Boolean getFreeCoffee() {
            return this.freeCoffee;
        }

        @Nullable
        public final String getRequestingPage() {
            return this.requestingPage;
        }

        @Nullable
        public final String getVoucherCode() {
            return this.voucherCode;
        }

        public int hashCode() {
            int i11 = this.country * 31;
            String str = this.duration;
            int i12 = 0;
            int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.freeCoffee;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.voucherCode;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.requestingPage;
            if (str3 != null) {
                i12 = str3.hashCode();
            }
            return hashCode3 + i12;
        }

        @NotNull
        public String toString() {
            int i11 = this.country;
            String str = this.duration;
            Boolean bool = this.freeCoffee;
            String str2 = this.voucherCode;
            String str3 = this.requestingPage;
            return "Params(country=" + i11 + ", duration=" + str + ", freeCoffee=" + bool + ", voucherCode=" + str2 + ", requestingPage=" + str3 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(int i11, String str, Boolean bool, String str2, String str3, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : bool, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : str3);
        }

        public Params(int i11) {
            this(i11, (String) null, (Boolean) null, (String) null, (String) null);
        }
    }
}
