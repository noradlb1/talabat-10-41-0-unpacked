package library.talabat.mvp.orderdetails;

import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.RxProcessor;
import com.talabat.helpers.TalabatUtils;
import datamodels.OrderDetails;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.helpcenter.GetOrderDetailsUseCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Llibrary/talabat/mvp/orderdetails/OrderDetailsPresenter;", "Llibrary/talabat/mvp/orderdetails/IOrderDetailsPresenter;", "view", "Llibrary/talabat/mvp/orderdetails/OrderDetailsView;", "getOrderDetailsUseCase", "Llibrary/talabat/mvp/helpcenter/GetOrderDetailsUseCase;", "rxProcessor", "Lcom/talabat/helpers/RxProcessor;", "(Llibrary/talabat/mvp/orderdetails/OrderDetailsView;Llibrary/talabat/mvp/helpcenter/GetOrderDetailsUseCase;Lcom/talabat/helpers/RxProcessor;)V", "fetchOrderDetails", "", "encryptedOrderId", "", "onAttach", "orderDetails", "Ldatamodels/OrderDetails;", "onDestroy", "presentCouponDiscount", "presentGeneralRequest", "presentMunicipalityTax", "presentOrderDetails", "presentPickupScreen", "presentRiderTip", "presentServiceFee", "presentSmallOrderFee", "presentTalabatCharges", "presentTouristTax", "presentVoucherDiscount", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OrderDetailsPresenter implements IOrderDetailsPresenter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final GetOrderDetailsUseCase getOrderDetailsUseCase;
    @NotNull
    private final RxProcessor rxProcessor;
    /* access modifiers changed from: private */
    @NotNull
    public final OrderDetailsView view;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/orderdetails/OrderDetailsPresenter$Companion;", "", "()V", "initialize", "Llibrary/talabat/mvp/orderdetails/OrderDetailsPresenter;", "view", "Llibrary/talabat/mvp/orderdetails/OrderDetailsView;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final OrderDetailsPresenter initialize(@NotNull OrderDetailsView orderDetailsView) {
            Intrinsics.checkNotNullParameter(orderDetailsView, "view");
            return new OrderDetailsPresenter(orderDetailsView, (GetOrderDetailsUseCase) null, (RxProcessor) null, 6, (DefaultConstructorMarker) null);
        }
    }

    public OrderDetailsPresenter(@NotNull OrderDetailsView orderDetailsView, @NotNull GetOrderDetailsUseCase getOrderDetailsUseCase2, @NotNull RxProcessor rxProcessor2) {
        Intrinsics.checkNotNullParameter(orderDetailsView, "view");
        Intrinsics.checkNotNullParameter(getOrderDetailsUseCase2, "getOrderDetailsUseCase");
        Intrinsics.checkNotNullParameter(rxProcessor2, "rxProcessor");
        this.view = orderDetailsView;
        this.getOrderDetailsUseCase = getOrderDetailsUseCase2;
        this.rxProcessor = rxProcessor2;
    }

    private final void fetchOrderDetails(String str) {
        this.view.showLoading();
        this.rxProcessor.process(this.getOrderDetailsUseCase.getOrderDetails(str), new OrderDetailsPresenter$fetchOrderDetails$observer$1(this));
    }

    @JvmStatic
    @NotNull
    public static final OrderDetailsPresenter initialize(@NotNull OrderDetailsView orderDetailsView) {
        return Companion.initialize(orderDetailsView);
    }

    private final void presentCouponDiscount(OrderDetails orderDetails) {
        if (orderDetails.getCouponDiscount() > 0.0f) {
            this.view.showCouponDiscount(orderDetails.getCouponDiscount());
        }
    }

    private final void presentGeneralRequest(OrderDetails orderDetails) {
        if (!TalabatUtils.isNullOrEmpty(orderDetails.getGeneralRequest())) {
            this.view.showGeneralRequest(true, orderDetails.getGeneralRequest());
        } else {
            this.view.showGeneralRequest(false, "");
        }
    }

    private final void presentMunicipalityTax(OrderDetails orderDetails) {
        if (orderDetails.getMunicipalityTax() > 0.0f) {
            this.view.showMunicipalityCharges(TalabatFormatter.getInstance().getFormattedCurrency(orderDetails.getMunicipalityTax()));
            if (!TalabatUtils.isNullOrEmpty(orderDetails.getAlterMunicipalityText())) {
                this.view.showMunicipalityTaxAltText(orderDetails.getAlterMunicipalityText());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void presentOrderDetails(OrderDetails orderDetails) {
        this.view.showOrderDetails();
        this.view.showRestaurantName(orderDetails.getRestaurantName());
        OrderDetailsView orderDetailsView = this.view;
        String str = GlobalDataModel.imageBaseUrl;
        String restaurantLogo = orderDetails.getRestaurantLogo();
        orderDetailsView.showRestaurantImage(str + "restaurants/" + restaurantLogo);
        this.view.showOrderItems(orderDetails.getOrderDetailsItems());
        this.view.showOrderId(orderDetails.getOrderID());
        this.view.showOrderDate(orderDetails.getOrderTime());
        this.view.showSubTotal(TalabatFormatter.getInstance().getFormattedCurrency(orderDetails.getSubTotal()));
        this.view.showTotal(TalabatFormatter.getInstance().getFormattedCurrency(orderDetails.getGrandTotal()));
        this.view.showFirstName(orderDetails.getFullName());
        this.view.showDeliveryAddress(orderDetails.getDeliveryAddress());
        this.view.showOrderStatus(orderDetails);
        this.view.showGemDiscountView(orderDetails.isGemOrder(), orderDetails.getGemDiscountOrderAmount());
        presentGeneralRequest(orderDetails);
        presentTalabatCharges(orderDetails);
        presentServiceFee(orderDetails);
        presentSmallOrderFee(orderDetails);
        presentMunicipalityTax(orderDetails);
        presentTouristTax(orderDetails);
        presentCouponDiscount(orderDetails);
        presentVoucherDiscount(orderDetails);
        presentRiderTip(orderDetails);
        this.view.showPaymentMethod(orderDetails.getPaymentMethod());
        this.view.showDeliveryTime(orderDetails.getDeliveryTime());
        presentPickupScreen(orderDetails);
    }

    private final void presentPickupScreen(OrderDetails orderDetails) {
        if (orderDetails.isPickup()) {
            this.view.showPickupScreen();
        }
    }

    private final void presentRiderTip(OrderDetails orderDetails) {
        if (orderDetails.getRiderTipAmount() > 0.0f) {
            String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(orderDetails.getRiderTipAmount(), true);
            OrderDetailsView orderDetailsView = this.view;
            Intrinsics.checkNotNullExpressionValue(formattedCurrency, "formattedTip");
            orderDetailsView.showRiderTip(formattedCurrency);
        }
    }

    private final void presentServiceFee(OrderDetails orderDetails) {
        Float serviceFeeValue = orderDetails.getServiceFeeValue();
        if (serviceFeeValue == null || Intrinsics.areEqual(serviceFeeValue, 0.0f)) {
            this.view.showServiceFee((String) null, (String) null);
            return;
        }
        this.view.showServiceFee(orderDetails.getServiceFeeLabel(), TalabatFormatter.getInstance().getFormattedCurrency(serviceFeeValue.floatValue()));
    }

    private final void presentSmallOrderFee(OrderDetails orderDetails) {
        Float smallOrderFeeValue = orderDetails.getSmallOrderFeeValue();
        if (smallOrderFeeValue == null || Intrinsics.areEqual(smallOrderFeeValue, 0.0f)) {
            this.view.showSmallOrderFee((String) null, (String) null);
            return;
        }
        this.view.showSmallOrderFee(orderDetails.getSmallOrderFeeLabel(), TalabatFormatter.getInstance().getFormattedCurrency(smallOrderFeeValue.floatValue()));
    }

    private final void presentTalabatCharges(OrderDetails orderDetails) {
        String str;
        if (orderDetails.getTalabatCharges() > 0.0f) {
            this.view.showRestaurantDeliveryCharges("t", orderDetails.getDisplayTalabatCharges());
            return;
        }
        if (!TalabatUtils.isNullOrEmpty(orderDetails.getAlterDeliveryText())) {
            str = orderDetails.getAlterDeliveryText();
        } else {
            str = "d";
        }
        this.view.showRestaurantDeliveryCharges(str, orderDetails.getDeliveryCharges());
    }

    private final void presentTouristTax(OrderDetails orderDetails) {
        if (orderDetails.getTouristTax() > 0.0f) {
            this.view.showTouristTax(TalabatFormatter.getInstance().getFormattedCurrency(orderDetails.getTouristTax()));
            if (!TalabatUtils.isNullOrEmpty(orderDetails.getAlterTouristText())) {
                this.view.showTouristTaxAltTax(orderDetails.getAlterTouristText());
            }
        }
    }

    private final void presentVoucherDiscount(OrderDetails orderDetails) {
        if (orderDetails.getVoucherDiscount() > 0.0f) {
            this.view.showVoucherDiscount(orderDetails.getVoucherDiscount());
        }
    }

    public void onAttach(@Nullable OrderDetails orderDetails, @Nullable String str) {
        boolean z11;
        if (orderDetails != null) {
            presentOrderDetails(orderDetails);
            return;
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.view.showError();
        } else if (str != null) {
            fetchOrderDetails(str);
        }
    }

    public void onDestroy() {
        this.rxProcessor.clear();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderDetailsPresenter(OrderDetailsView orderDetailsView, GetOrderDetailsUseCase getOrderDetailsUseCase2, RxProcessor rxProcessor2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderDetailsView, (i11 & 2) != 0 ? new GetOrderDetailsUseCase((ApiHandler) null, 1, (DefaultConstructorMarker) null) : getOrderDetailsUseCase2, (i11 & 4) != 0 ? new RxProcessor((Scheduler) null, (Scheduler) null, 3, (DefaultConstructorMarker) null) : rxProcessor2);
    }
}
