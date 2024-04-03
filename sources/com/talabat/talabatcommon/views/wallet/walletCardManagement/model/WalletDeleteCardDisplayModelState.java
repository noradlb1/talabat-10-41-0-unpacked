package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "", "()V", "ErrorDeleteCard", "Loading", "SuccessDeleteCard", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$SuccessDeleteCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$ErrorDeleteCard;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletDeleteCardDisplayModelState {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$ErrorDeleteCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "errorResult", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;)V", "getErrorResult", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorDeleteCard extends WalletDeleteCardDisplayModelState {
        @Nullable
        private final WalletDeleteCardErrorResult errorResult;

        public ErrorDeleteCard(@Nullable WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
            super((DefaultConstructorMarker) null);
            this.errorResult = walletDeleteCardErrorResult;
        }

        public static /* synthetic */ ErrorDeleteCard copy$default(ErrorDeleteCard errorDeleteCard, WalletDeleteCardErrorResult walletDeleteCardErrorResult, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                walletDeleteCardErrorResult = errorDeleteCard.errorResult;
            }
            return errorDeleteCard.copy(walletDeleteCardErrorResult);
        }

        @Nullable
        public final WalletDeleteCardErrorResult component1() {
            return this.errorResult;
        }

        @NotNull
        public final ErrorDeleteCard copy(@Nullable WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
            return new ErrorDeleteCard(walletDeleteCardErrorResult);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorDeleteCard) && Intrinsics.areEqual((Object) this.errorResult, (Object) ((ErrorDeleteCard) obj).errorResult);
        }

        @Nullable
        public final WalletDeleteCardErrorResult getErrorResult() {
            return this.errorResult;
        }

        public int hashCode() {
            WalletDeleteCardErrorResult walletDeleteCardErrorResult = this.errorResult;
            if (walletDeleteCardErrorResult == null) {
                return 0;
            }
            return walletDeleteCardErrorResult.hashCode();
        }

        @NotNull
        public String toString() {
            WalletDeleteCardErrorResult walletDeleteCardErrorResult = this.errorResult;
            return "ErrorDeleteCard(errorResult=" + walletDeleteCardErrorResult + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WalletDeleteCardDisplayModelState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState$SuccessDeleteCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessDeleteCard extends WalletDeleteCardDisplayModelState {
        @NotNull
        public static final SuccessDeleteCard INSTANCE = new SuccessDeleteCard();

        private SuccessDeleteCard() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletDeleteCardDisplayModelState() {
    }

    public /* synthetic */ WalletDeleteCardDisplayModelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
