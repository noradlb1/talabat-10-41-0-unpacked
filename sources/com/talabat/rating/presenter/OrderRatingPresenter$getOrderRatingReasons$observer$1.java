package com.talabat.rating.presenter;

import JsonModels.Response.rateOrders.RateReasonResponse;
import com.talabat.observability.ObservabilityManager;
import com.talabat.rating.domain.model.OrderRatingDetails;
import io.reactivex.observers.DisposableSingleObserver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/talabat/rating/presenter/OrderRatingPresenter$getOrderRatingReasons$observer$1", "Lio/reactivex/observers/DisposableSingleObserver;", "LJsonModels/Response/rateOrders/RateReasonResponse;", "onError", "", "e", "", "onSuccess", "rateReasonResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingPresenter$getOrderRatingReasons$observer$1 extends DisposableSingleObserver<RateReasonResponse> {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderRatingPresenter f61186c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61187d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OrderRatingDetails f61188e;

    public OrderRatingPresenter$getOrderRatingReasons$observer$1(OrderRatingPresenter orderRatingPresenter, String str, OrderRatingDetails orderRatingDetails) {
        this.f61186c = orderRatingPresenter;
        this.f61187d = str;
        this.f61188e = orderRatingDetails;
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        this.f61186c.view.hideLoading();
        this.f61186c.view.showGenericError();
        ObservabilityManager.trackUnExpectedScenario$default("Order rating reason api failed", (Map) null, 2, (Object) null);
    }

    public void onSuccess(@NotNull RateReasonResponse rateReasonResponse) {
        Intrinsics.checkNotNullParameter(rateReasonResponse, "rateReasonResponse");
        this.f61186c.view.hideLoading();
        if (rateReasonResponse.isHasError()) {
            this.f61186c.view.showGenericError();
        } else {
            this.f61186c.view.showRatingView(this.f61187d, this.f61188e, rateReasonResponse);
        }
    }
}
