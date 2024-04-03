package fs;

import com.talabat.homescreen.orderstatus.data.impl.OrderStatusRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusRepositoryImpl f62069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62070c;

    public /* synthetic */ b(OrderStatusRepositoryImpl orderStatusRepositoryImpl, List list) {
        this.f62069b = orderStatusRepositoryImpl;
        this.f62070c = list;
    }

    public final Object apply(Object obj) {
        return OrderStatusRepositoryImpl.m10648observeOrderStatuses$lambda1(this.f62069b, this.f62070c, (Long) obj);
    }
}
