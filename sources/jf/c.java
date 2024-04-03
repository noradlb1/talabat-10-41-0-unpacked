package jf;

import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRemoteDataSourceImpl f56920b;

    public /* synthetic */ c(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl) {
        this.f56920b = authenticationRemoteDataSourceImpl;
    }

    public final void accept(Object obj) {
        this.f56920b.observe((Throwable) obj);
    }
}
