package p005if;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* renamed from: if.a  reason: invalid package */
public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenData f56896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f56897b;

    public /* synthetic */ a(TokenData tokenData, AuthenticationRepositoryImpl authenticationRepositoryImpl) {
        this.f56896a = tokenData;
        this.f56897b = authenticationRepositoryImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        AuthenticationRepositoryImpl.m9510swapWithLegacyToken$lambda9(this.f56896a, this.f56897b, singleEmitter);
    }
}
