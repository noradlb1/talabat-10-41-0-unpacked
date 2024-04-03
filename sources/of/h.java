package of;

import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRemoteDataSourceImpl f57076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f57077c;

    public /* synthetic */ h(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl, SingleEmitter singleEmitter) {
        this.f57076b = tokenRemoteDataSourceImpl;
        this.f57077c = singleEmitter;
    }

    public final void accept(Object obj) {
        TokenRemoteDataSourceImpl.m9531fetchClientTokenData$lambda2$lambda1(this.f57076b, this.f57077c, (Throwable) obj);
    }
}
