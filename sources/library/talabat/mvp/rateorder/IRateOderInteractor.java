package library.talabat.mvp.rateorder;

import datamodels.RateOrderReq;
import library.talabat.mvp.IGlobalInteractor;

interface IRateOderInteractor extends IGlobalInteractor {
    void submitRating(RateOrderReq rateOrderReq);
}
