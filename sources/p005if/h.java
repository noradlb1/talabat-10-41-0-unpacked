package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import io.reactivex.functions.Consumer;

/* renamed from: if.h  reason: invalid package */
public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f56904b;

    public /* synthetic */ h(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f56904b = authenticationRepositoryImpl;
    }

    public final void accept(Object obj) {
        AuthenticationRepositoryImpl.m9509logout$lambda4(this.f56904b, (LogoutResponse) obj);
    }
}
