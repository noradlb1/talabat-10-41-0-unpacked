package com.talabat.wallet.checkoutpaymentmanager.domain.entity;

import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "", "()V", "BenefitBinsInfo", "DefaultPaymentMethod", "KNetIsAvailable", "KNetIsUnAvailable", "QPayBinsInfo", "QPayIsAvailable", "QPayIsDown", "QPayIsNotAvailable", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$KNetIsAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$KNetIsUnAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsNotAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsDown;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$DefaultPaymentMethod;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$BenefitBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayBinsInfo;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CheckoutPaymentUpdateResult {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$BenefitBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "bins", "", "", "benefitCardDeflectionExpiryDate", "(Ljava/util/Set;Ljava/lang/String;)V", "getBenefitCardDeflectionExpiryDate", "()Ljava/lang/String;", "getBins", "()Ljava/util/Set;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BenefitBinsInfo extends CheckoutPaymentUpdateResult {
        @NotNull
        private final String benefitCardDeflectionExpiryDate;
        @NotNull
        private final Set<String> bins;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BenefitBinsInfo(@NotNull Set<String> set, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, TalabatCommonUrlConstantsKt.BIN_NUMBER_PATH);
            Intrinsics.checkNotNullParameter(str, "benefitCardDeflectionExpiryDate");
            this.bins = set;
            this.benefitCardDeflectionExpiryDate = str;
        }

        @NotNull
        public final String getBenefitCardDeflectionExpiryDate() {
            return this.benefitCardDeflectionExpiryDate;
        }

        @NotNull
        public final Set<String> getBins() {
            return this.bins;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$DefaultPaymentMethod;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultPaymentMethod extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final DefaultPaymentMethod INSTANCE = new DefaultPaymentMethod();

        private DefaultPaymentMethod() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$KNetIsAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KNetIsAvailable extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final KNetIsAvailable INSTANCE = new KNetIsAvailable();

        private KNetIsAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$KNetIsUnAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KNetIsUnAvailable extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final KNetIsUnAvailable INSTANCE = new KNetIsUnAvailable();

        private KNetIsUnAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "bins", "", "", "qPayCardDeflectionExpiryDate", "(Ljava/util/Set;Ljava/lang/String;)V", "getBins", "()Ljava/util/Set;", "getQPayCardDeflectionExpiryDate", "()Ljava/lang/String;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayBinsInfo extends CheckoutPaymentUpdateResult {
        @NotNull
        private final Set<String> bins;
        @NotNull
        private final String qPayCardDeflectionExpiryDate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QPayBinsInfo(@NotNull Set<String> set, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, TalabatCommonUrlConstantsKt.BIN_NUMBER_PATH);
            Intrinsics.checkNotNullParameter(str, "qPayCardDeflectionExpiryDate");
            this.bins = set;
            this.qPayCardDeflectionExpiryDate = str;
        }

        @NotNull
        public final Set<String> getBins() {
            return this.bins;
        }

        @NotNull
        public final String getQPayCardDeflectionExpiryDate() {
            return this.qPayCardDeflectionExpiryDate;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayIsAvailable extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final QPayIsAvailable INSTANCE = new QPayIsAvailable();

        private QPayIsAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsDown;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayIsDown extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final QPayIsDown INSTANCE = new QPayIsDown();

        private QPayIsDown() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult$QPayIsNotAvailable;", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayIsNotAvailable extends CheckoutPaymentUpdateResult {
        @NotNull
        public static final QPayIsNotAvailable INSTANCE = new QPayIsNotAvailable();

        private QPayIsNotAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CheckoutPaymentUpdateResult() {
    }

    public /* synthetic */ CheckoutPaymentUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
