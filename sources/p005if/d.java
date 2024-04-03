package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.token.data.model.SwapTokenData;
import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.functions.Function;

/* renamed from: if.d  reason: invalid package */
public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenData f56900b;

    public /* synthetic */ d(TokenData tokenData) {
        this.f56900b = tokenData;
    }

    public final Object apply(Object obj) {
        return AuthenticationRepositoryImpl.m9512swapWithLegacyToken$lambda9$lambda8(this.f56900b, (SwapTokenData) obj);
    }
}
