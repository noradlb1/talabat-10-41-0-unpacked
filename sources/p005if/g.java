package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import io.reactivex.functions.Consumer;

/* renamed from: if.g  reason: invalid package */
public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f56903b;

    public /* synthetic */ g(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f56903b = authenticationRepositoryImpl;
    }

    public final void accept(Object obj) {
        AuthenticationRepositoryImpl.m9508logout$lambda3(this.f56903b, (Throwable) obj);
    }
}
