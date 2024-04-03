package nf;

import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenRepositoryImpl f57058b;

    public /* synthetic */ a(TokenRepositoryImpl tokenRepositoryImpl) {
        this.f57058b = tokenRepositoryImpl;
    }

    public final void accept(Object obj) {
        TokenRepositoryImpl.m9521loginClient$lambda16$lambda12(this.f57058b, (TokenData) obj);
    }
}
