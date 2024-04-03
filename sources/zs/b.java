package zs;

import JsonModels.Response.RateOrderResponse;
import com.talabat.rating.repo.impl.OrderRatingRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderRatingRepositoryImpl f63127b;

    public /* synthetic */ b(OrderRatingRepositoryImpl orderRatingRepositoryImpl) {
        this.f63127b = orderRatingRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return OrderRatingRepositoryImpl.m10714getRatingStatus$lambda1(this.f63127b, (RateOrderResponse) obj);
    }
}
