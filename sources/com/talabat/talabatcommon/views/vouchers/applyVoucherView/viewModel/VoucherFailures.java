package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0013\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u000b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "Lcom/talabat/talabatcore/exception/Failure$FeatureFailure;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "getDataFailure", "()Lcom/talabat/talabatcore/exception/Failure;", "FailToAddVoucherCode", "FailToApplyVoucher", "FailToLoadFreeVoucherItems", "FailToLoadGuestVoucher", "FailToLoadPossibleVouchers", "FailToLoadPotentialBinRestrictedVoucher", "FailToRedeemVoucher", "FailToUnApplyVoucher", "OrderLowerThanMinAcceptedAmount", "TargetedItemMissed", "UserNotLoggedIn", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$UserNotLoggedIn;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadFreeVoucherItems;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToUnApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToRedeemVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$OrderLowerThanMinAcceptedAmount;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToAddVoucherCode;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadGuestVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadPotentialBinRestrictedVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$TargetedItemMissed;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VoucherFailures extends Failure.FeatureFailure {
    @Nullable
    private final Failure dataFailure;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToAddVoucherCode;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToAddVoucherCode extends VoucherFailures {
        public FailToAddVoucherCode() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToAddVoucherCode(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToAddVoucherCode(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "bounds", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "(Lcom/talabat/talabatcore/exception/Failure;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;)V", "getBounds", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToApplyVoucher extends VoucherFailures {
        @Nullable
        private final Bounds bounds;

        public FailToApplyVoucher() {
            this((Failure) null, (Bounds) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToApplyVoucher(Failure failure, Bounds bounds2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure, (i11 & 2) != 0 ? null : bounds2);
        }

        @Nullable
        public final Bounds getBounds() {
            return this.bounds;
        }

        public FailToApplyVoucher(@Nullable Failure failure, @Nullable Bounds bounds2) {
            super(failure, (DefaultConstructorMarker) null);
            this.bounds = bounds2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadFreeVoucherItems;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToLoadFreeVoucherItems extends VoucherFailures {
        public FailToLoadFreeVoucherItems() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToLoadFreeVoucherItems(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToLoadFreeVoucherItems(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadGuestVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToLoadGuestVoucher extends VoucherFailures {
        public FailToLoadGuestVoucher() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToLoadGuestVoucher(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToLoadGuestVoucher(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToLoadPossibleVouchers extends VoucherFailures {
        public FailToLoadPossibleVouchers() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToLoadPossibleVouchers(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToLoadPossibleVouchers(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToLoadPotentialBinRestrictedVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToLoadPotentialBinRestrictedVoucher extends VoucherFailures {
        public FailToLoadPotentialBinRestrictedVoucher() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToLoadPotentialBinRestrictedVoucher(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToLoadPotentialBinRestrictedVoucher(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToRedeemVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToRedeemVoucher extends VoucherFailures {
        public FailToRedeemVoucher() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToRedeemVoucher(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }

        public FailToRedeemVoucher(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToUnApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "dataFailure", "Lcom/talabat/talabatcore/exception/Failure;", "(Lcom/talabat/talabatcore/exception/Failure;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToUnApplyVoucher extends VoucherFailures {
        public FailToUnApplyVoucher() {
            this((Failure) null, 1, (DefaultConstructorMarker) null);
        }

        public FailToUnApplyVoucher(@Nullable Failure failure) {
            super(failure, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FailToUnApplyVoucher(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : failure);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$OrderLowerThanMinAcceptedAmount;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "reamingAmount", "", "(F)V", "getReamingAmount", "()F", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OrderLowerThanMinAcceptedAmount extends VoucherFailures {
        private final float reamingAmount;

        public OrderLowerThanMinAcceptedAmount(float f11) {
            super((Failure) null, 1, (DefaultConstructorMarker) null);
            this.reamingAmount = f11;
        }

        public final float getReamingAmount() {
            return this.reamingAmount;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$TargetedItemMissed;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "itemsName", "", "(Ljava/lang/String;)V", "getItemsName", "()Ljava/lang/String;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TargetedItemMissed extends VoucherFailures {
        @Nullable
        private final String itemsName;

        public TargetedItemMissed() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public TargetedItemMissed(@Nullable String str) {
            super((Failure) null, 1, (DefaultConstructorMarker) null);
            this.itemsName = str;
        }

        @Nullable
        public final String getItemsName() {
            return this.itemsName;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TargetedItemMissed(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$UserNotLoggedIn;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UserNotLoggedIn extends VoucherFailures {
        @NotNull
        public static final UserNotLoggedIn INSTANCE = new UserNotLoggedIn();

        private UserNotLoggedIn() {
            super((Failure) null, 1, (DefaultConstructorMarker) null);
        }
    }

    private VoucherFailures(Failure failure) {
        this.dataFailure = failure;
    }

    public /* synthetic */ VoucherFailures(Failure failure, DefaultConstructorMarker defaultConstructorMarker) {
        this(failure);
    }

    @Nullable
    public Failure getDataFailure() {
        return this.dataFailure;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherFailures(Failure failure, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : failure, (DefaultConstructorMarker) null);
    }
}
