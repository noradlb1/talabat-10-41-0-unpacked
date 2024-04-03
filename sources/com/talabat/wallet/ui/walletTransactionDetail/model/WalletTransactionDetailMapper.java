package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.configuration.country.Country;
import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailCashBackModel;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailPaymentModel;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRefundModel;
import com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRestaurantModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDisplayModelState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailMapper;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailMapper$Companion;", "", "()V", "mapCommonViewResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;", "response", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "mapPaymentResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;", "selectedCountryParam", "Lcom/talabat/configuration/country/Country;", "mapRechargeResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;", "mapRefundModelToBottomSheetDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;", "refundModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;", "mapRefundResponseToDisplayModel", "mapRefundSentResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundSentWalletTransactionTypeDisplayModel;", "mapWalletTransactionDetailHeaderToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "mapWalletTransactionDetailTypeToDisplayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "walletTransactionDetail", "selectedCountry", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommonViewTransactionTypeDisplayModel mapCommonViewResponseToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail) {
            WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel = null;
            CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel = new CommonViewTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (CashBackWalletTransactionModel) null, 3, (DefaultConstructorMarker) null);
            commonViewTransactionTypeDisplayModel.setHeaderInfo(WalletTransactionDetailMapper.Companion.mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            CashBackWalletTransactionModel cashBackWalletTransactionModel = new CashBackWalletTransactionModel(0.0f, 0, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailCashBackModel = walletTransactionDetail.getCashBack();
            }
            commonViewTransactionTypeDisplayModel.setCashBack((CashBackWalletTransactionModel) ModelMappingIntegrationKt.parseFromNullable(cashBackWalletTransactionModel, walletTransactionDetailCashBackModel));
            return commonViewTransactionTypeDisplayModel;
        }

        @NotNull
        public final PaidWalletTransactionTypeDisplayModel mapPaymentResponseToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail, @NotNull Country country) {
            WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel;
            Intrinsics.checkNotNullParameter(country, "selectedCountryParam");
            PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel = new PaidWalletTransactionTypeDisplayModel((CashBackWalletTransactionModel) null, (WalletTransactionDetailHeaderDisplayModel) null, (Country) null, 7, (DefaultConstructorMarker) null);
            CashBackWalletTransactionModel cashBackWalletTransactionModel = new CashBackWalletTransactionModel(0.0f, 0, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailCashBackModel = walletTransactionDetail.getCashBack();
            } else {
                walletTransactionDetailCashBackModel = null;
            }
            paidWalletTransactionTypeDisplayModel.setCashBack((CashBackWalletTransactionModel) ModelMappingIntegrationKt.parseFromNullable(cashBackWalletTransactionModel, walletTransactionDetailCashBackModel));
            paidWalletTransactionTypeDisplayModel.setHeaderInfo(WalletTransactionDetailMapper.Companion.mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            paidWalletTransactionTypeDisplayModel.setSelectedCountry(country);
            return paidWalletTransactionTypeDisplayModel;
        }

        @NotNull
        public final RechargeWalletTransactionTypeDisplayModel mapRechargeResponseToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail) {
            WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel;
            WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel = null;
            RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel = new RechargeWalletTransactionTypeDisplayModel((WalletTransactionDetailHeaderDisplayModel) null, (PaymentWalletTransactionDisplayModel) null, (CashBackWalletTransactionModel) null, 7, (DefaultConstructorMarker) null);
            PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = new PaymentWalletTransactionDisplayModel(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailPaymentModel = walletTransactionDetail.getPayment();
            } else {
                walletTransactionDetailPaymentModel = null;
            }
            rechargeWalletTransactionTypeDisplayModel.setPayment((PaymentWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(paymentWalletTransactionDisplayModel, walletTransactionDetailPaymentModel));
            CashBackWalletTransactionModel cashBackWalletTransactionModel = new CashBackWalletTransactionModel(0.0f, 0, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailCashBackModel = walletTransactionDetail.getCashBack();
            }
            rechargeWalletTransactionTypeDisplayModel.setCashBack((CashBackWalletTransactionModel) ModelMappingIntegrationKt.parseFromNullable(cashBackWalletTransactionModel, walletTransactionDetailCashBackModel));
            rechargeWalletTransactionTypeDisplayModel.setHeaderInfo(WalletTransactionDetailMapper.Companion.mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            return rechargeWalletTransactionTypeDisplayModel;
        }

        @NotNull
        public final WalletRefundBottomSheetDisplayModel mapRefundModelToBottomSheetDisplayModel(@NotNull RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel) {
            Intrinsics.checkNotNullParameter(refundWalletTransactionTypeDisplayModel, "refundModel");
            WalletRefundBottomSheetDisplayModel walletRefundBottomSheetDisplayModel = new WalletRefundBottomSheetDisplayModel((PaymentMethod) null, (String) null, 0.0f, 0, 0, (String) null, 63, (DefaultConstructorMarker) null);
            walletRefundBottomSheetDisplayModel.setPaymentMethod(PaymentMethod.Companion.fromInt(refundWalletTransactionTypeDisplayModel.getPaymentDisplay().getPaymentMethod()));
            walletRefundBottomSheetDisplayModel.setCardType(refundWalletTransactionTypeDisplayModel.getPaymentDisplay().getCardType());
            walletRefundBottomSheetDisplayModel.setCard4Digits(refundWalletTransactionTypeDisplayModel.getPaymentDisplay().getCard4Digits());
            walletRefundBottomSheetDisplayModel.setRevertAmount(refundWalletTransactionTypeDisplayModel.getRefundDisplay().getRevertAmount());
            walletRefundBottomSheetDisplayModel.setRevertMinDays(refundWalletTransactionTypeDisplayModel.getRefundDisplay().getRevertMinDays());
            walletRefundBottomSheetDisplayModel.setRevertMaxDays(refundWalletTransactionTypeDisplayModel.getRefundDisplay().getRevertMaxDays());
            return walletRefundBottomSheetDisplayModel;
        }

        @NotNull
        public final RefundWalletTransactionTypeDisplayModel mapRefundResponseToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail) {
            WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel;
            WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel;
            WalletTransactionDetail walletTransactionDetail2 = walletTransactionDetail;
            WalletTransactionDetailRefundModel walletTransactionDetailRefundModel = null;
            RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel = new RefundWalletTransactionTypeDisplayModel((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, (WalletTransactionDetailHeaderDisplayModel) null, 15, (DefaultConstructorMarker) null);
            PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = new PaymentWalletTransactionDisplayModel(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail2 != null) {
                walletTransactionDetailPaymentModel = walletTransactionDetail.getPayment();
            } else {
                walletTransactionDetailPaymentModel = null;
            }
            refundWalletTransactionTypeDisplayModel.setPaymentDisplay((PaymentWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(paymentWalletTransactionDisplayModel, walletTransactionDetailPaymentModel));
            RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel = new RestaurantWalletTransactionDisplayModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail2 != null) {
                walletTransactionDetailRestaurantModel = walletTransactionDetail.getRestaurant();
            } else {
                walletTransactionDetailRestaurantModel = null;
            }
            refundWalletTransactionTypeDisplayModel.setRestaurantDisplay((RestaurantWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(restaurantWalletTransactionDisplayModel, walletTransactionDetailRestaurantModel));
            RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel = new RefundWalletTransactionDisplayModel((String) null, 0, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null);
            if (walletTransactionDetail2 != null) {
                walletTransactionDetailRefundModel = walletTransactionDetail.getRefund();
            }
            refundWalletTransactionTypeDisplayModel.setRefundDisplay((RefundWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(refundWalletTransactionDisplayModel, walletTransactionDetailRefundModel));
            refundWalletTransactionTypeDisplayModel.setHeaderInfo(WalletTransactionDetailMapper.Companion.mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail2));
            return refundWalletTransactionTypeDisplayModel;
        }

        @NotNull
        public final RefundSentWalletTransactionTypeDisplayModel mapRefundSentResponseToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail) {
            WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel;
            WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel;
            WalletTransactionDetailRefundModel walletTransactionDetailRefundModel = null;
            RefundSentWalletTransactionTypeDisplayModel refundSentWalletTransactionTypeDisplayModel = new RefundSentWalletTransactionTypeDisplayModel((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, 7, (DefaultConstructorMarker) null);
            PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = new PaymentWalletTransactionDisplayModel(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailPaymentModel = walletTransactionDetail.getPayment();
            } else {
                walletTransactionDetailPaymentModel = null;
            }
            refundSentWalletTransactionTypeDisplayModel.setPaymentDisplay((PaymentWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(paymentWalletTransactionDisplayModel, walletTransactionDetailPaymentModel));
            RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel = new RestaurantWalletTransactionDisplayModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailRestaurantModel = walletTransactionDetail.getRestaurant();
            } else {
                walletTransactionDetailRestaurantModel = null;
            }
            refundSentWalletTransactionTypeDisplayModel.setRestaurantDisplay((RestaurantWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(restaurantWalletTransactionDisplayModel, walletTransactionDetailRestaurantModel));
            RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel = new RefundWalletTransactionDisplayModel((String) null, 0, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailRefundModel = walletTransactionDetail.getRefund();
            }
            refundSentWalletTransactionTypeDisplayModel.setRefundDisplay((RefundWalletTransactionDisplayModel) ModelMappingIntegrationKt.parseFromNullable(refundWalletTransactionDisplayModel, walletTransactionDetailRefundModel));
            return refundSentWalletTransactionTypeDisplayModel;
        }

        @NotNull
        public final WalletTransactionDetailHeaderDisplayModel mapWalletTransactionDetailHeaderToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail) {
            int i11;
            WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = new WalletTransactionDetailHeaderDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null);
            if (walletTransactionDetail != null) {
                walletTransactionDetailHeaderDisplayModel.setId(IntKt.orZero(walletTransactionDetail.getId()));
                String orderId = walletTransactionDetail.getOrderId();
                String str = "";
                if (orderId == null) {
                    orderId = str;
                }
                walletTransactionDetailHeaderDisplayModel.setOrderId(orderId);
                String name2 = walletTransactionDetail.getName();
                if (name2 == null) {
                    name2 = str;
                }
                walletTransactionDetailHeaderDisplayModel.setName(name2);
                String date = walletTransactionDetail.getDate();
                if (date == null) {
                    date = str;
                }
                walletTransactionDetailHeaderDisplayModel.setDate(date);
                String imageUrl = walletTransactionDetail.getImageUrl();
                if (imageUrl == null) {
                    imageUrl = str;
                }
                walletTransactionDetailHeaderDisplayModel.setImageUrl(imageUrl);
                walletTransactionDetailHeaderDisplayModel.setAmount(FloatKt.orZero(walletTransactionDetail.getAmount()));
                walletTransactionDetailHeaderDisplayModel.setExpiryDays(IntKt.orZero(walletTransactionDetail.getExpiryDays()));
                String creditSource = walletTransactionDetail.getCreditSource();
                if (creditSource == null) {
                    creditSource = str;
                }
                walletTransactionDetailHeaderDisplayModel.setCreditSource(creditSource);
                String transactionTypeName = walletTransactionDetail.getTransactionTypeName();
                if (transactionTypeName != null) {
                    str = transactionTypeName;
                }
                walletTransactionDetailHeaderDisplayModel.setTransactionType(str);
                Integer transactionTypeId = walletTransactionDetail.getTransactionTypeId();
                if (transactionTypeId != null) {
                    i11 = transactionTypeId.intValue();
                } else {
                    i11 = -1;
                }
                walletTransactionDetailHeaderDisplayModel.setTransactionTypeId(i11);
            }
            return walletTransactionDetailHeaderDisplayModel;
        }

        @NotNull
        public final WalletTransactionDisplayModelState mapWalletTransactionDetailTypeToDisplayModel(@Nullable WalletTransactionDetail walletTransactionDetail, @NotNull Country country) {
            Integer num;
            Intrinsics.checkNotNullParameter(country, "selectedCountry");
            WalletTransactionType walletTransactionType = WalletTransactionType.REFUND_ORDER;
            Set of2 = SetsKt__SetsKt.setOf(WalletTransactionType.REFUND_CREDIT.getValue(), walletTransactionType.getValue(), WalletTransactionType.CMS_COMPENSATION.getValue(), WalletTransactionType.CMS_GIFT.getValue(), WalletTransactionType.CMS_REFUND.getValue(), WalletTransactionType.TALABAT_CREDIT.getValue(), WalletTransactionType.GIFT_VOUCHER_RECHARGE.getValue(), WalletTransactionType.TALABAT_REWARDS_LOYALTY.getValue(), WalletTransactionType.RECEIVED_CREDIT.getValue(), WalletTransactionType.EMPLOYEE_GIFT_CREDIT.getValue());
            Set of3 = SetsKt__SetsKt.setOf(WalletTransactionType.PAID.getValue(), WalletTransactionType.CASH_BACK_REVERSAL.getValue());
            if (walletTransactionDetail != null) {
                num = walletTransactionDetail.getTransactionTypeId();
            } else {
                num = null;
            }
            if (Intrinsics.areEqual((Object) num, (Object) WalletTransactionType.RECHARGE.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessRechargeViewTransaction(mapRechargeResponseToDisplayModel(walletTransactionDetail));
            }
            if (Intrinsics.areEqual((Object) num, (Object) WalletTransactionType.CREDIT_VOUCHER.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessCreditVoucherViewTransaction(mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            }
            if (Intrinsics.areEqual((Object) num, (Object) WalletTransactionType.CREDIT_EXPIRED.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessCreditExpiredViewTransaction(mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            }
            if (Intrinsics.areEqual((Object) num, (Object) WalletTransactionType.RIDER_TIP.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessRiderTipViewTransaction(mapWalletTransactionDetailHeaderToDisplayModel(walletTransactionDetail));
            }
            if (Intrinsics.areEqual((Object) num, (Object) walletTransactionType.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessRefundViewTransaction(mapRefundResponseToDisplayModel(walletTransactionDetail));
            }
            if (Intrinsics.areEqual((Object) num, (Object) WalletTransactionType.REFUND_SENT.getValue())) {
                return new WalletTransactionDisplayModelState.SuccessRefundSentViewTransaction(mapRefundSentResponseToDisplayModel(walletTransactionDetail));
            }
            if (of3.contains(num)) {
                return new WalletTransactionDisplayModelState.SuccessPaymentViewTransaction(mapPaymentResponseToDisplayModel(walletTransactionDetail, country));
            }
            if (of2.contains(num)) {
                return new WalletTransactionDisplayModelState.SuccessCommonViewTransaction(mapCommonViewResponseToDisplayModel(walletTransactionDetail));
            }
            return WalletTransactionDisplayModelState.Default.INSTANCE;
        }
    }
}
