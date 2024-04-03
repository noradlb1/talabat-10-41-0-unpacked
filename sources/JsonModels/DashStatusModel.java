package JsonModels;

import com.google.gson.annotations.SerializedName;

public class DashStatusModel {
    @SerializedName("osl")
    DashStatusDetailsModel[] orderStatus;

    public DashStatusDetailsModel[] getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(DashStatusDetailsModel[] dashStatusDetailsModelArr) {
        this.orderStatus = dashStatusDetailsModelArr;
    }
}
