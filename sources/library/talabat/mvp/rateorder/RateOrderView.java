package library.talabat.mvp.rateorder;

import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.RateOrderItem;
import datamodels.RateOrderReq;
import datamodels.RateTag;
import java.util.ArrayList;

public interface RateOrderView extends Talabat {
    Context getContext();

    float getDeliveryRating();

    String getDriverOtherReason();

    float getDriverRating();

    String getOrderId();

    float getPackageRating();

    RateOrderItem getRateOrderItemAtIndex(int i11);

    RateOrderReq getRateOrderReq();

    String getReview();

    ArrayList<Integer> getSelectedDriverTagsIds();

    float getValueRating();

    boolean isDriverOtherReviewVisible();

    void onRatingSubmited();

    void onValidationFailed(int i11);

    void setDeliveryRating(float f11);

    void setDriverOtherReason(String str);

    void setDriverRating(float f11);

    void setOrderDetails(String str, String str2, String str3);

    void setPackageRating(float f11);

    void setRateOrderItems(RateOrderItem[] rateOrderItemArr);

    void setRated(boolean z11);

    void setRestaurantLogo(String str);

    void setRestaurantName(String str);

    void setReview(String str);

    void setSelectedTags(ArrayList<RateTag.Tag> arrayList);

    void setValueRating(float f11);
}
