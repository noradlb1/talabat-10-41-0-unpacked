package zs;

import JsonModels.Response.OrderRatingDetailsResponse;
import com.talabat.rating.repo.impl.OrderRatingRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderRatingRepositoryImpl f63126b;

    public /* synthetic */ a(OrderRatingRepositoryImpl orderRatingRepositoryImpl) {
        this.f63126b = orderRatingRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return OrderRatingRepositoryImpl.m10713getRatingStatus$lambda0(this.f63126b, (OrderRatingDetailsResponse) obj);
    }
}
