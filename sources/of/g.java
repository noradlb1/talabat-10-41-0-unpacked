package of;

import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRemoteDataSourceImpl f57075b;

    public /* synthetic */ g(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl) {
        this.f57075b = tokenRemoteDataSourceImpl;
    }

    public final void accept(Object obj) {
        this.f57075b.observe((Throwable) obj);
    }
}
