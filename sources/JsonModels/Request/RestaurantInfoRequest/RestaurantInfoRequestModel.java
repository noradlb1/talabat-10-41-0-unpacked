package JsonModels.Request.RestaurantInfoRequest;

import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import java.util.Objects;

public class RestaurantInfoRequestModel {
    public String areaId;
    public String countryid;
    public int deliveryMode = Cart.getInstance().getOrderDeliveryMode();
    public String latitude;
    public String longitude;

    public RestaurantInfoRequestModel(String str, String str2, String str3, String str4) {
        this.areaId = str;
        this.latitude = str2;
        this.longitude = str3;
        this.countryid = str4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RestaurantInfoRequestModel restaurantInfoRequestModel = (RestaurantInfoRequestModel) obj;
        if (!Objects.equals(this.areaId, restaurantInfoRequestModel.areaId) || !Objects.equals(this.latitude, restaurantInfoRequestModel.latitude) || !Objects.equals(this.longitude, restaurantInfoRequestModel.longitude) || !Objects.equals(this.countryid, restaurantInfoRequestModel.countryid)) {
            return false;
        }
        if (this.deliveryMode == restaurantInfoRequestModel.deliveryMode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14 = this.deliveryMode * 31;
        String str = this.areaId;
        int i15 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i16 = (i14 + i11) * 31;
        String str2 = this.latitude;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i17 = (i16 + i12) * 31;
        String str3 = this.longitude;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i18 = (i17 + i13) * 31;
        String str4 = this.countryid;
        if (str4 != null) {
            i15 = str4.hashCode();
        }
        return i18 + i15;
    }
}
