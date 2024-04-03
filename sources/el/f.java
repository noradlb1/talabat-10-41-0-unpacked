package el;

import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActiveCartInfoRepositoryImpl f61978b;

    public /* synthetic */ f(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        this.f61978b = activeCartInfoRepositoryImpl;
    }

    public final boolean test(Object obj) {
        return ActiveCartInfoRepositoryImpl.m10116getQCommerceCart$lambda3(this.f61978b, (Integer) obj);
    }
}
