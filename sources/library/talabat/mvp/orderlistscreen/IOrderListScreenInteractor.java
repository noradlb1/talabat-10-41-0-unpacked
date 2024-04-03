package library.talabat.mvp.orderlistscreen;

import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface IOrderListScreenInteractor extends IGlobalInteractor {
    void getAddressBasedDeliveryArea(DeliverAddressRequest deliverAddressRequest);

    void getBranchIdForReorderCart(InforMapRequest inforMapRequest);

    void getBranchIdGrl(McdBranchRequest mcdBranchRequest);

    void getGrlReorderCart(String str, int i11, int i12);

    void getGroceryBuyAgainSwimlaneInfo(boolean z11, int i11);

    void getOrderDetails(String str);

    void getOrderList(int i11);

    void getReorderAreas(String str);

    void getReorderCart(String str, int i11);
}
