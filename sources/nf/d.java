package nf;

import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRepositoryImpl f57060b;

    public /* synthetic */ d(TokenRepositoryImpl tokenRepositoryImpl) {
        this.f57060b = tokenRepositoryImpl;
    }

    public final void accept(Object obj) {
        TokenRepositoryImpl.g(this.f57060b, (Throwable) obj, (Throwable) null, 2, (Object) null);
    }
}
