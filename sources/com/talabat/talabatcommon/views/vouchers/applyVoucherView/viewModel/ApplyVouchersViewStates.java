package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u001d\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0001\t\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "", "isLoading", "", "voucherFailure", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "(ZLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;)V", "()Z", "getVoucherFailure", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "ApplyVoucher", "ApplyVouchersFailure", "Complete", "EmptyMyPossibleVouchers", "EnableVouchersFeature", "Loading", "RedeemVoucherDone", "ShowAllMyPossibleVouchers", "UnAppliedVouchersDone", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$Loading;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ApplyVouchersFailure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$EmptyMyPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ShowAllMyPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$Complete;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$UnAppliedVouchersDone;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$RedeemVoucherDone;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$EnableVouchersFeature;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApplyVouchersViewStates {
    private final boolean isLoading;
    @Nullable
    private final VoucherFailures voucherFailure;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ApplyVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "voucherResult", "Lkotlin/Pair;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "(Lkotlin/Pair;)V", "getVoucherResult", "()Lkotlin/Pair;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ApplyVoucher extends ApplyVouchersViewStates {
        @NotNull
        private final Pair<VoucherData, VoucherItemsDisplayModel> voucherResult;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApplyVoucher(@NotNull Pair<VoucherData, VoucherItemsDisplayModel> pair) {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pair, "voucherResult");
            this.voucherResult = pair;
        }

        @NotNull
        public final Pair<VoucherData, VoucherItemsDisplayModel> getVoucherResult() {
            return this.voucherResult;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ApplyVouchersFailure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "voucherFailure", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;)V", "getVoucherFailure", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ApplyVouchersFailure extends ApplyVouchersViewStates {
        @Nullable
        private final VoucherFailures voucherFailure;

        public ApplyVouchersFailure(@Nullable VoucherFailures voucherFailures) {
            super(false, voucherFailures, (DefaultConstructorMarker) null);
            this.voucherFailure = voucherFailures;
        }

        public static /* synthetic */ ApplyVouchersFailure copy$default(ApplyVouchersFailure applyVouchersFailure, VoucherFailures voucherFailures, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                voucherFailures = applyVouchersFailure.getVoucherFailure();
            }
            return applyVouchersFailure.copy(voucherFailures);
        }

        @Nullable
        public final VoucherFailures component1() {
            return getVoucherFailure();
        }

        @NotNull
        public final ApplyVouchersFailure copy(@Nullable VoucherFailures voucherFailures) {
            return new ApplyVouchersFailure(voucherFailures);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApplyVouchersFailure) && Intrinsics.areEqual((Object) getVoucherFailure(), (Object) ((ApplyVouchersFailure) obj).getVoucherFailure());
        }

        @Nullable
        public VoucherFailures getVoucherFailure() {
            return this.voucherFailure;
        }

        public int hashCode() {
            if (getVoucherFailure() == null) {
                return 0;
            }
            return getVoucherFailure().hashCode();
        }

        @NotNull
        public String toString() {
            VoucherFailures voucherFailure2 = getVoucherFailure();
            return "ApplyVouchersFailure(voucherFailure=" + voucherFailure2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$Complete;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Complete extends ApplyVouchersViewStates {
        @NotNull
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$EmptyMyPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyMyPossibleVouchers extends ApplyVouchersViewStates {
        @NotNull
        public static final EmptyMyPossibleVouchers INSTANCE = new EmptyMyPossibleVouchers();

        private EmptyMyPossibleVouchers() {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$EnableVouchersFeature;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "loyaltyVoucherEnabled", "", "voucherCodesEnabled", "isDarkStore", "isPickup", "(ZZZZ)V", "()Z", "getLoyaltyVoucherEnabled", "getVoucherCodesEnabled", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EnableVouchersFeature extends ApplyVouchersViewStates {
        private final boolean isDarkStore;
        private final boolean isPickup;
        private final boolean loyaltyVoucherEnabled;
        private final boolean voucherCodesEnabled;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ EnableVouchersFeature(boolean z11, boolean z12, boolean z13, boolean z14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(z11, z12, z13, (i11 & 8) != 0 ? false : z14);
        }

        public final boolean getLoyaltyVoucherEnabled() {
            return this.loyaltyVoucherEnabled;
        }

        public final boolean getVoucherCodesEnabled() {
            return this.voucherCodesEnabled;
        }

        public final boolean isDarkStore() {
            return this.isDarkStore;
        }

        public final boolean isPickup() {
            return this.isPickup;
        }

        public EnableVouchersFeature(boolean z11, boolean z12, boolean z13, boolean z14) {
            super(false, (VoucherFailures) null, 3, (DefaultConstructorMarker) null);
            this.loyaltyVoucherEnabled = z11;
            this.voucherCodesEnabled = z12;
            this.isDarkStore = z13;
            this.isPickup = z14;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$Loading;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends ApplyVouchersViewStates {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(true, (VoucherFailures) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$RedeemVoucherDone;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "updatedVoucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;)V", "getUpdatedVoucherDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RedeemVoucherDone extends ApplyVouchersViewStates {
        @NotNull
        private final VoucherDisplayModel updatedVoucherDisplayModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RedeemVoucherDone(@NotNull VoucherDisplayModel voucherDisplayModel) {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(voucherDisplayModel, "updatedVoucherDisplayModel");
            this.updatedVoucherDisplayModel = voucherDisplayModel;
        }

        @NotNull
        public final VoucherDisplayModel getUpdatedVoucherDisplayModel() {
            return this.updatedVoucherDisplayModel;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$ShowAllMyPossibleVouchers;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "applyVoucherViewHolderDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;)V", "getApplyVoucherViewHolderDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowAllMyPossibleVouchers extends ApplyVouchersViewStates {
        @NotNull
        private final ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowAllMyPossibleVouchers(@NotNull ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel2) {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(applyVoucherViewHolderDisplayModel2, "applyVoucherViewHolderDisplayModel");
            this.applyVoucherViewHolderDisplayModel = applyVoucherViewHolderDisplayModel2;
        }

        public static /* synthetic */ ShowAllMyPossibleVouchers copy$default(ShowAllMyPossibleVouchers showAllMyPossibleVouchers, ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                applyVoucherViewHolderDisplayModel2 = showAllMyPossibleVouchers.applyVoucherViewHolderDisplayModel;
            }
            return showAllMyPossibleVouchers.copy(applyVoucherViewHolderDisplayModel2);
        }

        @NotNull
        public final ApplyVoucherViewHolderDisplayModel component1() {
            return this.applyVoucherViewHolderDisplayModel;
        }

        @NotNull
        public final ShowAllMyPossibleVouchers copy(@NotNull ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel2) {
            Intrinsics.checkNotNullParameter(applyVoucherViewHolderDisplayModel2, "applyVoucherViewHolderDisplayModel");
            return new ShowAllMyPossibleVouchers(applyVoucherViewHolderDisplayModel2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowAllMyPossibleVouchers) && Intrinsics.areEqual((Object) this.applyVoucherViewHolderDisplayModel, (Object) ((ShowAllMyPossibleVouchers) obj).applyVoucherViewHolderDisplayModel);
        }

        @NotNull
        public final ApplyVoucherViewHolderDisplayModel getApplyVoucherViewHolderDisplayModel() {
            return this.applyVoucherViewHolderDisplayModel;
        }

        public int hashCode() {
            return this.applyVoucherViewHolderDisplayModel.hashCode();
        }

        @NotNull
        public String toString() {
            ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel2 = this.applyVoucherViewHolderDisplayModel;
            return "ShowAllMyPossibleVouchers(applyVoucherViewHolderDisplayModel=" + applyVoucherViewHolderDisplayModel2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$UnAppliedVouchersDone;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "shouldUpdateApplyVoucherOwner", "", "(Z)V", "getShouldUpdateApplyVoucherOwner", "()Z", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnAppliedVouchersDone extends ApplyVouchersViewStates {
        private final boolean shouldUpdateApplyVoucherOwner;

        public UnAppliedVouchersDone(boolean z11) {
            super(false, (VoucherFailures) null, (DefaultConstructorMarker) null);
            this.shouldUpdateApplyVoucherOwner = z11;
        }

        public final boolean getShouldUpdateApplyVoucherOwner() {
            return this.shouldUpdateApplyVoucherOwner;
        }
    }

    private ApplyVouchersViewStates(boolean z11, VoucherFailures voucherFailures) {
        this.isLoading = z11;
        this.voucherFailure = voucherFailures;
    }

    public /* synthetic */ ApplyVouchersViewStates(boolean z11, VoucherFailures voucherFailures, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, voucherFailures);
    }

    @Nullable
    public VoucherFailures getVoucherFailure() {
        return this.voucherFailure;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApplyVouchersViewStates(boolean z11, VoucherFailures voucherFailures, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? null : voucherFailures, (DefaultConstructorMarker) null);
    }
}
