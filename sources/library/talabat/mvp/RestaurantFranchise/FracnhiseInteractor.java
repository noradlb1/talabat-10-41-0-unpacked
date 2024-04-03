package library.talabat.mvp.RestaurantFranchise;

import JsonModels.Request.FranchiseRestRequest;
import JsonModels.RestaurantFranchiseRespone;
import com.talabat.helpers.AppUrls;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import service.ApiHandler;

public class FracnhiseInteractor implements IFranchiseInteractor {
    /* access modifiers changed from: private */
    public FranchiseListener listener;

    public FracnhiseInteractor(FranchiseListener franchiseListener) {
        this.listener = franchiseListener;
    }

    public void getFranchiseBasedLoc(FranchiseRestRequest franchiseRestRequest) {
        ApiHandler.callApi().getResFranchiseBasedLoc(AppUrls.RESTAURANT_FRANCHAISE_BASED_LOCATION, franchiseRestRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<RestaurantFranchiseRespone>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                if (FracnhiseInteractor.this.listener != null) {
                    FracnhiseInteractor.this.listener.onResponseError();
                }
            }

            public void onNext(RestaurantFranchiseRespone restaurantFranchiseRespone) {
                if (restaurantFranchiseRespone != null && FracnhiseInteractor.this.listener != null) {
                    if (restaurantFranchiseRespone.result != null) {
                        FracnhiseInteractor.this.listener.franchiseRestaurantReceived(restaurantFranchiseRespone.result);
                    } else {
                        FracnhiseInteractor.this.listener.onResponseError();
                    }
                }
            }
        });
    }

    public void unregister() {
        this.listener = null;
    }
}
