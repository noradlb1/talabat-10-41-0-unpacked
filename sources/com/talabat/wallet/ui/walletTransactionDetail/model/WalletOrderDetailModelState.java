package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import datamodels.OrderDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "", "()V", "Error", "Loading", "SuccessOrderDetail", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$Loading;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$Error;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$SuccessOrderDetail;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletOrderDetailModelState {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$Error;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "errorMsg", "", "(Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends WalletOrderDetailModelState {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$Loading;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WalletOrderDetailModelState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState$SuccessOrderDetail;", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "data", "Ldatamodels/OrderDetails;", "(Ldatamodels/OrderDetails;)V", "getData", "()Ldatamodels/OrderDetails;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessOrderDetail extends WalletOrderDetailModelState {
        @NotNull
        private final OrderDetails data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessOrderDetail(@NotNull OrderDetails orderDetails) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(orderDetails, "data");
            this.data = orderDetails;
        }

        public static /* synthetic */ SuccessOrderDetail copy$default(SuccessOrderDetail successOrderDetail, OrderDetails orderDetails, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                orderDetails = successOrderDetail.data;
            }
            return successOrderDetail.copy(orderDetails);
        }

        @NotNull
        public final OrderDetails component1() {
            return this.data;
        }

        @NotNull
        public final SuccessOrderDetail copy(@NotNull OrderDetails orderDetails) {
            Intrinsics.checkNotNullParameter(orderDetails, "data");
            return new SuccessOrderDetail(orderDetails);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessOrderDetail) && Intrinsics.areEqual((Object) this.data, (Object) ((SuccessOrderDetail) obj).data);
        }

        @NotNull
        public final OrderDetails getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            OrderDetails orderDetails = this.data;
            return "SuccessOrderDetail(data=" + orderDetails + ")";
        }
    }

    private WalletOrderDetailModelState() {
    }

    public /* synthetic */ WalletOrderDetailModelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
