package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u000b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "", "()V", "Default", "Error", "Loading", "SuccessCommonViewTransaction", "SuccessCreditExpiredViewTransaction", "SuccessCreditVoucherViewTransaction", "SuccessPaymentViewTransaction", "SuccessRechargeViewTransaction", "SuccessRefundSentViewTransaction", "SuccessRefundViewTransaction", "SuccessRiderTipViewTransaction", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Loading;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Default;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Error;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessPaymentViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRechargeViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCommonViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRiderTipViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCreditVoucherViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCreditExpiredViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundSentViewTransaction;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletTransactionDisplayModelState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Default;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Default extends WalletTransactionDisplayModelState {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Error;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "errorMsg", "", "(Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends WalletTransactionDisplayModelState {
        @NotNull
        private final String errorMsg;

        public Error() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorMsg");
            this.errorMsg = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.errorMsg;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.errorMsg;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "errorMsg");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.errorMsg, (Object) ((Error) obj).errorMsg);
        }

        @NotNull
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public int hashCode() {
            return this.errorMsg.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.errorMsg;
            return "Error(errorMsg=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$Loading;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WalletTransactionDisplayModelState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCommonViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessCommonViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final CommonViewTransactionTypeDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessCommonViewTransaction(@NotNull CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(commonViewTransactionTypeDisplayModel, "data");
            this.data = commonViewTransactionTypeDisplayModel;
        }

        public static /* synthetic */ SuccessCommonViewTransaction copy$default(SuccessCommonViewTransaction successCommonViewTransaction, CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                commonViewTransactionTypeDisplayModel = successCommonViewTransaction.data;
            }
            return successCommonViewTransaction.copy(commonViewTransactionTypeDisplayModel);
        }

        @NotNull
        public final CommonViewTransactionTypeDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessCommonViewTransaction copy(@NotNull CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(commonViewTransactionTypeDisplayModel, "data");
            return new SuccessCommonViewTransaction(commonViewTransactionTypeDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessCommonViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessCommonViewTransaction) obj).data);
        }

        @NotNull
        public final CommonViewTransactionTypeDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel = this.data;
            return "SuccessCommonViewTransaction(data=" + commonViewTransactionTypeDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCreditExpiredViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessCreditExpiredViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final WalletTransactionDetailHeaderDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessCreditExpiredViewTransaction(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            this.data = walletTransactionDetailHeaderDisplayModel;
        }

        public static /* synthetic */ SuccessCreditExpiredViewTransaction copy$default(SuccessCreditExpiredViewTransaction successCreditExpiredViewTransaction, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                walletTransactionDetailHeaderDisplayModel = successCreditExpiredViewTransaction.data;
            }
            return successCreditExpiredViewTransaction.copy(walletTransactionDetailHeaderDisplayModel);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessCreditExpiredViewTransaction copy(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            return new SuccessCreditExpiredViewTransaction(walletTransactionDetailHeaderDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessCreditExpiredViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessCreditExpiredViewTransaction) obj).data);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.data;
            return "SuccessCreditExpiredViewTransaction(data=" + walletTransactionDetailHeaderDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCreditVoucherViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessCreditVoucherViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final WalletTransactionDetailHeaderDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessCreditVoucherViewTransaction(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            this.data = walletTransactionDetailHeaderDisplayModel;
        }

        public static /* synthetic */ SuccessCreditVoucherViewTransaction copy$default(SuccessCreditVoucherViewTransaction successCreditVoucherViewTransaction, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                walletTransactionDetailHeaderDisplayModel = successCreditVoucherViewTransaction.data;
            }
            return successCreditVoucherViewTransaction.copy(walletTransactionDetailHeaderDisplayModel);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessCreditVoucherViewTransaction copy(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            return new SuccessCreditVoucherViewTransaction(walletTransactionDetailHeaderDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessCreditVoucherViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessCreditVoucherViewTransaction) obj).data);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.data;
            return "SuccessCreditVoucherViewTransaction(data=" + walletTransactionDetailHeaderDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessPaymentViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessPaymentViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final PaidWalletTransactionTypeDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessPaymentViewTransaction(@NotNull PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paidWalletTransactionTypeDisplayModel, "data");
            this.data = paidWalletTransactionTypeDisplayModel;
        }

        public static /* synthetic */ SuccessPaymentViewTransaction copy$default(SuccessPaymentViewTransaction successPaymentViewTransaction, PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                paidWalletTransactionTypeDisplayModel = successPaymentViewTransaction.data;
            }
            return successPaymentViewTransaction.copy(paidWalletTransactionTypeDisplayModel);
        }

        @NotNull
        public final PaidWalletTransactionTypeDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessPaymentViewTransaction copy(@NotNull PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(paidWalletTransactionTypeDisplayModel, "data");
            return new SuccessPaymentViewTransaction(paidWalletTransactionTypeDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessPaymentViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessPaymentViewTransaction) obj).data);
        }

        @NotNull
        public final PaidWalletTransactionTypeDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel = this.data;
            return "SuccessPaymentViewTransaction(data=" + paidWalletTransactionTypeDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRechargeViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessRechargeViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final RechargeWalletTransactionTypeDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessRechargeViewTransaction(@NotNull RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rechargeWalletTransactionTypeDisplayModel, "data");
            this.data = rechargeWalletTransactionTypeDisplayModel;
        }

        public static /* synthetic */ SuccessRechargeViewTransaction copy$default(SuccessRechargeViewTransaction successRechargeViewTransaction, RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                rechargeWalletTransactionTypeDisplayModel = successRechargeViewTransaction.data;
            }
            return successRechargeViewTransaction.copy(rechargeWalletTransactionTypeDisplayModel);
        }

        @NotNull
        public final RechargeWalletTransactionTypeDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessRechargeViewTransaction copy(@NotNull RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(rechargeWalletTransactionTypeDisplayModel, "data");
            return new SuccessRechargeViewTransaction(rechargeWalletTransactionTypeDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessRechargeViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessRechargeViewTransaction) obj).data);
        }

        @NotNull
        public final RechargeWalletTransactionTypeDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel = this.data;
            return "SuccessRechargeViewTransaction(data=" + rechargeWalletTransactionTypeDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundSentViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessRefundSentViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final RefundSentWalletTransactionTypeDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessRefundSentViewTransaction(@NotNull RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(refundSentWalletTransactionTypeDisplayModel, "data");
            this.data = refundSentWalletTransactionTypeDisplayModel;
        }

        public static /* synthetic */ SuccessRefundSentViewTransaction copy$default(SuccessRefundSentViewTransaction successRefundSentViewTransaction, RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                refundSentWalletTransactionTypeDisplayModel = successRefundSentViewTransaction.data;
            }
            return successRefundSentViewTransaction.copy(refundSentWalletTransactionTypeDisplayModel);
        }

        @NotNull
        public final RefundSentWalletTransactionTypeDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessRefundSentViewTransaction copy(@NotNull RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(refundSentWalletTransactionTypeDisplayModel, "data");
            return new SuccessRefundSentViewTransaction(refundSentWalletTransactionTypeDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessRefundSentViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessRefundSentViewTransaction) obj).data);
        }

        @NotNull
        public final RefundSentWalletTransactionTypeDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel = this.data;
            return "SuccessRefundSentViewTransaction(data=" + refundSentWalletTransactionTypeDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessRefundViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final RefundWalletTransactionTypeDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessRefundViewTransaction(@NotNull RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(refundWalletTransactionTypeDisplayModel, "data");
            this.data = refundWalletTransactionTypeDisplayModel;
        }

        public static /* synthetic */ SuccessRefundViewTransaction copy$default(SuccessRefundViewTransaction successRefundViewTransaction, RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                refundWalletTransactionTypeDisplayModel = successRefundViewTransaction.data;
            }
            return successRefundViewTransaction.copy(refundWalletTransactionTypeDisplayModel);
        }

        @NotNull
        public final RefundWalletTransactionTypeDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessRefundViewTransaction copy(@NotNull RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(refundWalletTransactionTypeDisplayModel, "data");
            return new SuccessRefundViewTransaction(refundWalletTransactionTypeDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessRefundViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessRefundViewTransaction) obj).data);
        }

        @NotNull
        public final RefundWalletTransactionTypeDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel = this.data;
            return "SuccessRefundViewTransaction(data=" + refundWalletTransactionTypeDisplayModel + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRiderTipViewTransaction;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "data", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getData", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessRiderTipViewTransaction extends WalletTransactionDisplayModelState {
        @NotNull
        private final WalletTransactionDetailHeaderDisplayModel data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessRiderTipViewTransaction(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            this.data = walletTransactionDetailHeaderDisplayModel;
        }

        public static /* synthetic */ SuccessRiderTipViewTransaction copy$default(SuccessRiderTipViewTransaction successRiderTipViewTransaction, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                walletTransactionDetailHeaderDisplayModel = successRiderTipViewTransaction.data;
            }
            return successRiderTipViewTransaction.copy(walletTransactionDetailHeaderDisplayModel);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel component1() {
            return this.data;
        }

        @NotNull
        public final SuccessRiderTipViewTransaction copy(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
            Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "data");
            return new SuccessRiderTipViewTransaction(walletTransactionDetailHeaderDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessRiderTipViewTransaction) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessRiderTipViewTransaction) obj).data);
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.data;
            return "SuccessRiderTipViewTransaction(data=" + walletTransactionDetailHeaderDisplayModel + ")";
        }
    }

    private WalletTransactionDisplayModelState() {
    }

    public /* synthetic */ WalletTransactionDisplayModelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
