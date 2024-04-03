package gg;

import com.talabat.core.facebook.login.data.datasource.impl.FacebookLoginDataSourceImpl;
import io.reactivex.functions.Cancellable;

public final /* synthetic */ class b implements Cancellable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginDataSourceImpl f56839a;

    public /* synthetic */ b(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl) {
        this.f56839a = facebookLoginDataSourceImpl;
    }

    public final void cancel() {
        FacebookLoginDataSourceImpl.m9579performLogin$lambda1(this.f56839a);
    }
}
