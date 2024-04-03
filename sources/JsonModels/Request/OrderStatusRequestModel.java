package JsonModels.Request;

import java.util.ArrayList;

public class OrderStatusRequestModel {
    private ArrayList<String> orderIds;

    public ArrayList<String> getOrderIds() {
        return this.orderIds;
    }

    public void setOrderIds(ArrayList<String> arrayList) {
        this.orderIds = arrayList;
    }
}
