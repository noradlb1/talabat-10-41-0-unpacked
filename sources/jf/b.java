package jf;

import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import io.reactivex.functions.Function;
import retrofit2.Response;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRemoteDataSourceImpl f56919b;

    public /* synthetic */ b(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl) {
        this.f56919b = authenticationRemoteDataSourceImpl;
    }

    public final Object apply(Object obj) {
        return AuthenticationRemoteDataSourceImpl.m9514authenticateWithPassword$lambda8$lambda6(this.f56919b, (Response) obj);
    }
}
