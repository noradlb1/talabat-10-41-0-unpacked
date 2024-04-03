package nf;

import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRepositoryImpl f57059b;

    public /* synthetic */ c(TokenRepositoryImpl tokenRepositoryImpl) {
        this.f57059b = tokenRepositoryImpl;
    }

    public final void accept(Object obj) {
        TokenRepositoryImpl.m9523loginClient$lambda16$lambda14(this.f57059b, (Disposable) obj);
    }
}
