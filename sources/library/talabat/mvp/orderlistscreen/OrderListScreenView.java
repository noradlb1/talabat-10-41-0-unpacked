package library.talabat.mvp.orderlistscreen;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.OrderInfoPaging;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J9\u0010\u0018\u001a\u00020\u000b2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u00020\u000b2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010\u001aH&¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u001a\u0010'\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\rH&J.\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010+\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0007H&J>\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00072\u0006\u00101\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0007H&J\b\u00102\u001a\u00020\u000bH&J \u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020&H&J,\u00107\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u00109\u001a\u00020\u000bH&J\b\u0010:\u001a\u00020\u000bH&J\u001a\u0010;\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\u0007H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006="}, d2 = {"Llibrary/talabat/mvp/orderlistscreen/OrderListScreenView;", "Lcom/talabat/helpers/Talabat;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "screenName", "", "getScreenName", "()Ljava/lang/String;", "getBranchIdForReOrderCart", "", "reorderRestaurantId", "", "selectedAreaId", "selectedAddress", "Lcom/talabat/domain/address/Address;", "hideLoading", "hideLoggedOutUserView", "mcdServerError", "noOrdersFound", "onOrderDetailsReceived", "orderDetails", "Ldatamodels/OrderDetails;", "onOrderListLoaded", "orderInfo", "", "Ldatamodels/OrderInfoPaging;", "totalPages", "totalRecords", "timestamp", "([Ldatamodels/OrderInfoPaging;IILjava/lang/String;)V", "onRedirectToAreaSelection", "areas", "Ldatamodels/DeliveryArea;", "([Ldatamodels/DeliveryArea;)V", "onReorderCartReceived", "selectedRestaurant", "Ldatamodels/Restaurant;", "onReorderCartReceivedNavigateToFlutterCartScreen", "cartId", "redirectToChooseSavedAddressScreenFromReorder", "selectedCustomerAddress", "orderId", "reOrderResName", "redirectToHomeMapScreenFromReorder", "isIgnoreLocation", "", "userSelectedAddress", "IsIngoreSavedLoc", "showCartClearAlert", "showCartLoadingError", "errorMessage", "showNoItemsBottomsheet", "restaurant", "showGoogleMapMcd", "reoderRestaurantId", "showLoading", "showLoggedOutUserView", "showMap", "resName", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderListScreenView extends Talabat {
    void getBranchIdForReOrderCart(int i11, int i12, @Nullable Address address);

    @Nullable
    Context getContext();

    @Nullable
    String getScreenName();

    void hideLoading();

    void hideLoggedOutUserView();

    void mcdServerError();

    void noOrdersFound();

    void onOrderDetailsReceived(@Nullable OrderDetails orderDetails);

    void onOrderListLoaded(@Nullable OrderInfoPaging[] orderInfoPagingArr, int i11, int i12, @Nullable String str);

    void onRedirectToAreaSelection(@Nullable DeliveryArea[] deliveryAreaArr);

    void onReorderCartReceived(@Nullable Restaurant restaurant);

    void onReorderCartReceivedNavigateToFlutterCartScreen(@Nullable Restaurant restaurant, int i11);

    void redirectToChooseSavedAddressScreenFromReorder(@Nullable Address address, @Nullable String str, int i11, @Nullable String str2);

    void redirectToHomeMapScreenFromReorder(boolean z11, @Nullable String str, boolean z12, @Nullable String str2, int i11, @Nullable String str3);

    void showCartClearAlert();

    void showCartLoadingError(@NotNull String str, boolean z11, @NotNull Restaurant restaurant);

    void showGoogleMapMcd(int i11, @Nullable String str, int i12, @Nullable Address address);

    void showLoading();

    void showLoggedOutUserView();

    void showMap(int i11, @Nullable String str);
}
