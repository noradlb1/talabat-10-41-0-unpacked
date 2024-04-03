package jf;

import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRemoteDataSourceImpl f56922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f56923c;

    public /* synthetic */ e(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, SingleEmitter singleEmitter) {
        this.f56922b = authenticationRemoteDataSourceImpl;
        this.f56923c = singleEmitter;
    }

    public final void accept(Object obj) {
        AuthenticationRemoteDataSourceImpl.m9515authenticateWithPassword$lambda8$lambda7(this.f56922b, this.f56923c, (Throwable) obj);
    }
}
