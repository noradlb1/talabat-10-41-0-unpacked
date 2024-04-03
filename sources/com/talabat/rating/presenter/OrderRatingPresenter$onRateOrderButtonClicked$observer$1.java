package com.talabat.rating.presenter;

import com.talabat.observability.ObservabilityManager;
import com.talabat.rating.domain.model.OrderRatingDetails;
import io.reactivex.observers.DisposableSingleObserver;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/talabat/rating/presenter/OrderRatingPresenter$onRateOrderButtonClicked$observer$1", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/talabat/rating/domain/model/OrderRatingDetails;", "onError", "", "e", "", "onSuccess", "orderRatingDetails", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingPresenter$onRateOrderButtonClicked$observer$1 extends DisposableSingleObserver<OrderRatingDetails> {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderRatingPresenter f61189c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61190d;

    public OrderRatingPresenter$onRateOrderButtonClicked$observer$1(OrderRatingPresenter orderRatingPresenter, String str) {
        this.f61189c = orderRatingPresenter;
        this.f61190d = str;
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        this.f61189c.view.hideLoading();
        this.f61189c.view.showGenericError();
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("Order can rate api failed", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    public void onSuccess(@NotNull OrderRatingDetails orderRatingDetails) {
        Intrinsics.checkNotNullParameter(orderRatingDetails, "orderRatingDetails");
        if (orderRatingDetails.getCanRate()) {
            this.f61189c.getOrderRatingReasons(this.f61190d, orderRatingDetails);
            return;
        }
        this.f61189c.view.hideLoading();
        this.f61189c.view.showOrderCannotBeRated(orderRatingDetails.getErrorMessage());
    }
}
