package of;

import com.talabat.authentication.aaa.TokenResponse;
import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRemoteDataSourceImpl f57074b;

    public /* synthetic */ f(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl) {
        this.f57074b = tokenRemoteDataSourceImpl;
    }

    public final Object apply(Object obj) {
        return TokenRemoteDataSourceImpl.m9530fetchClientTokenData$lambda2$lambda0(this.f57074b, (TokenResponse) obj);
    }
}
