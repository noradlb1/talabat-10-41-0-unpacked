package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import io.reactivex.functions.Consumer;

/* renamed from: if.b  reason: invalid package */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f56898b;

    public /* synthetic */ b(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f56898b = authenticationRepositoryImpl;
    }

    public final void accept(Object obj) {
        this.f56898b.observeError((Throwable) obj);
    }
}
