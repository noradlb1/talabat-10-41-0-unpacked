package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "", "()V", "AddVoucherCodeAction", "ApplyVoucherAction", "CheckApplyVouchersFeaturesEnabled", "LoadPossibleVouchersAction", "RedeemVoucherAction", "UnApplyVoucherAction", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$LoadPossibleVouchersAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$ApplyVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$RedeemVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$UnApplyVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$CheckApplyVouchersFeaturesEnabled;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$AddVoucherCodeAction;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApplyVouchersActions {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$AddVoucherCodeAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "orderTotalAmount", "", "voucherCode", "", "brandId", "branchId", "groceryVendorId", "cartItems", "", "Ldatamodels/CartMenuItem;", "verticalId", "", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getBranchId", "()Ljava/lang/String;", "getBrandId", "getCartItems", "()Ljava/util/List;", "getGroceryVendorId", "getOrderTotalAmount", "()F", "getVerticalId", "()I", "getVoucherCode", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AddVoucherCodeAction extends ApplyVouchersActions {
        @NotNull
        private final String branchId;
        @NotNull
        private final String brandId;
        @Nullable
        private final List<CartMenuItem> cartItems;
        @NotNull
        private final String groceryVendorId;
        private final float orderTotalAmount;
        private final int verticalId;
        @NotNull
        private final String voucherCode;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddVoucherCodeAction(float f11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable List<? extends CartMenuItem> list, int i11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "voucherCode");
            Intrinsics.checkNotNullParameter(str2, "brandId");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            Intrinsics.checkNotNullParameter(str4, "groceryVendorId");
            this.orderTotalAmount = f11;
            this.voucherCode = str;
            this.brandId = str2;
            this.branchId = str3;
            this.groceryVendorId = str4;
            this.cartItems = list;
            this.verticalId = i11;
        }

        @NotNull
        public final String getBranchId() {
            return this.branchId;
        }

        @NotNull
        public final String getBrandId() {
            return this.brandId;
        }

        @Nullable
        public final List<CartMenuItem> getCartItems() {
            return this.cartItems;
        }

        @NotNull
        public final String getGroceryVendorId() {
            return this.groceryVendorId;
        }

        public final float getOrderTotalAmount() {
            return this.orderTotalAmount;
        }

        public final int getVerticalId() {
            return this.verticalId;
        }

        @NotNull
        public final String getVoucherCode() {
            return this.voucherCode;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$ApplyVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "myPossibleVoucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "branchId", "", "cartSubTotal", "", "brandId", "groceryVendorId", "cartItems", "", "Ldatamodels/CartMenuItem;", "verticalId", "", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getBranchId", "()Ljava/lang/String;", "getBrandId", "getCartItems", "()Ljava/util/List;", "getCartSubTotal", "()F", "getGroceryVendorId", "getMyPossibleVoucherDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "getVerticalId", "()I", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ApplyVoucherAction extends ApplyVouchersActions {
        @NotNull
        private final String branchId;
        @NotNull
        private final String brandId;
        @Nullable
        private final List<CartMenuItem> cartItems;
        private final float cartSubTotal;
        @NotNull
        private final String groceryVendorId;
        @NotNull
        private final VoucherDisplayModel myPossibleVoucherDisplayModel;
        private final int verticalId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApplyVoucherAction(@NotNull VoucherDisplayModel voucherDisplayModel, @NotNull String str, float f11, @NotNull String str2, @NotNull String str3, @Nullable List<? extends CartMenuItem> list, int i11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(voucherDisplayModel, "myPossibleVoucherDisplayModel");
            Intrinsics.checkNotNullParameter(str, "branchId");
            Intrinsics.checkNotNullParameter(str2, "brandId");
            Intrinsics.checkNotNullParameter(str3, "groceryVendorId");
            this.myPossibleVoucherDisplayModel = voucherDisplayModel;
            this.branchId = str;
            this.cartSubTotal = f11;
            this.brandId = str2;
            this.groceryVendorId = str3;
            this.cartItems = list;
            this.verticalId = i11;
        }

        @NotNull
        public final String getBranchId() {
            return this.branchId;
        }

        @NotNull
        public final String getBrandId() {
            return this.brandId;
        }

        @Nullable
        public final List<CartMenuItem> getCartItems() {
            return this.cartItems;
        }

        public final float getCartSubTotal() {
            return this.cartSubTotal;
        }

        @NotNull
        public final String getGroceryVendorId() {
            return this.groceryVendorId;
        }

        @NotNull
        public final VoucherDisplayModel getMyPossibleVoucherDisplayModel() {
            return this.myPossibleVoucherDisplayModel;
        }

        public final int getVerticalId() {
            return this.verticalId;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$CheckApplyVouchersFeaturesEnabled;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "applyVoucherOwner", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;)V", "getApplyVoucherOwner", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CheckApplyVouchersFeaturesEnabled extends ApplyVouchersActions {
        @NotNull
        private final ApplyVoucherOwner applyVoucherOwner;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CheckApplyVouchersFeaturesEnabled(@NotNull ApplyVoucherOwner applyVoucherOwner2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(applyVoucherOwner2, "applyVoucherOwner");
            this.applyVoucherOwner = applyVoucherOwner2;
        }

        @NotNull
        public final ApplyVoucherOwner getApplyVoucherOwner() {
            return this.applyVoucherOwner;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$LoadPossibleVouchersAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "restaurantId", "", "verticalId", "", "(Ljava/lang/String;I)V", "getRestaurantId", "()Ljava/lang/String;", "getVerticalId", "()I", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LoadPossibleVouchersAction extends ApplyVouchersActions {
        @NotNull
        private final String restaurantId;
        private final int verticalId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadPossibleVouchersAction(@NotNull String str, int i11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "restaurantId");
            this.restaurantId = str;
            this.verticalId = i11;
        }

        @NotNull
        public final String getRestaurantId() {
            return this.restaurantId;
        }

        public final int getVerticalId() {
            return this.verticalId;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$RedeemVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "applyVoucherOwner", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "voucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "branchId", "", "userId", "", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;Ljava/lang/String;I)V", "getApplyVoucherOwner", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "getBranchId", "()Ljava/lang/String;", "getUserId", "()I", "getVoucherDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RedeemVoucherAction extends ApplyVouchersActions {
        @NotNull
        private final ApplyVoucherOwner applyVoucherOwner;
        @NotNull
        private final String branchId;
        private final int userId;
        @NotNull
        private final VoucherDisplayModel voucherDisplayModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RedeemVoucherAction(@NotNull ApplyVoucherOwner applyVoucherOwner2, @NotNull VoucherDisplayModel voucherDisplayModel2, @NotNull String str, int i11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(applyVoucherOwner2, "applyVoucherOwner");
            Intrinsics.checkNotNullParameter(voucherDisplayModel2, "voucherDisplayModel");
            Intrinsics.checkNotNullParameter(str, "branchId");
            this.applyVoucherOwner = applyVoucherOwner2;
            this.voucherDisplayModel = voucherDisplayModel2;
            this.branchId = str;
            this.userId = i11;
        }

        @NotNull
        public final ApplyVoucherOwner getApplyVoucherOwner() {
            return this.applyVoucherOwner;
        }

        @NotNull
        public final String getBranchId() {
            return this.branchId;
        }

        public final int getUserId() {
            return this.userId;
        }

        @NotNull
        public final VoucherDisplayModel getVoucherDisplayModel() {
            return this.voucherDisplayModel;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions$UnApplyVoucherAction;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "shouldUpdateApplyVoucherOwner", "", "cartSubTotal", "", "cartItems", "", "Ldatamodels/CartMenuItem;", "(ZFLjava/util/List;)V", "getCartItems", "()Ljava/util/List;", "getCartSubTotal", "()F", "getShouldUpdateApplyVoucherOwner", "()Z", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnApplyVoucherAction extends ApplyVouchersActions {
        @Nullable
        private final List<CartMenuItem> cartItems;
        private final float cartSubTotal;
        private final boolean shouldUpdateApplyVoucherOwner;

        public UnApplyVoucherAction() {
            this(false, 0.0f, (List) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnApplyVoucherAction(boolean z11, float f11, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? null : list);
        }

        @Nullable
        public final List<CartMenuItem> getCartItems() {
            return this.cartItems;
        }

        public final float getCartSubTotal() {
            return this.cartSubTotal;
        }

        public final boolean getShouldUpdateApplyVoucherOwner() {
            return this.shouldUpdateApplyVoucherOwner;
        }

        public UnApplyVoucherAction(boolean z11, float f11, @Nullable List<? extends CartMenuItem> list) {
            super((DefaultConstructorMarker) null);
            this.shouldUpdateApplyVoucherOwner = z11;
            this.cartSubTotal = f11;
            this.cartItems = list;
        }
    }

    private ApplyVouchersActions() {
    }

    public /* synthetic */ ApplyVouchersActions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
