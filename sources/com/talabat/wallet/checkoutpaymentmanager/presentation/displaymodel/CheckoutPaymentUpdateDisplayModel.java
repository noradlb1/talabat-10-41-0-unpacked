package com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel;

import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "", "()V", "HideQPayPaymentOption", "Loading", "ShowBenefitBinsInfo", "ShowDefaultPaymentScreen", "ShowKNetFallback", "ShowKNetPaymentOption", "ShowQPayBinsInfo", "ShowQPayFallback", "ShowQPayPaymentOption", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$Loading;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowKNetPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowKNetFallback;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$HideQPayPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowDefaultPaymentScreen;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayFallback;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowBenefitBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayBinsInfo;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CheckoutPaymentUpdateDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$HideQPayPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideQPayPaymentOption extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final HideQPayPaymentOption INSTANCE = new HideQPayPaymentOption();

        private HideQPayPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$Loading;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowBenefitBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "bins", "", "", "benefitCardDeflectionExpiryDate", "(Ljava/util/Set;Ljava/lang/String;)V", "getBenefitCardDeflectionExpiryDate", "()Ljava/lang/String;", "getBins", "()Ljava/util/Set;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowBenefitBinsInfo extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        private final String benefitCardDeflectionExpiryDate;
        @NotNull
        private final Set<String> bins;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowBenefitBinsInfo(@NotNull Set<String> set, @NotNull String str) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowDefaultPaymentScreen;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowDefaultPaymentScreen extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final ShowDefaultPaymentScreen INSTANCE = new ShowDefaultPaymentScreen();

        private ShowDefaultPaymentScreen() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowKNetFallback;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowKNetFallback extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final ShowKNetFallback INSTANCE = new ShowKNetFallback();

        private ShowKNetFallback() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowKNetPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowKNetPaymentOption extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final ShowKNetPaymentOption INSTANCE = new ShowKNetPaymentOption();

        private ShowKNetPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayBinsInfo;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "bins", "", "", "qPayCardDeflectionExpiryDate", "(Ljava/util/Set;Ljava/lang/String;)V", "getBins", "()Ljava/util/Set;", "getQPayCardDeflectionExpiryDate", "()Ljava/lang/String;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayBinsInfo extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        private final Set<String> bins;
        @NotNull
        private final String qPayCardDeflectionExpiryDate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowQPayBinsInfo(@NotNull Set<String> set, @NotNull String str) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayFallback;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayFallback extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final ShowQPayFallback INSTANCE = new ShowQPayFallback();

        private ShowQPayFallback() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel$ShowQPayPaymentOption;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayPaymentOption extends CheckoutPaymentUpdateDisplayModel {
        @NotNull
        public static final ShowQPayPaymentOption INSTANCE = new ShowQPayPaymentOption();

        private ShowQPayPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CheckoutPaymentUpdateDisplayModel() {
    }

    public /* synthetic */ CheckoutPaymentUpdateDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
