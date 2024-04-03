package el;

import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import datamodels.Restaurant;
import io.reactivex.functions.Function3;

public final /* synthetic */ class h implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveCartInfoRepositoryImpl f61979a;

    public /* synthetic */ h(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        this.f61979a = activeCartInfoRepositoryImpl;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return ActiveCartInfoRepositoryImpl.m10118getQCommerceCart$lambda5(this.f61979a, (Integer) obj, (Restaurant) obj2, (Double) obj3);
    }
}
