package el;

import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActiveCartInfoRepositoryImpl f61977b;

    public /* synthetic */ c(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        this.f61977b = activeCartInfoRepositoryImpl;
    }

    public final Object call() {
        return ActiveCartInfoRepositoryImpl.m10113getFoodCart$lambda0(this.f61977b);
    }
}
