package library.talabat.mvp.orderdetails;

import com.talabat.domain.address.Address;
import datamodels.OrderDetails;
import datamodels.OrderDetailsItem;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001e\u001a\u00020\u0003H&J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010!\u001a\u00020\u00032\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0012\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0006H&J\b\u0010*\u001a\u00020\u0003H&J\u001c\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010.\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0006H&J\u0012\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0006H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H&J\u001c\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u00010\u0006H&J\u001c\u00108\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u00010\u0006H&J\u0012\u00109\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0006H&¨\u0006C"}, d2 = {"Llibrary/talabat/mvp/orderdetails/OrderDetailsView;", "", "hideLoading", "", "showCouponDiscount", "couponDiscount", "", "showDeliveryAddress", "address", "Lcom/talabat/domain/address/Address;", "showDeliveryTime", "deliveryTime", "showError", "showFirstName", "firstName", "showGemDiscountView", "isGemOrder", "", "gemDiscountOrderAmount", "", "showGeneralRequest", "show", "generalRequest", "showLoading", "showMunicipalityCharges", "municipalityCharges", "showMunicipalityTaxAltText", "altText", "showOrderDate", "orderDate", "showOrderDetails", "showOrderId", "orderId", "showOrderItems", "orderItems", "Ljava/util/ArrayList;", "Ldatamodels/OrderDetailsItem;", "showOrderStatus", "orderDetails", "Ldatamodels/OrderDetails;", "showPaymentMethod", "paymentMethod", "showPickupScreen", "showRestaurantDeliveryCharges", "text", "deliveryCharges", "showRestaurantDeliveryChargesAltText", "showRestaurantImage", "restaurantImage", "showRestaurantName", "restaurantName", "showRiderTip", "riderTipAmount", "showServiceFee", "label", "value", "showSmallOrderFee", "showSubTotal", "subTotal", "showTotal", "total", "showTouristTax", "touristTax", "showTouristTaxAltTax", "altTax", "showVoucherDiscount", "voucherDiscount", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderDetailsView {
    void hideLoading();

    void showCouponDiscount(@Nullable String str);

    void showDeliveryAddress(@Nullable Address address);

    void showDeliveryTime(@Nullable String str);

    void showError();

    void showFirstName(@Nullable String str);

    void showGemDiscountView(boolean z11, float f11);

    void showGeneralRequest(boolean z11, @Nullable String str);

    void showLoading();

    void showMunicipalityCharges(@Nullable String str);

    void showMunicipalityTaxAltText(@Nullable String str);

    void showOrderDate(@Nullable String str);

    void showOrderDetails();

    void showOrderId(@Nullable String str);

    void showOrderItems(@Nullable ArrayList<OrderDetailsItem> arrayList);

    void showOrderStatus(@NotNull OrderDetails orderDetails);

    void showPaymentMethod(@Nullable String str);

    void showPickupScreen();

    void showRestaurantDeliveryCharges(@Nullable String str, @Nullable String str2);

    void showRestaurantDeliveryChargesAltText(@Nullable String str);

    void showRestaurantImage(@Nullable String str);

    void showRestaurantName(@Nullable String str);

    void showRiderTip(@NotNull String str);

    void showServiceFee(@Nullable String str, @Nullable String str2);

    void showSmallOrderFee(@Nullable String str, @Nullable String str2);

    void showSubTotal(@Nullable String str);

    void showTotal(@Nullable String str);

    void showTouristTax(@Nullable String str);

    void showTouristTaxAltTax(@Nullable String str);

    void showVoucherDiscount(@Nullable String str);
}
