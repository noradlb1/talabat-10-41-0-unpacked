package go;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetActiveSubscriptionsRxWrapper f62112b;

    public /* synthetic */ b(GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper) {
        this.f62112b = getActiveSubscriptionsRxWrapper;
    }

    public final void accept(Object obj) {
        GetActiveSubscriptionsRxWrapper.m10294single$lambda1(this.f62112b, (Subscription) obj);
    }
}
