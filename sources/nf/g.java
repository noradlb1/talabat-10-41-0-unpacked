package nf;

import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class g implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenRepositoryImpl f57062a;

    public /* synthetic */ g(TokenRepositoryImpl tokenRepositoryImpl) {
        this.f57062a = tokenRepositoryImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        TokenRepositoryImpl.m9520loginClient$lambda16(this.f57062a, singleEmitter);
    }
}
