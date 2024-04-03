package com.talabat.homescreen;

import com.talabat.homescreen.adapter.model.order_tracking.OrderTrackingItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/homescreen/OnFragmentInteractionListener;", "", "goToOrderConfirmationScreen", "", "orderTrackingItem", "Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "onPromotionsWidgetClicked", "id", "", "deeplink", "info", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnFragmentInteractionListener {
    void goToOrderConfirmationScreen(@NotNull OrderTrackingItem orderTrackingItem);

    void onPromotionsWidgetClicked(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
