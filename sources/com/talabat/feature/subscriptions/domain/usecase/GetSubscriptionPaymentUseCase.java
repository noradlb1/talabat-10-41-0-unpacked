package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import java.util.Calendar;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "NO_YEAR_DIGITS", "", "formatCardExpiryDate", "", "expiryMonth", "expiryYear", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionPaymentUseCase {
    private final int NO_YEAR_DIGITS = 2;
    @NotNull
    private final ISubscriptionsRepository repository;

    @Inject
    public GetSubscriptionPaymentUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    private final String formatCardExpiryDate(String str, String str2) {
        boolean z11;
        boolean z12 = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            z12 = true;
        }
        if (z12) {
            return "";
        }
        return str + "/" + StringsKt___StringsKt.take(String.valueOf(Calendar.getInstance().get(1)), this.NO_YEAR_DIGITS) + str2;
    }

    @Nullable
    public final Object invoke(@NotNull Params params, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation) {
        int i11;
        ISubscriptionsRepository iSubscriptionsRepository = this.repository;
        String planId = params.getPlanId();
        if (planId == null) {
            planId = "";
        }
        Integer paymentMethod = params.getPaymentMethod();
        if (paymentMethod != null) {
            i11 = paymentMethod.intValue();
        } else {
            i11 = 0;
        }
        String cardTokenId = params.getCardTokenId();
        if (cardTokenId == null) {
            cardTokenId = "";
        }
        String card4Digits = params.getCard4Digits();
        if (card4Digits == null) {
            card4Digits = "";
        }
        String cardType = params.getCardType();
        if (cardType == null) {
            cardType = "";
        }
        return iSubscriptionsRepository.payForSubscriptionPlan(planId, i11, cardTokenId, card4Digits, cardType, formatCardExpiryDate(params.getCardExpiryMonth(), params.getCardExpiryYear()), continuation);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase$Params;", "", "planId", "", "cardTokenId", "card4Digits", "cardType", "paymentMethod", "", "cardExpiryMonth", "cardExpiryYear", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "getCardExpiryMonth", "getCardExpiryYear", "getCardTokenId", "getCardType", "getPaymentMethod", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlanId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase$Params;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @Nullable
        private final String card4Digits;
        @Nullable
        private final String cardExpiryMonth;
        @Nullable
        private final String cardExpiryYear;
        @Nullable
        private final String cardTokenId;
        @Nullable
        private final String cardType;
        @Nullable
        private final Integer paymentMethod;
        @Nullable
        private final String planId;

        public Params() {
            this((String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public Params(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable String str6) {
            this.planId = str;
            this.cardTokenId = str2;
            this.card4Digits = str3;
            this.cardType = str4;
            this.paymentMethod = num;
            this.cardExpiryMonth = str5;
            this.cardExpiryYear = str6;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, Integer num, String str5, String str6, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = params.planId;
            }
            if ((i11 & 2) != 0) {
                str2 = params.cardTokenId;
            }
            String str7 = str2;
            if ((i11 & 4) != 0) {
                str3 = params.card4Digits;
            }
            String str8 = str3;
            if ((i11 & 8) != 0) {
                str4 = params.cardType;
            }
            String str9 = str4;
            if ((i11 & 16) != 0) {
                num = params.paymentMethod;
            }
            Integer num2 = num;
            if ((i11 & 32) != 0) {
                str5 = params.cardExpiryMonth;
            }
            String str10 = str5;
            if ((i11 & 64) != 0) {
                str6 = params.cardExpiryYear;
            }
            return params.copy(str, str7, str8, str9, num2, str10, str6);
        }

        @Nullable
        public final String component1() {
            return this.planId;
        }

        @Nullable
        public final String component2() {
            return this.cardTokenId;
        }

        @Nullable
        public final String component3() {
            return this.card4Digits;
        }

        @Nullable
        public final String component4() {
            return this.cardType;
        }

        @Nullable
        public final Integer component5() {
            return this.paymentMethod;
        }

        @Nullable
        public final String component6() {
            return this.cardExpiryMonth;
        }

        @Nullable
        public final String component7() {
            return this.cardExpiryYear;
        }

        @NotNull
        public final Params copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable String str6) {
            return new Params(str, str2, str3, str4, num, str5, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual((Object) this.planId, (Object) params.planId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) params.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) params.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) params.cardType) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) params.paymentMethod) && Intrinsics.areEqual((Object) this.cardExpiryMonth, (Object) params.cardExpiryMonth) && Intrinsics.areEqual((Object) this.cardExpiryYear, (Object) params.cardExpiryYear);
        }

        @Nullable
        public final String getCard4Digits() {
            return this.card4Digits;
        }

        @Nullable
        public final String getCardExpiryMonth() {
            return this.cardExpiryMonth;
        }

        @Nullable
        public final String getCardExpiryYear() {
            return this.cardExpiryYear;
        }

        @Nullable
        public final String getCardTokenId() {
            return this.cardTokenId;
        }

        @Nullable
        public final String getCardType() {
            return this.cardType;
        }

        @Nullable
        public final Integer getPaymentMethod() {
            return this.paymentMethod;
        }

        @Nullable
        public final String getPlanId() {
            return this.planId;
        }

        public int hashCode() {
            String str = this.planId;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.cardTokenId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.card4Digits;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cardType;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.paymentMethod;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.cardExpiryMonth;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.cardExpiryYear;
            if (str6 != null) {
                i11 = str6.hashCode();
            }
            return hashCode6 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.planId;
            String str2 = this.cardTokenId;
            String str3 = this.card4Digits;
            String str4 = this.cardType;
            Integer num = this.paymentMethod;
            String str5 = this.cardExpiryMonth;
            String str6 = this.cardExpiryYear;
            return "Params(planId=" + str + ", cardTokenId=" + str2 + ", card4Digits=" + str3 + ", cardType=" + str4 + ", paymentMethod=" + num + ", cardExpiryMonth=" + str5 + ", cardExpiryYear=" + str6 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Params(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r6 = this;
                r15 = r14 & 1
                java.lang.String r0 = ""
                if (r15 == 0) goto L_0x0008
                r15 = r0
                goto L_0x0009
            L_0x0008:
                r15 = r7
            L_0x0009:
                r7 = r14 & 2
                if (r7 == 0) goto L_0x000f
                r1 = r0
                goto L_0x0010
            L_0x000f:
                r1 = r8
            L_0x0010:
                r7 = r14 & 4
                if (r7 == 0) goto L_0x0016
                r2 = r0
                goto L_0x0017
            L_0x0016:
                r2 = r9
            L_0x0017:
                r7 = r14 & 8
                if (r7 == 0) goto L_0x001d
                r3 = r0
                goto L_0x001e
            L_0x001d:
                r3 = r10
            L_0x001e:
                r7 = r14 & 16
                if (r7 == 0) goto L_0x0027
                r7 = 0
                java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            L_0x0027:
                r4 = r11
                r7 = r14 & 32
                if (r7 == 0) goto L_0x002e
                r5 = r0
                goto L_0x002f
            L_0x002e:
                r5 = r12
            L_0x002f:
                r7 = r14 & 64
                if (r7 == 0) goto L_0x0035
                r14 = r0
                goto L_0x0036
            L_0x0035:
                r14 = r13
            L_0x0036:
                r7 = r6
                r8 = r15
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase.Params.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
