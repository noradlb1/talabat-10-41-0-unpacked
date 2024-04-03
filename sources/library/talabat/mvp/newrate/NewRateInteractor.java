package library.talabat.mvp.newrate;

import JsonModels.Request.rateOrders.RateOrderRequest;
import JsonModels.Response.rateOrders.RateOrderResponse;
import com.talabat.helpers.AppUrls;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import service.ApiHandler;

public class NewRateInteractor implements INewRateInteractor {

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26773b;

    /* renamed from: c  reason: collision with root package name */
    public INewRateListener f26774c;

    public void setListener(INewRateListener iNewRateListener) {
        this.f26774c = iNewRateListener;
    }

    public void submitRate(String str, String str2, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        RateOrderRequest rateOrderRequest = new RateOrderRequest();
        rateOrderRequest.setDeliveryRating(str3);
        rateOrderRequest.setOrderId(str);
        rateOrderRequest.setReview(str4);
        rateOrderRequest.setVendorRating(str2);
        rateOrderRequest.setDeliveryReasons(arrayList2);
        rateOrderRequest.setVendorReasons(arrayList);
        ApiHandler.Services services = ApiHandler.getInstance().getServices();
        this.f26773b = services.submitRating(AppUrls.RATE_BASE_URL + "/api/rating/save", rateOrderRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<RateOrderResponse>() {
            public void accept(RateOrderResponse rateOrderResponse) throws Exception {
                if (rateOrderResponse == null || rateOrderResponse.isHasError()) {
                    INewRateListener iNewRateListener = NewRateInteractor.this.f26774c;
                    if (iNewRateListener != null) {
                        iNewRateListener.rateFailed();
                    }
                } else if (NewRateInteractor.this.f26774c == null) {
                } else {
                    if (rateOrderResponse.getData() != null) {
                        NewRateInteractor.this.f26774c.rateSucceded(rateOrderResponse.getData().getTransactionId(), rateOrderResponse.getData().getVendorRating());
                    } else {
                        NewRateInteractor.this.f26774c.rateSucceded(0, 0.0f);
                    }
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) throws Exception {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("notaccept-failed ");
                sb2.append(th2.getMessage());
                INewRateListener iNewRateListener = NewRateInteractor.this.f26774c;
                if (iNewRateListener != null) {
                    iNewRateListener.rateFailed();
                }
            }
        });
    }

    public void unregister() {
        Disposable disposable = this.f26773b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26773b.dispose();
        }
    }
}
