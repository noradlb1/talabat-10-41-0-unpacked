package library.talabat.mvp.orderlistscreen;

import JsonModels.ReorderResponse;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.OrderListPagingRM;
import com.talabat.domain.address.Address;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import library.talabat.mvp.IGlobalListener;

public interface OrderListScreenListener extends IGlobalListener {
    void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse);

    void grlBranchIdfailed();

    void mcdBhBranchFailed();

    void mcdBranchReceived(int i11, McdStoresResponse mcdStoresResponse);

    void noOrdersFound();

    void onGroceryOrderAgainInfoReceived(String str, String str2, String str3);

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onOrdersListRecieved(OrderListPagingRM orderListPagingRM);

    void onReorderAreasRecieved(DeliveryArea[] deliveryAreaArr);

    void onReorderItemRecieved(ReorderResponse reorderResponse);

    void onResBasedDeliverAddressLoaded(Address[] addressArr);

    void onResCompleted();

    void onResponseError();
}
