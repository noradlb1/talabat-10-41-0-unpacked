package of;

import com.talabat.authentication.token.data.remote.impl.LegacyTokenRemoteDataSourceImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LegacyTokenRemoteDataSourceImpl f57072b;

    public /* synthetic */ c(LegacyTokenRemoteDataSourceImpl legacyTokenRemoteDataSourceImpl) {
        this.f57072b = legacyTokenRemoteDataSourceImpl;
    }

    public final void accept(Object obj) {
        this.f57072b.observe((Throwable) obj);
    }
}
