package fs;

import com.talabat.homescreen.orderstatus.data.impl.OrderStatusRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusRepositoryImpl f62068b;

    public /* synthetic */ a(OrderStatusRepositoryImpl orderStatusRepositoryImpl) {
        this.f62068b = orderStatusRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return OrderStatusRepositoryImpl.m10649observeOrderStatuses$lambda1$lambda0(this.f62068b, (List) obj);
    }
}
