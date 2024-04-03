package library.talabat.mvp.orderdetails;

import JsonModels.OrderDetailsRM;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.OrderDetails;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/orderdetails/OrderDetailsPresenter$fetchOrderDetails$observer$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/OrderDetailsRM;", "onComplete", "", "onError", "e", "", "onNext", "orderDetailsRM", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsPresenter$fetchOrderDetails$observer$1 extends DisposableObserver<OrderDetailsRM> {
    final /* synthetic */ OrderDetailsPresenter this$0;

    public OrderDetailsPresenter$fetchOrderDetails$observer$1(OrderDetailsPresenter orderDetailsPresenter) {
        this.this$0 = orderDetailsPresenter;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        this.this$0.view.hideLoading();
        this.this$0.view.showError();
        LogManager.logException(th2);
    }

    public void onNext(@NotNull OrderDetailsRM orderDetailsRM) {
        Intrinsics.checkNotNullParameter(orderDetailsRM, "orderDetailsRM");
        this.this$0.view.hideLoading();
        OrderDetails orderDetails = orderDetailsRM.result;
        if (orderDetails != null) {
            OrderDetailsPresenter orderDetailsPresenter = this.this$0;
            Intrinsics.checkNotNullExpressionValue(orderDetails, "orderDetailsRM.result");
            orderDetailsPresenter.presentOrderDetails(orderDetails);
            return;
        }
        this.this$0.view.showError();
    }
}
