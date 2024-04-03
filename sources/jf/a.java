package jf;

import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRemoteDataSourceImpl f56916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56917b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56918c;

    public /* synthetic */ a(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, String str, String str2) {
        this.f56916a = authenticationRemoteDataSourceImpl;
        this.f56917b = str;
        this.f56918c = str2;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        AuthenticationRemoteDataSourceImpl.m9513authenticateWithPassword$lambda8(this.f56916a, this.f56917b, this.f56918c, singleEmitter);
    }
}
