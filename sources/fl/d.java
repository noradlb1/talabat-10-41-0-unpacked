package fl;

import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandlerImpl;
import datamodels.Restaurant;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActiveCartsMethodCallHandlerImpl f62060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62061c;

    public /* synthetic */ d(ActiveCartsMethodCallHandlerImpl activeCartsMethodCallHandlerImpl, MethodChannel.Result result) {
        this.f62060b = activeCartsMethodCallHandlerImpl;
        this.f62061c = result;
    }

    public final void accept(Object obj) {
        ActiveCartsMethodCallHandlerImpl.m10122navigateToQcommerceBasket$lambda2(this.f62060b, this.f62061c, (Restaurant) obj);
    }
}
