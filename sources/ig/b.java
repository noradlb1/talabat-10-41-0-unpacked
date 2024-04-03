package ig;

import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginRepositoryImpl f56905b;

    public /* synthetic */ b(FacebookLoginRepositoryImpl facebookLoginRepositoryImpl) {
        this.f56905b = facebookLoginRepositoryImpl;
    }

    public final void accept(Object obj) {
        FacebookLoginRepositoryImpl.m9585requestData$lambda3(this.f56905b, (Throwable) obj);
    }
}
