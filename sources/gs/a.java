package gs;

import com.talabat.homescreen.orderstatus.data.remote.impl.OrderStatusesRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f62116a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusesRemoteDataSourceImpl f62117b;

    public /* synthetic */ a(List list, OrderStatusesRemoteDataSourceImpl orderStatusesRemoteDataSourceImpl) {
        this.f62116a = list;
        this.f62117b = orderStatusesRemoteDataSourceImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        OrderStatusesRemoteDataSourceImpl.m10650fetchOrderStatuses$lambda0(this.f62116a, this.f62117b, singleEmitter);
    }
}
