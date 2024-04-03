package library.talabat.mvp.rateorder;

import datamodels.RateOrderReq;
import datamodels.RateTag;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface IRateOrderPresenter extends IGlobalPresenter {
    float getAverageItemRate();

    ArrayList<RateTag.Tag> getRateTags(RateOrderReq rateOrderReq, int i11);

    boolean isAllRated();

    boolean reachedAverage();

    void setUpView(RateOrderReq rateOrderReq, int i11, int i12);

    void submitRating();
}
