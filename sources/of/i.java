package of;

import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class i implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenRemoteDataSourceImpl f57078a;

    public /* synthetic */ i(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl) {
        this.f57078a = tokenRemoteDataSourceImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        TokenRemoteDataSourceImpl.m9529fetchClientTokenData$lambda2(this.f57078a, singleEmitter);
    }
}
