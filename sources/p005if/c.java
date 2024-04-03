package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.token.data.model.SwapTokenData;
import io.reactivex.functions.Consumer;

/* renamed from: if.c  reason: invalid package */
public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f56899b;

    public /* synthetic */ c(AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f56899b = authenticationRepositoryImpl;
    }

    public final void accept(Object obj) {
        AuthenticationRepositoryImpl.m9511swapWithLegacyToken$lambda9$lambda7(this.f56899b, (SwapTokenData) obj);
    }
}
