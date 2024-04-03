package ig;

import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginRepositoryImpl f56906b;

    public /* synthetic */ d(FacebookLoginRepositoryImpl facebookLoginRepositoryImpl) {
        this.f56906b = facebookLoginRepositoryImpl;
    }

    public final void accept(Object obj) {
        FacebookLoginRepositoryImpl.m9583login$lambda1(this.f56906b, (Throwable) obj);
    }
}
